import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

import scala.io.Source

/**
 * Created by lorenzo on 14/10/14.
 */
case class TradeReader(orderFile: String) {
  val ordersRaw = Source fromURL getClass.getResource(orderFile)

  val orders = (ordersRaw.getLines.toList) map { line => line split "," match {
    case Array(year, month, day, symbol, side, quantity) =>
      (DateTime.parse(month + "/" + day + "/" + year, DateTimeFormat.forPattern("MM/dd/yyyy")), symbol, quantity.toInt * (if (side.toLowerCase() == "buy") 1 else -1))
  }}


}
