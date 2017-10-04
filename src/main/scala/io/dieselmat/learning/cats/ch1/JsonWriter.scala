package io.dieselmat.learning.cats.ch1

trait JsonWriter[A] {
  def write(value: A): Json
}

object JsonWriterInstances {

  implicit val stringJsonWriter: JsonWriter[String] = new JsonWriter[String] {
    override def write(value: String): Json = JsString(value)
  }

  implicit val intJsonWriter: JsonWriter[Int] = new JsonWriter[Int] {
    override def write(value: Int): Json = JsNumber(value)
  }

  implicit val doubleJsonWriter: JsonWriter[Double] = new JsonWriter[Double] {
    override def write(value: Double): Json = JsNumber(value)
  }

  implicit val personJsonWriter: JsonWriter[Person] = new JsonWriter[Person] {
    override def write(value: Person): Json = JsObject(Map(
      "name" -> JsString(value.name),
      "email" -> JsString(value.email)
    ))
  }


}

object JsonWriter {
  def write[A](value: A)(implicit jsonWriter: JsonWriter[A]) = jsonWriter.write(value)

  object ops {
    implicit class JsonWriterOps[A](value: A) {
      def write(implicit w: JsonWriter[A]): Json = w.write(value)
    }
  }
}

