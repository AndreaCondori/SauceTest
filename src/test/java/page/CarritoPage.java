package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.List;

public class CarritoPage {
    private final Page page;
    private final String btnCheckout = "#checkout";
    private final String cartItemsSelector = ".cart_item";
    private final String productNameSelector = ".inventory_item_name";

    public   CarritoPage(Page page){
          this.page=page;
      }

    public boolean validarProductoEnCarrito(String productName){
        page.waitForSelector(cartItemsSelector);
        List<Locator> cartItems = page.locator(cartItemsSelector).all();
        for (Locator item : cartItems) {
            String name = item.locator(productNameSelector).textContent().trim();

            if (name.equals(productName)) {
                return true;
            }
        }

        return false;
    }

    public void navegarAcheckout(){
        page.locator(btnCheckout).click();
    }

    public String getProductPrice(String productName) {
        page.waitForSelector(cartItemsSelector);
        List<Locator> cartItems = page.locator(cartItemsSelector).all();

        for (Locator item : cartItems) {
            String name = item.locator(productNameSelector).textContent().trim();
            if (name.equals(productName)) {
                return item.locator(".inventory_item_price").textContent().trim();
            }
        }
        return null;
    }
}
