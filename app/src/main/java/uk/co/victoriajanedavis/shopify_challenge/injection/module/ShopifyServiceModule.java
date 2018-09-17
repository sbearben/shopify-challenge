package uk.co.victoriajanedavis.shopify_challenge.injection.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import uk.co.victoriajanedavis.shopify_challenge.data.remote.ShopifyService;
import uk.co.victoriajanedavis.shopify_challenge.injection.ApplicationScope;

@Module(includes = NetworkModule.class)
public class ShopifyServiceModule {


    @Provides
    @ApplicationScope
    public ShopifyService shopifyService (Retrofit shopifyRetrofit) {
        return shopifyRetrofit.create(ShopifyService.class);
    }

    @Provides
    @ApplicationScope
    public Retrofit retrofit (OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl("https://api.vimeo.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    public Gson gson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }
}
