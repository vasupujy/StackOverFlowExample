package com.example.root.tabexample;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.root.tabexample.databinding.JobListItemBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/4/17.
 */

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.JobListViewHolder> {
  List<DetailItemList> itemListList = new ArrayList<>();
  private Context mContext;

  public JobListAdapter(Context context) {
    this.mContext = context;
  }

  @Override public JobListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    JobListItemBinding jobListItemBinding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_jonlist,
            parent, false);
    return new JobListViewHolder(jobListItemBinding);
  }

  public void addAllDara(List<DetailItemList> detailItemLists) {
    itemListList.addAll(detailItemLists);
    notifyDataSetChanged();
  }

  @Override public void onBindViewHolder(JobListViewHolder holder, int position) {
    ((JobListViewHolder) holder).bindData(itemListList.get(position), holder, mContext);
  }

  @Override public int getItemCount() {
    return itemListList.size();
  }

  public class JobListViewHolder extends RecyclerView.ViewHolder {
    JobListItemBinding itemBinding;

    public JobListViewHolder(JobListItemBinding itemView) {
      super(itemView.getRoot());
      this.itemBinding = itemView;
    }

    public void bindData(DetailItemList detailItemList, JobListViewHolder holder,
        Context mContext) {
      itemBinding.id.setText(String.valueOf(detailItemList.getAnswerId()));
      itemBinding.name.setText(String.valueOf(detailItemList.getAnswerId()));
      itemBinding.type.setText(String.valueOf(detailItemList.getAnswerId()));
    }
  }
}
