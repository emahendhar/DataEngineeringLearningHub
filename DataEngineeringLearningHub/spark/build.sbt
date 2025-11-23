version := "0.1.0-SNAPSHOT"

scalaVersion := "2.13.14"

name := "spark"
organization:= "com.dataengineering.learninghub"


lazy val root = (project in file("."))
  .settings(


      libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "3.5.3" % ,
      "org.apache.spark" %% "spark-sql" % "3.5.3" %
    )

  )
