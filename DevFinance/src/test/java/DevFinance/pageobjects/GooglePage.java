package DevFinance.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String URL_BASE = "https://www.google.com.br/";

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void abrirPagina() {
        driver.get(URL_BASE);
    }

    public void pesquisar(String termo) {
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys(termo + Keys.ENTER);
    }

    public void clicarPrimeiroResultado(String texto) {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), '" + texto + "')]/parent::a")));
        link.click();
    }
}
