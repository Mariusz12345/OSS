package OSS.client.application.presentersamochod;

import javax.inject.Inject;

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
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.DTO.SamochodDTO;
import OSS.client.place.NameTokens;


class PresenterSamochodView extends ViewWithUiHandlers<PresenterSamochodUiHandlers> implements PresenterSamochodPresenter.MyView,Editor<SamochodDTO> {
    interface PresenterSamochodUiBinder extends UiBinder<Widget, PresenterSamochodView> {
    }
    
    private static PresenterSamochodUiBinder uiBinder = GWT.create(PresenterSamochodUiBinder.class);
    interface Driver extends SimpleBeanEditorDriver<SamochodDTO,PresenterSamochodView>{
    }
    
    PlaceManager menager;
    @UiField
    TextBox marka;
    @UiField
    TextBox model;
    @UiField
    TextBox przebieg;
    @UiField
    Button zatwierdz;
    
    public Button getZatwierdz() {
		return zatwierdz;
	}

	@Inject
    PresenterSamochodView(PlaceManager menager) {
        initWidget(uiBinder.createAndBindUi(this));
        this.menager=menager;
    }
   
   
    Driver driver = GWT.create(Driver.class);
    
    public void zatwierdz(){
    	zatwierdz.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				wczytaj();
				ustaw();
				PlaceRequest request=new PlaceRequest(NameTokens.glowne);
				menager.revealPlace(request);
			}
		});
    }
    
    public SamochodDTO wczytaj(){
    	SamochodDTO samochodDTO = driver.flush();
    	return samochodDTO;
    }
    
    public void ustaw(){
    	driver.initialize(this);
    	driver.edit(new SamochodDTO());
    }
    
}