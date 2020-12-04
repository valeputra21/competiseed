package com.rylabs.competiseedx.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rylabs.competiseedx.R;

public class UpcomingOnlineAdapter extends RecyclerView.Adapter<UpcomingOnlineAdapter.ViewHolder> {

    private Context mContext;
    private OnInteractionListener listener;

    public interface OnInteractionListener {
        void onSelected(int position);
    }

    public UpcomingOnlineAdapter(Context context, OnInteractionListener listener) {
        this.mContext = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_upcoming_online, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        if (position == 0) {
//            setMargins(holder.itemView, 40, 16, 20, 0);
//        }

//        Glide.with(mContext)
//            .load(mContext.getResources().getDrawable(R.drawable.banner_foryou))
//            .placeholder(R.drawable.banner_foryou)
//            .into(holder.ivBackground);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder  {

//        ImageView ivBackground;

        ViewHolder(View itemView) {
            super(itemView);
//            ivBackground = itemView.findViewById(R.id.iv_background);
        }
    }

    private void setMargins (View v, int left, int top, int right, int bottom) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            v.requestLayout();
        }
    }
}
