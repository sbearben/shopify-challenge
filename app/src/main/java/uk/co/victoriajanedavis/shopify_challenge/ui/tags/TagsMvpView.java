package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import java.util.List;

import uk.co.victoriajanedavis.shopify_challenge.ui.base.MvpView;

public interface TagsMvpView extends MvpView {
    void showTags(List<String> tags);
}
