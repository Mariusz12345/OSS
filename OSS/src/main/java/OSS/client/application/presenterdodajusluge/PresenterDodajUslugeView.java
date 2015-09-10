package OSS.client.application.presenterdodajusluge;

import java.util.List;
import java.util.ArrayList;

import javax.inject.Inject;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.thirdparty.javascript.rhino.jstype.TemplatizedType;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.presenterdodajczesci.Jednostki;
import OSS.client.application.shared.DTO.UslugaDTO;
import OSS.client.place.NameTokens;
import OSS.server.DodajSerwis;

class PresenterDodajUslugeView extends ViewImpl implements PresenterDodajUslugePresenter.MyView,Editor<UslugaDTO> {
    interface PresenterDodajUslugeBinder extends UiBinder<Widget, PresenterDodajUslugeView> {
    }
    interface Driver extends SimpleBeanEditorDriver<UslugaDTO, PresenterDodajUslugeView> {

	}
    Driver driver = GWT.create(Driver.class);
    PlaceManager menager;
    @Inject
    PresenterDodajUslugeView(PresenterDodajUslugeBinder uiBinder,PlaceManager menager) {
        initWidget(uiBinder.createAndBindUi(this));
        this.menager=menager;
        
    }
    PresenterDodajUslugeView(){
    }
    @UiField
    TextBox odczyt;
    @UiField
    Button wykonaj;
    @UiField
    Button anuluj;
    @UiField
    DataGrid<UslugaDTO> listaUslug;
    public void ustawDaneWDataGrid(){
    	 Column<UslugaDTO, Boolean> checkColumn = new Column<UslugaDTO, Boolean>(
    		        new CheckboxCell(true, false)) {
    		      @Override
    		      public Boolean getValue(UslugaDTO object) {
    		        return false;
    		      }
    		    };
    	TextColumn<UslugaDTO> kosztJednostkowy = new TextColumn<UslugaDTO>() {

			@Override
			public String getValue(UslugaDTO usluga) {
				
				return usluga.getKoszJednostki();
			}
    	};
    	TextColumn<UslugaDTO> liczbaGodzin = new TextColumn<UslugaDTO>() {

			@Override
			public String getValue(UslugaDTO usluga) {
				
				return usluga.getlGodziny();
			}
    	};
    	listaUslug.setWidth("500px");
    	listaUslug.setHeight("100px");
    	listaUslug.addColumn(checkColumn,"");
    	listaUslug.addColumn(kosztJednostkowy,"Koszt Jednostkowy");
    	listaUslug.addColumn(liczbaGodzin,"Liczba Godzin");
    }
    public void wartosci(){
    	List<UslugaDTO> listaUslugg = new ArrayList<>();
    	listaUslugg.add(new UslugaDTO("200","20h"));
    	listaUslugg.add(new UslugaDTO("150","15h"));
    	listaUslugg.add(new UslugaDTO("100","10h"));
    	listaUslugg.add(new UslugaDTO("50","5h"));
    	listaUslug.setRowData(listaUslugg);
    }
    public void zatwierdz(){
    	wykonaj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//wczytaj();
				//ustaw();
				PlaceRequest request=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(request);
			}
		});
    }
    public void anuluj(){
    	anuluj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				PlaceRequest request=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(request);
			}
		});
    }
    public void wypisZBazy(String wypis){
    	this.odczyt.setText(wypis);
    }
//    public  void wczytaj(){
//    	UslugaDTO usluga = driver.flush();
//    	Window.alert("test: "+usluga.getKoszJednostki()+usluga.getlGodziny());
//    }
//    public void ustaw(){
//    	UslugaDTO p = new UslugaDTO();
//    	PresenterDodajUslugeView editor = new PresenterDodajUslugeView();
//		driver.initialize(editor);
//		driver.edit(p);
//    }
   
    
    
}