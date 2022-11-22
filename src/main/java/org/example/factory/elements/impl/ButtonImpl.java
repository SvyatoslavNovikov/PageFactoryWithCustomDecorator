package org.example.factory.elements.impl;

import org.example.factory.elements.Button;
import org.openqa.selenium.WebElement;

class ButtonImpl extends AbstractElement implements Button {
    protected ButtonImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public void click() {
        wrappedElement.click();
    }

}
