package sembarang.mainanimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

/**
 * Kelas yang mempraktekkan cara untuk download image secara langsung menggunakan URL.openStream
 * dan set ke ImageView
 */
public class LoadImageDirectlyActivity extends ImageViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // create and start DownloadImageTask
        new DownloadImageTask(imageView).execute(imageUrl);
    }

    // using static class and weak reference to avoid context leak
    static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private WeakReference<ImageView> imageViewWeakReference;

        DownloadImageTask(ImageView imageView) {
            imageViewWeakReference = new WeakReference<>(imageView);
        }

        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new URL(imageUrl).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap resultBitmap) {
            ImageView imageView = imageViewWeakReference.get();
            if (imageView != null) {
                imageView.setImageBitmap(resultBitmap);
            }
        }
    }
}
