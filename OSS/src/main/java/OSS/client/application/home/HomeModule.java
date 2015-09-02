package OSS.client.application.home;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import OSS.client.application.home.presenterlistaserwisow.PresenterListaSerwisowModule;

public class HomeModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new PresenterListaSerwisowModule());
		bindPresenter(HomePagePresenter.class, HomePagePresenter.MyView.class, HomePageView.class,
                HomePagePresenter.MyProxy.class);
    }
}
