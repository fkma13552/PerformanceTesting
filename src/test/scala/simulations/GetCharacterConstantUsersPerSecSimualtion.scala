package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetCharacterConstantUsersPerSecSimualtion extends BaseSimulation{
  def GetCharacter() =
    exec(
      http(s"Get character request")
        .get("/api/characters/583")
        .check(status.is(200))
    )

  val scn = scenario("Get Characters scenario")
    .exec(GetCharacter())

  setUp(scn.inject(
    constantUsersPerSec(20) during 5)
    .protocols(httpConf))
}
