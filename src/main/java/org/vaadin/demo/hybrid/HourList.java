package org.vaadin.demo.hybrid;

import java.util.ArrayList;

import org.vaadin.demo.hybrid.client.HourListEditor;
import org.vaadin.demo.hybrid.client.HourListServerRpc;
import org.vaadin.demo.hybrid.client.HourListState;
import org.vaadin.demo.hybrid.client.HourListState.HourEntry;

import com.vaadin.ui.AbstractComponent;

public class HourList extends AbstractComponent implements HourListEditor {

	private HourListServerRpc rpc = new HourListServerRpc() {
		public void hourUpdated(HourEntry hour, int row) {
			getState().hours.set(row, hour);
		}
	};

	public HourList() {
		getState().hours = new ArrayList<HourEntry>();
		registerRpc(rpc);
	}

	protected HourListState getState() {
		return (HourListState) super.getState();
	}

	public void addRow(int minutes, String description) {
		HourEntry h = new HourEntry();
		h.minutes = minutes;
		h.description = description;
		getState().hours.add(h);
	}

	public void setRow(int row, int minutes, String description) {
		HourEntry h = new HourEntry();
		h.minutes = minutes;
		h.description = description;
		while (getState().hours.size()<row) 
			getState().hours.add(new HourEntry());
		getState().hours.set(row, h);
	}

	public int getMin(int row) {
		if (row < 0 || row >= getState().hours.size())
			return 0;
		return getState().hours.get(row).minutes;
	}

	public String getDescription(int row) {
		if (row < 0 || row >= getState().hours.size())
			return "";
		return getState().hours.get(row).description;
	}
	
	public String getText() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<getState().hours.size();i++) {
			sb.append(getMin(i));
			sb.append("min - ");
			sb.append(getDescription(i));
			sb.append("\n");
		}
		return sb.toString();
	}

}
