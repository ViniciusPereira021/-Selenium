package DevFinance.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DevFinance.pageobjects.EndavaPage;
import DevFinance.pageobjects.GooglePage;

public class GoogleTeste {
    private WebDriver driver;
    private GooglePage googlePage;
    private EndavaPage endavaPage;

    private final String CAMINHO_DRIVER = "C:/Users/Vinicius de Moraes/Desktop/testes automatizados/DevFinance/DevFinance/src/test/java/DevFinance/resources/chromedriver.exe";

    @BeforeEach
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        googlePage = new GooglePage(driver);
        endavaPage = new EndavaPage(driver);
    }

    @Test
    public void testePesquisaEndava() {
        googlePage.abrirPagina();
        googlePage.pesquisar("Endava");
        googlePage.clicarPrimeiroResultado("Endava");

        endavaPage.aceitarCookies();
        endavaPage.abrirMenuLateral();
        endavaPage.clicarNoDropdown();
        endavaPage.clicarEmOverview();
        endavaPage.rolarPaginaLentamente(20, 80);
    }

    @AfterEach
    public void fechar() {
        if (driver != null) {
            driver.quit();
        }
    }
}
