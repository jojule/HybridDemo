package org.vaadin.demo.hybrid.client;

import com.google.gwt.user.client.ui.Label;

public class MyComponentWidget extends Label {

    public static final String CLASSNAME = "mycomponent";

    public MyComponentWidget() {

        // setText("MyComponent sets the text via MyComponentConnector using MyComponentState");
        setStyleName(CLASSNAME);

    }

}