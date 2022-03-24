object Async extends App {

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration.Duration
  import scala.concurrent.{Await, Future}

  def m1: Future[String] = m2.map("a" + _)
  def m2: Future[String] = m3.map("b" + _)
  def m3: Future[String] = Future(throw new Exception)

  Await.result(m1, Duration.Inf)
}