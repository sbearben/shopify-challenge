package uk.co.victoriajanedavis.shopify_challenge.ui.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.LongSparseArray;

import java.util.concurrent.atomic.AtomicLong;

import timber.log.Timber;
import uk.co.victoriajanedavis.shopify_challenge.ShopifyApplication;
import uk.co.victoriajanedavis.shopify_challenge.injection.component.ConfigPersistentComponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.component.DaggerConfigPersistentComponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.component.FragmentComponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.FragmentModule;

/**
 * Abstract Fragment that every other Fragment in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent survive
 * across configuration changes.
 */
public class BaseFragment extends Fragment {

    private static final String KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent>
            sComponentsMap = new LongSparseArray<>();

    private Context mContext;
    private FragmentComponent mFragmentComponent;
    private long mFragmentId;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create the FragmentComponent and reuses cached ConfigPersistentComponent if this is being called after a configuration change.
        mFragmentId = savedInstanceState != null ?
                savedInstanceState.getLong(KEY_FRAGMENT_ID) : NEXT_ID.getAndIncrement();

        ConfigPersistentComponent configPersistentComponent = sComponentsMap.get(mFragmentId, null);

        if (configPersistentComponent == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", mFragmentId);
            configPersistentComponent = DaggerConfigPersistentComponent.builder()
                    .applicationComponent(ShopifyApplication.get(mContext).getComponent())
                    .build();
            sComponentsMap.put(mFragmentId, configPersistentComponent);
        }
        mFragmentComponent = configPersistentComponent.fragmentComponent(new FragmentModule(this));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ShopifyApplication.get(mContext).mustDie(this);
    }

    @Override
    public void onDetach() {
        if (!((Activity) mContext).isChangingConfigurations()) {
            sComponentsMap.remove(mFragmentId);
        }
        super.onDetach();
    }

    public FragmentComponent fragmentComponent() {
        return mFragmentComponent;
    }
}
