package uk.co.victoriajanedavis.shopify_challenge.ui.base;

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
