package org.example.page;

import org.example.factory.ExtendedFieldDecorator;
import org.example.factory.elements.Button;
import org.example.factory.elements.Field;
import org.example.factory.elements.Input;
import org.example.factory.elements.impl.FieldContainer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(new ExtendedFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//input[@name = 'q']")
    public Input searchField;

    @FindBy(xpath = "//input[@name = 'btnK']")
    public Button searchButton;

    @FindBy(xpath = "//*[@id='rso']/div")
    public List<Field> searchResult;

    @FindBy(xpath = "//*[@id='rso']/div")
    public List<FieldContainer> searchResultContainers;

    @FindBy(xpath = "//*[@id='rso']/div")
    public List<WebElement> searchResultWebElements;

}
