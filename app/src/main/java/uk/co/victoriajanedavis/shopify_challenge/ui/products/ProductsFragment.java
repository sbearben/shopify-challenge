package uk.co.victoriajanedavis.shopify_challenge.ui.products;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;
import uk.co.victoriajanedavis.shopify_challenge.util.DisplayMetricsUtil;

public class ProductsFragment extends Fragment {

    public static final String TAG = "ProductsFragment";

    private static final String ARG_PRODUCTS_TAG = "products_tag";
    private static final String ARG_PRODUCTS_LIST = "products_list";

    private static final String SAVED_PRODUCTS_LIST = "fragment_products_saved_products_list";

    private ProductsAdapter mAdapter;

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.fragment_products_recyclerview) protected RecyclerView mRecycler;

    protected String mTag;
    protected Unbinder mUnbinder;


    public static ProductsFragment newInstance(String tag, List<Product> products) {
        Bundle args = new Bundle();
        args.putString(ARG_PRODUCTS_TAG, tag);
        args.putParcelableArrayList(ARG_PRODUCTS_LIST, new ArrayList<>(products));

        ProductsFragment fragment = new ProductsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTag = getArguments().getString(ARG_PRODUCTS_TAG);

        mAdapter = new ProductsAdapter(this);
        mAdapter.addProducts(getArguments().getParcelableArrayList(ARG_PRODUCTS_LIST));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_products, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        initViews(v);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle(String.format(Locale.getDefault(), "Products - %s", mTag));
        }
    }

    protected void initViews(View view) {
        mRecycler.setAdapter(mAdapter);
        mRecycler.setLayoutManager(new GridLayoutManager(getContext(), DisplayMetricsUtil.isTabletLayout() ? 4 : 2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecycler.setAdapter(null);

        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
