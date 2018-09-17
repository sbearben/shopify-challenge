package uk.co.victoriajanedavis.shopify_challenge.ui.products;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private Fragment mFragment;
    private List<Product> mProducts;


    public ProductsAdapter(Fragment fragment) {
        mFragment = fragment;
        mProducts = new ArrayList<>();
    }

    @Override
    @NonNull
    public ProductViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new ProductViewHolder (mFragment, layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder (@NonNull ProductViewHolder holder, int position) {
        Product product = mProducts.get(position);
        holder.bind(product);
    }

    @Override
    public void onViewRecycled(@NonNull ProductViewHolder holder) {
        super.onViewRecycled(holder);
        holder.onRecycle();
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public List<Product> getProducts() {
        return mProducts;
    }

    public void addProducts(List<Product> products) {
        mProducts.addAll(products);
        notifyItemRangeInserted(mProducts.size() - products.size(), products.size());
    }

    public void removeAll() {
        mProducts.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }
}
