package org.vaadin.demo.hybrid.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class MyOfflineUI implements EntryPoint {

	HourListWidget hourList = new HourListWidget();

	public void onModuleLoad() {
		RootPanel.getBodyElement().setInnerHTML("<h1>Offline mode</h1>");
		RootPanel.get().add(hourList);
		
		for (int i = 0; i < 10; i++) {
			hourList.setRow(i,(int)(Math.random()*200), "Desr " + i);
		}

	}

}
