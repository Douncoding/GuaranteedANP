package com.douncoding.guaranteedanp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LessonDetailsActivity extends AppCompatActivity {
    public static final String TAG = LessonDetailsActivity.class.getSimpleName();

    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = (ViewPager)findViewById(R.id.main_container);
    }

    private void setupTab() {
        SectionPagerAdapter mSectionPagerAdapter =
                new SectionPagerAdapter(getSupportFragmentManager());


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
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
