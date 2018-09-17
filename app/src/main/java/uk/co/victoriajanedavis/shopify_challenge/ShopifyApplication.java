package uk.co.victoriajanedavis.shopify_challenge;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;
import uk.co.victoriajanedavis.shopify_challenge.injection.component.ApplicationComponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.component.DaggerApplicationComponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.ApplicationModule;

public class ShopifyApplication extends Application  {

    ApplicationComponent mApplicationComponent;
    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mRefWatcher = LeakCanary.install(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Fabric.with(this, new Crashlytics());
        }
    }

    public void mustDie(Object object) {
        if (mRefWatcher != null) {
            mRefWatcher.watch(object);
        }
    }

    public static ShopifyApplication get(Context context) {
        return (ShopifyApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
