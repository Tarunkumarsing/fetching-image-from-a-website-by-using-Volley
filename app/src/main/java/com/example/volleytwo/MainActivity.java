package com.example.volleytwo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {
    //https://www.facebook.com/photo.php?fbid=2473698022951804&set=a.1391140231207594&type=3&theater

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageview = (ImageView) findViewById(R.id.imageView);
        Button mybutton = (Button) findViewById(R.id.button);
        final String myurl = "https://itwatchit.com/wp-content/uploads/2016/09/android.jpg";

        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest = new ImageRequest(myurl,
                        new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                imageview.setImageBitmap(response);
                            }
                        }, 0, 0, null,
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.i("Error", "Error");
                            }
                        }
                );
                MySingleton.getInstance(MainActivity.this).addToRequestQueue(imageRequest);
            }
        });
    }
}