package OSS.client.application.presenterdodajczesci;

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
import OSS.client.place.NameTokens;
public class PresenterDodajCzesciPresenter extends Presenter<PresenterDodajCzesciPresenter.MyView, PresenterDodajCzesciPresenter.MyProxy>  {
    interface MyView extends View  {
    	public void ustawValueListBox();
    	public void ustaw();
    	public void wykonaj();
    	public void anuluj();
    	public void ustawDataGrid();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterDodajCzesci = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.czesc)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterDodajCzesciPresenter> {
    }

    @Inject
    PresenterDodajCzesciPresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        getView().ustawValueListBox();
        getView().ustaw();
    }
    
    protected void onBind() {
        super.onBind();
        getView().ustawValueListBox();
        getView().wykonaj();
        getView().anuluj();
        getView().ustawDataGrid();
        
    }
    
}