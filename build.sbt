lazy val tenant = (project in file("."))
  .settings(
    name := "tenant-service",
    version := "0.1.0-SNAPSHOT",
    organization := "com.theblacktomcat.paws.service.tenant",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http" % "10.0.1"
      ,"com.typesafe.akka" %% "akka-http-testkit" % "10.0.1" % "test"
    )
  )
