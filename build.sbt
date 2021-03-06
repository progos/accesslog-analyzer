name := "accesslog-analyzer"

version := "1.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

assemblyJarName in assembly := "accesslog-analyzer.jar"

assemblyExcludedJars in assembly <<= (fullClasspath in assembly) map { cp =>
  val excludes = Set(
    "commons-beanutils-1.7.0.jar",
    "commons-beanutils-core-1.8.0.jar"
  )
  cp filter { jar => excludes(jar.data.getName) }
}

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.0" % " provided"
)