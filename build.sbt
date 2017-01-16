lazy val tenant = (project in file("."))
  .settings(
    name := "tenant-service",
    version := "0.1.0-SNAPSHOT",
    organization := "paws",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "paws" %% "service" % "0.1.0-SNAPSHOT"
    )
  )
