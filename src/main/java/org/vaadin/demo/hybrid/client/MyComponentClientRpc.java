package org.vaadin.demo.hybrid.client;

import com.vaadin.shared.communication.ClientRpc;

public interface MyComponentClientRpc extends ClientRpc {

    public void alert(String message);

}