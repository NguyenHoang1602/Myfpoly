package com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_schedule.fragment_schedule;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.fragment_test_schedule.fragment_test_schedule;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_study.fragment_notification_study;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_tuition.fragment_notification_tuition;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.fragment_notification_work.fragment_notification_work;


public class ScheduleViewpager2Adapter extends FragmentStateAdapter {
    public ScheduleViewpager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new fragment_schedule();
            case 1:
                return new fragment_test_schedule();
            default:
                return new fragment_schedule();

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
