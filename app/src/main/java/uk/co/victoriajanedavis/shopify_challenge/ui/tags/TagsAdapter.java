package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;

public class TagsAdapter extends RecyclerView.Adapter<TagViewHolder> {

    private Context mContext;
    private List<String> mTags;

    private Map<String, List<Product>> mTagsMap;


    public TagsAdapter(Context context) {
        mContext = context;
        mTags = new ArrayList<>();
    }

    @Override
    @NonNull
    public TagViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new TagViewHolder(mContext, layoutInflater, parent, mTagsMap);
    }

    @Override
    public void onBindViewHolder (@NonNull TagViewHolder holder, int position) {
        String tag = mTags.get(position);
        holder.bind(tag);
    }

    @Override
    public int getItemCount() {
        return mTags.size();
    }

    public List<String> getTags() {
        return mTags;
    }

    public void addTags(List<String> tags) {
        mTags.addAll(tags);
        notifyItemRangeInserted(mTags.size() - tags.size(), tags.size());
    }

    public void removeAll() {
        mTags.clear();
        notifyDataSetChanged();
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void setTagsMap(Map<String, List<Product>> tagsMap) {
        mTagsMap = tagsMap;
    }
}
