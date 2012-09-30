package org.vaadin.demo.hybrid.client;

public interface HourListEditor {
	public void addRow(int minutes, String description);
	public void setRow(int row, int minutes, String description);
	public int getMin(int row);
	public String getDesciption(int row);
}
