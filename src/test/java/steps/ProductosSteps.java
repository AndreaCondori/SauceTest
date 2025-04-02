package steps;

import com.microsoft.playwright.Page;
import io.cucumber.datatable.DataTable;
import page.LoginPage;
import page.ProductoPage;

import java.util.List;
import java.util.Map;

public class ProductosSteps {

    ProductoPage productoPage;
     public  ProductosSteps(Page page){
        productoPage= new ProductoPage(page);
    }

    public  void validarTituloPagina(){

    }

    public boolean validarIconoCarrito(int cantidad){
        productoPage.limpiarCarritoSiNoEstaVacio();
        if (productoPage.obtenerNumeroProductosEnCarrito()==cantidad)return true;
        else return false;
    }

    public void agregarProducto(String producto) {
        productoPage.seleccionarProducto(producto);
        productoPage.agregarProductoAlCarrito(producto);

    }

    public void irACarritoPage() {
         productoPage.abrirCarritoPage();
    }

    public void agregarProductos(DataTable dataTable) {
        List<Map<String,String>>productos=dataTable.asMaps(String.class,String.class);
        for (Map<String,String>producto:productos){
            productoPage.AgregardProductoDesdeProductPage(producto.get("Producto"));
        }
     }
}
