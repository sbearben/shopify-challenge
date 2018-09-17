package uk.co.victoriajanedavis.shopify_challenge.ui.base;

public interface MvpView {

    void showProgress();

    void hideProgress();

    void showError(String errorMessage);

    void showEmpty();

    void showMessageLayout(boolean show);

}
