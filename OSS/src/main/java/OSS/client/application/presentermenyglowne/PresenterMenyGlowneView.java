package OSS.client.application.presentermenyglowne;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.place.NameTokens;

class PresenterMenyGlowneView extends ViewWithUiHandlers<PresenterMenyGlowneUiHandlers>
		implements PresenterMenyGlownePresenter.MyView {
	interface Binder extends UiBinder<Widget, PresenterMenyGlowneView> {
	}

	@UiField
	Button dodajSamochod;
	@UiField
	Button dodajSerwis;
	@UiField
	Button listaSerwisow;
	@UiField
	HTMLPanel kontener;
	
	PlaceManager menager;
	
	@Inject
	PresenterMenyGlowneView(Binder uiBinder,PlaceManager menager) {
		initWidget(uiBinder.createAndBindUi(this));
		this.menager=menager;
	}
	@Override
	public void setInSlot(Object slot, IsWidget content) {
		if(slot == PresenterMenyGlownePresenter.SLOT_PresenterMenyGlowne){
			kontener.clear();
			
			if(content!=null){
				kontener.add(content);
				
			}
			}else{
				super.setInSlot(slot, content);
			}
		}
	
	
	public void przelacz(){
		dodajSamochod.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.samochod);
				menager.revealPlace(request);
			}
		});
		dodajSerwis.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				PlaceRequest request=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(request);
			}
		});
		listaSerwisow.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request=new PlaceRequest(NameTokens.listaserwisow);
				menager.revealPlace(request);
			}
		});
	}
	
	
	

}