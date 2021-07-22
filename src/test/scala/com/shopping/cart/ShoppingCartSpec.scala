package com.shopping.cart

import Item._
import org.scalatest.funsuite.AnyFunSuite

class ShoppingCartTest extends AnyFunSuite {
  test("ShoppingCart.checkout.empty") {
    val items = List()
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 0)
  }

  test("ShoppingCart.checkout.single") {
    val items = List(Apple)
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 0.6)
  }

  test("ShoppingCart.checkout") {
    val items = List(Apple, Orange)
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 0.85)
  }

  test("ShoppingCart.checkout.3for2Oranges") {
    val items = List(Apple, Orange, Orange, Orange)
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 1.1)

    val items2 = List(Apple, Orange, Orange, Orange, Orange, Orange, Orange, Orange)
    assert(cart.checkout(items2) === 1.85)
  }

  test("ShoppingCart.checkout.BuyOneGetOneFreeApples") {
    val items = List(Apple, Apple, Apple, Apple)
    val cart = new ShoppingCart()
    assert(cart.checkout(items) === 1.2)

    val items2 = List(Apple, Apple, Orange)
    assert(cart.checkout(items2) === 0.85)
  }
}