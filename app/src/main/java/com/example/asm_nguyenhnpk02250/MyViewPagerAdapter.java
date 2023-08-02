package com.example.asm_nguyenhnpk02250;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.asm_nguyenhnpk02250.Fragment.fragment_Schedule.Schedule_Fragment;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_Utilities.Utilities_Fragment;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_home.Home_Fragment;
import com.example.asm_nguyenhnpk02250.Fragment.fragment_score.Score_Fragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Home_Fragment();
            case 1:
                return new Schedule_Fragment();
            case 2:
                return new Score_Fragment();
            case 3:
                return new Utilities_Fragment();
            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
