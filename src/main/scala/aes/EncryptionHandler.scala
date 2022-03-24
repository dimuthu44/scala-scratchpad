package aes

import java.io.InputStream
import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.util
import java.util.Base64

import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}

//import scala.sys.process.processInternal.OutputStream
import scala.util.Try

object EncryptionHandler {
  // TODO: Another mode of operation: https://en.wikipedia.org/wiki/Block_cipher_mode_of_operation#Electronic_codebook_(ECB)
  private val cipherInstance = "AES/CBC/PKCS5Padding"
  private val CIPHER = "AES"
  private val IV_LENGTH = 16 // cipher block size

  def encrypt(storageInputStream: InputStream, secret: String): Try[Array[Byte]] = {
    Try {
      val secretKey = setKey(secret)
      val cipher = Cipher.getInstance(cipherInstance)
      cipher.init(Cipher.ENCRYPT_MODE, secretKey)
      Base64.getEncoder.encode(cipher.doFinal("".getBytes())) //todo
    }
  }

  def encrypt(payload: Array[Byte], secret: String): Try[Array[Byte]] = {
    Try {
      val secretKey = setKey(secret)
      val cipher = Cipher.getInstance(cipherInstance)
      val iv = generateIV()
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv))
      iv ++ Base64.getEncoder.encode(cipher.doFinal(payload))
    }
  }

  def decrypt(payloadToDecrypt: Array[Byte], secret: String): Try[Array[Byte]] = {
    Try {
      val secretKey = setKey(secret)
      val cipher = Cipher.getInstance(cipherInstance)
      cipher.init(Cipher.DECRYPT_MODE, secretKey)
      cipher.doFinal(Base64.getDecoder.decode(payloadToDecrypt))
    }
  }

  def setKey(secret: String): SecretKeySpec = {
    val cipherAlgorithm = "AES" // Only one supported by S3
    var key = secret.getBytes(StandardCharsets.UTF_8)
    key = util.Arrays.copyOf(key, 16); // Making the length to 16 to support AES algorithm
    new SecretKeySpec(key, cipherAlgorithm)
  }

//  private def read(src: InputStream, dest: OutputStream): Unit = {
//    val buffer = new Array[Byte](8 * 1024)
//    var len = 0
//
//    def read: Boolean = {
//      len = src.read(buffer)
//      len != -1
//    }
//    while (read) dest.write(buffer, 0, len)
//  }

  def generateIV(): Array[Byte] = {
    val random = new SecureRandom()
    val iv = new Array[Byte](IV_LENGTH)
    random.nextBytes(iv)
    java.util.Arrays.copyOf(iv, IV_LENGTH)
  }
}
