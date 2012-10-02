package org.vaadin.demo.hybrid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

public class WorkhoursView extends VerticalLayout implements View {

	HourList hourlist = new HourList();

	public void enter(ViewChangeEvent event) {
		setSizeFull();
		addComponent(hourlist);
		setComponentAlignment(hourlist, Alignment.BOTTOM_CENTER);
		for (int i = 0; i < 10; i++) {
			hourlist.addRow((int) (Math.random() * 200), "Desr " + i);
		}
		Button b = new Button("Show contents", new ClickListener() {
			public void buttonClick(ClickEvent event) {
				Notification.show(hourlist.getText());
			}
		});
		addComponent(b);
		setComponentAlignment(b, Alignment.TOP_CENTER);

	}
}
