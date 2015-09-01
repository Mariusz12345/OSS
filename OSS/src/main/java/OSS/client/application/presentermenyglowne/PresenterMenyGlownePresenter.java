package OSS.client.application.presentermenyglowne;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;
import com.gwtplatform.mvp.client.HasUiHandlers;
import OSS.client.place.NameTokens;
public class PresenterMenyGlownePresenter extends Presenter<PresenterMenyGlownePresenter.MyView, PresenterMenyGlownePresenter.MyProxy> implements PresenterMenyGlowneUiHandlers {
    interface MyView extends View , HasUiHandlers<PresenterMenyGlowneUiHandlers> {
    	public void przelacz();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterMenyGlowne = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.glowne)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterMenyGlownePresenter> {
    }

    @Inject
    PresenterMenyGlownePresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
        getView().setUiHandlers(this);
    }
    protected void revealInParent(){
    	RevealRootContentEvent.fire(this, this);
    }
    @Override
    protected void onBind() {
    	getView().przelacz();
    	super.onBind();
    }
    
}