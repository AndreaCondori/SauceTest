package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage {
    private final Page page;
    private final String inputFirtsName = "#first-name";
    private final String inputLastName = "#last-name";
    private final String inputZipCode = "#postal-code";
    private final String btnContinueCheckout = "#continue";
    private final String msjError = "[data-test='error']";




    public   CheckoutPage(Page page){
        this.page=page;
    }

    public void ingresarName(String firstName){
        page.locator(inputFirtsName).waitFor();
        page.locator(inputFirtsName).fill(firstName);
    }
    public void ingresarLastName(String lastname){
        page.locator(inputLastName).waitFor();

        page.locator(inputLastName).fill(lastname);
    }
    public void ingresarPostalCode(String postal){
        page.locator(inputZipCode).waitFor();

        page.locator(inputZipCode).fill(postal);
    }

    public void navegarAcheckoutResumen(){
        page.locator(btnContinueCheckout).click();
    }


    public String obtenerMessageError() {
        return  page.locator(msjError).textContent().trim();
    }
}