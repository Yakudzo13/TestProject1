package com.mShishkanov.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;

    //конструктор класса, занимающийся инициализацией полей класса:
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //Определение меню пользователя:
    //@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/a[1]/div")
    @FindBy(xpath = "//*[contains(@class, 'user-pic user-pic_has-plus_yes user-account__pic')]")
    private WebElement userMenu;

    //Определение кнопки выхода:
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[6]/a/span")
    private WebElement logoutBtn;

    //Метод для получения имени пользователя из меню пользователя
    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }

    //метод нажатия кнопки меню пользователя:
    public void entryMenu() {
        userMenu.click();
    }

    //Метод нажатия кнопки выхода из меню пользователя:
    public void userLogout() {
        logoutBtn.click();
    }


}
