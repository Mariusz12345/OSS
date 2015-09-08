package OSS.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import OSS.client.application.serwer.handler.PobierzUslugeHandler;
import OSS.client.application.shared.WyslijDoSerweraAction;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
    	bindHandler(WyslijDoSerweraAction.class, PobierzUslugeHandler.class);
    }
}
