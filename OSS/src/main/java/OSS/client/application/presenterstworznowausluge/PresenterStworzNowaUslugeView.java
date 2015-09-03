package OSS.client.application.presenterstworznowausluge;

import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

class PresenterStworzNowaUslugeView extends ViewImpl implements PresenterStworzNowaUslugePresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterStworzNowaUslugeView> {
    }


    @Inject
    PresenterStworzNowaUslugeView(Binder uiBinder) {
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
	public Button getZapisz() {
		return zapisz;
	}
	public TextBox getKosztJednostki() {
		return kosztJednostki;
	}
	public TextBox getLiczbaGodzin() {
		return liczbaGodzin;
	}
    
    
    
}