package baseConfig

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

class BaseSimulation extends Simulation {
    val httpConf = http
      .baseUrl("https://anapioficeandfire.com")
      .header("Accept", "application/json")
}
