package OSS.client.application.presentersamochod;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.gwt.user.client.ui.Button;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.Presenter.RevealType;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.HasUiHandlers;

import OSS.client.application.presentermenyglowne.PresenterMenyGlownePresenter;
import OSS.client.place.NameTokens;
public class PresenterSamochodPresenter extends Presenter<PresenterSamochodPresenter.MyView, PresenterSamochodPresenter.MyProxy> implements PresenterSamochodUiHandlers {
    interface MyView extends View , HasUiHandlers<PresenterSamochodUiHandlers> {
    	
    	public void zatwierdz();
    	public void ustaw();
    	 public Button getZatwierdz();
    	
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterSamochod = new Type<RevealContentHandler<?>>();
    PlaceManager menager;
    @NameToken(NameTokens.samochod)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterSamochodPresenter> {
    }

    @Inject
    PresenterSamochodPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy,PlaceManager menager) {
        super(eventBus, view, proxy ,RevealType.Root);
        this.menager=menager;
        getView().setUiHandlers(this);
        getView().ustaw();
    }
    @Override
    protected void revealInParent() {
    	RevealContentEvent.fire(this, PresenterMenyGlownePresenter.SLOT_PresenterMenyGlowne, this);
    }
    
    protected void onBind() {
        super.onBind();
        getView().zatwierdz();
        getView().getZatwierdz().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
					PlaceRequest request=new PlaceRequest(NameTokens.glowne);
					menager.revealPlace(request);
					
			}
		});
    }
}

