package mikecanco.de.leekspin;

import android.app.Application;
import android.content.Context;

/**
 * Created by koalahamlet on 10/4/14.
 */
public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getInstance() {
        return context;
    }
}
