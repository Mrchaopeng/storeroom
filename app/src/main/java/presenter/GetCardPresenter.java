package presenter;

import bean.CartBean;
import model.GetCardModel;
import model.IGetCardModel;
import network.OnListiner;
import view.ICart;

/**
 * Created by TH on 2018/1/6.
 */

public class GetCardPresenter {

    private ICart iCart;
    private IGetCardModel iGetCardModel;

    public GetCardPresenter(ICart iCartFragment) {
        this.iCart = iCartFragment;
        iGetCardModel = new GetCardModel();
    }

    public void getCarts() {
        iGetCardModel.getCard("4438", new OnListiner() {
            @Override
            public void onSuccess(Object o) {
                iCart.onShow((CartBean) o);
            }

            @Override
            public void onFailure(Throwable t) {
                t.getMessage();
            }
        });
    }
}
