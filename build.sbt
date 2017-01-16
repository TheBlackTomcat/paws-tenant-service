lazy val tenant = (project in file("."))
  .settings(
    name := "paws-tenant-service",
    version := "0.1.0-SNAPSHOT",
    organization := "com.theblacktomcat.paws",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "com.theblacktomcat.paws" %% "paws-service-library" % "0.1.0-SNAPSHOT"
    )
  )
