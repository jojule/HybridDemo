package org.vaadin.demo.hybrid;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public class MyVaadinUI extends UI
{
    protected void init(VaadinRequest request) {
        addComponent(new MyComponent());
    }

}
