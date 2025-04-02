package stepsDefinitions;

import com.microsoft.playwright.Page;
import core.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import page.ProductoPage;
import steps.CarritoSteps;
import steps.LoginSteps;
import steps.ProductosSteps;

public class CarritoStepDefinitions {

    private LoginSteps loginSteps;
    private Page page;
    private ProductosSteps productosSteps;
    private CarritoSteps carritoSteps;

    public CarritoStepDefinitions() {
        this.page = DriverManager.getPage();
        loginSteps = new LoginSteps(page);
        productosSteps = new ProductosSteps(page);
        carritoSteps= new CarritoSteps(page);
    }
    @And("ingresa la información de pago:")
    public void ingresarInformacionPago(){

    }


}
