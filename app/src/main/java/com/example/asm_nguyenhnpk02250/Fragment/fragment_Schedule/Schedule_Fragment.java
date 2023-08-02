package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.NotificationViewpager2Adapter;
import com.example.asm_nguyenhnpk02250.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Schedule_Fragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ScheduleViewpager2Adapter scheduleViewpager2Adapter;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.schedule_fragment, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_Schedule);
        viewPager2 = view.findViewById(R.id.view_pager_2_Schedule_fragment);
        scheduleViewpager2Adapter = new ScheduleViewpager2Adapter(getActivity());
        viewPager2.setAdapter(scheduleViewpager2Adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Lịch Học");
                        break;
                    case 1:
                        tab.setText("Lịch Thi");
                        break;
                }
            }
        }).attach();

        return view;
    }
}
