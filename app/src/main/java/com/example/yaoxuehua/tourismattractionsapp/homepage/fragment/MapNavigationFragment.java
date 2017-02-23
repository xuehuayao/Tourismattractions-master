package com.example.yaoxuehua.tourismattractionsapp.homepage.fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;
import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.fragment.BaseFragment;

/**
 * Created by yaoxuehua on 16-11-15.
 */

public class MapNavigationFragment extends BaseFragment {



    private TextureMapView myMapView;

    @Override
    protected int getLayoutResId() {
        return R.layout.map_navigation_fragment;
    }

    @Override
    protected void initView() {

        myMapView = (TextureMapView) rootView.findViewById(R.id.myMap);
        BaiduMap mBaiduMap = myMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
    }

    @Override
    protected void initData() {

    }
}
