package org.vaadin.demo.hybrid.client;

import java.util.LinkedList;

import com.vaadin.shared.communication.ServerRpc;

public interface HourListServerRpc extends ServerRpc {

    public void hoursUpdated(LinkedList<HourListState.HourEntry> hours);

}
