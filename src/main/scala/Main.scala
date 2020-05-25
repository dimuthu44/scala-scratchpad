import java.nio.charset.StandardCharsets
import java.security.SecureRandom
import java.util.Base64

import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import java.security.MessageDigest

import aes.AES
import flatmap.MapFlat


object Main extends App {
  var mapFlat: MapFlat = new MapFlat

  //  mapFlat.mapflat()


  val generator = KeyGenerator.getInstance("AES")
  generator.init(256)
  val key = generator.generateKey

  println("key: " + key)
  //  val keyBase64 = DatatypeConverter.printBase64Binary(key.getEncoded)
  val digester = MessageDigest.getInstance("MD5")
  val keyMd5 = digester.digest(key.getEncoded)
  println("keyMD5: " + keyMd5)
  //  val keyMd5Base64 = DatatypeConverter.printBase64Binary(keyMd5)

  val keygen = KeyGenerator.getInstance("AES")
  val random = new SecureRandom()
  //  random.setSeed(1234L) // Seed with auth company id
  keygen.init(256)

  private val secretKey: SecretKey = keygen.generateKey()
  println("securekey: " + secretKey)

  val secret = "a1910313431" // max length (11) authcompany id
  val encryptedString = AES.encrypt("Hello World".getBytes(StandardCharsets.UTF_8), secret)
  val decryptedString = AES.decrypt(encryptedString, secret)

  println(encryptedString)
  println(decryptedString)
}








//def main(args: Array[String]): Unit = {

//        var mapFlat : MapFlat = new MapFlat
//        mapFlat.mapflat()

//        var fold: FoldDemo = new FoldDemo
//        println(fold.fold())

//        val inputList: List[Int] = List(1,3,5)
//        inputList.foldLeft(0) {(acc, i) => acc + i}

//    val mapTest = new MapTest
//  }
