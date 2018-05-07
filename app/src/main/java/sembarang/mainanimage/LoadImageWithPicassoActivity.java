package sembarang.mainanimage;

import android.os.Bundle;

import com.squareup.picasso.Picasso;

/**
 * Kelas yang mempraktekkan cara untuk download image dan set ke ImageView menggunakan Picasso
 */
public class LoadImageWithPicassoActivity extends ImageViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Picasso.get().load(imageUrl).into(imageView);
    }
}
