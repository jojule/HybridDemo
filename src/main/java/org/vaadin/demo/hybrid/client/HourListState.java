package org.vaadin.demo.hybrid.client;

import java.util.LinkedList;

public class HourListState extends com.vaadin.shared.ComponentState {
	public LinkedList<HourEntry> hours;
	
	public static class HourEntry {
		public int minutes;
		public String description;
	}
}