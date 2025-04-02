package steps;

import com.microsoft.playwright.Page;
import page.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;

    public LoginSteps(Page page) {
        loginPage = new LoginPage(page);
    }
    public void IrLoging(){
        loginPage.navigateToLoginPage();
    }

    public void login(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    public boolean isLoginSuccessful() {
        return loginPage.isLoginSuccessful();
    }

    public boolean validateErrorMessage(String msj){
       if ( loginPage.getErrorMessage().equals(msj))return true;
       else return false;
    }
}