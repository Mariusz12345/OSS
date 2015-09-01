package OSS.client.application.presenterdodajusluge;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterDodajUslugeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterDodajUslugePresenter.class, PresenterDodajUslugePresenter.MyView.class, PresenterDodajUslugeView.class, PresenterDodajUslugePresenter.MyProxy.class);
    }
}