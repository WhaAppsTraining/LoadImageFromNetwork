package sembarang.mainanimage;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Kelas yang mempraktekkan cara untuk download image menggunakan Fresco
 */
public class LoadImageWithFrescoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_drawee_view);

        // mendapatkan reference dari SimpleDraweeView
        SimpleDraweeView simpleDraweeView = findViewById(R.id.simpleDraweeView);

        // mendapatkan imageUrl dari strings.xml
        String imageUrl = getString(R.string.image_url);

        simpleDraweeView.setImageURI(Uri.parse(imageUrl));
    }
}
