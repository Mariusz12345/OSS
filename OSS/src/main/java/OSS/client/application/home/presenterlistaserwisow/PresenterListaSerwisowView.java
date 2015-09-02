package OSS.client.application.home.presenterlistaserwisow;


import javax.inject.Inject;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import OSS.client.application.shared.DTO.SerwisDTO;

class PresenterListaSerwisowView extends ViewImpl implements PresenterListaSerwisowPresenter.MyView {
    interface Binder extends UiBinder<Widget, PresenterListaSerwisowView> {
    }
  


    @Inject
    PresenterListaSerwisowView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
   
}