package stepsDefinitions;

import com.microsoft.playwright.Page;
import core.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.CarritoSteps;
import steps.LoginSteps;
import steps.ProductosSteps;

public class ProductosStepDefinitions {

    private LoginSteps loginSteps;
    private Page page;
    private ProductosSteps productosSteps;
    private CarritoSteps carritoSteps;

    public ProductosStepDefinitions() {
        this.page = DriverManager.getPage();
        loginSteps = new LoginSteps(page);
        productosSteps = new ProductosSteps(page);
        carritoSteps= new CarritoSteps(page);
    }

    @Given("me encuentro en la página de productos")
    public void paginaProductos() {
        productosSteps.validarTituloPagina();
    }

    @Given("el usuario ha iniciado sesión correctamente en Sauce Demo")
    public void elUsuarioHaIniciadoSesionCorrectamenteEnSauceDemo() {
        loginSteps.IrLoging();
        loginSteps.login("standard_user", "secret_sauce");
    }

    @When("agrego el producto {string} al carrito")
    public void agregoElProductoAlCarrito(String producto) {
        productosSteps.agregarProducto(producto);
    }

    @Then("el número de productos en el carrito debería ser {int}")
    public void elNumeroDeProductosEnElCarritoDeberiaSer(int cantidad) {
        productosSteps.validarIconoCarrito(cantidad);
    }

    @Given("que he agregado el producto {string} al carrito")
    public void queHeAgregadoElProductoAlCarrito(String producto) {
         productosSteps.agregarProducto(producto);
    }

    @When("presiono sobre el ícono del carrito")
    public void presionoSobreElIconoDelCarrito() {
        productosSteps.irACarritoPage();
    }

    @Then("debería mostrarse en la lista de productos {string}")
    public void deberiaMostrarseEnLaListaDeProductos(String producto) {

        Assert.assertTrue("No se encuentra el producto",carritoSteps.validarProductoAgregados(producto.trim()));
    }

    @When("entro al detalle del carrito")
    public void entroAlDetalleDelCarrito() {
        productosSteps.irACarritoPage();
    }
}