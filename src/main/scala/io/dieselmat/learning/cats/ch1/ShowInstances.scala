package io.dieselmat.learning.cats.ch1

import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.Show.ops._

object ShowInstances {

  implicit val shownCats: Show[Cat] = new Show[Cat] {
    override def show(t: Cat): String = {
      val name = t.name.show
      val age = t.age.show
      val color = t.color.show
      s"$name is a $age year-old $color cat"
    }
  }

}
