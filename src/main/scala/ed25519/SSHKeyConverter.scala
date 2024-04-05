package ed25519

import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters
import org.bouncycastle.crypto.util.SubjectPublicKeyInfoFactory
import org.bouncycastle.jce.provider.BouncyCastleProvider

import java.security.spec.X509EncodedKeySpec
import java.security.{KeyFactory, PublicKey, Security}
import java.util.Base64
import scala.collection.mutable.ArrayBuffer

object SSHKeyConverter {
  def convertSSHKeyToPublicKey(sshKey: String): java.security.PublicKey = {
    val Array(keyType, keyData, keyComment) = sshKey.split(" ", 3)
    val decodedKeyBytes = Base64.getDecoder.decode(keyData)

    if (keyType != "ssh-ed25519") {
      throw new IllegalArgumentException("Only supports ssh-ed25519 keys")
    }

    // Extracting the public key bytes
    val publicKeyBytes = decodedKeyBytes.slice(11, decodedKeyBytes.length)

    // Creating SubjectPublicKeyInfo
    val keySpec = new Ed25519PublicKeyParameters(publicKeyBytes, 0).getEncoded
    val spki = SubjectPublicKeyInfo.getInstance(keySpec)

    // Converting to PublicKey
    val factory = KeyFactory.getInstance("Ed25519", "BC")
    val publicKeySpec = new X509EncodedKeySpec(spki.getEncoded())
    factory.generatePublic(publicKeySpec)
  }

  def main(args: Array[String]): Unit = {
    // ssh key generated from openssl:
    // openssl genpkey -algorithm ed25519 -out private_key.pem
    // openssl pkey -in private_key.pem -pubout -out public_key.pem
    val sshKey = "MCowBQYDK2VwAyEA4LSmWoy4ZBYJuwRttwzSLu0KQAYBKGRMHqPNBAun0gA="
    println(stringToKey(sshKey))

    // ssh key generated using ssh-keygen (ssh-keygen -t ed25519 -C "martin")
    val sshKeyGen = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIGpjh408HMAa1uE60DFrUs0GcgRflP1Hc3iLJlesVfCb martin"
    val Array(_, keyData, _) = sshKeyGen.split(" ", 3) // Split the key
    println(stringToKeyBouncyCastle(keyData))
  }

  def stringToKey(sshKey: String): PublicKey = {
    Security.addProvider(new BouncyCastleProvider())

    val serializedKey: Array[Byte] = Base64.getDecoder.decode(sshKey)

    val kf: KeyFactory = KeyFactory.getInstance("Ed25519", "BC")
    val keySpec: X509EncodedKeySpec = new X509EncodedKeySpec(serializedKey)
    val key: PublicKey = kf.generatePublic(keySpec)
//    if (key.getAlgorithm != "EdDSA") {
//      throw new Exception("Key type is " + key.getAlgorithm + ", should be EdDSA.")
//    }
    key
  }

  def stringToKeyBouncyCastle(osshpub: String): PublicKey = {
    val rawpub: Array[Byte] = Base64.getDecoder.decode(osshpub)
//    val prefix: Array[Byte] = Array(0x30.toByte, 0x2a.toByte, 0x30.toByte, 0x05.toByte, 0x06.toByte, 0x03.toByte, 0x2b.toByte, 0x65.toByte, 0x70.toByte, 0x03.toByte, 0x21.toByte, 0x00.toByte)
    val prefix: Array[Byte] = Base64.getDecoder.decode("MCowBQYDK2VwAyEA")
    val spki: Array[Byte] = ArrayBuffer(prefix ++ rawpub.slice(19, 51): _*).toArray

    val keyFactory: KeyFactory = KeyFactory.getInstance("Ed25519")
    val pubKey: PublicKey = keyFactory.generatePublic(new X509EncodedKeySpec(spki))
    pubKey
  }
}