import java.nio.charset.StandardCharsets
import java.security.{MessageDigest, SecureRandom}

import aes.AES
import javax.crypto.{KeyGenerator, SecretKey}
import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class EncryptDecryptTest extends AnyFlatSpec with BeforeAndAfterAll with Matchers {

//  "decrypting the encrypted payload" should "give back the same payload" in {
//    val payload = "Hello World"
//
//    val generator = KeyGenerator.getInstance("AES")
//    generator.init(256)
//    val key = generator.generateKey
//
//    println("key: " + key)
//    //  val keyBase64 = DatatypeConverter.printBase64Binary(key.getEncoded)
//    val digester = MessageDigest.getInstance("MD5")
//    val keyMd5 = digester.digest(key.getEncoded)
//    println("keyMD5: " + keyMd5)
//    //  val keyMd5Base64 = DatatypeConverter.printBase64Binary(keyMd5)
//
//    val keygen = KeyGenerator.getInstance("AES")
//    val random = new SecureRandom()
//    //  random.setSeed(1234L) // Seed with auth company id
//    keygen.init(256)
//
//    val secretKey: SecretKey =
//    keygen.generateKey()
//    println("securekey: " + secretKey)
//
//    val secret = "a1910313431" // max length (11) authcompany id
//    val encryptedString = AES.encrypt(payload.getBytes(StandardCharsets.UTF_8), secret)
//    val decryptedString = AES.decrypt(encryptedString, secret)
//
//    payload should equal (decryptedString)
//  }
}
