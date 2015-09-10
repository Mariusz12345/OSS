package OSS.client.application.serwer.handler;


import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.google.gwt.dev.protobuf.Service;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;
import OSS.server.DodajSerwis;


public class PobierzUslugeHandler implements ActionHandler<WyslijDoSerweraAction,OdpowiedzZSerweraResult>{
	@Inject
	public PobierzUslugeHandler() {
	}
	@Override
	public OdpowiedzZSerweraResult execute(WyslijDoSerweraAction action	, ExecutionContext execution) throws ActionException {
		try{
			Wywolaj service = null;
			service = (Wywolaj) new InitialContext().lookup("java:app/OSS-1.5/CallerName!OSS.client.application.serwer.handler.Wywolaj");
			service.dodaj4(action.getWart1(),action.getWart2());
			
		} catch (NamingException e) {
		}
		return new OdpowiedzZSerweraResult("Zapisano");
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
