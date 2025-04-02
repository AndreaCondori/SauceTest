package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.ArrayList;
import java.util.List;

public class CheckoutResumenPage {
    private final Page page;
    private final String btnFinzalizar = "[data-test='finish']";
    private final String itemProductResumen = ".cart_item";
    private final String btnContinueCheckout = "#continue";
    private final String mensajeConfirmacion="[data-test='complete-header']";

    public   CheckoutResumenPage(Page page){
        this.page=page;
    }
    public List<String> obtenerProductos() {
        List<String> productos = new ArrayList<>();
        Locator productosCarrito = page.locator(itemProductResumen);
        productosCarrito.waitFor();
        List<Locator> productosList = productosCarrito.locator(".inventory_item_name").all();
        for (Locator producto : productosList) {
            productos.add(producto.textContent().trim());
        }

        return productos;
    }

    public String obtenerSubtotal() {
        Locator subtotalLocator = page.locator(".summary_subtotal_label");
        return subtotalLocator.textContent().trim();
    }
    public void navegarAcheckoutResumen(){
        page.locator(btnContinueCheckout).click();
    }

    public void finalilzarCompra() {
        page.locator(btnFinzalizar).click();

    }

    public String  confirmacionCompra( ) {
        return page.locator(mensajeConfirmacion).textContent();
    }
}
