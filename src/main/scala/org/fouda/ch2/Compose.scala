package org.fouda.ch2

/*
Let’s look at a final example, function composition, which feeds the output of one function to the input of another function.
Again, the implementation of this function is fully determined by its type signature.

 Exercise 2.5
Implement the higher-order function that composes two functions.

def compose[A,B,C](f: B => C, g: A => B): A => C
This is such a common thing to want to do that Scala’s standard library provides compose as a method on Function1 (the interface for functions that take one argument).
To compose two functions f and g, we simply say f compose g.[10] It also provides an andThen method. f andThen g is the same as g compose f:
10 Solving the compose exercise by using this library function is considered cheating.

scala> val f = (x: Double) => math.Pi / 2 - x
f: Double => Double = <function1>

scala> val cos = f andThen math.sin
cos: Double => Double = <function1>
 */
object Compose {
  def compose[A, B, C](f: B => C, g: A => B): A => C =
    (a: A) => (f.apply(g.apply(a)))

  def main(args: Array[String]): Unit = {
    assert(3 == compose(((b: Int) => b + 1), ((a: Int) => a * 2))(1))
    val composeWithLib = ((a: Int) => a * 2) andThen ((b: Int) => b + 1)  //Compose many functions where output of first is the input to second and so on
    assert(3 == composeWithLib(1))//Call first function with input to trigger the chain
  }
}
