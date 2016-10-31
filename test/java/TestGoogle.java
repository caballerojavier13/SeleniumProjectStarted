import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestGoogle {

    private WebDriver selenium;

    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {

        selenium = new FirefoxDriver(); // Utilizamos el navegador firefox

        String baseUrl = "https://www.google.com.ar/"; // Indicamos la url del sitio con elque vamos a trabajar

        wait = new WebDriverWait(selenium, 40); // Objeto que nos permite realizar esperas

        selenium.navigate().to(baseUrl); // Abre el navegador en la url especificada
    }

    @Test
    public void testUntitled() throws Exception {

        WebElement input_search = selenium.findElement(By.id("lst-ib")); // Buscamos en campo para ingresar el texto a buscar

        input_search.sendKeys("Selenium"); //Ingresamos nuestro texto que queremos buscar

        input_search.sendKeys(Keys.ENTER); // Presionamos Enter para decirle a Google que realize la búsqueda

        List<WebElement> result_search = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#res .g h3 a"))); // Esperamos a que Google nos traiga un resultado

        assert(result_search.size() > 1); // Validamos que exista al menos un resultado de  la búsqueda

        result_search.get(1).click(); // Vemos el primer resultado de la búsqueda

        Thread.sleep(2 * 1000); //Esperamos 2 segundo hasta que haga la redirección Google

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body"))); //Esperamos hasta que la pantalla se haya cargado

        assert(selenium.getCurrentUrl().contains("seleniumhq.org")); //Corroboramos que estamos en la página que deseamos

    }

    @After
    public void tearDown() throws Exception {
        selenium.close(); // Cerramos El navegador seleccionado
        selenium.quit(); // Finalizamos Selenium
    }

}
