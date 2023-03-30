
name := "scala-scratchpad"

version := "0.1"

scalaVersion := "2.12.5"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature", "-language:postfixOps")

libraryDependencies ++= {
  val akkaVersion = "2.3.15"
  val sprayVersion = "1.3.2"

  lazy val minioVersion = "6.0.13"
  lazy val commonsioVersion = "2.5"

  Seq(
    "commons-io" % "commons-io" % "2.5",
    "com.typesafe.akka" %% "akka-http" % "10.1.5",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.5",
    "com.typesafe.akka" %% "akka-http-testkit" % "10.1.5",
    "com.typesafe.akka" %% "akka-actor" % "2.5.22",
    "com.typesafe.akka" %% "akka-actor" % "2.5.22",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.22" % Test,
    "com.typesafe.akka" %% "akka-stream" % "2.5.13",
    "io.minio" % "minio" % minioVersion,
    "commons-io" % "commons-io" % commonsioVersion,
    "org.slf4j" % "slf4j-api" % "1.7.5",
    "ch.qos.logback" % "logback-classic" % "1.0.9",
    "com.amazonaws" % "aws-java-sdk-s3" % "1.11.371",
    "org.scalatest" %% "scalatest" % "3.1.1" % "test",
  )
}

