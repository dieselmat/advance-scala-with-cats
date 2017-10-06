package io.dieselmat.learning.cats.ch2

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

object Semigroup {
  implicit def setInterSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
  }
}
