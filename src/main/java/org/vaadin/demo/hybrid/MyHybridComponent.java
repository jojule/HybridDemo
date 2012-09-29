package org.vaadin.demo.hybrid;

import org.vaadin.demo.hybrid.client.MyComponentClientRpc;
import org.vaadin.demo.hybrid.client.MyComponentServerRpc;
import org.vaadin.demo.hybrid.client.MyComponentState;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

public class MyHybridComponent extends AbstractComponent {

    private MyComponentServerRpc rpc = new MyComponentServerRpc() {
        private int clickCount = 0;
        
        public void clicked(MouseEventDetails mouseDetails) {
            // nag every 5:th click using RPC
            if (++clickCount % 5 == 0) {
                getRpcProxy(MyComponentClientRpc.class).alert(
                        "Ok, that's enough!");
            }
            // update shared state
            getState().text="You have clicked " + clickCount + " times";
        }
    };  

    public MyHybridComponent() {
        getState().text="This is MyComponent";
        registerRpc(rpc);
    }

    @Override
    public MyComponentState getState() {
        return (MyComponentState) super.getState();
    }
}
