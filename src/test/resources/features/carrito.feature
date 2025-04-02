Feature: Agregar productos al carrito
  Como usuario de SauceDemo
  Quiero poder agregar productos al carrito
  Para completar mi compra con los productos deseados


  Background:
    Given el usuario ha iniciado sesión correctamente en Sauce Demo
@AgregarProducto
  Scenario: Agregar un producto al carrito
    Given me encuentro en la página de productos
    When agrego el producto "Sauce Labs Backpack" al carrito
    Then el número de productos en el carrito debería ser 1

@VerificarCarrito
  Scenario: Ver productos en el carrito
    Given que he agregado el producto "Sauce Labs Backpack" al carrito
    When entro al detalle del carrito
    Then debería mostrarse en la lista de productos "Sauce Labs Backpack"