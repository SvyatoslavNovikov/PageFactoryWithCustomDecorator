package org.example.factory.elements;

public interface Input extends Element {

    Input clear();

    Input sendKeys(String text);
}
