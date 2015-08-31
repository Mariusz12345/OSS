package OSS.client.application.presentersamochod;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterSamochodModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterSamochodPresenter.class, PresenterSamochodPresenter.MyView.class, PresenterSamochodView.class, PresenterSamochodPresenter.MyProxy.class);
    }
}