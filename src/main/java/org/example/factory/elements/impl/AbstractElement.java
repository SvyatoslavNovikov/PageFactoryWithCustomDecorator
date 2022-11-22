package org.example.factory.elements.impl;

import org.example.factory.elements.Element;
import org.openqa.selenium.WebElement;

public abstract class AbstractElement implements Element {
    protected final WebElement wrappedElement;

    protected AbstractElement(final WebElement wrappedElement) {
        this.wrappedElement = wrappedElement;
    }

    @Override
    public boolean isDisplayed() {
        return wrappedElement.isDisplayed();
    }

    public WebElement getWrappedElement() {
        return wrappedElement;
    }

}
