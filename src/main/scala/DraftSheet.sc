import org.joda.time.DateTime
import scala.io.Source
object DraftSheet {
  val title = "- DraftSheet-"
  val file = TradeReader("/orders.csv")
  println(file.orders)

  val appl = PriceReader("AAPL", DateTime.now, DateTime.now().minusYears(1))
  println(appl.prices)
  //val port = Portfolio(file.orders, 1000000, "", DateTime.now.minusYears(5), DateTime.now)


  //println(port.prices)
  //println(port.cashChanges)

}