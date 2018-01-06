package view;

import bean.MessageBean;

/**
 * Created by TH on 2018/1/6.
 */

public interface Iview {

    void onSuccess(Object o);
    void onFailed(Exception e);

    void delSuccess(MessageBean listMessageBean);
}
