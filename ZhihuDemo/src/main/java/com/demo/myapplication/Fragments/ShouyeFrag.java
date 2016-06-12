package com.demo.myapplication.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.myapplication.Adapters.ViewPagerAdapter;
import com.demo.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ShouyeFrag extends Fragment {
	private ViewPager viewPager;
	private TabLayout tabLayout;
	private List<Fragment> fragmentList;
	private List<String> titleList;
	private View v;
	private Toolbar toolbar;

	private void initTabLayoutAndViewPager() {
		viewPager = (ViewPager) v.findViewById(R.id.viewPager);
		tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
		fragmentList = new ArrayList<>();
		fragmentList.add(new ToutiaoFrag());
		fragmentList.add(new ShoucangFrag());
		fragmentList.add(new GuanzhuFrag());

		titleList = new ArrayList<>();
		titleList.add("头条");
		titleList.add("体育");
		titleList.add("天气");

		ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(),
				fragmentList, titleList);

		viewPager.setAdapter(viewPagerAdapter);

		tabLayout.addTab(tabLayout.newTab().setText(titleList.get(0)));
		tabLayout.addTab(tabLayout.newTab().setText(titleList.get(1)));
		tabLayout.addTab(tabLayout.newTab().setText(titleList.get(2)));

		tabLayout.setTabMode(TabLayout.MODE_FIXED);
		tabLayout.setupWithViewPager(viewPager);

	}

	private void initToolbar() {
		toolbar = (Toolbar) v.findViewById(R.id.toolbar);
		toolbar.setTitle("首页");
		// toolbar.setNavigationIcon (R.drawable.sousuo);
		((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
		// toolbar.setLogo (R.drawable.lingdang);
		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem item) {

				switch (item.getItemId()) {
					case R.id.sousuo :
						Toast.makeText(getActivity(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
						break;
					case R.id.lingdang :
						Toast.makeText(getActivity(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
						break;
					case R.id.setting :
						Toast.makeText(getActivity(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
						break;
					case R.id.guanyu :
						Toast.makeText(getActivity(), item.getTitle().toString(), Toast.LENGTH_SHORT).show();
						break;
				}

				return true;
			}
		});

		// 设置toolbar的指示图标
		DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawerLayout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
				R.string.open_drawer, R.string.close_drawer);
		drawerLayout.setDrawerListener(toggle);
		toggle.syncState();
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.shouye_frag, container, false);
		initTabLayoutAndViewPager();
		initToolbar();

		return v;
	}
}
