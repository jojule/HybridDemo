package org.vaadin.demo.hybrid.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class HourListWidget extends VerticalPanel implements HourListEditor {

	public static final String CLASSNAME = "mycomponent";

	public HourListWidget() {
		setStyleName(CLASSNAME);
	}

	public void addRow(int minutes, String description) {
		HorizontalPanel h = new HorizontalPanel();
		TextBox m = new TextBox();
		TextBox d = new TextBox();
		m.setValue(minutesAsString(minutes));
		d.setValue(description);
		h.add(m);
		h.add(d);
		add(h);
	}

	public void setRow(int row, int minutes, String description) {
		while (row >= getChildren().size())
			addRow(0, "");
		Widget r = getChildren().get(row);
		if (!(r instanceof HorizontalPanel))
			return;
		TextBox min = (TextBox) ((HorizontalPanel) r).getWidget(0);
		TextBox descr = (TextBox) ((HorizontalPanel) r).getWidget(1);
		min.setValue(minutesAsString(minutes));
		descr.setValue(description);
	}

	public int getMin(int row) {
		if (row >= getChildren().size())
			return 0;
		Widget r = getChildren().get(row);
		if (!(r instanceof HorizontalPanel))
			return 0;
		TextBox min = (TextBox) ((HorizontalPanel) r).getWidget(0);
		return parseMinutes(min.getValue());
	}

	public String getDesciption(int row) {
		if (row >= getChildren().size())
			return "";
		Widget r = getChildren().get(row);
		if (!(r instanceof HorizontalPanel))
			return "";
		TextBox descr = (TextBox) ((HorizontalPanel) r).getWidget(1);
		return descr.getValue();
	}

	private String minutesAsString(int minutes) {
		int h = minutes / 60;
		int m = minutes - h * 60;
		return "" + h + ":" + (m < 10 ? "0" : "") + m;
	}

	private int parseMinutes(String minutes) {
		String[] a = minutes.split(":");
		if (a.length != 2)
			return 0;
		try {
			int h = Integer.parseInt(a[0]);
			int m = Integer.parseInt(a[1]);
			return h * 60 + m;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}