# Proyecto de Pruebas Automatizadas

Este proyecto implementa pruebas automatizadas utilizando **Playwright**, **Cucumber** y **JUnit**, siguiendo la arquitectura **Page Object Model** (POM). Las pruebas están diseñadas para la aplicación **Sauce Demo**, cubriendo el proceso de autenticación, compra y validación del carrito de compras.

---

## Requisitos

Antes de comenzar, asegúrate de tener instalado lo siguiente:

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

Para ejecutar las pruebas, utiliza el siguiente comando:

```bash
mvn test

Informe breve sobre la estrategia de automatización y patrones utilizados.
Este framework automatiza pruebas en Sauce Demo utilizando Playwright, Cucumber y JUnit, siguiendo el patrón Page Object Model (POM) para mantener un código modular y reutilizable.

✅ Patrón: POM, separando lógica de negocio y automatización.
✅ Ejecución: Mediante Maven, permitiendo ejecución selectiva con etiquetas (@CompletarCompra).
✅ Gestión del Driver: DriverManager centraliza la configuración de Playwright.
✅ Reporte: Generación automática en HTML tras la ejecución.

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
