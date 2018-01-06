package app;

import android.app.Application;

        import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by TH on 2018/1/6.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);


    }
}

