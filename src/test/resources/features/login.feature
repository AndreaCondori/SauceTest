Feature: Inicio de sesión en SauceDemo
    Como usuario de SauceDemo
    Quiero poder iniciar sesión con mis credenciales
    Para acceder a la tienda
@LoginExitoso
  Scenario: Login exitoso
    Given el usuario navega a la página de login
    When ingresa credenciales "standard_user" y "secret_sauce"
    Then debería poder ver la página de productos


  @LginInvalido
  Scenario Outline: Login con credenciales inválidas
    Given el usuario navega a la página de login
    When ingresa credenciales "<username>" y "<password>"
    Then debería ver el mensaje de error "<message>"

    Examples:
      | username        | password     | message                                                                   |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |
      | wrong_user      | secret_sauce | Epic sadface: Username and password do not match any user in this service                                                                          |
      |                 | secret_sauce | Epic sadface: Username is required |
      | standard_user   |              | Epic sadface: Password is required                                        |