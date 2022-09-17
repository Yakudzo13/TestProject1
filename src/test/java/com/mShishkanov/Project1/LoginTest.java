package com.mShishkanov.Project1;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //определение пути до драйвера и его настройка

        //создание объектов
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        driver.manage().window().maximize();
        //Чтобы ход теста отображался в полностью открытом окне, необходимо сказать об этом драйверу

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Использовано неявное ожидание Implicitly Wait, которое задается вначале теста и будет работать при каждом вызове метода поиска элемента

        driver.get(ConfProperties.getProperty("loginpage"));
        //Для передачи драйверу адреса страницы используется команда

    }

    @Test
        public void loginTest() {

        //вводим логин:
        loginPage.inoutLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа:
        loginPage.clickLoginBtn();

        //вводим пароль:
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа:
        loginPage.clickLoginBtn();

        //получаем отображаемый логин:
        String user = profilePage.getUserName();

        //и сравниваем его с логином из файла настроек:
        Assert.assertEquals(ConfProperties.getProperty("login"),user);
    }

    @AfterClass
    public static void tearDown() {
        //выбор меню:
        profilePage.entryMenu();
        //нажимаем кнопку выхода:
        profilePage.userLogout();
        //закрываем браузер:
        driver.quit();
    }

}
