package simulations

import io.gatling.core.Predef.*
import io.gatling.http.Predef.*

import baseConfig.BaseSimulation

class GetBookAtSameTimeSimulation extends BaseSimulation{
  def GetBook() =
    exec(http("Get book request")
      .get("/api/books/1")
      .check(status.is(200)))
    
  val scn = scenario("Get book scenario")
    .exec(GetBook())
  
  setUp(scn.inject(
    atOnceUsers(10))
    .protocols(httpConf))
}
