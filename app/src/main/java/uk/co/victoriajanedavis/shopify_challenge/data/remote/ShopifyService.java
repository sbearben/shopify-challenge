package uk.co.victoriajanedavis.shopify_challenge.data.remote;

import io.reactivex.Single;
import retrofit2.http.GET;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Products;

public interface ShopifyService {

    @GET("https://shopicruit.myshopify.com/admin/products.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Single<Products> getProducts();

}
