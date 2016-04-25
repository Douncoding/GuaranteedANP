package com.douncoding.guaranteedanp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class LessonDetailsActivity extends AppCompatActivity {
    public static final String TAG = LessonDetailsActivity.class.getSimpleName();

    ViewPager mViewPager;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager)findViewById(R.id.container);
        mTabLayout = (TabLayout)findViewById(R.id.main_tabs);

        setupTab();
    }

    private void setupTab() {
        SectionPagerAdapter mSectionPagerAdapter =
                new SectionPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mSectionPagerAdapter);
        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mSectionPagerAdapter.getCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            if (tab != null) {
                tab.setIcon(getTabLayoutIcon(i));
            }
        }
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new LessonBasicInfoFragment();
                case 1:
                    return new LessonBasicInfoFragment();
                case 2:
                    return new LessonContactFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "강의";
                case 1:
                    return "출석부";
                case 2:
                    return "연락처";
                default:
                    return null;
            }
        }
    }

    private Drawable getTabLayoutIcon(int position) {
        switch (position) {
            case 0:
                return getResources().getDrawable(R.drawable.ic_assignment_black_24dp);
            case 1:
                return getResources().getDrawable(R.drawable.ic_chrome_reader_mode_black_24dp);
            case 2:
                return getResources().getDrawable(R.drawable.ic_group_black_24dp);
            default:
                return null;
        }
    }
}
