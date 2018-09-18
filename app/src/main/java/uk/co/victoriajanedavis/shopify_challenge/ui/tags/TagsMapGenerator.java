package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;

public class TagsMapGenerator {

    private static List<Product> mProductsList;
    private static Map<String, List<Product>> mTagsMap;


    public static Map<String, List<Product>> generateTagsMapFromProductsList(List<Product> productsList) {
        mProductsList = productsList;
        mTagsMap = new TreeMap<>();
        return generateTagsMap();
    }

    private static Map<String, List<Product>> generateTagsMap() {
        for (Product product : mProductsList) {
            List<String> productTags = generateTagsListFromTagsString(product.getTagsString());
            addProductToMapAtAllItsTags(product, productTags);
        }

        return mTagsMap;
    }

    private static List<String> generateTagsListFromTagsString(String tagsString) {
        return Arrays.asList(tagsString.split(", "));
    }

    private static void addProductToMapAtAllItsTags(Product product, List<String> productTags) {
        for (String tag : productTags) {
            addProductToMapByTag(tag, product);
        }

    }

    private static void addProductToMapByTag(String tagKey, Product product) {
        if (mapContainsTag(tagKey)) {
            List<Product> productsList = getProductsFromMapByTag(tagKey);
            addProductToListIfNotAlreadyIn(product, productsList);
        }
        else {
            addNewTagWithProductToMap(tagKey, product);
        }
    }

    private static boolean mapContainsTag(String tagKey) {
        return mTagsMap.containsKey(tagKey);
    }

    private static List<Product> getProductsFromMapByTag(String tagKey) {
        return mTagsMap.get(tagKey);
    }

    private static void addProductToListIfNotAlreadyIn(Product product, List<Product> productsList) {
        if (!productsList.contains(product)) {
            productsList.add(product);
        }
    }

    private static void addNewTagWithProductToMap(String tagKey, Product product) {
        List<Product> productsList = new ArrayList<>();
        productsList.add(product);
        mTagsMap.put(tagKey, productsList);
    }
}
