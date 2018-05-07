package sembarang.mainanimage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Base class yang memiliki 1 ImageView di dalamnya
 *
 * @author hendrawd on 07/05/18
 */
public abstract class ImageViewActivity extends AppCompatActivity {

    protected ImageView imageView;
    protected String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        // mendapatkan reference dari ImageView
        imageView = findViewById(R.id.imageView);

        // mendapatkan imageUrl dari strings.xml
        imageUrl = getString(R.string.image_url);
    }
}
