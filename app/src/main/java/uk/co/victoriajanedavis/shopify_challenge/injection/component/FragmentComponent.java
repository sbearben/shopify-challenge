package uk.co.victoriajanedavis.shopify_challenge.injection.component;

import dagger.Subcomponent;
import uk.co.victoriajanedavis.shopify_challenge.injection.PerFragment;
import uk.co.victoriajanedavis.shopify_challenge.injection.module.FragmentModule;
import uk.co.victoriajanedavis.shopify_challenge.ui.tags.TagsFragment;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(TagsFragment tagsFragment);
}
