package org.vaadin.demo.hybrid.client;

import java.util.ArrayList;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class HourListWidget extends VerticalPanel implements HourListEditor {

	public static final String CLASSNAME = "mycomponent";
	ArrayList<ChangeListener> changeListeners = new ArrayList<ChangeListener>();

	public HourListWidget() {
		setStyleName(CLASSNAME);
		addEmptyRow();
	}

	public void setRow(int row, int minutes, String description) {
		while (row >= getChildren().size())
			addEmptyRow();
		if ((minutes != 0 || !"".equals(description))&&row == getChildren().size()-1)
			addEmptyRow();
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

	public String getDescription(int row) {
		if (row >= getChildren().size())
			return "";
		Widget r = getChildren().get(row);
		if (!(r instanceof HorizontalPanel))
			return "";
		TextBox descr = (TextBox) ((HorizontalPanel) r).getWidget(1);
		return descr.getValue();
	}

	private void addEmptyRow() {
		final int row = getChildren().size();

		HorizontalPanel h = new HorizontalPanel();
		final TextBox m = new TextBox();
		TextBox d = new TextBox();
		m.setValue(minutesAsString(0));
		d.setValue("");
		h.add(m);
		h.add(d);
		add(h);
		
		m.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent e) {
				m.setValue(minutesAsString(parseMinutes(m.getValue())));
				if (row==getChildren().size()-1)
					addEmptyRow();
				fireChange(row);
			}
		});
		
		d.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent e) {
				if (row==getChildren().size()-1)
					addEmptyRow();
				fireChange(row);
			}
		});		
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
	
	public interface ChangeListener {
		public void hourListChange(HourListWidget hourList, int rowChanged);
	}
	
	public void addChangeListener(ChangeListener listener) {
		changeListeners.add(listener);
	}
	public void removeChangeListener(ChangeListener listener) {
		changeListeners.remove(listener);
	}
	public void removeAllChangeListener() {
		changeListeners.clear();
	}
	@SuppressWarnings("unchecked")
	private void fireChange(int rowChanged) {
		for (ChangeListener l : (ArrayList<ChangeListener>) changeListeners.clone()) {
			l.hourListChange(this,rowChanged);
		}
	}
}