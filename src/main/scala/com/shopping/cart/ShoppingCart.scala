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

  private def getTotal(items: List[Item]): Double = {
    items.map(getValue).reduce( _ + _)
  }

  def checkout(items: List[Item]): Double = {
      getTotal(items)
  }
}
