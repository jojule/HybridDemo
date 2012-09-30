package org.vaadin.demo.hybrid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MyOfflineUI implements EntryPoint {

	HourListWidget myWidget = new HourListWidget();

	public void onModuleLoad() {
		RootPanel.getBodyElement().setInnerHTML("<h1>Offline mode</h1>");
		RootPanel.get().add(myWidget);
	}

}
