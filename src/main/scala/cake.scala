
class A {

}

class WheatField

class Mill(wheatField: WheatField)

class CowPasture

class DairyFarm(cowPasture: CowPasture)

class Bakery(mill: Mill, dairyFarm: DairyFarm)

class EspressoMachine()

class Cafe(bakery: Bakery, espressoMachine: EspressoMachine) {
  def orderCoffeeAndCroissant(): Unit = {
    //
    ////    val myDBIOAction = for {
    ////      _ <- create()
    ////      _ <- save()
    ////      _ <- DBIO.from(client.send())
    ////    } yield something
    ////
    ////    db.run(myDBIOAction.transactionally)
    ////  }

  }


  trait CropModule {
    lazy val wheatField = new WheatField()
    lazy val mill = new Mill(wheatField)
  }

  trait LivestockModule {
    lazy val cowPasture = new CowPasture()
    lazy val dairyFarm = new DairyFarm(cowPasture)
  }


  // composition via inheritance: bakery depends on crop and livestock modules
  trait BakeryModule extends CropModule with LivestockModule {
    lazy val bakery = new Bakery(mill, dairyFarm)
  }

  // abstract member: we need a bakery
  trait CafeModule {
    lazy val espressoMachine = new EspressoMachine()
    lazy val cafe = new Cafe(bakery, espressoMachine)

    def bakery: Bakery
  }

  // the abstract bakery member is implemented in another module
  object CafeApp extends CafeModule with BakeryModule {
    cafe.orderCoffeeAndCroissant()
  }
}