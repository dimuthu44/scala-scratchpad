package fold

class FoldDemo {

  def fold(): Double = {
    val prices: Seq[Double] = Seq(1.5, 2.0, 2.5)
    prices.fold(0.0)(_ + _)

  }

}
