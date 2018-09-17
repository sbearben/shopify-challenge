package uk.co.victoriajanedavis.shopify_challenge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Products;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Variant;
import uk.co.victoriajanedavis.shopify_challenge.ui.tags.TagsMapGenerator;

import static org.junit.Assert.*;

public class TagsGeneratorTest {

    private static final String TAG = "TagsGeneratorTest";
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    private Gson mGson;


    @Before
    public void setup() {
        mGson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();
    }

    @Test
    public void tagsGeneratorWorks() {
        String json =
                "{\n" +
                        "  \"products\": [\n" +
                        "    {\n" +
                        "      \"id\": 2759137027,\n" +
                        "      \"title\": \"Aerodynamic Concrete Clock\",\n" +
                        "      \"body_html\": \"Transition rich vortals\",\n" +
                        "      \"vendor\": \"Jenkins, Orn and Blick\",\n" +
                        "      \"product_type\": \"Clock\",\n" +
                        "      \"created_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "      \"handle\": \"aerodynamic-concrete-clock\",\n" +
                        "      \"updated_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "      \"published_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "      \"template_suffix\": null,\n" +
                        "      \"tags\": \"Aerodynamic, Clock, Concrete\",\n" +
                        "      \"published_scope\": \"web\",\n" +
                        "      \"admin_graphql_api_id\": \"gid://shopify/Product/2759137027\",\n" +
                        "      \"variants\": [\n" +
                        "        {\n" +
                        "          \"id\": 8041741187,\n" +
                        "          \"product_id\": 2759137027,\n" +
                        "          \"title\": \"Mint green\",\n" +
                        "          \"price\": \"4.32\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Mint green\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 4917,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 134,\n" +
                        "          \"weight\": 4.917,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015629699,\n" +
                        "          \"old_inventory_quantity\": 134,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041741187\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041741251,\n" +
                        "          \"product_id\": 2759137027,\n" +
                        "          \"title\": \"Violet\",\n" +
                        "          \"price\": \"76.67\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 2,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Violet\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:17-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 8081,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 112,\n" +
                        "          \"weight\": 8.081,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 931603459,\n" +
                        "          \"old_inventory_quantity\": 112,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041741251\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"options\": [\n" +
                        "        {\n" +
                        "          \"id\": 3321582851,\n" +
                        "          \"product_id\": 2759137027,\n" +
                        "          \"name\": \"Title\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"values\": [\n" +
                        "            \"Mint green\",\n" +
                        "            \"Violet\"\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"id\": 5641966979,\n" +
                        "          \"product_id\": 2759137027,\n" +
                        "          \"position\": 1,\n" +
                        "          \"created_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "          \"updated_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "          \"alt\": null,\n" +
                        "          \"width\": 300,\n" +
                        "          \"height\": 300,\n" +
                        "          \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734\",\n" +
                        "          \"variant_ids\": [],\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641966979\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"image\": {\n" +
                        "        \"id\": 5641966979,\n" +
                        "        \"product_id\": 2759137027,\n" +
                        "        \"position\": 1,\n" +
                        "        \"created_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "        \"updated_at\": \"2015-09-23T20:48:54-04:00\",\n" +
                        "        \"alt\": null,\n" +
                        "        \"width\": 300,\n" +
                        "        \"height\": 300,\n" +
                        "        \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Concrete_20Clock.png?v=1443055734\",\n" +
                        "        \"variant_ids\": [],\n" +
                        "        \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641966979\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 2759162243,\n" +
                        "      \"title\": \"Aerodynamic Cotton Keyboard\",\n" +
                        "      \"body_html\": \"Extend leading-edge bandwidth\",\n" +
                        "      \"vendor\": \"Mayer LLC\",\n" +
                        "      \"product_type\": \"Keyboard\",\n" +
                        "      \"created_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "      \"handle\": \"aerodynamic-cotton-keyboard\",\n" +
                        "      \"updated_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "      \"published_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "      \"template_suffix\": null,\n" +
                        "      \"tags\": \"Aerodynamic, Cotton, Keyboard\",\n" +
                        "      \"published_scope\": \"web\",\n" +
                        "      \"admin_graphql_api_id\": \"gid://shopify/Product/2759162243\",\n" +
                        "      \"variants\": [\n" +
                        "        {\n" +
                        "          \"id\": 8041822275,\n" +
                        "          \"product_id\": 2759162243,\n" +
                        "          \"title\": \"Blue\",\n" +
                        "          \"price\": \"6.00\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Blue\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:18-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 905,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 80,\n" +
                        "          \"weight\": 0.905,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 1710034179,\n" +
                        "          \"old_inventory_quantity\": 80,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041822275\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"options\": [\n" +
                        "        {\n" +
                        "          \"id\": 3321609667,\n" +
                        "          \"product_id\": 2759162243,\n" +
                        "          \"name\": \"Title\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"values\": [\n" +
                        "            \"Blue\"\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"id\": 5642017731,\n" +
                        "          \"product_id\": 2759162243,\n" +
                        "          \"position\": 1,\n" +
                        "          \"created_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "          \"updated_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "          \"alt\": null,\n" +
                        "          \"width\": 300,\n" +
                        "          \"height\": 300,\n" +
                        "          \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Cotton_20Keyboard.png?v=1443055852\",\n" +
                        "          \"variant_ids\": [],\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5642017731\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"image\": {\n" +
                        "        \"id\": 5642017731,\n" +
                        "        \"product_id\": 2759162243,\n" +
                        "        \"position\": 1,\n" +
                        "        \"created_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "        \"updated_at\": \"2015-09-23T20:50:52-04:00\",\n" +
                        "        \"alt\": null,\n" +
                        "        \"width\": 300,\n" +
                        "        \"height\": 300,\n" +
                        "        \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Cotton_20Keyboard.png?v=1443055852\",\n" +
                        "        \"variant_ids\": [],\n" +
                        "        \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5642017731\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 2759143811,\n" +
                        "      \"title\": \"Aerodynamic Granite Plate\",\n" +
                        "      \"body_html\": \"Whiteboard cross-platform users\",\n" +
                        "      \"vendor\": \"Schneider and Sons\",\n" +
                        "      \"product_type\": \"Plate\",\n" +
                        "      \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "      \"handle\": \"aerodynamic-granite-plate\",\n" +
                        "      \"updated_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "      \"published_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "      \"template_suffix\": null,\n" +
                        "      \"tags\": \"Aerodynamic, Granite, Plate\",\n" +
                        "      \"published_scope\": \"web\",\n" +
                        "      \"admin_graphql_api_id\": \"gid://shopify/Product/2759143811\",\n" +
                        "      \"variants\": [\n" +
                        "        {\n" +
                        "          \"id\": 8041765955,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Teal\",\n" +
                        "          \"price\": \"50.88\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Teal\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 9205,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 73,\n" +
                        "          \"weight\": 9.205,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015635907,\n" +
                        "          \"old_inventory_quantity\": 73,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041765955\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766019,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Turquoise\",\n" +
                        "          \"price\": \"24.91\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 2,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Turquoise\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:18-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 1208,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 13,\n" +
                        "          \"weight\": 1.208,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015635971,\n" +
                        "          \"old_inventory_quantity\": 13,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766019\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766083,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Ivory\",\n" +
                        "          \"price\": \"20.08\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 3,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Ivory\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:12-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 9324,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 174,\n" +
                        "          \"weight\": 9.324,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015636035,\n" +
                        "          \"old_inventory_quantity\": 174,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766083\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766147,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Azure\",\n" +
                        "          \"price\": \"19.45\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 4,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Azure\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 7304,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 173,\n" +
                        "          \"weight\": 7.304,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015636099,\n" +
                        "          \"old_inventory_quantity\": 173,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766147\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766211,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Grey\",\n" +
                        "          \"price\": \"3.61\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 5,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Grey\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:18-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 2624,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 168,\n" +
                        "          \"weight\": 2.624,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 931604739,\n" +
                        "          \"old_inventory_quantity\": 168,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766211\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766275,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Green\",\n" +
                        "          \"price\": \"73.59\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 6,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Green\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:12-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 2890,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 12,\n" +
                        "          \"weight\": 2.89,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 931604803,\n" +
                        "          \"old_inventory_quantity\": 12,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766275\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766339,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Blue\",\n" +
                        "          \"price\": \"16.09\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 7,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Blue\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 342,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 148,\n" +
                        "          \"weight\": 0.342,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 1745596803,\n" +
                        "          \"old_inventory_quantity\": 148,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766339\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766723,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Violet\",\n" +
                        "          \"price\": \"29.20\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 8,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Violet\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 1317,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 115,\n" +
                        "          \"weight\": 1.317,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015636163,\n" +
                        "          \"old_inventory_quantity\": 115,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766723\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041766851,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"title\": \"Black\",\n" +
                        "          \"price\": \"20.14\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 9,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Black\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:12-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 7315,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 186,\n" +
                        "          \"weight\": 7.315,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015636227,\n" +
                        "          \"old_inventory_quantity\": 186,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041766851\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"options\": [\n" +
                        "        {\n" +
                        "          \"id\": 3321590147,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"name\": \"Title\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"values\": [\n" +
                        "            \"Teal\",\n" +
                        "            \"Turquoise\",\n" +
                        "            \"Ivory\",\n" +
                        "            \"Azure\",\n" +
                        "            \"Grey\",\n" +
                        "            \"Green\",\n" +
                        "            \"Blue\",\n" +
                        "            \"Violet\",\n" +
                        "            \"Black\"\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"id\": 5641981891,\n" +
                        "          \"product_id\": 2759143811,\n" +
                        "          \"position\": 1,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"updated_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "          \"alt\": null,\n" +
                        "          \"width\": 300,\n" +
                        "          \"height\": 300,\n" +
                        "          \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Granite_20Plate.png?v=1443055768\",\n" +
                        "          \"variant_ids\": [],\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641981891\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"image\": {\n" +
                        "        \"id\": 5641981891,\n" +
                        "        \"product_id\": 2759143811,\n" +
                        "        \"position\": 1,\n" +
                        "        \"created_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "        \"updated_at\": \"2015-09-23T20:49:28-04:00\",\n" +
                        "        \"alt\": null,\n" +
                        "        \"width\": 300,\n" +
                        "        \"height\": 300,\n" +
                        "        \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Granite_20Plate.png?v=1443055768\",\n" +
                        "        \"variant_ids\": [],\n" +
                        "        \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641981891\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"id\": 2759149635,\n" +
                        "      \"title\": \"Aerodynamic Linen Computer\",\n" +
                        "      \"body_html\": \"Whiteboard virtual web services\",\n" +
                        "      \"vendor\": \"Connelly LLC\",\n" +
                        "      \"product_type\": \"Computer\",\n" +
                        "      \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "      \"handle\": \"aerodynamic-linen-computer\",\n" +
                        "      \"updated_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "      \"published_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "      \"template_suffix\": null,\n" +
                        "      \"tags\": \"Aerodynamic, Computer, Linen\",\n" +
                        "      \"published_scope\": \"web\",\n" +
                        "      \"admin_graphql_api_id\": \"gid://shopify/Product/2759149635\",\n" +
                        "      \"variants\": [\n" +
                        "        {\n" +
                        "          \"id\": 8041781891,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"title\": \"Cyan\",\n" +
                        "          \"price\": \"82.13\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Cyan\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 709,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 51,\n" +
                        "          \"weight\": 0.709,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015638851,\n" +
                        "          \"old_inventory_quantity\": 51,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041781891\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041781955,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"title\": \"White\",\n" +
                        "          \"price\": \"27.26\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 2,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"White\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:18-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 6985,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 173,\n" +
                        "          \"weight\": 6.985,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015638915,\n" +
                        "          \"old_inventory_quantity\": 173,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041781955\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041782019,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"title\": \"Plum\",\n" +
                        "          \"price\": \"85.71\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 3,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Plum\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:12-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 5337,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 23,\n" +
                        "          \"weight\": 5.337,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015638979,\n" +
                        "          \"old_inventory_quantity\": 23,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041782019\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041782083,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"title\": \"Orchid\",\n" +
                        "          \"price\": \"75.90\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 4,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Orchid\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:13-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 3843,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 86,\n" +
                        "          \"weight\": 3.843,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015639043,\n" +
                        "          \"old_inventory_quantity\": 86,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041782083\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": 8041782147,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"title\": \"Lavender\",\n" +
                        "          \"price\": \"62.80\",\n" +
                        "          \"sku\": \"\",\n" +
                        "          \"position\": 5,\n" +
                        "          \"inventory_policy\": \"deny\",\n" +
                        "          \"compare_at_price\": null,\n" +
                        "          \"fulfillment_service\": \"manual\",\n" +
                        "          \"inventory_management\": null,\n" +
                        "          \"option1\": \"Lavender\",\n" +
                        "          \"option2\": null,\n" +
                        "          \"option3\": null,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2018-09-11T18:07:18-04:00\",\n" +
                        "          \"taxable\": true,\n" +
                        "          \"barcode\": null,\n" +
                        "          \"grams\": 914,\n" +
                        "          \"image_id\": null,\n" +
                        "          \"inventory_quantity\": 98,\n" +
                        "          \"weight\": 0.914,\n" +
                        "          \"weight_unit\": \"kg\",\n" +
                        "          \"inventory_item_id\": 6015639107,\n" +
                        "          \"old_inventory_quantity\": 98,\n" +
                        "          \"requires_shipping\": true,\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductVariant/8041782147\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"options\": [\n" +
                        "        {\n" +
                        "          \"id\": 3321596227,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"name\": \"Title\",\n" +
                        "          \"position\": 1,\n" +
                        "          \"values\": [\n" +
                        "            \"Cyan\",\n" +
                        "            \"White\",\n" +
                        "            \"Plum\",\n" +
                        "            \"Orchid\",\n" +
                        "            \"Lavender\"\n" +
                        "          ]\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"images\": [\n" +
                        "        {\n" +
                        "          \"id\": 5641993091,\n" +
                        "          \"product_id\": 2759149635,\n" +
                        "          \"position\": 1,\n" +
                        "          \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"updated_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "          \"alt\": null,\n" +
                        "          \"width\": 300,\n" +
                        "          \"height\": 300,\n" +
                        "          \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Linen_20Computer.png?v=1443055794\",\n" +
                        "          \"variant_ids\": [],\n" +
                        "          \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641993091\"\n" +
                        "        }\n" +
                        "      ],\n" +
                        "      \"image\": {\n" +
                        "        \"id\": 5641993091,\n" +
                        "        \"product_id\": 2759149635,\n" +
                        "        \"position\": 1,\n" +
                        "        \"created_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "        \"updated_at\": \"2015-09-23T20:49:54-04:00\",\n" +
                        "        \"alt\": null,\n" +
                        "        \"width\": 300,\n" +
                        "        \"height\": 300,\n" +
                        "        \"src\": \"https://cdn.shopify.com/s/files/1/1000/7970/products/Aerodynamic_20Linen_20Computer.png?v=1443055794\",\n" +
                        "        \"variant_ids\": [],\n" +
                        "        \"admin_graphql_api_id\": \"gid://shopify/ProductImage/5641993091\"\n" +
                        "      }\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}";

        Products products = mGson.fromJson(json, Products.class);

        Map<String, List<Product>> tagsMap = TagsMapGenerator.generateTagsMapFromProductsList(products.getProductsList());
        List<String> tags = new ArrayList<>(tagsMap.keySet());

        assertTrue(tags.contains("Aerodynamic"));
        assertTrue(tags.contains("Clock"));
        assertTrue(tags.contains("Concrete"));
        assertTrue(tags.contains("Cotton"));
        assertTrue(tags.contains("Keyboard"));
        assertTrue(tags.contains("Granite"));
        assertTrue(tags.contains("Plate"));
        assertTrue(tags.contains("Computer"));
        assertTrue(tags.contains("Linen"));
        assertEquals(tags.size(), 9);

        List<Product> aeroProducts = tagsMap.get("Aerodynamic");
        assertEquals(4, aeroProducts.size());

        Observable.fromIterable(aeroProducts.get(0).getVariants())
                .map(Variant::getInventoryQuantity)
                .reduce((total, next) -> total + next)
                .subscribe(value -> {
                    assertEquals(246, value.intValue());
                });
    }
}
