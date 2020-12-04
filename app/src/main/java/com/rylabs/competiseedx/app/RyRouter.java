package com.rylabs.competiseedx.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


/**
 * Created by ryputra on 18/03/2018.
 */

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

    public void openActivityAndClearAllPrevious(Class<?> nextClass, Bundle mbundle) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            mIntent.putExtras(mbundle);
            mContext.startActivity(mIntent);
            ((AppCompatActivity) mContext).finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void openActivityAndClearPreviousTop(Class<?> nextClass, Bundle mbundle) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            mIntent.putExtras(mbundle);
            mContext.startActivity(mIntent);
            ((AppCompatActivity) mContext).finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using For Clear Stack Between
     * ex :
     * A -> B -> C -> D -> A
     * B & C will cleared
     *
     * */
    public void openActivityAndClearPrevious(Class<?> nextClass, Bundle mbundle) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mIntent.putExtras(mbundle);
            mContext.startActivity(mIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openActivityAndClearPrevious(Class<?> nextClass) {
        try {
            mIntent = new Intent(mContext, nextClass);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            mContext.startActivity(mIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void openFragmentFromActivity(Fragment fragment, Bundle datas, int containerId) {
//        try {
//            FragmentManager manager = ((AppCompatActivity) mContext).getSupportFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
//            fragment.setArguments(datas);
//            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
//                    .replace(containerId, fragment)
//                    .addToBackStack(null)
//                    .commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public void openFragmentFromActivity(Fragment fragment, Bundle datas, int containerId, String fragmentId) {
//        try {
//            FragmentManager manager = ((AppCompatActivity) mContext).getSupportFragmentManager();
//            FragmentTransaction transaction = manager.beginTransaction();
//            fragment.setArguments(datas);
//            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
//                    .replace(containerId, fragment)
//                    .addToBackStack(fragmentId)
//                    .commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * openCreateFavoriteDialog from Fragment
     *
     * */
//    public void openCreateFavoriteDialog(Fragment fragment, Bundle bundle) {
//        FragmentManager fm = fragment.getFragmentManager();
//        FavoriteInsertBottomSheet dialogFragment = new FavoriteInsertBottomSheet();
//        dialogFragment.setArguments(bundle);
//        dialogFragment.show(fm, "Tambah Favorit");
//    }

//    public void openCreateFavoriteDialog(Fragment fragment, Bundle bundle, FavoriteInsertBottomSheet.FavoritBottomSheetListener favoritInsertListener) {
//        FragmentManager fm = fragment.getFragmentManager();
//        FavoriteInsertBottomSheet dialogFragment = new FavoriteInsertBottomSheet();
//        dialogFragment.setFavoritInsertListener(favoritInsertListener);
//        dialogFragment.setArguments(bundle);
//        dialogFragment.show(fm, "Tambah Favorit");
//    }

    /**
     * openCreateFavoriteDialog from Activity
     *
     * */
//    public void openCreateFavoriteDialog(Context context, Bundle bundle) {
//        FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
//        FavoriteInsertBottomSheet dialogFragment = new FavoriteInsertBottomSheet();
//        dialogFragment.setArguments(bundle);
//        dialogFragment.show(fm, "Tambah Favorit");
//    }
}