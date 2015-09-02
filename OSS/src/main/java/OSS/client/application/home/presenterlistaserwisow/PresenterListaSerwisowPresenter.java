package OSS.client.application.home.presenterlistaserwisow;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
    import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import OSS.client.application.presentermenyglowne.PresenterMenyGlownePresenter;
import OSS.client.place.NameTokens;
public class PresenterListaSerwisowPresenter extends Presenter<PresenterListaSerwisowPresenter.MyView, PresenterListaSerwisowPresenter.MyProxy>  {
    interface MyView extends View  {
    	
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterListaSerwisow = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.listaserwisow)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterListaSerwisowPresenter> {
    }

    @Inject
    PresenterListaSerwisowPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        
    }
    protected void revealInParent() {
    	RevealContentEvent.fire(this, PresenterMenyGlownePresenter.SLOT_PresenterMenyGlowne, this);
    }
    
    protected void onBind() {
        super.onBind();
    }
    
}