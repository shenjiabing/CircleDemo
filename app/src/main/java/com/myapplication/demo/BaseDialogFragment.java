package com.myapplication.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Administrator on 2018/7/25.
 */

public class BaseDialogFragment extends DialogFragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            onCurrentAttach(context);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            onCurrentAttach(activity);
        }
    }

    protected Activity mActivity;
    private void onCurrentAttach(Context context) {
        this.mActivity= (FragmentActivity) context;
    }



}
