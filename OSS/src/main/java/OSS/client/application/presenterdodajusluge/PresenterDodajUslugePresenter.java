package OSS.client.application.presenterdodajusluge;

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
public class PresenterDodajUslugePresenter extends Presenter<PresenterDodajUslugePresenter.MyView, PresenterDodajUslugePresenter.MyProxy>  {
    interface MyView extends View  {
    	public void zatwierdz();
    	public void ustaw();
    	public void anuluj();
    	 public void ustawDaneWDataGrid();
    	 public void wartosci();
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterDodajUsluge = new Type<RevealContentHandler<?>>();

    @NameToken(NameTokens.usluga)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<PresenterDodajUslugePresenter> {
    }

    @Inject
    PresenterDodajUslugePresenter(
            EventBus eventBus,
            MyView view, 
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
        getView().ustaw();
        
    }
    @Override
    protected void onBind() {
    	super.onBind();
    	getView().zatwierdz();
    	getView().anuluj();
    	getView().ustawDaneWDataGrid();
    	getView().wartosci();
    }
    
}