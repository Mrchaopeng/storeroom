package network;

/**
 * Created by TH on 2018/1/6.
 */

public interface OnListiner<T> {

    public void onSuccess(T t);
    public void onFailure(Throwable throwable);
}
