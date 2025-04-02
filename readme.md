Descripción:

Este proyecto implementa pruebas automatizadas utilizando Playwright, Cucumber y JUnit,
siguiendo la arquitectura Page Object Model (POM). Las pruebas están diseñadas para la aplicación Sauce Demo,
cubriendo el proceso de autenticación, compra y validación del carrito de compras.


Requisitos:
Tener instalado lo siguiente:
Java 11+
Maven

Instalación y Configuración:
Clonar repositorio
Instalación de dependencias
mvn clean install

Ejecución de pruebas: 
mvn test

Estructura del Proyecto: 
SauceTest/
│── core/               # Configuración del Driver (Playwright)
│── page/               # Clases POM para las páginas
│── runner/             # Runner de Cucumber para ejecutar las pruebas
│── steps/              # Métodos de interacción con las páginas
│── stepsDefinitions/   # Definiciones de los pasos de Cucumber
│── resources/
│   └── features/       # Archivos Feature de Cucumber
│── pom.xml             # Dependencias del proyecto
│── README.md           # Instrucciones del proyecto

Configuración del Driver

El driver se maneja en la clase DriverManager, que configura Playwright para ejecutar las pruebas en modo no headless:
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

Ejecución de las Pruebas @RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features",
glue = {"stepsDefinitions", "core"},
plugin = {"pretty", "html:target/cucumber/cucumber-report.html"},
tags = ""
)
public class RunnerTest {
}

Generación de Reportes
![{E329AC9F-0846-4D79-B11D-4E4D1617EB81}](https://github.com/user-attachments/assets/7335bc0e-9577-41d7-8acb-04801eea0c76)


Las pruebas generan un reporte HTML en la carpeta target/cucumber/cucumber-report.html. Para visualizarlo, abre el archivo en tu navegador:
