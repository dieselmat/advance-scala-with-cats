package io.dieselmat.learning.cats.ch2

trait Monoid[A] extends Semigroup[A]{
  def empty: A
}

object Monoid {
  def apply[A](implicit monoid: Monoid[A]) = monoid

  implicit val orMonoid: Monoid[Boolean] = new Monoid[Boolean]{
    override def empty = false
    override def combine(x: Boolean, y: Boolean) = x || y
  }

  implicit val andMonoid: Monoid[Boolean] = new Monoid[Boolean]{
    override def empty = true
    override def combine(x: Boolean, y: Boolean) = x && y
  }

  implicit val xOrMonoid: Monoid[Boolean] = new Monoid[Boolean]{
    override def empty = false
    override def combine(x: Boolean, y: Boolean) = (x && !y) || ( !x && y)
  }

  implicit val xNorMonoid: Monoid[Boolean] = new Monoid[Boolean]{
    override def empty = true
    override def combine(x: Boolean, y: Boolean) = (x || !y) && ( !x || y)
  }

  implicit def setCombine[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty[A]
    override def combine(x: Set[A], y: Set[A]): Set[A] = x union y

  }
}

