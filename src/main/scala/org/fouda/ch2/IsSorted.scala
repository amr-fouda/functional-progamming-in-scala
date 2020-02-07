package org.fouda.ch2

import scala.annotation.tailrec

object main {

  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def isSorted[A](i: Int): Boolean = {
      if (i + 1 >= as.length) true
      else if (ordered.apply(as(i), as(i + 1))) isSorted(i + 1)
      else false
    }

    isSorted(0)
  }

  def main(args: Array[String]): Unit = {
    assert(isSorted(Array(1, 2, 3), (x: Int, y: Int) => x.compareTo(y) <= 0))
    assert(isSorted(Array(-1, 1, 200), (x: Int, y: Int) => x.compareTo(y) <= 0))
    assert(isSorted(Array(Student(10, "Amr"), Student(20, "alaa")), (x: Student, y: Student) => x.age.compareTo(y.age) <= 0))
    assert(!isSorted(Array(100, 2, 3), (x: Int, y: Int) => x.compareTo(y) <= 0))
    assert(!isSorted(Array(Student(100, "Amr"), Student(20, "alaa")), (x: Student, y: Student) => x.age.compareTo(y.age) <= 0))
    println("Assertion finished")
  }

}

case class Student(age: Int, name: String)
