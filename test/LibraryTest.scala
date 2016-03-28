package Scalabox.Test

/**
  * Created by lisy on 14.9.15.
  */

import Scalabox.Configure
import Scalabox.Article
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

/**
  * Requires ScalaTest and JUnit4.
  */
@RunWith(classOf[JUnitRunner])
class LibraryTest extends FunSuite with BeforeAndAfter {

  before {
  }

  test("Should_Return_53_For_Articles_Length") {
    val articlesAll: Array[Article] = Configure.ConfigureArticles()
    assert(53 == articlesAll.length)
  }
}
