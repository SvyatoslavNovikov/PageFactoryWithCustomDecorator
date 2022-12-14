package org.example.factory;

import org.example.factory.elements.Element;
import org.example.factory.elements.impl.DefaultElementFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {
    private ElementFactory elementFactory = new DefaultElementFactory();
    private ContainerFactory containerFactory = new DefaultContainerFactory();

    public ExtendedFieldDecorator(final SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(final ClassLoader loader, final Field field) {
        if (Container.class.isAssignableFrom(field.getType())) {
            return decorateContainer(loader, field);
        }
        if (Element.class.isAssignableFrom(field.getType())) {
            return decorateElement(loader, field);
        }
        /**
         * added logic
         * not ready
         */

        // ToDo Как то нужно получать класс из genericType, и вызывать соотвевующий метод
        if (List.class.isAssignableFrom(field.getType())) {
            System.out.println("1" + field.getGenericType());
            System.out.println("2" + loader.getClass());
            return decorateListContainer(loader, field);
        }
        return super.decorate(loader, field);
    }

    private Object decorateElement(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        return elementFactory.create((Class<? extends Element>) field.getType(), wrappedElement);
    }

    private ElementLocator createLocator(final Field field) {
        return factory.createLocator(field);
    }

    private Object decorateContainer(final ClassLoader loader, final Field field) {
        final WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        final Container container = containerFactory.create((Class<? extends Container>) field.getType(), wrappedElement);

        PageFactory.initElements(new ExtendedFieldDecorator(wrappedElement), container);
        return container;
    }

    /**
     * added methods
     * not ready
     */

    private List<Object> decorateListElement(final ClassLoader loader, final Field field) {
        final List<WebElement> wrapperElements = proxyForListLocator(loader, createLocator(field));
        final List<Object> elements = new ArrayList<>();
        for (WebElement wrapperElement: wrapperElements) {
            elements.add(elementFactory.create((Class<? extends Element>) field.getGenericType(), wrapperElement));
        }

        return elements;
    }

    private List<Object> decorateListContainer(final ClassLoader loader, final Field field) {
        final List<WebElement> wrapperElements = proxyForListLocator(loader, createLocator(field));
        final List<Object> containers = new ArrayList<>();
        for (WebElement wrapperElement: wrapperElements) {
            final Container container = containerFactory
                    .create((Class<? extends Container>) field.getGenericType(),wrapperElement);
            PageFactory.initElements(new ExtendedFieldDecorator(wrapperElement), container);
            containers.add(container);
        }

        return containers;
   }
}
