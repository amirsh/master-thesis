name := "master-thesis-graphs"

version := "0.1.0"

scalaVersion := "2.10.2"

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:postfixOps",
  "-language:reflectiveCalls",
  "-language:existentials",
  "-language:implicitConversions",
  "-Xlint",
  "-Ywarn-all"
)

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies += "org.rogach" %% "s4gnuplot" % "0.2.0"