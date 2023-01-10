package id.ac.poliban.mi.fauzi.codingchallenge33_038;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple", "indigo", "blue", "light_blue",
            "cyan", "teal", "green", "light_green", "lime", "yellow", "amber",
            "orange", "deep_orange", "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.hello_textview);

        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(colorName,"color",getApplicationContext()
                .getPackageName());
        int colorRes = ContextCompat.getColor(this,colorResourceName);
        mHelloTextView.setTextColor(colorRes);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            colorRes = ContextCompat.getColor(this, com.google.android.material.R.color.design_default_color_on_primary);
        } else {
            colorRes = getResources().getColor(R.color.app_theme_color);
        }
    }

}