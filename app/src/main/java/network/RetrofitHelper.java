package network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TH on 2018/1/6.
 */

public class RetrofitHelper {
    private static OkHttpClient client;
    private static ServiceApi api;
    static {
        initOkHttp();
    }

    private static void initOkHttp() {
        if (client == null) {
            synchronized (OkHttpClient.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .addInterceptor(new MyInterceptor())
                            .build();
                }
            }
        }
    }

    public static ServiceApi getApi() {
        if (api == null) {
            synchronized (ServiceApi.class) {
                if (api == null) {
                    api = RetrofitHelper.create(ServiceApi.class, UrlUtils.BASE_URL);
                }
            }
        }
        return api;
    }

    private static <T> T create(Class<T> tClass, String baseUrl) {
        Retrofit re = new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return re.create(tClass);
    }
}
