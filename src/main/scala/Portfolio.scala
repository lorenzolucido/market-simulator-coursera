import org.joda.time.DateTime

/**
 * Created by lorenzo on 14/10/14.
 */
case class Portfolio(trades: List[(DateTime,String, Int)], cashInit: Float, benchmark: String, from: DateTime, to: DateTime) {
  val symbols =  (trades map {t => t._2}).distinct

  val prices = ( symbols map {s => (s, PriceReader(s, from, to).prices)} ).toMap

  val cashChanges = trades map {t => (t._1, t._3 * prices(t._2)(t._1))} groupBy(t => t._1) map {t => (t._1, t._2.map(_._2).sum)}

  //val portValue =
}
