package owcucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import owcucumber.BrowserDriver;

public class perfil_cuenta {
    @Given("la interfaz web de la aplicación iniciada")
    public void laInterfazWebDeLaAplicaciónIniciada() {
        System.out.println("- Given: Este paso es para iniciar la interfaz web del producto");
        // Comienza Selenium
        BrowserDriver.getCurrentDriver().get("https://openwebinars.net/");
        BrowserDriver.getCurrentDriver().manage().window().setSize(new Dimension(1280, 800));
        // Si el botón Iniciar Sesión de muestra, correcto!
        Assert.assertTrue(BrowserDriver.getCurrentDriver().findElement(By.cssSelector(".link-ofus")).isDisplayed());
    }

    @Given("un usuario ya logado con perfil de formador")
    public void unUsuarioYaLogadoConPerfilDeFormador() {
        System.out.println("- Given: Este paso es para logar al usuario");
        // Comienza Selenium
        BrowserDriver.getCurrentDriver().findElement(By.cssSelector(".link-ofus")).click();
        BrowserDriver.getCurrentDriver().findElement(By.id("id_login")).click();
        BrowserDriver.getCurrentDriver().findElement(By.id("id_login")).sendKeys("maestord@gmail.com");
        BrowserDriver.getCurrentDriver().findElement(By.id("id_password")).click();
        BrowserDriver.getCurrentDriver().findElement(By.id("id_password")).sendKeys("cucumber2019");
        BrowserDriver.getCurrentDriver().findElement(By.cssSelector(".btn-lg")).click();
        // Aserción que verifica que el paso se ha ejecutado perfectamente
        //BrowserDriver.getCurrentDriver().findElement(By.cssSelector("#dropdownMenuUser > .img-circle")).click();
        // Si el botón MIS CURSOS de muestra, correcto!
        Assert.assertEquals(BrowserDriver.getCurrentDriver().findElement(By.cssSelector(".mb-1")).getText(), "Hola Miguel Alejandro");
    }

    @When("voy a la sección del perfil público")
    public void voyALaSecciónDelPerfilPúblico() {
        System.out.println("- When: Este paso es para ir a la sección de perfil público");
        // Comienza Selenium
        BrowserDriver.getCurrentDriver().findElement(By.cssSelector("#dropdownMenuUser > .img-circle")).click();
        BrowserDriver.getCurrentDriver().findElement(By.linkText("Perfil público")).click();
    }

    @Then("puedo consultar la información referente al usuario")
    public void puedoConsultarLaInformaciónReferenteAlUsuario() {

    }
}
