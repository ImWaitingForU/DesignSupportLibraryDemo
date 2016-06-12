package com.demo.myapplication;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.DragEvent;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayout;
    private FloatingActionButton floatingActionButton;
    private CoordinatorLayout coordinatorLayout;
    private Button openDrawerLayout;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    private String[] stringArray = {"我的收藏", "我的账户", "VIP权限", "更多设置"};

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        initTextInputLayout ();
        initFloatingActionButton ();
        initButtonOpen ();
        initToolBar ();
        initTabLayout ();
        initCollapsingToolbarLayout();
    }

    private void initTextInputLayout () {
        textInputLayout = (TextInputLayout) findViewById (R.id.textInputLayout);
        textInputLayout.setHint ("请在此处输入");
        textInputLayout.setHintAnimationEnabled (true); //是否在hint移动时加上动画
        //        textInputLayout.setError ("输入错误");
        //        textInputLayout.setErrorEnabled (true);
    }

    private void initFloatingActionButton () {
        coordinatorLayout = (CoordinatorLayout) findViewById (R.id.coordinatorLayout);
        floatingActionButton = (FloatingActionButton) findViewById (R.id.floatingActionButton);
        floatingActionButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Snackbar.make (coordinatorLayout, "--snackbar--", Snackbar.LENGTH_SHORT)
                        .setAction ("delete", new View.OnClickListener () {
                            @Override
                            public void onClick (View v) {
                                Toast.makeText (MainActivity.this, "delete", Toast.LENGTH_SHORT).show ();
                            }
                        }).show ();
            }
        });
    }

    private void initButtonOpen () {
        //初始化NavigationView
        navigationView = (NavigationView) findViewById (R.id.navigationView);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected (MenuItem item) {
                Snackbar.make (coordinatorLayout, "出现了NavigationView", Snackbar.LENGTH_SHORT).show ();
                item.setChecked (true);
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById (R.id.drawerLayout);
        openDrawerLayout = (Button) findViewById (R.id.open_drawerLayout);
        openDrawerLayout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                drawerLayout.openDrawer (navigationView);
            }
        });
    }

    private void initToolBar () {
        toolbar = (Toolbar) findViewById (R.id.toolBar);
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayShowHomeEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
    }

    private void initTabLayout () {
        //        tabLayout = (TabLayout) findViewById (R.id.tabLayout);
        //        tabLayout.setTabMode (TabLayout.MODE_SCROLLABLE);
        //        tabLayout.addTab (tabLayout.newTab ().setText ("tab1"));
        //        tabLayout.addTab (tabLayout.newTab ().setText ("tab2"));
        //        tabLayout.addTab (tabLayout.newTab ().setText ("tab3"));
        //        tabLayout.addTab (tabLayout.newTab ().setText ("tab4"));
        //        tabLayout.addTab (tabLayout.newTab ().setText ("tab5"));
    }

    private void initCollapsingToolbarLayout () {
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById (R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle ("CollapsingToolBar");
    }
}
