package model;

import network.OnListiner;

/**
 * Created by TH on 2018/1/6.
 */

public interface IGetCardModel<T> {

    public void getCard(String uid, OnListiner onListiner);
}
