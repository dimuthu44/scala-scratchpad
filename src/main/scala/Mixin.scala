class Mixin {


  trait User {
    def name: String
  }

  trait Tweeter {
    user: User =>
    def tweet(msg: String) = println(s"$name: $msg")
  }

  trait Wrong extends Tweeter with User {
    def noCanDo = name
  }

}
