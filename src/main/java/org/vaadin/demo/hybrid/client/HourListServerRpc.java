package org.vaadin.demo.hybrid.client;

import org.vaadin.demo.hybrid.client.HourListState.HourEntry;

import com.vaadin.shared.communication.ServerRpc;

public interface HourListServerRpc extends ServerRpc {

    public void hourUpdated(HourEntry hour, int row);

}
