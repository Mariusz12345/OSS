package OSS.client.application.serwer.handler;


import javax.inject.Provider;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;
import OSS.server.DodajSerwis;


public class PobierzUslugeHandler implements ActionHandler<WyslijDoSerweraAction,OdpowiedzZSerweraResult>{

	private Provider<HttpServletRequest> requestServlet;
	private ServletContext servletContex;
	
	@Inject
	public PobierzUslugeHandler(Provider<HttpServletRequest> requestServlet, ServletContext servletContex) {
		this.requestServlet = requestServlet;
		this.servletContex = servletContex;
	}
	@Override
	public OdpowiedzZSerweraResult execute(WyslijDoSerweraAction action	, ExecutionContext execution) throws ActionException {
		try{
			
			Wywolaj service = null;
			DodajSerwis serwis = new DodajSerwis("999","11111");
			 
			service = (Wywolaj) new InitialContext().lookup("java:app/OSS-1.5/CallerName!OSS.client.application.serwer.handler.Wywolaj");
			service.dodaj3(serwis);
			
		} catch (NamingException e) {
		
		}
		
		return new OdpowiedzZSerweraResult("zapisano");
	}
	@Override
	public Class<WyslijDoSerweraAction> getActionType() {
		return WyslijDoSerweraAction.class;
	}

	@Override
	public void undo(WyslijDoSerweraAction arg0, OdpowiedzZSerweraResult arg1, ExecutionContext arg2)
			throws ActionException {
	}

}
