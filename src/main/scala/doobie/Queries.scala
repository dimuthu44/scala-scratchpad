package doobie

import doobie.implicits.toSqlInterpolator

object Queries {

  //def insertQuery(student: Student): doobie.Update0 = {
  def insertQuery(student: Student): Unit = {
    sql"""
         |INSERT INTO student (
         |  id,
         |  name
         |)
         |VALUES (
         |  ${student.id},
         |  ${student.name}
         |)
     """.stripMargin
      .update

  }
}
