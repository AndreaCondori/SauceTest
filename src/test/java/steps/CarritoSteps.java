package steps;

import com.microsoft.playwright.Page;
import page.CarritoPage;
import page.ProductoPage;

public class CarritoSteps {

    CarritoPage carritoPage;
    ProductoPage productoPage;
    public  CarritoSteps(Page page){
        carritoPage= new CarritoPage(page);
        productoPage= new ProductoPage(page);
    }
    public boolean validarProductoAgregados(String producto){
        return  carritoPage.validarProductoEnCarrito(producto);
    }

    public void iniciarCheckout() {
        productoPage.abrirCarritoPage();
        carritoPage.navegarAcheckout();
    }
}
