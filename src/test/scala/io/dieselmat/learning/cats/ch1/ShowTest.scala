package io.dieselmat.learning.cats.ch1

import org.scalatest.FlatSpec

import cats.Show.ops._
import ShowInstances._

class ShowTest extends FlatSpec  {

  "A Cat Show instance" should "print a cat as a string" in {
    val fatCat = Cat("fatCat", 4, "purple")
    assert("fatCat is a 4 year-old purple cat" == fatCat.show)

  }

}
