package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

class GetBookSimulation extends BaseSimulation {
  def GetBook() =
    exec(
      http(s"Get house request")
        .get("/api/houses/378")
        .check(status.is(200))
    )

  val scn = scenario("Get house scenario")
    .exec(GetBook())

  setUp(scn.inject(
    stressPeakUsers(100)  during 2)
    .protocols(httpConf))
}
