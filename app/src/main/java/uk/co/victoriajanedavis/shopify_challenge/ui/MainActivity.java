package uk.co.victoriajanedavis.shopify_challenge.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import butterknife.ButterKnife;
import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.ui.base.BaseActivity;
import uk.co.victoriajanedavis.shopify_challenge.ui.tags.TagsFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    // For saving our instance state so that we open the correct fragment after rotation
    private static final String SAVED_SELECTED_FRAGMENT = "selected_fragment_tag";

    private static final String ACTION_HOME_TAG = "action_home";

    private String mSelectedFragmentTag = ACTION_HOME_TAG;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inflate the activity's view
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Check for saved fragment tag so that we can load up the correct fragment after rotation
        if (savedInstanceState != null) {
            mSelectedFragmentTag = savedInstanceState.getString (SAVED_SELECTED_FRAGMENT);
        }

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById (R.id.activity_fragment_container);

        if (fragment == null) {
            fragment = TagsFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.activity_fragment_container, fragment, TagsFragment.TAG)
                    .commit();
        }

        /*
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment selectedFragment = null;

        Fragment curFrag = fm.getPrimaryNavigationFragment();
        if (curFrag != null) {
            fragmentTransaction.detach(curFrag);
        }

        selectedFragment = fm.findFragmentByTag(mSelectedFragmentTag);
        if (selectedFragment == null) {
            selectedFragment = HomeFragment.newInstance();
            fragmentTransaction.add(R.id.activity_main_fragment_container, selectedFragment, mSelectedFragmentTag);
        } else {
            fragmentTransaction.attach(selectedFragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(selectedFragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNowAllowingStateLoss();
        */
    }

    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_SELECTED_FRAGMENT, mSelectedFragmentTag);
    }
}
