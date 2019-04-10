package flatmap


class MapFlat {

  def mapflat(): Unit = {


    // flatmap = map + flatten
    val list = List(1, 2, 3, 4, 5, 6)
    println(list.map(x => g(x)))
    println(list.flatMap(x => g(x)))
    println(list.map(x => g(x)).flatten)
  }


  def g(v: Int) = List(v-1, v, v+1)
}
