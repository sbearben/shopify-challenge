package uk.co.victoriajanedavis.shopify_challenge.injection.component;

import dagger.Subcomponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.PerActivity;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.ActivityModule;
import uk.co.victoriajanedavis.shopify_challenge.ui.MainActivity;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
