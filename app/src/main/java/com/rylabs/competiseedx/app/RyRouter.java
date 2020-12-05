package com.rylabs.competiseedx.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;


public class RyRouter {
    private Context mContext;
    private Intent mIntent;

    public RyRouter(Context context) {
        this.mContext = context;
    }

    public void openActivity(Class<?> nextClass) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mContext.startActivity(mIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openActivity(Class<?> nextClass, Bundle mbundle) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.putExtras(mbundle);
            mContext.startActivity(mIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openActivityAndClearAllPrevious(Class<?> nextClass) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            mContext.startActivity(mIntent);
            ((AppCompatActivity) mContext).finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}