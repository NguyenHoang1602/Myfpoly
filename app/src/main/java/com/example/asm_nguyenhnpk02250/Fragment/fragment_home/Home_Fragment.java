package com.example.asm_nguyenhnpk02250.Fragment.fragment_home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.asm_nguyenhnpk02250.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class Home_Fragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private NotificationViewpager2Adapter notificationViewpager2Adapter;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        tabLayout = view.findViewById(R.id.tab_layout_notification);
        viewPager2 = view.findViewById(R.id.viewp_pager_2_notification_fragment);
        notificationViewpager2Adapter = new NotificationViewpager2Adapter(getActivity());
        viewPager2.setAdapter(notificationViewpager2Adapter);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Học Tập");
                        break;
                    case 1:
                        tab.setText("Hoạt Động");
                        break;
                    case 2:
                        tab.setText("Học Phí");
                }
            }
        }).attach();

        return view;
    }
}
