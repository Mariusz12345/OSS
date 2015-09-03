package OSS.client.application.presenterserwis;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.presenterdodajczesci.Jednostki;
import OSS.client.application.shared.DTO.SerwisDTO;
import OSS.client.place.NameTokens;

class PresenterSerwisView extends ViewImpl implements PresenterSerwisPresenter.MyView, Editor<SerwisDTO> {
	interface PresenterSerwisUiBinder extends UiBinder<Widget, PresenterSerwisView> {
	}


	interface Driver extends SimpleBeanEditorDriver<SerwisDTO, PresenterSerwisView> {

	}
	PlaceManager menager;
	Driver driver = GWT.create(Driver.class);
	@Inject
	PresenterSerwisView(PresenterSerwisUiBinder uiBinder,PlaceManager menager) {
		initWidget(uiBinder.createAndBindUi(this));
		this.menager=menager;
	}
	PresenterSerwisView(){
		
	}
	@UiField
	Button guzik;
	@UiField
	Button dodajUsluge;
	@UiField
	Button dodajczesci;
	@UiField
	DateBox  biezacaData;
	
	// Struktura robienia ValueListBox skopiowane ze strony http://c.gwt-examples.com/home/ui/valuelistboxeditor 
	@UiField(provided = true)
	ValueListBox<Pracownik> pracownik = new ValueListBox<Pracownik>(new Renderer<Pracownik>() {

		@Override
		public String render(Pracownik object) {

			return String.valueOf(object);
		}

		@Override
		public void render(Pracownik object, Appendable appendable) throws IOException {
			
		}
	});
	public void przelaczDoUslug(){
		dodajUsluge.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request=new PlaceRequest(NameTokens.usluga);
				menager.revealPlace(request);
			}
		});
	}
	public void przelaczDoCzesc(){
		dodajczesci.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				PlaceRequest request=new PlaceRequest(NameTokens.czesc);
				menager.revealPlace(request);
			}
		});
	}

	public void zatwierdz() {
		guzik.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				wczytaj();
				ustaw();
			}
		});
	}

	public SerwisDTO wczytaj() {
		SerwisDTO samochod = driver.flush();
		Window.alert("Dane:" + samochod.getBiezacaData()+samochod.getPracownik() );
		return samochod;
	}

	public void ustawDataBox(){
		DateTimeFormat dateTimeFormat = DateTimeFormat.getFormat(PredefinedFormat.HOUR24_MINUTE_SECOND);
		DefaultFormat defaultFormat = new DateBox.DefaultFormat(dateTimeFormat);
		Date date = new Date();
		biezacaData.setValue(date);
		biezacaData.setFormat(defaultFormat);
	
	}
	public void ustawWartosciValueTexBox(){
		pracownik.setAcceptableValues(Arrays.asList(Pracownik.values()));
		pracownik.setValue(Pracownik.Kowalczyk, true);
	}
	public void ustaw() {
		//SerwisDTO p =new SerwisDTO();
		//PresenterSerwisView editor = new PresenterSerwisView();
		//driver.initialize(editor);
		//driver.edit(p);
		driver.initialize(this);
		driver.edit(new SerwisDTO());
	}
}