package org.example.factory.elements.impl;

import org.example.factory.AbstractContainer;
import org.example.factory.elements.Field;
import org.openqa.selenium.support.FindBy;

public class FieldContainer extends AbstractContainer {

    @FindBy(xpath = "./h3")
    public Field title;

}
