package OSS.client.application.presenterdodajczesci;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import OSS.client.application.shared.DTO.CzescDTO;
import OSS.client.place.NameTokens;

class PresenterDodajCzesciView extends ViewImpl implements PresenterDodajCzesciPresenter.MyView,Editor<CzescDTO> {
    interface PresenterDodajCzesciBinder extends UiBinder<Widget, PresenterDodajCzesciView> {
    }

    interface Driver extends SimpleBeanEditorDriver<CzescDTO, PresenterDodajCzesciView> {
    }
    PlaceManager menager;
    @Inject
    PresenterDodajCzesciView(PresenterDodajCzesciBinder uiBinder,PlaceManager menager) {
        initWidget(uiBinder.createAndBindUi(this));
        this.menager=menager;
    }
	Driver driver = GWT.create(Driver.class);
	
	
    @UiField
    Button wykonaj;
	@UiField
	Button anuluj;
	@UiField
	TextBox cenna;
	@UiField(provided = true)
	ValueListBox<Jednostki> jednostka = new ValueListBox<Jednostki>(new Renderer<Jednostki>() {
		@Override
		public String render(Jednostki object) {
			// TODO Auto-generated method stub
			return String.valueOf(object);
		}
		@Override
		public void render(Jednostki object, Appendable appendable) throws IOException {
			// TODO Auto-generated method stub
			
		}
	});
	@UiField
	DataGrid<CzescDTO> dataGrid;
	
	public void ustawDataGrid(){
		 Column<CzescDTO, Boolean> checkColumn = new Column<CzescDTO, Boolean>(
 		        new CheckboxCell(true, false)) {
 		      @Override
 		      public Boolean getValue(CzescDTO object) {
 		        return false;
 		      }
 		    };

    	TextColumn<CzescDTO> cenna = new TextColumn<CzescDTO>() {

			@Override
			public String getValue(CzescDTO cenna) {
				
				return cenna.getCenna();
			}
    	};
    
    	
    	dataGrid.setWidth("500px");
    	dataGrid.setHeight("100px");
    	dataGrid.addColumn(checkColumn,"");
    	dataGrid.addColumn(cenna,"Cenna czesci");
	}
	
	public void wykonaj(){
		wykonaj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			wczytaj();
			ustaw();
			PlaceRequest placeRequest=new PlaceRequest(NameTokens.serwis);
			menager.revealPlace(placeRequest);
			}
		});
	}
	public void anuluj(){
		anuluj.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			
				cenna.setValue("");
				PlaceRequest placeRequest=new PlaceRequest(NameTokens.serwis);
				menager.revealPlace(placeRequest);
				
			}
		});
	}
	
	public void ustawValueListBox(){
		jednostka.setAcceptableValues(Arrays.asList(Jednostki.values()));
		jednostka.setValue(Jednostki.Kilogramy, true);
	}
	public CzescDTO wczytaj(){
		CzescDTO czesc = driver.flush();
		Window.alert("Test: " + czesc.getCenna()+czesc.getJednostka());
		return czesc;
	}
	public void ustaw(){
		driver.initialize(this);
		driver.edit(new CzescDTO());
	}
	
}