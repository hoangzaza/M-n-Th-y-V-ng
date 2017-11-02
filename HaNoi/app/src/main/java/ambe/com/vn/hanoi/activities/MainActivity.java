package ambe.com.vn.hanoi.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ambe.com.vn.hanoi.R;
import ambe.com.vn.hanoi.adapters.ViewPagerAdapter;
import ambe.com.vn.hanoi.fragments.AmThucFragment;
import ambe.com.vn.hanoi.fragments.DiemDenFragment;
import ambe.com.vn.hanoi.fragments.HomeTestFragment;
import ambe.com.vn.hanoi.fragments.XemThemFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager manager;
    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private ArrayList<Fragment> arrayList;
    private ViewPagerAdapter adapter;
    private MenuItem prevMenuItem;

    private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (prevMenuItem != null) {
                prevMenuItem.setChecked(false);
            } else {
                navigation.getMenu().getItem(0).setChecked(false);

            }
            navigation.getMenu().getItem(position).setChecked(true);
            prevMenuItem = navigation.getMenu().getItem(position);


        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menu_trang_chu:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.menu_diem_den:
//                    manager=getSupportFragmentManager();
//                    DiemDenFragment diemDenFragment=DiemDenFragment.newInstance();
//                    manager.beginTransaction().replace(R.id.frame_main,diemDenFragment).commit();
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.menu_am_thuc:
//                    manager=getSupportFragmentManager();
//                    AmThucFragment amThucFragment=AmThucFragment.newInstance();
//                    manager.beginTransaction().replace(R.id.frame_main,amThucFragment).commit();
                    viewPager.setCurrentItem(2);

                    return true;
                case R.id.menu_xem_them:
//                    manager=getSupportFragmentManager();
//                    XemThemFragment xemThemFragment=XemThemFragment.newInstance();
//                    manager.beginTransaction().replace(R.id.frame_main,xemThemFragment).commit();
                    viewPager.setCurrentItem(3);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Toast.makeText(this, "click vao day", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }

    private void addEvents() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(mOnPageChangeListener);
    }

    private void addControls() {
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager = findViewById(R.id.view_pager);

        arrayList = new ArrayList<Fragment>();
        HomeTestFragment homeTestFragment = HomeTestFragment.newInstance();
        DiemDenFragment diemDenFragment1 = DiemDenFragment.newInstance();
        AmThucFragment amThucFragment = AmThucFragment.newInstance();
        XemThemFragment xemThemFragment = XemThemFragment.newInstance();

        arrayList.add(homeTestFragment);
        arrayList.add(diemDenFragment1);
        arrayList.add(amThucFragment);
        arrayList.add(xemThemFragment);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), arrayList);

        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());


    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }


}
