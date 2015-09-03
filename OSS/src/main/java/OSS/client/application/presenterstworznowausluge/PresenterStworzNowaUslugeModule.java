package OSS.client.application.presenterstworznowausluge;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterStworzNowaUslugeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterStworzNowaUslugePresenter.class, PresenterStworzNowaUslugePresenter.MyView.class, PresenterStworzNowaUslugeView.class, PresenterStworzNowaUslugePresenter.MyProxy.class);
    }
}