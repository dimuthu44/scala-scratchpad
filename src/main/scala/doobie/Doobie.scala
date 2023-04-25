package doobie

import cats.effect.IO
import cats.effect.{IO, Resource}
import cats.implicits.catsSyntaxApplicativeId
import doobie.hikari.HikariTransactor
import doobie.implicits.toSqlInterpolator
import cats.effect.kernel.Resource
import cats.effect.IO
import cats.effect.unsafe.implicits.global
import doobie.hikari._
import doobie.implicits._
import doobie.postgres.implicits._

case class Student(id: Int, name: String)
// This is just for testing. Consider using cats.effect.IOApp instead of calling
// unsafe methods directly.
object Doobie extends App {
  val program1: ConnectionIO[Int] = 42.pure[ConnectionIO]
  val io: IO[Int] = program1.transact(ConnectionPool.xa)
  io.unsafeRunSync()

}
