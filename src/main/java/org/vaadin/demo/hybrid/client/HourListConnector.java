package org.vaadin.demo.hybrid.client;

import java.util.ArrayList;

import org.vaadin.demo.hybrid.HourList;
import org.vaadin.demo.hybrid.client.HourListState.HourEntry;
import org.vaadin.demo.hybrid.client.HourListWidget.ChangeListener;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(HourList.class)
public class HourListConnector extends AbstractComponentConnector implements ChangeListener {

    HourListServerRpc rpc = RpcProxy
            .create(HourListServerRpc.class, this);

    @Override
    protected Widget createWidget() {
        HourListWidget w = GWT.create(HourListWidget.class);
        w.addChangeListener(this);
        return w;
    }

    @Override
    public HourListWidget getWidget() {
        return (HourListWidget) super.getWidget();
    }

    public HourListState getState() {
        return (HourListState) super.getState();
    }

    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        int row = 0;
        ArrayList<HourEntry> hours = getState().hours;
        for (HourListState.HourEntry h : hours) {
        		getWidget().setRow(row++, h.minutes, h.description);
        }
    }

	public void hourListChange(HourListWidget hourList, int rowChanged) {
		HourEntry h = new HourEntry();
		h.description = getWidget().getDescription(rowChanged);
		h.minutes = getWidget().getMin(rowChanged);
		rpc.hourUpdated(h, rowChanged);
	}

}

