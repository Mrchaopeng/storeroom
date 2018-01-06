package model;

import java.util.List;

import bean.DatasBean;
import bean.MessageBean;
import io.reactivex.Flowable;
import presenter.NewsPresenter;
import utils.RetrofitUtils;

/**
 * Created by TH on 2018/1/6.
 */

public class NewsModel implements IModel{
    private NewsPresenter presenter;

    public NewsModel(NewsPresenter presenter){
        this.presenter = (NewsPresenter) presenter;

    }
    @Override
    public void getData(String uid,String pid) {
        Flowable<MessageBean<List<DatasBean>>> flowable = RetrofitUtils.getInstance().getApiService().getDatas(uid);
        presenter.getNews(flowable);

    }
}
