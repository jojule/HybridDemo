package org.vaadin.demo.hybrid.client;

import com.google.gwt.user.client.ui.Label;

public class MyComponentWidget extends Label {

    public static final String CLASSNAME = "mycomponent";

    public MyComponentWidget() {
        setStyleName(CLASSNAME);
    }

	public void setText(String text) {
		super.setText("[MyComponentWidget: "+text+"]");
	}

}