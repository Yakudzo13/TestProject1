package com.mShishkanov.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;

    //конструктор класса, занимающийся инициализацией полей класса:
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement loginField;
    //Элемент Логин

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    //@FindBy(xpath = "//*[contains(text(), 'Войти')]") еще вариант использования
    private WebElement loginBtn;
    //Кнопка Войти

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    //@FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    //Метод ввода логина:
    public void inoutLogin(String login) {
        loginField.sendKeys(login);
    }

    //Метод ввода пароля:
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    //Метод нажатия кнопки входа:
    public void clickLoginBtn() {
        loginBtn.click();
    }

}
