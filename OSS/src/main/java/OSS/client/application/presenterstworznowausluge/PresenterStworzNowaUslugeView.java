package OSS.client.application.presenterstworznowausluge;

import javax.inject.Inject;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.client.application.shared.DTO.SerwisDTO;
import OSS.client.place.NameTokens;

class PresenterStworzNowaUslugeView extends ViewImpl
		implements PresenterStworzNowaUslugePresenter.MyView, Editor<DodajSerwisDTO> {
	interface Binder extends UiBinder<Widget, PresenterStworzNowaUslugeView> {
	}
	interface Driver extends
	SimpleBeanEditorDriver<DodajSerwisDTO,PresenterStworzNowaUslugeView>{
	
	 }
	Driver driver = GWT.create(Driver.class);
	private static Binder uiBinder = GWT.create(Binder.class);
	PlaceManager menager;

	@Inject
	PresenterStworzNowaUslugeView(PlaceManager menager) {
		initWidget(uiBinder.createAndBindUi(this));
		this.menager = menager;
	}

	@UiField
	TextBox kosztJednostki;
	@UiField
	TextBox liczbaGodzin;
	@UiField
	Button zapisz;
	@UiField
	Button anuluj;

	public Button getZapisz() {
		return zapisz;
	}
	public void zatwierdz() {
		anuluj.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.glowne);
				menager.revealPlace(request);
				com.google.gwt.user.client.Window.alert("wypis"+wczytaj().getKosztJednostki()+wczytaj().getLiczbaGodzin());
				ustaw();
			}
		});
	}
	@Override
	public void setOdpowiedziZSerwera(String serverOdpowiedz) {
		com.google.gwt.user.client.Window.alert(serverOdpowiedz);
	}
	 
	public DodajSerwisDTO wczytaj(){
	 
     DodajSerwisDTO serwis = driver.flush();
	 return serwis;
	 
	 }
	 public void ustaw(){
	 driver.initialize(this);
	 driver.edit(new DodajSerwisDTO());
	 }
}