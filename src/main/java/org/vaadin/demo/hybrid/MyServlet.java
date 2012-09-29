package org.vaadin.demo.hybrid;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@WebServlet(urlPatterns = {"/*"})
public class MyServlet extends VaadinServlet implements SessionInitListener {

	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		getService().addSessionInitListener(this);
	}

	public void sessionInit(SessionInitEvent event)
			throws ServiceException {
		getService().addUIProvider(event.getSession(),
				new MyUIProvider());
	}

	static class MyUIProvider extends UIProvider {
		public Class<? extends UI> getUIClass(
				UIClassSelectionEvent event) {
			return MyUI.class;
		}		
	}
}
