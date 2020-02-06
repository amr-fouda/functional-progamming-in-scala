package org.fouda.ch2

import scala.annotation.tailrec

/*
 Write a recursive function to get the nth Fibonacci number (http://mng.bz/C29s).
 The first two Fibonacci numbers are 0 and 1.
 The nth number is always the sum of the previous two—the sequence begins 0, 1, 1, 2, 3, 5. Your definition should use a local tail-recursive function.
  fib(3) = fib(2)+fib(1)
  0, 1, 2, 3, 4, 5
  0, 1, 1, 2, 3, 5
*/
object Fibonacci {
  //Tail recursive solution //Compiler knows to optimise it by essentially turning it into a while loops
  def fibWithTailRecursive(n: Int): Int = {
    @tailrec
    def fib(i: Int, n: Int, x: Int, y: Int): Int = {
      if (i == n) x + y
      else
        fib(i + 1, n, y, x + y)
    }
    if (n == 0) 0
    else if (n == 1) 1
    else fib(2, n, 0, 1)
  }

  //Recursive solution
  def fibWithRegularRecursive(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case n => fibWithRegularRecursive(n - 1) + fibWithRegularRecursive(n - 2)
    }
  }

  def main(args: Array[String]): Unit = {
    assert(fibWithRegularRecursive(0) == 0 && fibWithTailRecursive(0) == 0)
    assert(fibWithRegularRecursive(1) == 1 && fibWithTailRecursive(1) == 1)
    assert(fibWithRegularRecursive(2) == 1 && fibWithTailRecursive(2) == 1)
    assert(fibWithRegularRecursive(3) == 2 && fibWithTailRecursive(3) == 2)
    assert(fibWithRegularRecursive(4) == 3 && fibWithTailRecursive(4) == 3)
    println("Assertion finished.")
  }
}

