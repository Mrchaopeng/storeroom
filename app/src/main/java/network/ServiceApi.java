package network;

import bean.BaseBean;
import bean.CartBean;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TH on 2018/1/6.
 */

public interface ServiceApi {

    //查询购物车
    @GET(UrlUtils.SELECTCAR_PATH_URL)
    public Flowable<CartBean> getCart(@Query("uid") String uid);

    //删除购物车
    @GET(UrlUtils.DELETECAR_PATH_URL)
    Observable<BaseBean> deleteGoodCar(@Query("uid") String uid, @Query("pid") String pid);
}
