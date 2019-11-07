package com.ceng319.listviewdemo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {
    String countryName;
    TextView mTextView;
    ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO: This is an activity to show the detailed page.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extras = getIntent().getExtras();// extras bundle has the position index.
        if (extras == null) { return; } // get data via the key
        countryName = extras.getString("country");

        findAllViews();

        setDisplayOnLayout();

    }

    private int findCountryIndex(String country){
        int index = 0;
        for (DataItem item:SampleData.dataItemList){
            if (item.getItemName().equals(country)){
                return index;
            }
            index++;
        }
        return 0;
    }

    private void setDisplayOnLayout() {
        int countryId = findCountryIndex(countryName);
        // TODO: Read the image from the asset directory and display it on the detailed page.
        // Setup the textview.
        mTextView.setText("You clicked: " + SampleData.dataItemList.get(countryId).getItemName());
        // Define an InputStream
        InputStream inputStream = null;
        try {
            // Get the image file
            String imageFile = SampleData.dataItemList.get(countryId).getImage();
            // File operations, need to get the image from asset files.
            inputStream = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(inputStream, null);
            mImage.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void findAllViews(){
        mTextView = findViewById(R.id.detailPage);
        mImage = findViewById(R.id.imagedetails);
    }

}
