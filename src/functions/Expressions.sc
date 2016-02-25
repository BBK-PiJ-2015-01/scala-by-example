package functions

object Expressions {

  println("Expressions")                          //> Expressions

  /*
  * The binary operation E op E' is always interpreted as the method call E.op(E').
  */
  case class Integer(value: Int) {
    def +(i: Int) = value + i
    def<(i: Int) = (value < i)
  }

  val seven = Integer(5) + 2                      //> seven  : Int = 7
  Integer(7) < 9                                  //> res0: Boolean = true
}