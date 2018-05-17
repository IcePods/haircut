package com.example.lu.thebarbershop.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lu.thebarbershop.Adapter.EffectiveAppointmentAdapter;
import com.example.lu.thebarbershop.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserPersonAppointmentEffectiveFragment extends Fragment {
    private ListView appointmentEffectiveList;//有效预约列表
    private Context context;


    public UserPersonAppointmentEffectiveFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_person_appointment_effective, container, false);
        appointmentEffectiveList = view.findViewById(R.id.lv_appointment_effective);
        context = getActivity().getApplicationContext();


        final EffectiveAppointmentAdapter adapter = new EffectiveAppointmentAdapter(getActivity().getApplicationContext(),prepareDatas(),R.layout.item_user_appointment_effective);
        appointmentEffectiveList.setAdapter(adapter);
        appointmentEffectiveList.setDivider(null);
        appointmentEffectiveList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Toast.makeText(getActivity().getApplicationContext(),"test",Toast.LENGTH_SHORT).show();*/
            }
        });

        return view;
    }

    //静态数据模拟
    private List<Map<String,Object>> prepareDatas() {
        List<Map<String,Object>> appointments = new ArrayList<>();
        //第一个商品
        Map<String,Object> appointments1 = new HashMap<>();
        appointments1.put("img",R.mipmap.user_person_headimg);
        appointments1.put("merchantName","美轮美奂理发店");
        appointments1.put("barber","John");
        appointments1.put("tel","123456789");
        appointments1.put("time","2017-5-6 7:00");
        appointments1.put("person","张三123");
        appointments.add(appointments1);

        Map<String,Object> appointments2 = new HashMap<>();
        appointments2.put("img",R.mipmap.user_person_headimg);
        appointments2.put("merchantName","美轮美奂理发店");
        appointments2.put("barber","John");
        appointments2.put("tel","123456789");
        appointments2.put("time","2017-5-6 7:00");
        appointments2.put("person","张三123");
        appointments.add(appointments2);

        return appointments;
    }

}
