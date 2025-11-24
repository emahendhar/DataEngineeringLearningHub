version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.12"

name := "spark"
organization:= "com.dataengineering.learninghub"
javacOptions ++= Seq("--release", "17")

lazy val root = (project in file("."))
  .settings(
      libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "2.4.8" ,
      "org.apache.spark" %% "spark-sql" % "2.4.8"
    )

  )
