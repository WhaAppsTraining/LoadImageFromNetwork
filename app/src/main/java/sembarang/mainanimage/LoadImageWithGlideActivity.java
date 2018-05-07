package sembarang.mainanimage;

import android.os.Bundle;

import com.bumptech.glide.Glide;

/**
 * Kelas yang mempraktekkan cara untuk download image dan set ke ImageView menggunakan Glide
 */
public class LoadImageWithGlideActivity extends ImageViewActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Glide.with(this).load(imageUrl).into(imageView);
    }
}
