package io.dieselmat.learning.cats.ch1

trait Printable[A] {
  def formatX(value: A): String
}

object PrintableInstances {


  implicit val stringPrintable: Printable[String] = new Printable[String] {
    override def formatX(value: String): String = value
  }

  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def formatX(value: Int): String = value.toString
  }

  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    override def formatX(cat: Cat): String = {
      val name = Printable.formatX(cat.name)
      val age = Printable.formatX(cat.age)
      val color = Printable.formatX(cat.color)
      s"$name is a $age year-old $color cat"

    }
  }

}

object Printable {

  object ops {
    implicit class PrintableOps[A](value: A) {
      def formatX(implicit p: Printable[A]) = p.formatX(value)
    }
  }

  def formatX[A](value: A)(implicit p: Printable[A]) = p.formatX(value)
  def print[A](value: A)(implicit p: Printable[A]) = println(formatX(value))

}


