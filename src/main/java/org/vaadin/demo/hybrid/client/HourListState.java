package org.vaadin.demo.hybrid.client;

import java.util.ArrayList;

public class HourListState extends com.vaadin.shared.ComponentState {
	public ArrayList<HourEntry> hours = new ArrayList<HourEntry>();
	
	public static class HourEntry {
		public int minutes =0;
		public String description="";
	}
}