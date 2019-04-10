class MapTest {
    val ll = List((1, 2), (3, 4), (5, 6))
    println(ll.map {case (x: Int, y: Int) => x + y})

}
