package uk.co.victoriajanedavis.shopify_challenge.ui.products;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uk.co.victoriajanedavis.shopify_challenge.GlideApp;
import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Variant;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_product_name_textview) TextView mNameTextView;
    @BindView(R.id.item_product_imageview) AppCompatImageView mImageView;
    @BindView(R.id.item_product_quantity_textview) TextView mInventoryTextView;

    private Fragment mFragment;
    private Product mProduct;

    private Disposable mDisposable;


    ProductViewHolder(Fragment fragment, LayoutInflater inflater, ViewGroup parent) {
        super (inflater.inflate (R.layout.item_product, parent, false));
        ButterKnife.bind(this, itemView);

        mFragment = fragment;
    }

    public void bind (Product product) {
        mProduct = product;

        mNameTextView.setText(product.getTitle());

        GlideApp.with(mFragment)
                .load(product.getImage().getSrc())
                .placeholder(R.drawable.product_image_placeholder)
                .fallback(R.drawable.product_image_placeholder)
                .fitCenter()
                .into(mImageView);

        mDisposable = Observable.fromIterable(product.getVariants())
                .map(Variant::getInventoryQuantity)
                .reduce((total, next) -> total + next)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    mInventoryTextView.setText(String.format(Locale.getDefault(), "Remaining Inventory: %d", value));
                });
    }

    public void onRecycle() {
        Glide.with(mFragment)
                .clear(mImageView);
        mImageView.setImageDrawable(null);

        mDisposable.dispose();
    }
}
