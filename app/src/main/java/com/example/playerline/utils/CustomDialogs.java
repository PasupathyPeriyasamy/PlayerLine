package com.example.playerline.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.playerline.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.kaopiz.kprogresshud.KProgressHUD;


public class CustomDialogs {

    public static KProgressHUD getProgressDialog(Activity activity, String toastMsg, final String action, final boolean cancelable) {
        KProgressHUD hud = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setWindowColor(activity.getResources().getColor(android.R.color.transparent))
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .setLabel(toastMsg)
                .setDetailsLabel(action)
                .setCancellable(cancelable);
        return hud;
    }

    public static KProgressHUD getProgressDialog(Context activity, String toastMsg, final String action, final boolean cancelable) {
        KProgressHUD hud = KProgressHUD.create(activity)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setWindowColor(activity.getResources().getColor(android.R.color.transparent))
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .setLabel(toastMsg)
                .setDetailsLabel(action)
                .setCancellable(cancelable);
        return hud;
    }

}
