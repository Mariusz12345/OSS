package OSS.client.application.presentermenyglowne;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PresenterMenyGlowneModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PresenterMenyGlownePresenter.class, PresenterMenyGlownePresenter.MyView.class, PresenterMenyGlowneView.class, PresenterMenyGlownePresenter.MyProxy.class);
    }
}