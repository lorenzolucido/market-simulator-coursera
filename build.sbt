name := "market-simulator-coursera"

version := "1.0"

scalaVersion := "2.11.3"

organization := "com.enzo"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.4.6" % Test,
  "joda-time" % "joda-time" % "2.5"
)

scalacOptions in Test ++= Seq("-Yrangepos")

resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"