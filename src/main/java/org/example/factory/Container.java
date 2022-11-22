package org.example.factory;

import org.example.factory.elements.Element;
import org.openqa.selenium.WebElement;

public interface Container extends Element {
    void init(WebElement wrappedElement);
}
