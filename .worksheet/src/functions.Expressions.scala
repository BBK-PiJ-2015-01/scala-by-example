package functions

object Expressions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(65); 

  println("Expressions")

  /*
  * The binary operation E op E' is always interpreted as the method call E.op(E').
  */
  case class Integer(value: Int) {
    def +(i: Int) = value + i
    def <(i: Int) = (value < i)
  };$skip(226); 

  val seven = Integer(5) + 2;System.out.println("""seven  : Int = """ + $show(seven ));$skip(17); val res$0 = 
  Integer(7) < 9;System.out.println("""res0: Boolean = """ + $show(res$0));$skip(24); 

  println("Recursion");$skip(96); 

  // not tail recursive
  def factorial(n: Int): Int = if (n == 1) 1 else n * factorial(n - 1);System.out.println("""factorial: (n: Int)Int""");$skip(15); val res$1 = 
  factorial(6);System.out.println("""res1: Int = """ + $show(res$1));$skip(142); 
  // tail recursive
  def tailFact(n: Int): Int = {
    def f(n: Int, acc: Int): Int = if (n == 1) acc else f(n - 1, n * acc)
    f(n, 1)
  };System.out.println("""tailFact: (n: Int)Int""");$skip(14); val res$2 = 
  tailFact(6);System.out.println("""res2: Int = """ + $show(res$2))}
}
