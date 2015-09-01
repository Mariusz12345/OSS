package OSS.client.application.presenterdodajusluge;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.DTO.SerwisDTO;
import OSS.client.application.shared.DTO.UslugaDTO;
import OSS.client.place.NameTokens;

class PresenterDodajUslugeView extends ViewImpl implements PresenterDodajUslugePresenter.MyView,Editor<UslugaDTO> {
    interface PresenterDodajUslugeBinder extends UiBinder<Widget, PresenterDodajUslugeView> {
    }
    interface Driver extends SimpleBeanEditorDriver<UslugaDTO, PresenterDodajUslugeView> {

	}
    Driver driver = GWT.create(Driver.class);
    PlaceManager menager;
    
    @UiField
    TextBox koszJednostki;
    @UiField
    Button wykonaj;
    @UiField
    Button anuluj;
    @UiField
    TextBox lGodziny;

    @Inject
    PresenterDodajUslugeView(PresenterDodajUslugeBinder uiBinder,PlaceManager menager) {
        initWidget(uiBinder.createAndBindUi(this));
        this.menager=menager;
    }
    
    public void zatwierdz(){
    	wykonaj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				wczytaj();
				ustaw();
				PlaceRequest request=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(request);
			}
		});
    }
    public void anuluj(){
    	anuluj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				koszJednostki.setValue("");
				lGodziny.setValue("");
				PlaceRequest request=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(request);
			}
		});
    	
    }
    public UslugaDTO wczytaj(){
    	UslugaDTO usluga = driver.flush();
    	Window.alert("test: "+usluga.getKoszJednostki()+usluga.getlGodziny());
    	return usluga;
    }
    public void ustaw(){
    	driver.initialize(this);
    	driver.edit(new UslugaDTO());
    }
    
}