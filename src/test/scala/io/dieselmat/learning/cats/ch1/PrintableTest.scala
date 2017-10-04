package io.dieselmat.learning.cats.ch1

import org.scalatest.FlatSpec

import io.dieselmat.learning.cats.ch1.Printable._
import io.dieselmat.learning.cats.ch1.Printable.ops._
import io.dieselmat.learning.cats.ch1.PrintableInstances._


class PrintableTest extends FlatSpec {

  "A Printable" should "print a string" in {
    assert("Hello World" == "Hello World".formatX)

  }

  it should "print an Int" in  {
    assert("123456" == 123456.formatX)
  }

  it should "print a Cat" in {
    val fatCat = Cat("fatCat", 4, "purple")
    assert("fatCat is a 4 year-old purple cat" == fatCat.formatX)
  }

}
