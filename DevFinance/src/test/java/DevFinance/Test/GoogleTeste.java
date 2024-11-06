package DevFinance.Test;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTeste {

    private WebDriver driver;
    private WebDriverWait wait; // WebDriverWait para aguardar elementos
    private final String URL_BASE = "https://www.google.com.br/";
    private final String CAMINHO_DRIVER = "C:/Users/Vinicius de Moraes/Desktop/testes automatizados/DevFinance/DevFinance/src/test/java/DevFinance/resources/chromedriver.exe";

    @BeforeEach
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver(); // Inicia o navegador
        driver.manage().window().maximize(); // Maximiza a janela
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Inicializa o WebDriverWait com 20 segundos
    }
        
    @Test
    public void devePesquisarNoGoogle() {
        driver.get(URL_BASE); // Acessa a URL base (Google)
        
        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Endava" + Keys.ENTER);

        // Usa o WebDriverWait para esperar até que o elemento do link esteja visível e clicável
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(), 'Endava')]/parent::a")));
        link.click(); // Clica no link do primeiro resultado

        // Chama o método explorarSiteEndava após clicar no link
        explorarSiteEndava();

        // Clica no menu lateral
        WebElement clicarNoMenuEsquerdo = driver.findElement(By.id("openMenuBtn"));
        clicarNoMenuEsquerdo.click();

        // Espera o dropdown estar disponível para interação
        WebElement clicarnodropbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='header-page-title-div-4']")));
        clicarnodropbox.click(); // Clica no dropdown que expande as opções

        // Clica no link "Overview"
        WebElement linkOverview = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.endava.com/who-we-are' and text()='Overview']")));
        linkOverview.click(); 






        rolarPaginaLentamente(20, 80);

        fechar();


        
    }

    public void explorarSiteEndava() {
        // Aguarda até que o botão de cookies esteja visível
        WebElement aceitarCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));

        // Usa JavaScriptExecutor para clicar no botão de cookies, caso o método tradicional não funcione
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", aceitarCookiesButton);
    }



    @AfterEach
    public void fechar() {
        if (driver != null) {
            driver.quit(); // Encerra a sessão do Selenium após o teste
        }
    }



    public void rolarPaginaLentamente(int pixelsPorRolagem, int intervaloEmMilissegundos) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long alturaPagina = (long) js.executeScript("return document.body.scrollHeight");
    
        for (int posicaoAtual = 0; posicaoAtual < alturaPagina; posicaoAtual += pixelsPorRolagem) {
            js.executeScript("window.scrollBy(0, arguments[0]);", pixelsPorRolagem);
    
            // Pausa para tornar a rolagem lenta
            try {
                Thread.sleep(intervaloEmMilissegundos);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    










}
