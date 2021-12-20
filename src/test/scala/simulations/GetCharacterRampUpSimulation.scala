package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetCharacterRampUpSimulation extends BaseSimulation {
  def GetCharacter() =
    exec(http("Get character request}")
      .get("/api/characters/583")
      .check(status.is(200)))

  val scn = scenario("Get character scenario")
    .exec(GetCharacter())

  setUp(scn.inject(
    rampUsers(50) during 5)
    .protocols(httpConf))
}
