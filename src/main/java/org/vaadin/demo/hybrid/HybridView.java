package org.vaadin.demo.hybrid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

public class HybridView extends VerticalLayout implements View {

	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new MyHybridComponent());
	}

}
