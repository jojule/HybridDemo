package org.vaadin.demo.hybrid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class AdminView extends VerticalLayout implements View {

	public void enter(ViewChangeEvent event) {
		Label l = new Label("Add Admin Functionality Here");
		l.setSizeUndefined();
		addComponent(l);
		setSizeFull();
		setComponentAlignment(l,Alignment.MIDDLE_CENTER);
	}

}
