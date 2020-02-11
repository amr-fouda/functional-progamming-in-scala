package org.fouda.ch2

/*
Implement uncurry, which reverses the transformation of curry. Note that since => associates to the right, A => (B => C) can be written as A => B => C.

def uncurry[A,B,C](f: A => B => C): (A, B) => C
 */
object Uncurry {
  //Parentheses for clarification
  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f.apply(a).apply(b)

  def main(args: Array[String]): Unit = {
    assert(3 == uncurry((x: Int) => ((y: Int) => (x + y)))(1, 2))
  }
}
