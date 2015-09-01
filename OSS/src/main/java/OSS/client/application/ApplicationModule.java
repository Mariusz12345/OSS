package OSS.client.application;

import OSS.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import OSS.client.application.presentersamochod.PresenterSamochodModule;
import OSS.client.application.presentermenyglowne.PresenterMenyGlowneModule;
import OSS.client.application.presenterserwis.PresenterSerwisModule;
import OSS.client.application.presenterdodajusluge.PresenterDodajUslugeModule;
import OSS.client.application.presenterdodajczesci.PresenterDodajCzesciModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
		install(new PresenterDodajCzesciModule());
		install(new PresenterDodajUslugeModule());
		install(new PresenterSerwisModule());
		install(new PresenterMenyGlowneModule());
		install(new PresenterSamochodModule());
		install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
}
