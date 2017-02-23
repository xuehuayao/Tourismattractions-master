package com.example.yaoxuehua.tourismattractionsapp.homepage;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.TextureMapView;
import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.homepage.FragmentAdapter.ViewPagerFragmentAdapter;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.MapNavigationFragment;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.PersonalCenterFragment;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.TourismRecommendFragment;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseTopBarActivity;
import com.example.yaoxuehua.tourismattractionsapp.view.NoScrollViewPager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseTopBarActivity implements View.OnClickListener {

    private NoScrollViewPager viewPager;
    private LinearLayout viewGroup;
    private TextureMapView myMapView;
    private List<Fragment> fragmentList;
    private RadioButton tourismBtn;
    private RadioButton personalBtn;
    private RadioButton mapBtn;
    private int positionItem;//当前的选中选中页面


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tourism_main_radio_btn:

                viewPager.setCurrentItem(0);
                break;
            case R.id.personal_radio_btn_:

                viewPager.setCurrentItem(1);
                break;
            case R.id.map_radio_btn:

                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void getSetContentViewBefore() {
        super.getSetContentViewBefore();

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("首页");
        viewPager = (NoScrollViewPager) findViewById(R.id.Main_viewPager);
        viewGroup = (LinearLayout) findViewById(R.id.viewGroup);
        tourismBtn = (RadioButton) findViewById(R.id.tourism_main_radio_btn);
        personalBtn = (RadioButton) findViewById(R.id.personal_radio_btn_);
        mapBtn = (RadioButton) findViewById(R.id.map_radio_btn);
        setFragmentList();

    }

    @Override
    protected void initListener() {
        super.initListener();
        tourismBtn.setOnClickListener(this);
        personalBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
    }

    /**
     * 设置三个碎片来切换
     */
    public void setFragmentList() {
        fragmentList = new ArrayList<>();
        TourismRecommendFragment tourismRecommendFragment = new TourismRecommendFragment();
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        MapNavigationFragment mapNavigationFragment = new MapNavigationFragment();
        fragmentList.add(tourismRecommendFragment);
        fragmentList.add(personalCenterFragment);
        fragmentList.add(mapNavigationFragment);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(viewPagerFragmentAdapter);
        viewPager.setIfCanScorll(true);
    }

}
