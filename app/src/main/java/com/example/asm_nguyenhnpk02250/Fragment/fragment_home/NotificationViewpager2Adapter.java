package com.example.asm_nguyenhnpk02250.Fragment.fragment_home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_study.fragment_notification_study;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_tuition.fragment_notification_tuition;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_work.fragment_notification_work;



public class NotificationViewpager2Adapter extends FragmentStateAdapter {
    public NotificationViewpager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new fragment_notification_study();
            case 1:
                return new fragment_notification_work();
            case 2:
                return new fragment_notification_tuition();
            default:
                return new fragment_notification_study();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
