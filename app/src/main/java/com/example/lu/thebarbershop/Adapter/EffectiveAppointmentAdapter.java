package com.example.lu.thebarbershop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lu.thebarbershop.Entity.Dynamic;
import com.example.lu.thebarbershop.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/15 0015.
 */

public class EffectiveAppointmentAdapter extends BaseAdapter {
    //上下文环境
    private Context mContext;
    //声明数据源
    private List<Map<String, Object>> appointments;
    //声明列表项的布局itemID
    private int item_layout_id;

    public EffectiveAppointmentAdapter(Context mContext, List<Map<String, Object>> appointments, int item_layout_id) {
        this.mContext = mContext;
        this.appointments = appointments;
        this.item_layout_id = item_layout_id;
    }

    //数据源的数量
    @Override
    public int getCount() {
        return appointments.size();
    }

    //返回选择的item项的数据
    @Override
    public Object getItem(int position) {
        return appointments.get(position);
    }

    //返回当前选择了第几个item项
    @Override
    public long getItemId(int position) {
        return position;
    }

    //返回item的布局视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView && null != mContext) {
            //获取子项目item的布局文件
            LayoutInflater mInflater = LayoutInflater.from(mContext);
            //布局文件赋值给convertView参数
            convertView = mInflater.inflate(item_layout_id, null);
        }
        //获取布局文件中的控件对象
        ImageView img = convertView.findViewById(R.id.merchant_img);
        TextView merchantName = convertView.findViewById(R.id.appointment_merchant);
        TextView barber = convertView.findViewById(R.id.appointment_barber);
        TextView tel = convertView.findViewById(R.id.appointment_phone);
        TextView time = convertView.findViewById(R.id.appointment_time);
        TextView person = convertView.findViewById(R.id.appointment_person);

        //利用传递的数据源给相应的控件对象赋值
        Map<String, Object> effectiveAppointments = appointments.get(position);
        img.setImageResource((Integer)effectiveAppointments.get("img"));
        merchantName.setText((String)effectiveAppointments.get("merchantName"));
        barber.setText((String)effectiveAppointments.get("barber"));
        tel.setText((String)effectiveAppointments.get("tel"));
        time.setText((String)effectiveAppointments.get("time"));
        person.setText((String)effectiveAppointments.get("person"));

        return convertView;
    }

}
