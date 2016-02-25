package functions

object Expressions {

  println("Expressions")                          //> Expressions

  /*
  * The binary operation E op E' is always interpreted as the method call E.op(E').
  */
  case class Integer(value: Int) {
    def +(i: Int) = value + i
    def <(i: Int) = (value < i)
  }

  val seven = Integer(5) + 2                      //> seven  : Int = 7
  Integer(7) < 9                                  //> res0: Boolean = true

  println("Recursion")                            //> Recursion

  // not tail recursive
  def factorial(n: Int): Int = if (n == 1) 1 else n * factorial(n - 1)
                                                  //> factorial: (n: Int)Int
  factorial(6)                                    //> res1: Int = 720
  // tail recursive
  def tailFact(n: Int): Int = {
    def f(n: Int, acc: Int): Int = if (n == 1) acc else f(n - 1, n * acc)
    f(n, 1)
  }                                               //> tailFact: (n: Int)Int
  tailFact(6)                                     //> res2: Int = 720
}