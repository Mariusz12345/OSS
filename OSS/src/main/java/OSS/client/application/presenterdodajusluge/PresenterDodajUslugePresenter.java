package OSS.client.application.presenterdodajusluge;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;
import OSS.client.place.NameTokens;
import OSS.server.DodajSerwis;
public class PresenterDodajUslugePresenter extends Presenter<PresenterDodajUslugePresenter.MyView, PresenterDodajUslugePresenter.MyProxy>  {
    interface MyView extends View  {
    	public void zatwierdz();
    	//public void ustaw();
    	public void anuluj();
    	 public void ustawDaneWDataGrid();
    	 public void wartosci();
    	 public void setOdpowiedziZSerwera(String serverOdpowiedz);
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterDodajUsluge = new Type<RevealContentHandler<?>>();
    private DispatchAsync dispacher;
    private String name = "";
    @NameToken(NameTokens.usluga)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterDodajUslugePresenter> {
    }

    @Inject
    PresenterDodajUslugePresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,DispatchAsync dispacher) {
        super(eventBus, view, proxy, RevealType.Root);
        //getView().ustaw();
        this.dispacher=dispacher;
    }
    @Override
    protected void onBind() {
    	super.onBind();
    	getView().zatwierdz();
    	getView().anuluj();
    	getView().ustawDaneWDataGrid();
    	getView().wartosci();
    }
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		name = request.getParameter("name", "wartosci Domyslan");
	}
   
    @Override
   protected void onReset() {
    	getView().setOdpowiedziZSerwera("poczeka");
    	dispacher.execute(new WyslijDoSerweraAction(name), new AsyncCallback<OdpowiedzZSerweraResult>() {

			@Override
			public void onFailure(Throwable caught) {
				getView().setOdpowiedziZSerwera("erro"+caught.getMessage());
				
			}
			@Override
			public void onSuccess(OdpowiedzZSerweraResult result) {
				getView().setOdpowiedziZSerwera(result.getOdpowiedziZSerwera());
			}
		});
    }
}