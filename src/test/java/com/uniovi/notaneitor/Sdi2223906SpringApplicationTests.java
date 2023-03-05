package com.uniovi.notaneitor;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Sdi2223906SpringApplicationTests {

    static String PathFirefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    static String Geckodriver = "C:\\Users\\Diego Marty\\Downloads\\PL-SDI-Sesion5-material\\PL-SDI-Sesion5-material\\geckodriver-v0.30.0-win64.exe";
    //static String Geckodriver = "C:\\Dev\\tools\\selenium\\geckodriver-v0.30.0-win64.exe";
    //static String PathFirefox = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
    //static String Geckodriver = "/Users/USUARIO/selenium/geckodriver-v0.30.0-macos";

    //Com�n a Windows y a MACOSX
    static WebDriver driver = getDriver(PathFirefox, Geckodriver);
    static String URL = "http://localhost:8090";
    public static WebDriver getDriver(String PathFirefox, String Geckodriver) {
        System.setProperty("webdriver.firefox.bin", PathFirefox);
        System.setProperty("webdriver.gecko.driver", Geckodriver);
        driver = new FirefoxDriver();
        return driver;
    }

    @Test
    void contextLoads() {
    }
    @BeforeEach
    public void setUp(){
        driver.navigate().to(URL);
    }
    //Despu�s de cada prueba se borran las cookies del navegador
    @AfterEach
    public void tearDown(){
        driver.manage().deleteAllCookies();
    }
    //Antes de la primera prueba
    @BeforeAll
    static public void begin() {}
    //Al finalizar la �ltima prueba
    @AfterAll
    static public void end() {
        //Cerramos el navegador al finalizar las pruebas
        driver.quit();
    }

    @Test
    @Order(1)
    void PR01(){}
    @Test
    @Order(1)
    void PR02(){}
    @Test
    @Order(1)
    void PR03(){}
    @Test
    @Order(1)
    void PR04(){}
    @Test
    @Order(1)
    void PR05(){}
    @Test
    @Order(1)
    void PR06(){}
    @Test
    @Order(1)
    void PR07(){}
    @Test
    @Order(1)
    void PR08(){}
    @Test
    @Order(1)
    void PR09(){}
    @Test
    @Order(1)
    void PR10(){}
}
