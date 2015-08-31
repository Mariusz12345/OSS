package OSS.client.application.presenterserwis;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;


import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.core.java.util.Arrays;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import OSS.client.application.shared.DTO.SerwisDTO;

class PresenterSerwisView extends ViewImpl implements PresenterSerwisPresenter.MyView,Editor<SerwisDTO> {
    interface PresenterSerwisUiBinder extends UiBinder<Widget, PresenterSerwisView> {
    }

    private static PresenterSerwisUiBinder uiBinder = GWT.create(PresenterSerwisUiBinder.class);
 
    
    
    
    interface Driver extends SimpleBeanEditorDriver<SerwisDTO,PresenterSerwisView>{
    	
    }
    @Inject
    PresenterSerwisView(PresenterSerwisUiBinder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    Driver driver = GWT.create(Driver.class);
    @UiField
    TextBox data;
    @UiField
    Button guzik;
    //Chwilowo nie dzia³a
//    @UiField(provided = true) 
//    ValueListBox<Pracownik> pracownik = new ValueListBox<Pracownik>(new Renderer<Pracownik>() {
//
//		@Override
//		public String render(Pracownik object) {
//			String s = "";
//
//			 if (object != null) {
//			        s = object.toString();
//			 }
//		      return s.toString(); 
//
//			
//		}
//		@Override
//		public void render(Pracownik object, Appendable appendable) throws IOException {
//			// TODO Auto-generated method stub
//		}
//	});

 
    
    
    public void zatwierdz(){
    	guzik.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				wczytaj();
				ustaw();
				
			}
		});
    }
    
    
    public SerwisDTO wczytaj(){
    	SerwisDTO samochod =driver.flush();
    	Window.alert("Dane:"+samochod.getData());
    	return samochod;
    }
    
    public void ustaw(){
    	driver.initialize(this);
    	driver.edit(new SerwisDTO());
    }
    
}