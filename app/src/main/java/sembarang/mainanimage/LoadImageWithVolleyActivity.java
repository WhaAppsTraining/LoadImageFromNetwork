package sembarang.mainanimage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

/**
 * Kelas yang mempraktekkan cara untuk download image menggunakan Volley(NetworkImageView)
 */
public class LoadImageWithVolleyActivity extends AppCompatActivity {

    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_image_view);

        // mendapatkan reference dari NetworkImageView
        NetworkImageView networkImageView = findViewById(R.id.networkImageView);

        // mendapatkan imageUrl dari strings.xml
        String imageUrl = getString(R.string.image_url);

        networkImageView.setImageUrl(imageUrl, getImageLoader());
    }

    private ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = new ImageLoader(getRequestQueue(), new BitmapLruCache());
        }
        return imageLoader;
    }

    private RequestQueue getRequestQueue() {
        return Volley.newRequestQueue(this);
    }

    static class BitmapLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
        static int getDefaultLruCacheSize() {
            final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            final int cacheSize = maxMemory / 8;

            return cacheSize;
        }

        BitmapLruCache() {
            this(getDefaultLruCacheSize());
        }

        BitmapLruCache(int sizeInKiloBytes) {
            super(sizeInKiloBytes);
        }

        @Override
        protected int sizeOf(String key, Bitmap value) {
            return value.getRowBytes() * value.getHeight() / 1024;
        }

        @Override
        public Bitmap getBitmap(String url) {
            return get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            put(url, bitmap);
        }
    }
}
