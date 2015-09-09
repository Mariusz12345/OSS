package OSS.client.application.serwer.handler;


import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
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
//		String wyjscie = action.getSerwis();
//		String serverInfo = servletContex.getServerInfo();
//		String userAgent = requestServlet.get().getHeader("User-Agent");
//		return new OdpowiedzZSerweraResult("Witaj! Twoja wiadomosci wyslana do nas to: " + wyjscie
//				+ "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are using:<br>" + userAgent);
//		
		try{
			Wywolaj service = null;
			DodajSerwis serwis = new DodajSerwis(1l, 15, 24);
//
//		    //service.doAction(action.getSerwisDTO().dodajSerwisNaSztywno());
			//InitialContext ctx = new InitialContext();
			//Bean bean = (Bean) ctx.lookup("java:/OSS/src/main/java/OSS/client/application/serwer/handler/Bean");
			//Bean bean = new Bean();
			   service = (Wywolaj) new InitialContext().lookup("java:app/OSS-1.5/CallerName!OSS.client.application.serwer.handler.Wywolaj");
			   service.dodaj3(serwis);
			//bean.dodaj1(serwis);
			
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
		// TODO Auto-generated method stub
	}

}
