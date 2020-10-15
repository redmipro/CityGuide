package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;

public class SignUp2ndClass extends AppCompatActivity {

    //variables
    ImageView backBtn;
    Button next, login;
    TextView titleNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up2nd_class);


        backBtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_button);
        //login = findViewById(R.id.signup_login_button);
        titleNext = findViewById(R.id.signup_title_next);
    }


    public void callNextSignupScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), SignUp3rdClass.class);

        //add transition
        Pair[] pairs = new Pair[4];

        pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
        pairs[1] = new Pair<View, String>(next, "transition_next_btn");
        //pairs[2] = new Pair<View, String>(login, "transition_login_btn");
        pairs[2] = new Pair<View, String>(titleNext, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp2ndClass.this, pairs);
            startActivity(intent, options.toBundle());
        }else {
    startActivity(intent);
}
    }


            }