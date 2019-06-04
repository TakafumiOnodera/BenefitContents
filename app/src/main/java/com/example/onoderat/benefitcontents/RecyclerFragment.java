package com.example.onoderat.benefitcontents;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment implements OnRecyclerListener {

    private Activity mActivity = null;
    private RecyclerFragmentListener mFragmentListener = null;

    // RecyclerViewとAdapter
    private RecyclerView mRecyclerView = null;
    private RecyclerAdapter mAdapter = null;

    public interface RecyclerFragmentListener {
        void onRecyclerEvent();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mFragmentListener == null){
            mFragmentListener = (RecyclerFragmentListener) context;
        }
        mActivity = (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        mRecyclerView = view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<String> array = new ArrayList<>();
        array.add(getString(R.string.test));
        array.add("B");
        array.add("C");

        mAdapter = new RecyclerAdapter(mActivity, array, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRecyclerClicked(View v, int position) {
        //TODO セルクリック処理
        Log.d("RecyclerFragment", "セルクリック");
        mFragmentListener.onRecyclerEvent();
    }
}