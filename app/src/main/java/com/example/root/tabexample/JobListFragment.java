package com.example.root.tabexample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.root.tabexample.databinding.JobListBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 10/4/17.
 */

public class JobListFragment extends Fragment {
  String BASE_URL = "https://api.stackexchange.com/2.2";
  JobListAdapter jobListAdapter;
  JobListBinding mJobListBinding;

  public static JobListFragment newInstance() {
    return new JobListFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    mJobListBinding =
        DataBindingUtil.inflate(inflater, R.layout.fragment_joblist, container, false);
    mJobListBinding.jobListData.setLayoutManager(new LinearLayoutManager(getContext()));
    jobListAdapter = new JobListAdapter(getActivity());
    mJobListBinding.jobListData.setAdapter(jobListAdapter);
    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    Call<AnswerDetailItem> call =
        apiService.getQuestionList(1, 1, "desc", "activity", "stackoverflow");
    call.enqueue(new Callback<AnswerDetailItem>() {
      @Override
      public void onResponse(Call<AnswerDetailItem> call, Response<AnswerDetailItem> response) {
        jobListAdapter.addAllDara(response.body().getItemListList());
      }

      @Override public void onFailure(Call<AnswerDetailItem> call, Throwable t) {
        Log.d("JobListFragment", "onFailure: ");
      }
    });
    return mJobListBinding.getRoot();
  }
}
