# Proyecto de autamtización con Playwright y Cucumber,
---

## Requisitos
Tener instalado lo siguiente
- **Java 17**
- **Maven**

---

## Instalación y Configuración

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tuusuario/tu-repositorio.git
    ```

2. Instala las dependencias:

    ```bash
    mvn clean install
    ```

---

## Ejecución de Pruebas

Comando para ejecutar las pruebas:

```bash
   mvn test
```
---

## Informe breve sobre la estrategia de automatización y patrones utilizados.
--
```
Este framework automatiza pruebas en Sauce Demo utilizando Playwright, Cucumber y JUnit, siguiendo el patrón Page Object Model (POM) para mantener un código modular y reutilizable.

✅ Patrón: POM, separando lógica de negocio y automatización.
✅ Ejecución: Mediante Maven, permitiendo ejecución selectiva con etiquetas (@CompletarCompra).
✅ Gestión del Driver: DriverManager centraliza la configuración de Playwright.
✅ Reporte: Generación automática en HTML tras la ejecución (target/cucumber-report.html)

La estructura del proyecto es la siguiente:
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

Las pruebas se ejecutan con Cucumber y están configuradas en la clase RunnerTest
---