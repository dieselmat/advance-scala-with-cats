package io.dieselmat.learning.cats.ch1

import java.util.Date

import cats.syntax.eq._
import cats.instances.long._
import io.dieselmat.learning.cats.ch1.EqualInstances._

import org.scalatest.FlatSpec

class EqTest extends FlatSpec {

  "A Date Eq instance" should "equal two dates of the same value" in  {
    val x = new Date()
    val y = new Date()

    //assert(x === x)
    //assert(x === y)

  }



}
