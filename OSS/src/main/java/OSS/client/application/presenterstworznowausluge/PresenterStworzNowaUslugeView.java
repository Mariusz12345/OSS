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

import OSS.client.application.shared.DTO.DodajSerwisDTO;
import OSS.client.application.shared.DTO.SerwisDTO;

class PresenterStworzNowaUslugeView extends ViewImpl
		implements PresenterStworzNowaUslugePresenter.MyView,Editor<DodajSerwisDTO> {
	interface Binder extends UiBinder<Widget, PresenterStworzNowaUslugeView> {
	}
	
	interface Driver extends SimpleBeanEditorDriver<DodajSerwisDTO,PresenterStworzNowaUslugeView>{
		
	}
	
	Driver driver = GWT.create(Driver.class);
	 private static Binder uiBinder = GWT.create(Binder.class);
	PlaceManager menager;
	PresenterStworzNowaUslugeView(PlaceManager menager){
		this.menager=menager;
	}
	
	@Inject
	PresenterStworzNowaUslugeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	@UiField
	TextBox kosztJednostki;
	@UiField
	TextBox liczbaGodzin;
	@UiField
	Button zapisz;
	@UiField
	Button anuluj;
	
	public void zatwierdz(){
		zapisz.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				wczytaj();
				ustaw();
				
			}
		});
	}
	
	public void wczytaj(){
		DodajSerwisDTO serwis = driver.flush();
		com.google.gwt.user.client.Window.alert("wypis:" + serwis.getKosztJednostki()+serwis.getLiczbaGodzin());
	}
	public void ustaw(){

		driver.initialize(this);
		driver.edit(new DodajSerwisDTO());
	}
}