package Scalabox

/**
  * Created by ladislavlisy on 25.03.16.
  */
case class Article(code: Int, catg: Int, pendings: Array[Int]) {
  def compareTo(other:Article):Int = {
    code.compareTo(other.code)
  }

  def equalTo(other:Article): Boolean = {
    code == other.code
  }

  def ==(other: Article): Boolean = {
    code == other.code
  }
  def !=(other: Article): Boolean = {
    code != other.code
  }
  def < (other: Article): Boolean = {
    code < other.code
  }
  def > (other: Article): Boolean = {
    code > other.code
  }
  def <=(other: Article): Boolean = {
    code <= other.code
  }
  def >=(other: Article): Boolean = {
    code >= other.code
  }
}
