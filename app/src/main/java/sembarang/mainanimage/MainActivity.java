package sembarang.mainanimage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDownloadImageDirectlyActivity(View clickedView){
        Intent intent = new Intent(this, LoadImageDirectlyActivity.class);
        startActivity(intent);
    }

    public void openDownloadImageWithVolleyActivity(View clickedView){
        Intent intent = new Intent(this, LoadImageWithVolleyActivity.class);
        startActivity(intent);
    }

    public void openDownloadImageWithGlideActivity(View clickedView){
        Intent intent = new Intent(this, LoadImageWithGlideActivity.class);
        startActivity(intent);
    }

    public void openDownloadImageWithPicassoActivity(View clickedView){
        Intent intent = new Intent(this, LoadImageWithPicassoActivity.class);
        startActivity(intent);
    }

    public void openDownloadImageWithFrescoActivity(View clickedView){
        Intent intent = new Intent(this, LoadImageWithFrescoActivity.class);
        startActivity(intent);
    }
}
