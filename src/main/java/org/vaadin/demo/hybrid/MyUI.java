package org.vaadin.demo.hybrid;

import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Widgetset("org.vaadin.demo.hybrid.MyWidgetSet")
public class MyUI extends UI {
	private SimpleViewDisplay display = new SimpleViewDisplay();
	private Navigator navigator = new Navigator(this, (ViewDisplay) display);

	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.addComponent(buildMenu(navigator));
		layout.addComponent(display);
		layout.setExpandRatio(display, 1.0f);
		setContent(layout);
	}

	@SuppressWarnings("unchecked")
	private Component buildMenu(final Navigator navigator) {
		MenuBar menu = new MenuBar();
		menu.setWidth("100%");

		for (Class<? extends View> viewClass : new Class[] { WorkhoursView.class, AdminView.class,
				ReportView.class }) {
			String name = viewClass.getSimpleName();
			if (name.indexOf("View") > 0)
				name = name.substring(0, name.indexOf("View"));
			final String path = viewClass == WorkhoursView.class ? "" : name
					.toLowerCase();
			menu.addItem(name, new Command() {
				public void menuSelected(MenuItem selectedItem) {
					navigator.navigateTo(path);
					
				}
			});
			navigator.addView(path, viewClass);
		}

		return menu;
	}
}
