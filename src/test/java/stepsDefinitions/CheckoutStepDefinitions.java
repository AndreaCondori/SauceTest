package stepsDefinitions;

import com.microsoft.playwright.Page;
import core.DriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.CarritoSteps;
import steps.CheckoutSteps;
import steps.ProductosSteps;

public class CheckoutStepDefinitions {
    private Page page;
    private ProductosSteps productosSteps;
    private CarritoSteps carritoSteps;
    private CheckoutSteps checkoutSteps;

    public CheckoutStepDefinitions() {
        this.page = DriverManager.getPage();
        productosSteps = new ProductosSteps(page);
        carritoSteps = new CarritoSteps(page);
        checkoutSteps = new CheckoutSteps(page);
    }


    @Given("he iniciado el proceso de checkout")
    public void heIniciadoElProcesoDeCheckout() {
        carritoSteps.iniciarCheckout();
    }

    @When("completo el formulario con {string} {string} {string}")
    public void completoElFormularioCon(String nombre, String apellido, String postal) {
        checkoutSteps.completarFormulario(nombre, apellido, postal);
    }

    @Then("debería ver el resumen de la compra con:")
    public void deberiaVerElResumenDeLaCompraCon(DataTable productosEsperados) {
        checkoutSteps.validarResumenCompra(productosEsperados);
    }

    @When("confirmo la orden")
    public void confirmoLaOrden() {
        checkoutSteps.confirmarOrden();
    }
    @Then("debería ver el mensaje de confirmación {string}")
    public void deberiaVerElMensajeDeConfirmacion(String mensaje) {
       Assert.assertTrue("Error en la confirmación de compra",checkoutSteps.validarConfirmaciondeCompra(mensaje));
    }

    @Given("que he agregado los siguientes productos al carrito:")
    public void queHeAgregadoLosSiguientesProductosAlCarrito(DataTable dataTable) {
        productosSteps.agregarProductos(dataTable);
    }

    @Then("debería ver el resumen de compra con:")
    public void deberiaVerElResumenDeCompraCon(DataTable dataTable) {
        checkoutSteps.validarResumenCompra( dataTable);
    }

    @And("el subtotal debería ser {string}")
    public void elSubtotalDeberiaSer(String subtotal) {
        checkoutSteps.validarSubtotal(subtotal);
    }

    @When("intento completar el formulario con {string} {string} {string}")
    public void intentoCompletarElFormularioCon(String name, String lastname, String code) {
        checkoutSteps.completarFormulario(name,lastname,code);

    }

    @Then("debería mostrar el siguiente mensaje {string}")
    public void deberiaMostrarElSiguienteMensaje(String msj ) {
        Assert.assertTrue("El mensaje no es el esperado ",checkoutSteps.validarMsjErrorFormCheckout(msj));
    }

    @And("entro al formulario de pago")
    public void entroAlFormularioDePago() {
        carritoSteps.iniciarCheckout();
    }
}