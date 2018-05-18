package com.example.lu.thebarbershop.Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lu.thebarbershop.Adapter.DynamicListAdapter;
import com.example.lu.thebarbershop.Entity.Dynamic;
import com.example.lu.thebarbershop.R;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by lu on 2018/5/9 0009.
 * 动态fragment
 */

public class DynamicFragment extends Fragment{
    private RecyclerView DynamicList;
    private Context context;
    private DynamicListAdapter dynamicListAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Dynamic> list;
    RefreshLayout refreshLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //加载选项卡对应的选项页面
        View view = inflater.inflate(R.layout.fragment_dynamic_page,container,false);
        DynamicList  = view.findViewById(R.id.dynamic_list);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        context = getActivity().getApplicationContext();
        initData();
        setPullRefresher();
        ////通过listview展示动态列表
        //ShowDynamicByListView(dataSource(),context);
        return view;


    }
    /*//实现通过listview展示动态列表
    private void ShowDynamicByListView(List<Dynamic> dataSource, Context context){
        //管理器对象
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //实例化DynamicListAdapter对象
        dynamicListAdapter = new DynamicListAdapter(context,dataSource);
        //设置布局管理器
        DynamicList.setLayoutManager(layoutManager);
        //绑定适配器
        DynamicList.setAdapter(dynamicListAdapter);
    }

    //假设的数据源  后期通过数据库返回用户的动态
    private List<Dynamic> dataSource(){
        List<Dynamic> dataSource = new ArrayList<Dynamic>();
        List<String> list = new ArrayList<String>();
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        list.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        //定义第一个数据项
        Dynamic d1 =  new Dynamic();
        d1.setImgName(R.mipmap.default_header_img);
        d1.setUserName("用户名1");
        d1.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d1.setDynamicImageList(list);
        dataSource.add(d1);
        //定义第2个数据项
        Dynamic d2 =  new Dynamic();
        d2.setImgName(R.mipmap.default_header_img);
        d2.setUserName("用户名2");
        d2.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d2.setDynamicImageList(list);
        dataSource.add(d2);
        //定义第一个数据项
        Dynamic d3 =  new Dynamic();
        d3.setImgName(R.mipmap.default_header_img);
        d3.setUserName("用户名3");
        d3.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d3.setDynamicImageList(list);
        dataSource.add(d3);
        //定义第一个数据项
        Dynamic d4 =  new Dynamic();
        d4.setImgName(R.mipmap.default_header_img);
        d4.setUserName("用户名4");
        d4.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d4.setDynamicImageList(list);
        dataSource.add(d4);
        //定义第一个数据项
        Dynamic d5 =  new Dynamic();
        d5.setImgName(R.mipmap.default_header_img);
        d5.setUserName("用户名5");
        d5.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d5.setDynamicImageList(list);
        dataSource.add(d5);
        //定义第一个数据项
        Dynamic d6 =  new Dynamic();
        d6.setImgName(R.mipmap.default_header_img);
        d6.setUserName("用户名6");
        d6.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                "、巴拉巴拉吧小魔仙、");
        d6.setDynamicImageList(list);
        dataSource.add(d6);

        return dataSource;
    }*/
    private void initData(){
        list = new ArrayList<Dynamic>();
        List<String> imglist = new ArrayList<String>();
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        for (int i=0;i<=5;i++){
            Dynamic dynamic = new Dynamic();
            dynamic.setImgName(R.mipmap.default_header_img);
            dynamic.setUserName("用户名"+i);
            dynamic.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                    "、巴拉巴拉吧小魔仙、");
            dynamic.setDynamicImageList(imglist);
            list.add(dynamic);
        }
        dynamicListAdapter = new DynamicListAdapter(context,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        DynamicList.setLayoutManager(linearLayoutManager);
        DynamicList.setAdapter(dynamicListAdapter);
    }
    private void setPullRefresher(){
        final List<String> imglist = new ArrayList<String>();
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        imglist.add("https://avatars3.githubusercontent.com/u/23027828?v=3&u=3bd94805200528fb9217cde5ed98fce70cd7acc1&s=400");
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                //在这里执行上拉刷新时的具体操作(网络请求、更新UI等)

                //模拟网络请求到的数据
                ArrayList<Dynamic> newList = new ArrayList<Dynamic>();
                for (int i=0;i<=5;i++){
                    Dynamic dynamic = new Dynamic();
                    dynamic.setImgName(R.mipmap.default_header_img);
                    dynamic.setUserName("用户名"+i);
                    dynamic.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                            "、巴拉巴拉吧小魔仙、");
                    dynamic.setDynamicImageList(imglist);
                    newList.add(dynamic);
                }
                dynamicListAdapter.refresh(newList);
                refreshLayout.finishRefresh(2000/*,false*/);
                //不传时间则立即停止刷新    传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                //在这里执行上拉刷新时的具体操作(网络请求、更新UI等)

                //模拟网络请求到的数据
                ArrayList<Dynamic> newList = new ArrayList<Dynamic>();
                for (int i=0;i<=5;i++){
                    Dynamic dynamic = new Dynamic();
                    dynamic.setImgName(R.mipmap.default_header_img);
                    dynamic.setUserName("用户名"+i);
                    dynamic.setDynamicContent("巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙、巴拉巴拉吧小魔仙" +
                            "、巴拉巴拉吧小魔仙、");
                    dynamic.setDynamicImageList(imglist);
                    newList.add(dynamic);
                }
                dynamicListAdapter.add(newList);
                refreshLayout.finishLoadMore(2000);
            }
        });
    }
}