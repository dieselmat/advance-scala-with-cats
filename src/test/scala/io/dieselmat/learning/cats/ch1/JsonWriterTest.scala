package io.dieselmat.learning.cats.ch1

import org.scalatest.FlatSpec

import io.dieselmat.learning.cats.ch1.JsonWriter._
import io.dieselmat.learning.cats.ch1.JsonWriter.ops._
import io.dieselmat.learning.cats.ch1.JsonWriterInstances._

class JsonWriterTest extends FlatSpec {

  "A JsonWriter" should "write a JsString from a string" in {
    assert(JsString("Hello World") == "Hello World".write)
    assert(JsString("World Hello") == write("World Hello"))
  }

  it should "write a JsNumber from a number" in {
    assert(JsNumber(123456) == 123456.write)
    assert(JsNumber(987654) == write(987654))
  }

  it should "write a JsObect from a person case class" in {
    val person = Person("diesel mat", "diesel@mat.com")
    val jsPerson = JsObject(Map(
      "name" -> JsString("diesel mat"),
      "email" -> JsString("diesel@mat.com")
    ))
    assert(jsPerson == person.write)
  }

}
