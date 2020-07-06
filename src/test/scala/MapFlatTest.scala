import com.amazonaws.services.stepfunctions.builder.states.WaitFor
import flatmap.MapFlat
import fold.FoldDemo

import org.scalatest.BeforeAndAfterAll
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MapFlatTest extends AnyFlatSpec with BeforeAndAfterAll with WaitFor with Matchers {

  "trying some mapflat " should "run" in {
    var mapFlat: MapFlat = new MapFlat
    mapFlat.mapflat()

    var fold: FoldDemo = new FoldDemo
    println(fold.fold())

    val inputList: List[Int] = List(1, 3, 5)
    inputList.foldLeft(0) { (acc, i) => acc + i }

    val mapTest = new MapTest
  }

}
