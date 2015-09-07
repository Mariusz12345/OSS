package OSS.client.application.presenterstworznowausluge;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
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

import OSS.client.place.NameTokens;
public class PresenterStworzNowaUslugePresenter extends Presenter<PresenterStworzNowaUslugePresenter.MyView, PresenterStworzNowaUslugePresenter.MyProxy>  {
    interface MyView extends View  {
    	public Button getZapisz();
    	public TextBox getKosztJednostki();
    	public TextBox getLiczbaGodzin();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterStworzNowaUsluge = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.stworzUsluge)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterStworzNowaUslugePresenter> {
    }
    PlaceManager menager;
    @Inject
    PresenterStworzNowaUslugePresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,PlaceManager menager
           ) {
        super(eventBus, view, proxy, RevealType.Root);
        this.menager=menager;
    }
    
    protected void onBind() {
        super.onBind();
        
       registerHandler(getView().getZapisz().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				wyslijDaneNaSerwer();
			}

		}));
    }

	private void wyslijDaneNaSerwer() {
		PlaceRequest request = new PlaceRequest.Builder().nameToken(NameTokens.usluga).build().with("name", getView().getKosztJednostki().getText()).with("name2", getView().getLiczbaGodzin().getText());
		menager.revealPlace(request);
		
	}
    
}