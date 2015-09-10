package OSS.client.application.presenterdodajusluge;

import org.hibernate.event.internal.OnReplicateVisitor;

import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
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
    }
    @ContentSlot
    public static final Type<RevealContentHandler<?>> SLOT_PresenterDodajUsluge = new Type<RevealContentHandler<?>>();
    private DispatchAsync dispacher;
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
    
}