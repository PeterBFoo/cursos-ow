package owcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class BrowserDriver {

    private static WebDriver navDriver;

    public synchronized static WebDriver getCurrentDriver() {
        if (navDriver == null) {
            try {
                // Inserta la ubicación del Proxy entre el navegador y el cliente
                System.setProperty("webdriver.gecko.driver",
                        "/Users/maestord/Documents/BDD/geckodriver");

                String webdriver = System.getProperty("browser", "firefox");
                System.out.println("Driver Seleccionado: " + webdriver);

                FactoryBrowser(webdriver);
            } finally {
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }
        }
        return navDriver;
    }

    private static void FactoryBrowser (String webdriver) {
        if ("firefox".equals(webdriver)) {
            // Creamos un nuevo elemento opción y perfil, para añadir elementos en el futuro
            FirefoxOptions option = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            // Añadimos opciones para aceptar certificados no válidos
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            // Añadimos el perfil a las opciones
            option.setProfile(profile);
            // Creamos el Driver añadiendo las opciones
            navDriver = new FirefoxDriver(option);
            navDriver.manage().window().maximize();
        } else if ("chrome".equals(webdriver)) {
            navDriver = new ChromeDriver();
            navDriver.manage().window().maximize();
        } else {
            throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }

    private static class BrowserCleanup implements Runnable {
        public void run() {
            System.out.println("Cerrando el navegador");
            close();
        }
    }

    public static void close() {
        try {
            getCurrentDriver().quit();
            navDriver = null;
            System.out.println("Cerrando el navegador");
        } catch (UnreachableBrowserException e) {
            System.out.println("se puede cerrar el navegador: navegador inalcanzable");
        }
    }

    public static void loadPage(String url){
        System.out.println("Dirigiendo el navegador a: " + url);
        getCurrentDriver().get(url);
    }

}

