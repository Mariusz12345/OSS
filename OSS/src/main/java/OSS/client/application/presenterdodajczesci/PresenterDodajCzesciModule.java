package OSS.client.application.presenterdodajczesci;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterDodajCzesciModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterDodajCzesciPresenter.class, PresenterDodajCzesciPresenter.MyView.class, PresenterDodajCzesciView.class, PresenterDodajCzesciPresenter.MyProxy.class);
    }
}