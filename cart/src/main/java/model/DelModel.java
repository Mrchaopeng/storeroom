package model;

import bean.MessageBean;
import io.reactivex.Flowable;
import presenter.DelPresenter;
import utils.RetrofitUtils;

/**
 * Created by TH on 2018/1/6.
 */

public class DelModel implements IModel{

    private DelPresenter presenter;

    public DelModel(DelPresenter presenter){
        this.presenter =  presenter;

    }
    @Override
    public void getData(String uid,String pid) {

        Flowable<MessageBean> delFlowable = RetrofitUtils.getInstance().getApiService().deleteData(uid,pid);
        presenter.delData(delFlowable);
    }
}
