package sembarang.mainanimage;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author hendrawd on 07/05/18
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
