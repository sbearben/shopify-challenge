package uk.co.victoriajanedavis.shopify_challenge.injection.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import uk.co.victoriajanedavis.shopify_challenge.injection.ActivityContext;
import uk.co.victoriajanedavis.shopify_challenge.injection.FragmentContext;

@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    Fragment provideFragment() {
        return mFragment;
    }

    @Provides
    @FragmentContext
    Context providesContext() {
        return mFragment.getContext();
    }

    @Provides
    @FragmentContext
    Activity providesActivity() {
        return mFragment.getActivity();
    }
}
