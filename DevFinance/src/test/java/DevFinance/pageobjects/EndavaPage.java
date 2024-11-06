package DevFinance.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndavaPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public EndavaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void aceitarCookies() {
        WebElement aceitarCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", aceitarCookiesButton);
    }

    public void abrirMenuLateral() {
        WebElement menuButton = driver.findElement(By.id("openMenuBtn"));
        menuButton.click();
    }

    public void clicarNoDropdown() {
        WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='header-page-title-div-4']")));
        dropdownOption.click();
    }

    public void clicarEmOverview() {
        WebElement linkOverview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.endava.com/who-we-are' and text()='Overview']")));
        linkOverview.click();
    }

    public void rolarPaginaLentamente(int pixelsPorRolagem, int intervaloEmMilissegundos) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long alturaPagina = (long) js.executeScript("return document.body.scrollHeight");

        for (int posicaoAtual = 0; posicaoAtual < alturaPagina; posicaoAtual += pixelsPorRolagem) {
            js.executeScript("window.scrollBy(0, arguments[0]);", pixelsPorRolagem);
            try {
                Thread.sleep(intervaloEmMilissegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
