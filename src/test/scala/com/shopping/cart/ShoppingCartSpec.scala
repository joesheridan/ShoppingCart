package com.shopping.cart

import Item._
import org.scalatest.funsuite.AnyFunSuite

class ShoppingCartTest extends AnyFunSuite {
  test("ShoppingCart.checkout") {
    val items = List(Apple, Orange)
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 0.85)
  }
}