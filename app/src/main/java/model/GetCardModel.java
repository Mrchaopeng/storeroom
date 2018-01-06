package model;

import android.util.Log;

import org.reactivestreams.Subscription;

import bean.CartBean;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import network.OnListiner;
import network.RetrofitHelper;

/**
 * Created by TH on 2018/1/6.
 */

public class GetCardModel implements IGetCardModel{
    @Override
    public void getCard( String uid, final OnListiner onListiner) {
        Flowable<CartBean> cart = RetrofitHelper.getApi().getCart(uid);
        cart.doOnSubscribe(new Consumer<Subscription>() {
            @Override
            public void accept(Subscription subscription) throws Exception {
                Log.d("ssss","开始请求数据");
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onListiner.onSuccess(cartBean);
                    }
                })  ;
    }
}
