package steps;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import page.CheckoutPage;
import page.CheckoutResumenPage;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    private Page page;
    private CheckoutPage checkoutPage;
    private CheckoutResumenPage checkoutResumenPage;

    public  CheckoutSteps (Page page){
        this.page= page;
        checkoutPage= new CheckoutPage(page);
        checkoutResumenPage=new CheckoutResumenPage(page);
    }

    public void completarFormulario(String nombre, String apellido, String postal) {
        checkoutPage.ingresarName(nombre);
        checkoutPage.ingresarLastName(apellido);
        checkoutPage.ingresarPostalCode(postal);
        checkoutPage.navegarAcheckoutResumen();
    }

    public void validarResumenCompra(DataTable productosEsperados) {
        List<Map<String, String>> productos = productosEsperados.asMaps(String.class, String.class);

        List<String> productosEnPagina = checkoutResumenPage.obtenerProductos();

        for (Map<String, String> productoEsperado : productos) {
            String nombreEsperado = productoEsperado.get("Producto").trim();

            if (!productosEnPagina.contains(nombreEsperado)) {
                throw new AssertionError("Producto '" + nombreEsperado + "' no encontrado en el resumen de la compra.");
            }
    }

}

   public boolean validarSubtotal(String subtotal) {
       if(checkoutResumenPage.obtenerSubtotal().equals(subtotal))return true;
       return false;
    }

    public void confirmarOrden() {
        checkoutResumenPage.finalilzarCompra();
    }


    public boolean validarConfirmaciondeCompra(String mensaje) {
           if( checkoutResumenPage.confirmacionCompra().equals(mensaje))return true;
           return false;
    }

    public boolean validarMsjErrorFormCheckout(String msj) {
        if(checkoutPage.obtenerMessageError().equals(msj.trim()))return true;
        return false;

    }
}
