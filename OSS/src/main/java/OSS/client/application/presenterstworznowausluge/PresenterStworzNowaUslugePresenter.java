package OSS.client.application.presenterstworznowausluge;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.OdpowiedzZSerweraResult;
import OSS.client.application.shared.WyslijDoSerweraAction;
import OSS.client.place.NameTokens;
public class PresenterStworzNowaUslugePresenter extends Presenter<PresenterStworzNowaUslugePresenter.MyView, PresenterStworzNowaUslugePresenter.MyProxy>  {
    interface MyView extends View  {
    	//public void ustaw();
    	public TextBox getKosztJednostki();
    	public void setOdpowiedziZSerwera(String serverOdpowiedz);
    	public Button getZapisz();
    	public TextBox getLiczbaGodzin();
    	public void zatwierdz();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterStworzNowaUsluge = new Type<RevealContentHandler<?>>();
    private DispatchAsync dispacher;
    @NameToken(NameTokens.stworzUsluge)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterStworzNowaUslugePresenter> {
    }
    
    
    PlaceManager menager;
    @Inject
    PresenterStworzNowaUslugePresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,PlaceManager menager,DispatchAsync dispacher
           ) {
        super(eventBus, view, proxy, RevealType.Root);
        this.menager=menager;
        this.dispacher=dispacher;
        //getView().ustaw();
    }
    @Override
    protected void onBind() {
    	//getView().ustaw();
    	getView().zatwierdz();
    	super.onBind();
    }
    @Override
    protected void onReset() {
    	getView().getZapisz().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
		    	dispacher.execute(new WyslijDoSerweraAction(getView().getKosztJednostki().getText(),getView().getLiczbaGodzin().getText()), new AsyncCallback<OdpowiedzZSerweraResult>() {
					@Override
					public void onFailure(Throwable caught) {
						getView().setOdpowiedziZSerwera("erro"+caught.getMessage());
					}
					@Override
					public void onSuccess(OdpowiedzZSerweraResult result) {
						getView().setOdpowiedziZSerwera(result.getOdpowiedziZSerwera());
					}
				});
			getView().getKosztJednostki().setText(null);	
			getView().getLiczbaGodzin().setText(null);
			}
		});
    }
}