package uk.co.victoriajanedavis.shopify_challenge.injection.module;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;
import uk.co.victoriajanedavis.shopify_challenge.injection.ApplicationScope;

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    public OkHttpClient okHttpClient (HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    public HttpLoggingInterceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message -> {
            Timber.i(message);
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return interceptor;
    }
}
