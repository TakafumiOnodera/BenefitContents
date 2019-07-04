package com.example.onoderat.benefitcontents;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PagerViewFragment extends Fragment {
    private final static String BACKGROUND_COLOR = "background_color";

    public static PagerViewFragment newInstance(@ColorRes int IdRes) {
        PagerViewFragment frag = new PagerViewFragment();
        Bundle b = new Bundle();
        b.putInt(BACKGROUND_COLOR, IdRes);
        frag.setArguments(b);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_view_flagment, null);
        LinearLayout linearLayout = view.findViewById(R.id.fragment_main_linear_layout);
        if (getArguments() != null) {
            linearLayout.setBackgroundResource(getArguments().getInt(BACKGROUND_COLOR));
        }

        return view;
    }
}
