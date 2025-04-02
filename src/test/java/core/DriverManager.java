package core;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DriverManager {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;
    private static Scenario scenario;

    public static Page getPage() {
        return page;
    }

    @Before(order = 0)
    public void setUp() {
        System.out.println("iniciando driver");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
        page.context().clearCookies();
        page.context().clearPermissions();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        DriverManager.scenario = scenario;
    }

    @After
    public void tearDown() {
        takeScreenshot();
        if (scenario.isFailed()) {
            takeScreenshot();
        }
        context.close();
        browser.close();
        playwright.close();
    }

    public static void takeScreenshot() {
        byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));
        scenario.attach(screenshot, "image/png", "Captura de pantalla");
    }
}