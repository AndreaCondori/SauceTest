package stepsDefinitions;

import com.microsoft.playwright.Page;
import core.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import page.ProductoPage;
import steps.LoginSteps;

public class LoginStepDefinitions {
    private LoginSteps loginSteps;
    private ProductoPage productosPage;

    public LoginStepDefinitions() {
        loginSteps = new LoginSteps(DriverManager.getPage());
        productosPage= new ProductoPage(DriverManager.getPage());
    }

    @Given("el usuario navega a la página de login")
    public void elUsuarioNavegaALaPaginaDeLogin() {

        loginSteps.IrLoging();
    }

    @When("ingresa credenciales {string} y {string}")
    public void ingresaCredencialesValidasY(String username, String pass) {
        loginSteps.login(username,pass);

    }

    @Then("debería poder ver la página de productos")
    public void deberiaPoderVerLaPaginaDeProductos() {
        Assert.assertTrue("no se cargó la pagina correctamente",productosPage.paginaCargada());
    }


    @Then("debería ver el mensaje de error {string}")
    public void deberiaVerElMensajeDeError(String msjError) {
        Assert.assertTrue("El message errror no es el esperado",loginSteps.validateErrorMessage(msjError.trim()));
    }
}