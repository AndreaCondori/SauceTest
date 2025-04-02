package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductoPage {
    private final Page page;

    private final String tituloPagina = "[data-test='title']";
    private final String productoPorNombre = "//div[contains(@class,'inventory_item_name') and text()='%s']";
    private final String botonAgregarAlCarrito = "#add-to-cart";
    public final String carritoBadgeSelector = "[data-test='shopping-cart-badge']";
    private final String btnAgregarProductoPage="#add-to-cart-%s";

    public ProductoPage(Page page) {
        this.page = page;
    }


    public boolean paginaCargada() {
        return page.locator(tituloPagina).isVisible();
    }

    public void seleccionarProducto(String nombre) {
        page.locator(String.format(productoPorNombre, nombre)).click();
    }

    public void agregarProductoAlCarrito(String nombre) {
        page.locator(String.format(botonAgregarAlCarrito, nombre)).click();
    }

    public void limpiarCarritoSiNoEstaVacio() {
        if (obtenerNumeroProductosEnCarrito()>0){
            page.locator(carritoBadgeSelector).click();

        }
    }
    public int obtenerNumeroProductosEnCarrito(){
        return Integer.parseInt(page.locator(carritoBadgeSelector).textContent());
    };
    public void  abrirCarritoPage(){
        page.locator(carritoBadgeSelector).click();
    }
    public void AgregardProductoDesdeProductPage(String nombre){
        String selectorProducto = String.format(btnAgregarProductoPage, nombre.toLowerCase().replace(" ", "-"));
        page.locator(selectorProducto).click();
    }

}