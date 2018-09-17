package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.ui.MarginDividerItemDecoration;
import uk.co.victoriajanedavis.shopify_challenge.ui.base.BaseFragment;

public class TagsFragment extends BaseFragment implements TagsMvpView, SwipeRefreshLayout.OnRefreshListener {

    public static final String TAG = "TagsFragment";

    private static final String SAVED_TAGS_LIST = "fragment_tags_saved_tags_list";

    @Inject TagsPresenter mPresenter;

    private TagsAdapter mAdapter;

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @BindView(R.id.fragment_tags_swipe_to_refresh) SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.fragment_tags_recyclerview) protected RecyclerView mRecycler;

    @BindView(R.id.content_progress) protected ProgressBar mContentLoadingProgress;
    @BindView(R.id.message_layout) protected View mMessageLayout;
    @BindView(R.id.message_imageview) protected ImageView mMessageImage;
    @BindView(R.id.message_textview) protected TextView mMessageText;
    @BindView(R.id.message_tryagain_button) protected Button mMessageButton;

    protected Unbinder mUnbinder;


    public static TagsFragment newInstance() {
        return new TagsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
        mPresenter.attachView(this);

        mAdapter = new TagsAdapter(getContext());

        if (savedInstanceState != null) {
            mAdapter.setTagsMap(mPresenter.getTagsMap());
            mAdapter.addTags(savedInstanceState.getStringArrayList(SAVED_TAGS_LIST));
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tags, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        initViews(v);

        if (mAdapter.isEmpty()) {
            mPresenter.onInitialListRequested();
        }

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setTitle("Tags");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    protected void initViews(View view) {
        mRecycler.setAdapter(mAdapter);

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.addItemDecoration (new MarginDividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL, R.dimen.recycler_view_divider_margin));

        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.white);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mRecycler.setAdapter(null);

        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView();
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVED_TAGS_LIST, new ArrayList<>(mAdapter.getTags()));
    }

    @Override
    @OnClick(R.id.message_tryagain_button)
    public void onRefresh() {
        mAdapter.removeAll();
        mPresenter.onInitialListRequested();
    }

    /***** MVP View methods implementation *****/

    @Override
    public void showTags (List<String> tags) {
        if (!mSwipeRefreshLayout.isActivated()) {
            mSwipeRefreshLayout.setEnabled(true);
        }

        mAdapter.setTagsMap(mPresenter.getTagsMap());
        mAdapter.addTags(tags);
    }

    @Override
    public void showProgress() {
        if (mAdapter.isEmpty() && !mSwipeRefreshLayout.isRefreshing()) {
            mContentLoadingProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideProgress() {
        if (getView() != null) {
            mSwipeRefreshLayout.setRefreshing(false);
            mContentLoadingProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String errorMessage) {
        mMessageImage.setImageResource(R.drawable.ic_error_outline_black_48dp);
        mMessageText.setText(getString(R.string.error_generic_error, errorMessage));
        mMessageButton.setText(getString(R.string.action_try_again));
        showMessageLayout(true);
    }

    @Override
    public void showEmpty() {
        mMessageImage.setImageResource(R.drawable.ic_clear_black_48dp);
        mMessageText.setText(R.string.error_no_items_to_display);
        mMessageButton.setText(getString(R.string.action_check_again));
        showMessageLayout(true);
    }

    @Override
    public void showMessageLayout(boolean show) {
        mMessageLayout.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
