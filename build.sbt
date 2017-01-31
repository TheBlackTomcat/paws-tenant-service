lazy val `pawzzle-tenant-service` = (project in file("."))
  .settings(
    name := "pawzzle-tenant-service",
    version := "0.1.0-SNAPSHOT",
    organization := "com.theblacktomcat.pawzzle",
    scalaVersion := "2.12.1",
    libraryDependencies ++= Seq(
      "com.theblacktomcat.pawzzle" %% "pawzzle-service-library" % "0.1.0-SNAPSHOT",

      "org.scalatest" %% "scalatest" % "3.0.1" % "test"
    ),
    exportJars := true,
    oneJarSettings
  )