package OSS.client.application.presenterdodajczesci;

import java.io.IOException;
import java.util.Arrays;

import javax.inject.Inject;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import OSS.client.application.presenterserwis.Pracownik;
import OSS.client.application.shared.DTO.CzescDTO;

class PresenterDodajCzesciView extends ViewImpl implements PresenterDodajCzesciPresenter.MyView,Editor<CzescDTO> {
    interface PresenterDodajCzesciBinder extends UiBinder<Widget, PresenterDodajCzesciView> {
    }

    interface Driver extends SimpleBeanEditorDriver<CzescDTO, PresenterDodajCzesciView> {
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
	
	public void ustaw(){
		jednostka.setAcceptableValues(Arrays.asList(Jednostki.values()));
		jednostka.setValue(Jednostki.Kilogramy, true);
	}
	
	
	@Inject
    PresenterDodajCzesciView(PresenterDodajCzesciBinder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

	
	
	
}