package uk.co.victoriajanedavis.shopify_challenge.data;

import javax.inject.Inject;

import io.reactivex.Single;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Products;
import uk.co.victoriajanedavis.shopify_challenge.data.remote.ShopifyService;
import uk.co.victoriajanedavis.shopify_challenge.injection.ApplicationScope;

@ApplicationScope
public class DataManager {

    private final ShopifyService mShopifyService;

    @Inject
    public DataManager(ShopifyService shopifyService) {
        mShopifyService = shopifyService;
    }

    public Single<Products> getAllProducts() {
        return mShopifyService.getProducts();
    }
}
