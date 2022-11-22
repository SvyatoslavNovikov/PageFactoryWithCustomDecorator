package org.example.factory.elements.impl;


import org.example.factory.elements.Field;
import org.openqa.selenium.WebElement;

class FieldImpl extends AbstractElement implements Field {
    protected FieldImpl(final WebElement wrappedElement) {
        super(wrappedElement);
    }

    @Override
    public String getText() {
        return wrappedElement.getText();
    }
}
