import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}
import org.slf4j.LoggerFactory

import scala.concurrent.ExecutionContextExecutor

object Main extends App {

  val rootConfig: Config = ConfigFactory.load()

  implicit val system: ActorSystem                        = ActorSystem("AtCoder", config = rootConfig)
  implicit val materializer: ActorMaterializer            = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher

  val logger = LoggerFactory.getLogger(getClass)

  val route         = ???
  val bindingFuture = Http().bindAndHandle(route, "0.0.0.0", 80)

  sys.addShutdownHook {
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }

}
