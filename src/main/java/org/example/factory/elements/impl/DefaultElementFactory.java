package org.example.factory.elements.impl;

import org.example.factory.ElementFactory;
import org.example.factory.elements.Element;
import org.openqa.selenium.WebElement;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static java.text.MessageFormat.format;

public class DefaultElementFactory implements ElementFactory {
    @Override
    public <E extends Element> E create(final Class<E> elementClass, final WebElement wrappedElement) {
        try {
            return findImplementationFor(elementClass)
                    .getDeclaredConstructor(WebElement.class)
                    .newInstance(wrappedElement);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    // Хз, работает это или нет. По идеи должно, если в elementClass присылать Element, вместо List<Element>
    @Override
    public <E extends Element> E createList(final Class<E> elementClass, final List<WebElement> wrapperElements) {
        try {
            return findImplementationFor(elementClass).getDeclaredConstructor(WebElement.class).newInstance(wrapperElements);
        }  catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private <E extends Element> Class<? extends E> findImplementationFor(final Class<E> elementClass) {
        try {
            return (Class<? extends E>) Class.forName(format("{0}.{1}Impl", getClass().getPackage().getName(), elementClass.getSimpleName()));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

