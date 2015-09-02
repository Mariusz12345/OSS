package OSS.client.application.home.presenterlistaserwisow;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterListaSerwisowModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterListaSerwisowPresenter.class, PresenterListaSerwisowPresenter.MyView.class, PresenterListaSerwisowView.class, PresenterListaSerwisowPresenter.MyProxy.class);
    }
}