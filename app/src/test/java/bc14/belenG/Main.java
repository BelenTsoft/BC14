package bc14.belenG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String rutaDriver = "C:\\Users\\belen.gonzalez\\Desktop\\BC14\\app\\src\\test\\resources\\drivers\\chromedriver.exe";

        //enlazar el driver

        System.setProperty("webdriver.chrome.driver", rutaDriver);

        WebDriver driver = new ChromeDriver(); // si quisiera para Edge creo un edgeDriver y así (estan entre las opciones del IDE

        //ir a una url
        driver.get("https://open.spotify.com/intl-es");

        //poner en espera fija en nuestra ejecución para poder ver los pasos
        Thread.sleep(5000) ; // agregar la exception en el metodo: throw

        //driver.getTitle();

        //driver.close();

        //hacer click en el boton registrarse
        //busco el elemento
        By locatorBtnRegistrarte = By.xpath("//button[contains(text(),'Registrarte')]");
        //creo el elemento
        WebElement btnRegistrarte = driver.findElement(locatorBtnRegistrarte);
        //genero la accion
        btnRegistrarte.click();

        Thread.sleep(3000);

        By locatorInputmail = By.id("email");
        WebElement inputMail = driver.findElement(locatorInputmail);
        inputMail.sendKeys("emaildepruebabelen@gmail.com");

        By locatorInputPasword = By.name("password");
        WebElement inputPassword = driver.findElement(locatorInputPasword);
        inputPassword.sendKeys("Papa1234");

        //opcion corta
        driver.findElement(By.name("day")).sendKeys("16");

        //para listas desplegables
        Select selectorMes = new Select(driver.findElement(By.name("month")));
        selectorMes.selectByValue("08");

        driver.findElement(By.name("year")).sendKeys("1985");

        // si necesitamos hacer un scroll
        JavascriptExecutor js =(JavascriptExecutor) driver;

        driver.findElements(By.xpath("//label[contains(@for,'gender_option')]"));
        List<WebElement> generos = driver.findElements(By.xpath("//label[contains(@for,'gender_option')]"));

        generos.get(1).click();

        List<WebElement> checks = driver.findElements(By.xpath("//label[contains(@for,'checkbox')]"));
        js.executeScript("arguments[0].scrollIntoView();",checks.get(0));

        By locatorBtnSubmit = By.xpath("//button[@type='submit']");
        WebElement btnSubmit = driver.findElement(locatorBtnSubmit);

        //Thread.sleep(3000);
       // js.executeScript("arguments[0].scrollIntoView():", btnSubmit);

        btnSubmit.click();







    }
}
