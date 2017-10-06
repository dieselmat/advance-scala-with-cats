package io.dieselmat.learning.cats.ch1

import java.util.Date
import cats.instances.long._
import cats.instances.string._
import cats.instances.int._
import cats.syntax.eq._

import cats.Eq

object EqualInstances {

  implicit val dateEqual = Eq.instance[Date] { (d1, d2) =>
    d1.getTime === d2.getTime
  }

  implicit val catEqual = Eq.instance[Cat] { (c1, c2) =>
    c1.name === c2.name && c1.age === c2.age && c1.color === c2.color
  }

}
