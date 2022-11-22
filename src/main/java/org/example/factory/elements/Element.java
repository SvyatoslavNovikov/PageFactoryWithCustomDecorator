package org.example.factory.elements;

import org.openqa.selenium.WebElement;

public interface Element {
    boolean isDisplayed();

    WebElement getWrappedElement();
}
