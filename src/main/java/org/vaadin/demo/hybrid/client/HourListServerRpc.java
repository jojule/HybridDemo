package org.vaadin.demo.hybrid.client;

import java.util.ArrayList;

import org.vaadin.demo.hybrid.client.HourListState.HourEntry;

import com.vaadin.shared.communication.ServerRpc;

public interface HourListServerRpc extends ServerRpc {

    public void hoursUpdated(ArrayList<HourEntry> hours);

}
