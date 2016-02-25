package functions

object FirstClass {

  println("First class functions")                //> First class functions

  // recursive function with signature sum(Function, Int, Int)
  def sum(f: Int => Int, a: Int, b: Int): Int = if (a > b) 0 else f(a) + sum(f, a + 1, b)
                                                  //> sum: (f: Int => Int, a: Int, b: Int)Int

  // So the sum of powers of 2
  def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
                                                  //> sumPowersOfTwo: (a: Int, b: Int)Int
  // where
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)
                                                  //> powerOfTwo: (x: Int)Int

  sumPowersOfTwo(1, 10)                           //> res0: Int = 2046

  // Simple implementation of sum()
  def sumOfSquares(a: Int, b: Int) = sum(x => x * x, a, b)
                                                  //> sumOfSquares: (a: Int, b: Int)Int
  sumOfSquares(1, 10)                             //> res1: Int = 385

  println("Currying")                             //> Currying

  // sum5_2 takes a function (Int => Int) and returns function (Int,Int) => Int
  // 5_2 refers to the chapter number
  def sum5_2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum5_2: (f: Int => Int)(Int, Int) => Int

  // now sum of squares can be defined
  def sumOfSquares5_2 = sum5_2(x => x * x)        //> sumOfSquares5_2: => (Int, Int) => Int

  // sumOfSquares5_2(..) returns a function which takes (Int,Int) as parameters
  // function application associates to the left so the the second set of parameters is passed to
  // the function returned from sum5_2
  sumOfSquares5_2(1, 10)                          //> res2: Int = 385

  // with event less code the cube function x*x*x can be applied to a number range
  sum5_2(x => x * x * x)(1, 100)                  //> res3: Int = 25502500

  // With special syntax ( function types associate to the right.)
  def sumSS(f: Int => Int)(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumSS(f)(a + 1, b)
                                                  //> sumSS: (f: Int => Int)(a: Int, b: Int)Int

  sumSS(x => x * x * x)(1, 50)                    //> res4: Int = 1625625

  //
  //	Special syntax example: take an Int => Int function and apply it to a second parameter
  //
  def specialSyntax(f: Int => Int)(y: Int): Int = f(y)
                                                  //> specialSyntax: (f: Int => Int)(y: Int)Int

  specialSyntax(x => x + 13)(13)                  //> res5: Int = 26

  // product is the the product of the function f over a:b
  def product(f: Int => Int)(a: Int, b: Int): Int = if (a > b) 1 else f(a) * product(f)(a + 1, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int
                                                 
  product(x => x)(1, 5)                           //> res6: Int = 120
  product(x => x*x)(1, 5)                         //> res7: Int = 14400
  
  
}