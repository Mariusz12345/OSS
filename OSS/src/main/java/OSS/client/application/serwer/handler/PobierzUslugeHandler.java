package OSS.client.application.serwer.handler;

import javax.inject.Provider;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;

public class PobierzUslugeHandler implements ActionHandler<WyslijDoSerweraAction,OdpowiedzZSerweraResult>{

	private Provider<HttpServletRequest> requestServlet;
	private ServletContext servletContex;
	
	public PobierzUslugeHandler(Provider<HttpServletRequest> requestServlet, ServletContext servletContex) {
		super();
		this.requestServlet = requestServlet;
		this.servletContex = servletContex;
	}
	@Override
	public OdpowiedzZSerweraResult execute(WyslijDoSerweraAction action	, ExecutionContext execution) throws ActionException {
		
		return null;
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
