package org.vaadin.demo.hybrid.client;

import java.util.ArrayList;

public class HourListState extends com.vaadin.shared.ComponentState {
	public ArrayList<HourEntry> hours;
	
	public static class HourEntry {
		public int minutes;
		public String description;
	}
}