package org.vaadin.demo.hybrid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class ReportView extends VerticalLayout implements View {

	public void enter(ViewChangeEvent event) {
		Label l = new Label("Add Admin Functionality Here");
		addComponent(l);
		setSizeFull();
		setComponentAlignment(l,Alignment.MIDDLE_CENTER);
	}

}
