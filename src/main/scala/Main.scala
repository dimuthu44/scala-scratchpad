import java.util.Base64


object Main extends App {

  val s = "abc".getBytes
  val firstDecode = Base64.getDecoder().decode(s)
  println(firstDecode)
  println(Base64.getDecoder().decode(firstDecode))


}








