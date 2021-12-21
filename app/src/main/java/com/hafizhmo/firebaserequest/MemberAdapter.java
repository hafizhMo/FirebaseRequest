package com.hafizhmo.firebaserequest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hafizhmo.firebaserequest.databinding.ItemMemberBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.ViewHolder> {
    private ItemMemberBinding binding;
    private final Context context;
    private final ArrayList<Member> members;

    public MemberAdapter(Context context, ArrayList<Member> fish) {
        this.context = context;
        this.members = fish;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemMemberBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(members.get(position), context);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Member fish, Context context) {
            binding.tvName.setText(fish.getName());
            binding.tvRole.setText(fish.getRole());
            Picasso.with(context).load(fish.getImage())
                    .into(binding.ivPhoto);
        }
    }
}
