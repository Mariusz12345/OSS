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

	// interface Driver extends
	// SimpleBeanEditorDriver<DodajSerwisDTO,PresenterStworzNowaUslugeView>{
	//
	// }
	//
	// Driver driver = GWT.create(Driver.class);
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

	public TextBox getLiczbaGodzin() {
		return liczbaGodzin;
	}

	public TextBox getKosztJednostki() {
		return kosztJednostki;
	}

	public void zatwierdz() {
		anuluj.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request = new PlaceRequest(NameTokens.glowne);
				menager.revealPlace(request);
			}
		});
	}

	@Override
	public void setOdpowiedziZSerwera(String serverOdpowiedz) {
		com.google.gwt.user.client.Window.alert(serverOdpowiedz);
	}

	// public void wczytaj(){
	// DodajSerwisDTO serwis = driver.flush();
	// com.google.gwt.user.client.Window.alert("wypis:" +
	// serwis.getKosztJednostki()+serwis.getLiczbaGodzin());
	// }
	// public void ustaw(){
	//
	// driver.initialize(this);
	// driver.edit(new DodajSerwisDTO());
	// }

}