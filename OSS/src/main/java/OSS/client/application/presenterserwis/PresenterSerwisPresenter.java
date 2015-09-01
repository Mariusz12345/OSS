package OSS.client.application.presenterserwis;

import java.text.ParseException;

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
public class PresenterSerwisPresenter extends Presenter<PresenterSerwisPresenter.MyView, PresenterSerwisPresenter.MyProxy>  {
    interface MyView extends View  {
    	public void zatwierdz();
    	public void ustaw();
    	public void przelaczDoUslug();
    	public void ustawDataBox();
    	public void przelaczDoCzesc();
    	public void ustawWartosciValueTexBox();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterSerwis = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.serwis)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterSerwisPresenter> {
    }

    @Inject
    PresenterSerwisPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        getView().ustaw();
        getView().ustawWartosciValueTexBox();
    }
    @Override
    protected void revealInParent() {
    	RevealContentEvent.fire(this, PresenterMenyGlownePresenter.SLOT_PresenterMenyGlowne, this);
    }
    
    protected void onBind() {
        super.onBind();
        getView().ustawDataBox();
        getView().zatwierdz();
        getView().przelaczDoUslug();
        getView().przelaczDoCzesc();
    }
    
}