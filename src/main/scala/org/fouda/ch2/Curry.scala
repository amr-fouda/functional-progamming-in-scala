package org.fouda.ch2

/*
currying,[9] which converts a function f of two arguments into a function of one argument that partially applies f.
Here again there’s only one implementation that compiles. Write this implementation.
def curry[A,B,C](f: (A, B) => C): A => (B => C)

 */
object Curry {
  //Parentheses for clarification
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => ((b: B) => (f.apply(a, b)))

  def main(args: Array[String]): Unit = {
    assert(4 == curry((x: Int, y: Int) => x + y)(2)(2))
    assert(6 == curry((x: Int, y: Int) => x * y)(3)(2))
  }
}
