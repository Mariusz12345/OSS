package OSS.client.application.presenterserwis;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterSerwisModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterSerwisPresenter.class, PresenterSerwisPresenter.MyView.class, PresenterSerwisView.class, PresenterSerwisPresenter.MyProxy.class);
    }
}