package org.vaadin.demo.hybrid.client;

import com.google.gwt.user.client.Window;
import com.vaadin.client.ApplicationConfiguration;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.WidgetSet;

public class CustomApplicationConnection extends ApplicationConnection {

	boolean offlineMode;

	@Override
	public void init(WidgetSet widgetSet, ApplicationConfiguration cnf) {
		offlineMode = Window.Location.getParameter("offline")!=null;
		if (offlineMode) 
			new MyOfflineUI().onModuleLoad();
		else
			super.init(widgetSet, cnf);
	}

	@Override
	public void start() {
		if (!offlineMode)
			super.start();
	}

}
