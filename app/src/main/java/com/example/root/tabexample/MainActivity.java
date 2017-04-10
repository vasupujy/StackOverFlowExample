package com.example.root.tabexample;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.root.tabexample.databinding.MainScreenBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  MainScreenBinding mBinding;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    setupViewPager();
  }

  private void setupViewPager() {
    QuestionerJobsAdapter adapter = new QuestionerJobsAdapter(getSupportFragmentManager());
    adapter.addFragment(JobListFragment.newInstance(), getResources().getString(R.string.app_name));
    adapter.addFragment(SecondListFragment.newInstance(), "Second");
    mBinding.viewPager.setAdapter(adapter);
    mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
  }

  public class QuestionerJobsAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public QuestionerJobsAdapter(FragmentManager manager) {
      super(manager);
    }

    @Override public Fragment getItem(int position) {
      return mFragmentList.get(position);
    }

    @Override public int getCount() {
      return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
      mFragmentList.add(fragment);
      mFragmentTitleList.add(title);
    }

    @Override public CharSequence getPageTitle(int position) {
      return mFragmentTitleList.get(position);
    }

  }
}
