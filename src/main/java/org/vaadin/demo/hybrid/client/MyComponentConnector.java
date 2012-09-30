package org.vaadin.demo.hybrid.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

import org.vaadin.demo.hybrid.HourList;
import com.vaadin.client.communication.RpcProxy;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.communication.StateChangeEvent;

@Connect(HourList.class)
public class MyComponentConnector extends AbstractComponentConnector {

    HourListServerRpc rpc = RpcProxy
            .create(HourListServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        return GWT.create(HourListWidget.class);
        // TODO register listener
    }

    @Override
    public HourListWidget getWidget() {
        return (HourListWidget) super.getWidget();
    }

    @Override
    public HourListState getState() {
        return (HourListState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        int row = 0;
        for (HourListState.HourEntry h : getState().hours) {
        		getWidget().setRow(row++, h.minutes, h.description);
        }
    }

}

