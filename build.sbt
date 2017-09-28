name := """play-scala-starter-example"""

version := "2.6.x"

lazy val root = (project in file(".")).enablePlugins(PlayScala)
resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += "typesafe" at "http://repo.typesafe.com/typesafe/releases/"

scalaVersion := "2.12.0"

libraryDependencies += "com.typesafe.play" %% "play-slick" %  "3.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.2"
libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.2.0",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)
//libraryDependencies ++= Seq(
//  jdbc,
//  "com.typesafe.play" %% "anorm" % "2.5.3"
//)
//libraryDependencies += "com.googlecode.mapperdao" %% "mapperdao" % "1.0.2"

libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.0.0" % Test
libraryDependencies += guice
libraryDependencies += "com.h2database" % "h2" % "1.4.194"
//libraryDependencies += jdbc
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
