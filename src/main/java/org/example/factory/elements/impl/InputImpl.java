package org.example.factory.elements.impl;

import org.example.factory.elements.Input;
import org.openqa.selenium.WebElement;

class InputImpl extends AbstractElement implements Input {
    protected InputImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public Input clear() {
        wrappedElement.clear();
        return this;
    }

    @Override
    public Input sendKeys(String text) {
        wrappedElement.sendKeys(text);
        return this;
    }

}
