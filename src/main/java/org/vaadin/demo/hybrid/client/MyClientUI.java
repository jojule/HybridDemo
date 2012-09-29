package org.vaadin.demo.hybrid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

public class MyClientUI implements EntryPoint {

	public void onModuleLoad() {
		MyComponentWidget label = new MyComponentWidget();
		label.setText("Hello GWT !!!");
		Button button = new Button("Say something");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Hello, again");
			}
		});

		RootPanel.get().add(label);
		RootPanel.get().add(button);
	}

}
