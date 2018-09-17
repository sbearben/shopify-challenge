package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;
import uk.co.victoriajanedavis.shopify_challenge.ui.products.ProductsFragment;

public class TagViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.item_tag_textview) TextView mTextView;

    private Context mContext;

    private String mTag;
    private Map<String, List<Product>> mTagsMap;


    TagViewHolder(Context context, LayoutInflater inflater, ViewGroup parent, Map<String, List<Product>> tagsMap) {
        super (inflater.inflate (R.layout.item_tag, parent, false));
        ButterKnife.bind(this, itemView);

        mContext = context;
        mTagsMap = tagsMap;

        itemView.setOnClickListener(this);
    }

    public void bind (String tag) {
        mTag = tag;
        mTextView.setText(tag);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = ((AppCompatActivity) mContext).getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.activity_fragment_container, ProductsFragment.newInstance(mTag, mTagsMap.get(mTag)))
                .addToBackStack(null)
                .commit();
    }
}
