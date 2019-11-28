
lazy val root = (project in file("."))
  .settings(
    libraryDependencies ++= Seq(
      Logback.classic,
      LogstashLogbackEncoder.encoder,
      Config.core,
      Circe.core,
      Circe.generic,
      Circe.parser,
      Akka.http,
      Akka.stream,
      Akka.slf4j,
      Akka.`akka-http-crice`,
    )
  )


