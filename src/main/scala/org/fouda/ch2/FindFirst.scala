package org.fouda.ch2

import scala.annotation.tailrec

object FindFirst {

  def findFirstWithGeneric[T](arr: Array[T], input: T): Int = {
    @tailrec
    def find(i: Int): Int = {
      if (i >= arr.length) -1
      else if (arr(i) == input) i
      else find(i + 1)
    }

    find(0)
  }

  def findFirst(arr: Array[String], input: String): Int = {
    @tailrec
    def find(i: Int): Int = {
      if (i >= arr.length) -1
      else if (arr(i) == input) i
      else find(i + 1)
    }

    find(0)
  }


  def main(args: Array[String]): Unit = {
    assert(findFirst(Array("a", "b", "c"), "a") == 0 && findFirstWithGeneric(Array("a", "b", "c"), "a") == 0)
    assert(findFirst(Array("a", "b", "c"), "b") == 1 && findFirstWithGeneric(Array("a", "b", "c"), "b") == 1)
    assert(findFirst(Array("a", "b", "c"), "c") == 2 && findFirstWithGeneric(Array("a", "b", "c"), "c") == 2)
    assert(findFirst(Array("a", "b", "c"), "d") == -1 && findFirstWithGeneric(Array("a", "b", "c"), "d") == -1)
    assert(findFirstWithGeneric(Array(1, 2, 3), 1) == 0)
    assert(findFirstWithGeneric(Array(1, 2, 3), 4) == -1)
    assert(findFirstWithGeneric(Array(Student("Amr"), Student("Alaa")), Student("Amr")) == 0)
    assert(findFirstWithGeneric(Array(Student("Amr"), Student("Alaa")), Student("Mohamed")) == -1)
    println("Assertion finished")
  }

}

case class Student(name: String)
