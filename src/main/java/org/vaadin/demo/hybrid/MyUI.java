package org.vaadin.demo.hybrid;

import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.Navigator.SimpleViewDisplay;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Widgetset("org.vaadin.demo.hybrid.MyWidgetSet")
public class MyUI extends UI {
	private SimpleViewDisplay display = new SimpleViewDisplay();
	private Navigator navigator = new Navigator(this, (ViewDisplay) display);

	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(new Label("Online mode"));
		layout.addComponent(buildMenu(navigator));
		layout.addComponent(display);
		setContent(layout);
	}

	@SuppressWarnings("unchecked")
	private Component buildMenu(final Navigator navigator) {
		HorizontalLayout menu = new HorizontalLayout();

		for (Class<? extends View> viewClass : new Class[] { HybridView.class, FooView.class,
				BarView.class }) {
			String name = viewClass.getSimpleName();
			if (name.indexOf("View") > 0)
				name = name.substring(0, name.indexOf("View"));
			final String path = viewClass == HybridView.class ? "" : name
					.toLowerCase();
			menu.addComponent(new Button(name, new ClickListener() {
				public void buttonClick(ClickEvent event) {
					navigator.navigateTo(path);
				}
			}));
			navigator.addView(path, viewClass);
		}

		return menu;
	}
}
