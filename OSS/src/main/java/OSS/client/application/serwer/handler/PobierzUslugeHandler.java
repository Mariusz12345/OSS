package OSS.client.application.serwer.handler;



import java.lang.invoke.MethodHandles.Lookup;
import java.sql.SQLException;

import javax.inject.Provider;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.google.gwt.i18n.client.Messages.Example;
import com.google.gwt.user.client.ui.ImageBundle.Resource;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;
import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.server.DodajSerwis;

public class PobierzUslugeHandler implements ActionHandler<WyslijDoSerweraAction,OdpowiedzZSerweraResult>{

	private static final Example Example = null;
	private Provider<HttpServletRequest> requestServlet;
	private ServletContext servletContex;
	
	public PobierzUslugeHandler(Provider<HttpServletRequest> requestServlet, ServletContext servletContex) {
		super();
		this.requestServlet = requestServlet;
		this.servletContex = servletContex;
	}
	@Override
	public OdpowiedzZSerweraResult execute(WyslijDoSerweraAction action	, ExecutionContext execution) throws ActionException {
		
		//@Resource(Lookup="java:/OSS/src/main/java/OSS/client/application/serwer/handler/DataAccessBean")
		
		try {
		
			DodajSerwis serwis = new DodajSerwis(1l, 15, 24);
			InitialContext ctx = new InitialContext();
			Bean bean = (Bean) ctx.lookup("java:/OSS/src/main/java/OSS/client/application/serwer/handler/Bean");
		ctx.lookup("bean");
			bean.dodaj1(serwis);
		//bean.dodaj1(action.getSerwisDTO().dodajSerwisNaSztywno());
		} catch (NamingException e) {
			e.printStackTrace();
		}
		//DodajSerwis serwis = new DodajSerwis(1l, 15, 24);
		//new Bean().dodaj1(action.getSerwisDTO().dodajSerwisNaSztywno());
		//new Bean().dodaj2(action.getServiceName());
		//new Bean().dodaj1(serwis);
		
		return  new OdpowiedzZSerweraResult("zapisano");
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
