package page;

import com.microsoft.playwright.Page;
import core.DriverManager;

public class LoginPage {
    private final Page page;

    // Definir los selectores como constantes
    private final String usernameField = "#user-name";
    private final String passwordField = "#password";
    private final String loginButton = "#login-button";
    private final String inventoryList = ".inventory_list";
    private final String errorMessage = "[data-test='error']";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void navigateToLoginPage() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        page.locator(usernameField).fill(username);
    }

    public void enterPassword(String password) {
        page.locator(passwordField).fill(password);
    }

    public void clickLogin() {
        page.locator(loginButton).click();
    }

    public boolean isLoginSuccessful() {
        return page.locator(inventoryList).isVisible();
    }

    public String getErrorMessage() {
        page.locator(errorMessage).waitFor();
        return page.locator(errorMessage).textContent().trim();
    }

    public void waitForInventoryPage() {
        page.waitForSelector(inventoryList);
    }
}