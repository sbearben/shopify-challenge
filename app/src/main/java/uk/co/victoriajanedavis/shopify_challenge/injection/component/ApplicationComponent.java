package uk.co.victoriajanedavis.shopify_challenge.injection.component;

import android.app.Application;
import android.content.Context;

import dagger.Component;
import uk.co.victoriajanedavis.shopify_challenge.data.DataManager;
import uk.co.victoriajanedavis.shopify_challenge.injection.ApplicationContext;
import uk.co.victoriajanedavis.shopify_challenge.injection.ApplicationScope;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.ApplicationModule;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.ShopifyServiceModule;

@ApplicationScope
@Component(modules = {ApplicationModule.class, ShopifyServiceModule.class})
public interface ApplicationComponent {

    @ApplicationContext Context context();
    Application application();
    DataManager dataManager();
}
