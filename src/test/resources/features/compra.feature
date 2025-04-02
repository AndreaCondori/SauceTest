

Feature: Proceso de compra
  Como usuario de Sauce Demo
  Quiero completar la compra de productos
  Para finalizar mi pedido
  Background:
    Given el usuario ha iniciado sesión correctamente en Sauce Demo

  @CompletarCompra
  Scenario: Completar el formulario de checkout con datos validos
    Given que he agregado los siguientes productos al carrito:
      | Producto              | Precio |
      | Sauce Labs Bike Light | $9.99  |
    And entro al detalle del carrito
    And entro al formulario de pago
    When completo el formulario con "Juan" "Pérez" "12345"
    Then debería ver el resumen de compra con:
      | Producto              | Precio |
      | Sauce Labs Bike Light | $9.99  |
    And el subtotal debería ser "$9.99"

  @FinalizarCompra
  Scenario: Confirmar compra y verificar mensaje final
    Given que he agregado el producto "Sauce Labs Backpack" al carrito
    And entro al detalle del carrito
    And entro al formulario de pago
    When completo el formulario con "Juan" "Pérez" "12345"
    When confirmo la orden
    Then debería ver el mensaje de confirmación "Thank you for your order!"

  @CheckoutNegativo
  Scenario Outline: Continuar checkout con datos incompletos
    Given que he agregado el producto "Sauce Labs Bolt T-Shirt" al carrito
    And he iniciado el proceso de checkout
    When intento completar el formulario con "<Nombre>" "<Apellido>" "<Postal>"
    Then debería mostrar el siguiente mensaje "<Mensaje de error>"

    Examples:
      | Nombre | Apellido | Postal | Mensaje de error               |
      |        | Pérez    | 12345  | Error: First Name is required  |
      | Juan   |          | 12345  | Error: Last Name is required   |
      | Juan   | Pérez    |        | Error: Postal Code is required |
      |        |          |        | Error: First Name is required  |

