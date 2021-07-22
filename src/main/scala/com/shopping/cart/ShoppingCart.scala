package com.shopping.cart

object Item extends Enumeration {
  type Item = Value
  val Apple, Orange = Value
}

import Item._

class ShoppingCart {
  private def getValue(item:Item): Double = {
    item match {
      case Apple => 0.6
      case Orange => 0.25
    }
  }

  private def get3for2OrangesDiscount(items: List[Item]): Double = {
    val oranges = items.count(i => i == Orange)
    (oranges / 3) * getValue(Orange)
  }

  private def getBuyOneGetOneFreeApplesDiscount(items: List[Item]): Double = {
    val apples = items.count(i => i == Apple)
    (apples / 2) * getValue(Apple)
  }

  private def getTotal(items: List[Item]): Double = {
    items.map(getValue).reduce( _ + _)
  }

  private def getDiscounts(items: List[Item]): Double = {
    get3for2OrangesDiscount(items) + getBuyOneGetOneFreeApplesDiscount(items)
  }

  def checkout(items: List[Item]): Double = {
    getTotal(items) - getDiscounts(items)
  }
}
