package uk.co.victoriajanedavis.shopify_challenge.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import uk.co.victoriajanedavis.shopify_challenge.R;
import uk.co.victoriajanedavis.shopify_challenge.ui.base.BaseActivity;
import uk.co.victoriajanedavis.shopify_challenge.ui.tags.TagsFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById (R.id.activity_fragment_container);

        if (fragment == null) {
            fragment = TagsFragment.newInstance();
            fm.beginTransaction()
                    .add(R.id.activity_fragment_container, fragment, TagsFragment.TAG)
                    .commit();
        }
    }
}
