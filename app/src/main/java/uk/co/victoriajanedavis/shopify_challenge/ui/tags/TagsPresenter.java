package uk.co.victoriajanedavis.shopify_challenge.ui.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import uk.co.victoriajanedavis.shopify_challenge.data.DataManager;
import uk.co.victoriajanedavis.shopify_challenge.data.model.Product;
import uk.co.victoriajanedavis.shopify_challenge.injection.ConfigPersistent;
import uk.co.victoriajanedavis.shopify_challenge.ui.base.BasePresenter;
import uk.co.victoriajanedavis.shopify_challenge.util.RxUtil;

@ConfigPersistent
public class TagsPresenter extends BasePresenter<TagsMvpView> {

    private static final String TAG = "CollectionPresenter";

    private DataManager mDataManager;
    private Map<String, List<Product>> mTagsMap;

    private Disposable mDisposable;


    @Inject
    TagsPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void onInitialListRequested() {
        getAllProducts();
    }

    private void getAllProducts() {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        getMvpView().showMessageLayout(false);
        getMvpView().showProgress();

        mDataManager.getAllProducts()
                .subscribeOn(Schedulers.computation())
                .flatMap(products -> Single.fromCallable(() ->
                        TagsMapGenerator.generateTagsMapFromProductsList(products.getProductsList()))
                            //.subscribeOn(Schedulers.computation())
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Map<String, List<Product>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onSuccess(Map<String, List<Product>> tagsMap) {
                        if (!isViewAttached()) return;
                        getMvpView().hideProgress();

                        mTagsMap = tagsMap;
                        List<String> tags = new ArrayList<>(mTagsMap.keySet());
                        getMvpView().showTags(tags);

                        if (tags.isEmpty()) {
                            getMvpView().showEmpty();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (!isViewAttached()) return;
                        getMvpView().hideProgress();
                        getMvpView().showError(e.getMessage());
                    }
                });
    }

    public Map<String, List<Product>> getTagsMap() {
        return mTagsMap;
    }
}
