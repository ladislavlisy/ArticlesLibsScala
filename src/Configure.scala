package Scalabox

import Scalabox.{Article, ConfigArticleCode, ProcessCategory}

/**
  * Created by ladislavlisy on 25.03.16.
  */
object Configure {
  val EMPTY_PENDING_NAMES = Array[Int]()

  def PendingArticleNames1(code1: Int): Array[Int] = {
    Array[Int](code1)
  }

  def ConfigureContractTermArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_TERMS

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_CONTRACT_EMPL_TERM, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_POSITION_EMPL_TERM, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_CONTRACT_EMPL_TERM))
    )
    articleArray
  }

  def ConfigureArticles(): Array[Article] = {
    ConfigureContractTermArticles()
  }
}
