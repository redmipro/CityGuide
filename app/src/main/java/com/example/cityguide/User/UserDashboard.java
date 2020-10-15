package com.example.cityguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguide.Common.LoginSignup.RetailerStartUpScreen;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    ImageView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        contentView= findViewById(R.id.content);

        //hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);

        //menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();


        //Recycler Views Functions Calls
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();


    }

    //navigation drawer functions
    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else drawerLayout.openDrawer(GravityCompat.START);


            }
        });
        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                // difuminar fondo de app cuand aparece el menu lateral.
                //scale the view based on current slide offset
                final  float diffScaledOddset = slideOffset * (1 - END_SCALE);
                final  float offsetScale = 1 - diffScaledOddset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //translate the view, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOddset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    //normal functions
    //login-signup
    public void callRetailerScreens(View view){
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    //implement method
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_all_categories:
                //startActivity(new Intent(getApplicationContext(), AllCategories.class));
                Intent intentCategries = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intentCategries);
                break;

        }

        return true;
    }



    //Dashboard items
    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.mcdoland_img, "@mcdonald", "mcdonald_description"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1, "Edenrobe", "edenrobe_description"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2, "Sweet and Bakers", "sweet_and_bakers_description"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);


        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600});

    }

    private void mostViewedRecycler() {
        //TODO
    }

    private void categoriesRecycler() {
        //TODO
    }



}