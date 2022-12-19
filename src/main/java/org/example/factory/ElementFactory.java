package org.example.factory;

import org.example.factory.elements.Element;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ElementFactory {
    <E extends Element> E create(Class<E> elementClass, WebElement wrappedElement);

    <E extends Element> E createList(Class<E> elementClass, List<WebElement> wrappedElement);
}
