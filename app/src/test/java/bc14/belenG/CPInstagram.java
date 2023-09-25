package bc14.belenG;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CPInstagram {

    private WebDriver driver;

    @BeforeEach
    public void preCondiciones() throws InterruptedException{
        String rutaDriver = "C:\\Users\\belen.gonzalez\\Desktop\\BC14\\app\\src\\test\\resources\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();

        driver.get("https://www.instagram.com/");

        Thread.sleep(3000);
    }
    @AfterEach
    public void postCondiciones() {
     //   driver.quit();
    }

    @Test
    public void CP001_creacion_cta_instagram() throws InterruptedException {

        By locatorLinkRegistrarte = By.xpath("//a[contains(@href,'/accounts/emailsignup/')]");
        WebElement LinkRegistrarte = driver.findElement(locatorLinkRegistrarte);
        LinkRegistrarte.click();

        Thread.sleep(3000);

        By locatorDatoUsuario = By.name("emailOrPhone");
        WebElement DatoUsuario = driver.findElement(locatorDatoUsuario);
        DatoUsuario.sendKeys("emaildepruebabelen@gmail.com");

        By locatorInputName = By.name("fullName");
        WebElement InputName = driver.findElement(locatorInputName);
        InputName.sendKeys("Fulanito Menganito");

        By locatorInputUsuario = By.name("username");
        WebElement InputUsuario = driver.findElement(locatorInputUsuario);
        InputUsuario.sendKeys("aguanten_las_pruebas_junit");

        By locatorInputPassword = By.name("password");
        WebElement InputPassword = driver.findElement(locatorInputPassword);
        InputPassword.sendKeys("Papa1234");

        By locatorBtnSubmit = By.xpath("//button[@type='submit']");
        WebElement btnSubmit = driver.findElement(locatorBtnSubmit);
        btnSubmit.click();

        Thread.sleep(3000);

        List<WebElement> nacimiento = driver.findElements(By.className("_aau-"));
        Select mes= new Select(nacimiento.get(0));
        mes.selectByVisibleText("agosto");
        Select dia= new Select(nacimiento.get(1));
        dia.selectByVisibleText("16");
        Select anio= new Select(nacimiento.get(2));
        anio.selectByVisibleText("2004");

        Thread.sleep(1000);

        By locatorBtnSiguiente = By.xpath("//button[contains(text(),'Siguiente')]");
        WebElement btnSiguiente = driver.findElement(locatorBtnSiguiente);
        btnSiguiente.click();

        Thread.sleep(3000);

        By parrafoConfirmacion = By.className("x1lliihq x1plvlek xryxfnj x1n2onr6 x193iq5w xeuugli x1fj9vlw x13faqbe x1vvkbs x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x1i0vuye xvs91rp x1s688f x5n08af x2b8uid x1tu3fi x3x7a5m x10wh9bi x1wdrske x8viiok x18hxmgj");
        WebElement texto = driver.findElement(parrafoConfirmacion);


        String resultadoEsperado = "Introduce el código de confirmación";
        String resultadoObtenido = texto.getText();

        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void CP002_cta_existente() throws InterruptedException {

        By locatorLinkRegistrarte = By.xpath("//a[contains(@href,'/accounts/emailsignup/')]");
        WebElement LinkRegistrarte = driver.findElement(locatorLinkRegistrarte);
        LinkRegistrarte.click();

        Thread.sleep(3000);

        By locatorDatoUsuario = By.name("emailOrPhone");
        WebElement DatoUsuario = driver.findElement(locatorDatoUsuario);
        DatoUsuario.sendKeys("emaildepruebabelen@gmail.com");

        By locatorInputName = By.name("fullName");
        WebElement InputName = driver.findElement(locatorInputName);
        InputName.sendKeys("Fulanito Menganito");

        By locatorInputUsuario = By.name("username");
        WebElement InputUsuario = driver.findElement(locatorInputUsuario);
        InputUsuario.sendKeys("bel.gonzalez.w");

        By locatorInputPassword = By.name("password");
        WebElement InputPassword = driver.findElement(locatorInputPassword);
        InputPassword.sendKeys("Papa1234");

        By locatorBtnSubmit = By.xpath("//button[@type='submit']");
        WebElement btnSubmit = driver.findElement(locatorBtnSubmit);
        btnSubmit.click();
        Thread.sleep(2000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",btnSubmit);

        WebElement texto = driver.findElement(By.id("ssfErrorAlert"));
        String resultadoObtenido = texto.getText();

        String resultadoEsperado = "Este nombre de usuario no estÃ¡ disponible. Prueba otro.";


        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void CP003_ingreso_contrasenia_incorrecta() throws InterruptedException{
        WebElement usuario = driver.findElement(By.name("username"));
        usuario.sendKeys("bel.gonzalez.w");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("chipirones");
        WebElement btnEntrar = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button"));
        btnEntrar.click();

        Thread.sleep(2000);
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",btnEntrar);

        WebElement texto = driver.findElement(By.className("_ab2z"));

        String preresultadoObtenido = texto.getText();
        boolean resultadoObtenido = preresultadoObtenido.contains("Vuelve a comprobarla.");

        boolean resultadoEsperado = true;


        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);

    }
}
