

import org.joda.time.DateTime

import scala.io.Source

/**
 * Created by lorenzo on 14/10/14.
 */
case class PriceReader(symbol: String, from: DateTime, to: DateTime) {
  val rawData = Source fromURL
    "http://real-chart.finance.yahoo.com/table.csv?s=" + symbol +
      "&a=" + from.dayOfMonth.get + "&b=" + from.monthOfYear.get + "&c=" + from.year.get + "&" +
      "&d=" + to.dayOfMonth.get + "&e=" + to.monthOfYear.get + "&f=" + to.year.get + "&g=d&ignore=.csv"

  val prices = (rawData.getLines().toList drop 1 map { line => line split "," match {
    case Array(date, open, high, low, close, volume, adj_close) => (DateTime.parse(date), adj_close.toFloat)
  }} sortWith (_._1 isBefore _._1) ).toMap


}
