package com.demo.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.demo.myapplication.Fragments.FaxianFrag;
import com.demo.myapplication.Fragments.GuanzhuFrag;
import com.demo.myapplication.Fragments.ShoucangFrag;
import com.demo.myapplication.Fragments.ShouyeFrag;

public class MainActivity extends AppCompatActivity {

	private NavigationView navigationView;
	private DrawerLayout drawerLayout;

	private ShouyeFrag shouyeFrag;
	private FaxianFrag faxianFrag;
	private GuanzhuFrag guanzhuFrag;
	private ShoucangFrag shoucangFrag;
    private Toolbar toolbar;

	private Fragment isFragment; // 当前使用的Fragment

	/*
	 * fragment保存数据,便于返回该fragment数据不清空
	 */
	private void switchContent(Fragment from, Fragment to) {
		if (isFragment != to) {
			isFragment = to;
			FragmentManager fragmentManager = getSupportFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			if (!to.isAdded()) {
				fragmentTransaction.hide(from).add(R.id.contentLayout, to)
						.commit();
			} else {
				fragmentTransaction.hide(from).show(to).commit();
			}
		}
	}

	/*
	 * 为页面加载初始状态的Fragment
	 */
	private void initFragment(Bundle savedInstanceState) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		if (shouyeFrag == null) {
			shouyeFrag = new ShouyeFrag();
		}
		isFragment = shouyeFrag;
		fragmentTransaction.replace(R.id.contentLayout, isFragment).commit();
	}

//	private void initDrawerLayout() {
//		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
//		FragmentManager fm = getSupportFragmentManager();
//		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
//				drawerLayout, toolbar, R.string.open_drawer,
//				R.string.close_drawer);
//		drawerLayout.setDrawerListener(toggle);
//		toggle.syncState();
//	}

	private void initNavigationView() {
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		navigationView = (NavigationView) findViewById(R.id.navigationView);
		// 让图标呈现本来的颜色
		navigationView.setItemIconTintList(null);
		navigationView
				.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(MenuItem item) {

						drawerLayout.closeDrawers();

						switch (item.getItemId()) {
							case R.id.shouye :
								// toolbar.setTitle ("首页");
								if (shouyeFrag == null) {
									shouyeFrag = new ShouyeFrag();
								}
								switchContent(isFragment, shouyeFrag);
								break;
							case R.id.faxian :
								// toolbar.setTitle ("发现");
								if (faxianFrag == null) {
									faxianFrag = new FaxianFrag();
								}
								switchContent(isFragment, faxianFrag);
								break;
							case R.id.guanzhu :
								// toolbar.setTitle ("关注");
								if (guanzhuFrag == null) {
									guanzhuFrag = new GuanzhuFrag();
								}
								switchContent(isFragment, guanzhuFrag);
								break;
							case R.id.shoucang :
								// toolbar.setTitle ("收藏");
								if (shoucangFrag == null) {
									shoucangFrag = new ShoucangFrag();
								}
								switchContent(isFragment, shoucangFrag);
								break;
						}
						return true;
					}
				});
	}

	/*
	 * 着色模式下设置状态栏颜色
	 */
	private void mySetStatusBar() {
		Window window = this.getWindow();
		// 取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
		window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

		// 需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
		window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
		// 设置状态栏颜色
		window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));

		ViewGroup mContentView = (ViewGroup) this
				.findViewById(Window.ID_ANDROID_CONTENT);
		View mChildView = mContentView.getChildAt(0);
		if (mChildView != null) {
			// 注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子
			// View . 预留出系统 View 的空间.
			ViewCompat.setFitsSystemWindows(mChildView, true);
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// myFullScreenSetStatusBar();
		mySetStatusBar();

//		initToolbar();
//		initDrawerLayout();
		initNavigationView();
		initFragment(savedInstanceState);
	}

//	private void initToolbar() {
//		toolbar = (Toolbar) findViewById(R.id.toolbar);
//		toolbar.setTitle("首页");
//		// toolbar.setNavigationIcon (R.drawable.sousuo);
//		setSupportActionBar(toolbar);
//		// toolbar.setLogo (R.drawable.lingdang);
//		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//			@Override
//			public boolean onMenuItemClick(MenuItem item) {
//
//				switch (item.getItemId()) {
//					case R.id.sousuo :
//						Toast.makeText(MainActivity.this,
//								item.getTitle().toString(), Toast.LENGTH_SHORT)
//								.show ();
//						break;
//					case R.id.lingdang :
//						Toast.makeText(MainActivity.this,
//								item.getTitle().toString(), Toast.LENGTH_SHORT)
//								.show ();
//						break;
//					case R.id.setting :
//						Toast.makeText(MainActivity.this,
//								item.getTitle().toString(), Toast.LENGTH_SHORT)
//								.show ();
//						break;
//					case R.id.guanyu :
//						Toast.makeText(MainActivity.this,
//								item.getTitle().toString(), Toast.LENGTH_SHORT)
//								.show ();
//						break;
//				}
//
//				return true;
//			}
//		});
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.toolbar_menu, menu);
		return true;
	}

}
