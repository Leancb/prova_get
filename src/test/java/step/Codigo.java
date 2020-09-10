package step;

import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.lang.Thread.sleep;

public class Codigo {


    private WebDriver navegador;
    private Object WebElement;


    @Dado("^configurei ambiente para acessar URL Chrome$")
    public void configurei_ambiente_para_acessar_URL_Chrome() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "/Users/leandrobrum/Desktop/TesteAuto/chromedriver");


    }

    @Quando("^abri tela da (.*)$")
    public void abri_tela_de_login(String site) throws Throwable {

        navegador = new ChromeDriver();
        navegador.get(site);
        navegador.manage().window().maximize();

    }


    @Quando("^pesquisar por (.*)$")

    public void clicar_no_botao_Entrar(String consulta) throws Throwable {

        sleep(5000);

        WebElement element = navegador.findElement(By.cssSelector("#search-trigger > div > span"));
        Actions builder = new Actions(navegador);
        builder.moveToElement(element).click(element);
        builder.perform();

        navegador.findElement(By.xpath("//*[@id=\"global-search-input\"]")).sendKeys(consulta);

        navegador.findElement(By.xpath("/html/body/section/div/div/div/form/button")).click();

    }



    @Quando("^clico no link$")
    public void clico_no_botão_atualiza_web() throws Throwable {
        sleep(1000);

        navegador.findElement(By.xpath("/html/body/div[1]/div/section/a[5]/h3")).click();


    }

    @Entao("^valido a (.*) da tela$")
    public void valido_que_atualizou_a_tela(String mensagem) throws Throwable {

        WebDriverWait wait = new WebDriverWait(navegador,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.o-modal.is-modal-open > div > div.o-modal__title")));

        String pvar = navegador.findElement(By.cssSelector("body > div.o-modal.is-modal-open > div > div.o-modal__title")).getText();

        Assert.assertTrue(pvar.contains(mensagem));

        navegador.close();

    }

}
