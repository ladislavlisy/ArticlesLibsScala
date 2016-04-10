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

  def PendingArticleNames2(code1: Int, code2: Int): Array[Int] = {
    Array[Int](code1, code2)
  }

  def PendingArticleNames3(code1: Int, code2: Int, code3: Int): Array[Int] = {
    Array[Int](code1, code2, code3)
  }

  def PendingArticleNames4(code1: Int, code2: Int, code3: Int, code4: Int): Array[Int] = {
    Array[Int](code1, code2, code3, code4)
  }

  def PendingArticleNames5(code1: Int, code2: Int, code3: Int, code4: Int, code5: Int): Array[Int] = {
    Array[Int](code1, code2, code3, code4, code5)
  }

  def PendingArticleNames9(code1: Int, code2: Int, code3: Int, code4: Int, code5: Int, code6: Int, code7: Int, code8: Int, code9: Int): Array[Int] = {
    Array[Int](code1, code2, code3, code4, code5, code6, code7, code8, code9)
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

  def ConfigurePositionTimeArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_TIMES

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_SCHEDULE_WORK, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_POSITION_EMPL_TERM
        )),
      new Article(ConfigArticleCode.ARTICLE_TIMESHEET_SCHEDULE, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SCHEDULE_WORK
        )),
      new Article(ConfigArticleCode.ARTICLE_TIMESHEET_WORKING, configCategory,
        PendingArticleNames2(
          ConfigArticleCode.ARTICLE_TIMESHEET_SCHEDULE,
          ConfigArticleCode.ARTICLE_POSITION_EMPL_TERM
        )),
      new Article(ConfigArticleCode.ARTICLE_TIMESHEET_ABSENCE, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TIMESHEET_WORKING
        )),
      new Article(ConfigArticleCode.ARTICLE_TIMEHOURS_WORKING, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TIMESHEET_WORKING
        )),
      new Article(ConfigArticleCode.ARTICLE_TIMEHOURS_ABSENCE, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TIMESHEET_ABSENCE
        ))
    )
    articleArray
  }

  def ConfigureGrossIncomeArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_AMOUNT

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_SALARY_BASE, configCategory,
        PendingArticleNames2(
          ConfigArticleCode.ARTICLE_TIMEHOURS_WORKING,
          ConfigArticleCode.ARTICLE_TIMEHOURS_ABSENCE
        ))
    )
    articleArray
  }

  def ConfigureTotalIncomeArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_FINAL

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_INCOME_GROSS, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_INCOME_NETTO, configCategory,
        PendingArticleNames9(
          ConfigArticleCode.ARTICLE_INCOME_GROSS,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_TOTAL,
          ConfigArticleCode.ARTICLE_TAXING_BONUS_CHILD,
          ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_GENERAL,
          ConfigArticleCode.ARTICLE_HEALTH_EMPLOYEE_GENERAL,
          ConfigArticleCode.ARTICLE_HEALTH_EMPLOYEE_MANDATORY,
          ConfigArticleCode.ARTICLE_SOCIAL_EMPLOYEE_GENERAL,
          ConfigArticleCode.ARTICLE_SOCIAL_EMPLOYEE_PENSION,
          ConfigArticleCode.ARTICLE_GARANT_EMPLOYEE_PENSION
        ))
    )
    articleArray
  }

  def ConfigureNettoDeductsArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_TOTAL, configCategory,
        PendingArticleNames2(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_GENERAL,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_SOLIDARY
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_BASIS_GENERAL
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_SOLIDARY, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_BASIS_SOLIDARY
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_BASIS_GENERAL
        )),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_EMPLOYEE_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_HEALTH_BASIS_GENERAL
        )),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_EMPLOYEE_MANDATORY, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_HEALTH_BASIS_MANDATORY
        )),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_EMPLOYEE_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_BASIS_GENERAL
        )),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_EMPLOYEE_PENSION, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_BASIS_PENSION
        )),
      new Article(ConfigArticleCode.ARTICLE_GARANT_EMPLOYEE_PENSION, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_GARANT_BASIS_PENSION
        ))
    )
    articleArray
  }

  def ConfigureBasisHealthArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_HEALTH_INCOME_SUBJECT, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_INCOME_PARTICIP, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_HEALTH_INCOME_SUBJECT
        )),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_BASIS_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_HEALTH_INCOME_PARTICIP
        )),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_BASIS_MANDATORY, configCategory,
        PendingArticleNames2(
          ConfigArticleCode.ARTICLE_HEALTH_BASIS_GENERAL,
          ConfigArticleCode.ARTICLE_HEALTH_INCOME_PARTICIP
        )),
      new Article(ConfigArticleCode.ARTICLE_HEALTH_BASIS_LEGALCAP, configCategory,
        PendingArticleNames2(
          ConfigArticleCode.ARTICLE_HEALTH_BASIS_GENERAL,
          ConfigArticleCode.ARTICLE_HEALTH_INCOME_PARTICIP
        ))
    )
    articleArray
  }

  def ConfigureBasisSocialArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_INCOME_SUBJECT, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_INCOME_PARTICIP, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_INCOME_SUBJECT
        )),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_BASIS_GENERAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_INCOME_PARTICIP
        )),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_BASIS_PENSION, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_INCOME_PARTICIP
        )),
      new Article(ConfigArticleCode.ARTICLE_SOCIAL_BASIS_LEGALCAP, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_SOCIAL_INCOME_PARTICIP
        ))
    )
    articleArray
  }

  def ConfigureBasisGarantArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_GARANT_INCOME_SUBJECT, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_GARANT_INCOME_PARTICIP, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_GARANT_INCOME_SUBJECT
        )),
      new Article(ConfigArticleCode.ARTICLE_GARANT_BASIS_PENSION, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_GARANT_INCOME_PARTICIP
        )),
      new Article(ConfigArticleCode.ARTICLE_GARANT_BASIS_LEGALCAP, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_GARANT_INCOME_PARTICIP
        ))
    )
    articleArray
  }

  def ConfigureBasisTaxingArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_INCOME_SUBJECT, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_TAXING_INCOME_HEALTH, configCategory,
        EMPTY_PENDING_NAMES),
      new Article(ConfigArticleCode.ARTICLE_TAXING_INCOME_SOCIAL, configCategory,
        EMPTY_PENDING_NAMES)
    )
    articleArray
  }

  def ConfigureBasisAdvancesArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_SUBJECT
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_HEALTH, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_HEALTH
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_SOCIAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_SOCIAL
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_BASIS_GENERAL, configCategory,
        PendingArticleNames3(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_HEALTH,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_SOCIAL
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ADVANCES_BASIS_SOLIDARY, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_BASIS_GENERAL
        ))
    )
    articleArray
  }

  def ConfigureBasisWithholdArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_INCOME, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_SUBJECT
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_HEALTH, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_HEALTH
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_SOCIAL, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_INCOME_SOCIAL
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_BASIS_GENERAL, configCategory,
        PendingArticleNames3(
          ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_INCOME,
          ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_HEALTH,
          ConfigArticleCode.ARTICLE_TAXING_WITHHOLD_SOCIAL
        ))
    )
    articleArray
  }

  def ConfigureAllowanceTaxisArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_PAYER, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_DISABILITY, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_STUDYING, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_CHILD, configCategory,
        PendingArticleNames1(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_INCOME
        ))
    )
    articleArray
  }

  def ConfigureRebateTaxisArticles(): Array[Article] = {
    val configCategory = ProcessCategory.CATEGORY_NETTO

    val articleArray = Array[Article](
      new Article(ConfigArticleCode.ARTICLE_TAXING_REBATE_PAYER, configCategory,
        PendingArticleNames4(
          ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_PAYER,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_TOTAL,
          ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_DISABILITY,
          ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_STUDYING
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_REBATE_CHILD, configCategory,
        PendingArticleNames3(
          ConfigArticleCode.ARTICLE_TAXING_ALLOWANCE_CHILD,
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_TOTAL,
          ConfigArticleCode.ARTICLE_TAXING_REBATE_PAYER
        )),
      new Article(ConfigArticleCode.ARTICLE_TAXING_BONUS_CHILD, configCategory,
        PendingArticleNames3(
          ConfigArticleCode.ARTICLE_TAXING_ADVANCES_TOTAL,
          ConfigArticleCode.ARTICLE_TAXING_REBATE_PAYER,
          ConfigArticleCode.ARTICLE_TAXING_REBATE_CHILD
        ))
    )
    articleArray
  }

  def ConfigureArticles(): Array[Article] = {
    ConfigureContractTermArticles()
  }
}
