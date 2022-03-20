package com.example.dc_midterm_proj_login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    public Toolbar myToolbar;
    public ImageView booking;
    public ImageView places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        booking = findViewById(R.id.booking);
        places= findViewById(R.id.places);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlaces();
            }
        });


        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        myToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });


        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://i.insider.com/5d38b30636e03c59cb0063c2?width=1300&format=jpeg&auto=webp"));
        slideModels.add(new SlideModel("https://i.insider.com/5e21c57cab49fd40043ae7f5?width=1300&format=jpeg&auto=webp"));
        slideModels.add(new SlideModel("https://i.insider.com/5d38929736e03c2138374645?width=1300&format=jpeg&auto=webp"));
        slideModels.add(new SlideModel("https://i.insider.com/5d377bf436e03c29e93eed13?width=1300&format=jpeg&auto=webp"));
        slideModels.add(new SlideModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/barcelona-parc-guell-at-sunset-royalty-free-image-1571860792.jpg?crop=1xw:1xh;center,top&resize=980:*"));
        slideModels.add(new SlideModel("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/holbox-island-palm-tree-huts-mexico-royalty-free-image-1571860719.jpg?crop=1xw:1xh;center,top&resize=980:*"));
        slideModels.add(new SlideModel("https://hips.hearstapps.com/hbz.h-cdn.co/assets/16/16/india.jpg?crop=1.0xw:1xh;center,top&resize=980:*"));
        slideModels.add(new SlideModel("https://hips.hearstapps.com/hbz.h-cdn.co/assets/16/16/moscow-gettyimages-552609685_1.jpg?crop=1xw:0.9999035865792518xh;center,top&resize=980:*"));

        imageSlider.setImageList(slideModels, true);


    }

    private void openPlaces() {
        Intent intent = new Intent(ExploreActivity.this, PlacesActivity.class);
        startActivity(intent);
    }

    private void openLogin() {
        Intent intent = new Intent(ExploreActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private void openHome() {
        Intent intent = new Intent(ExploreActivity.this, HomeActivity.class );
        startActivity(intent);
    }

}