package com.example.root.tabexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by root on 10/4/17.
 */

public interface ApiInterface {
  @GET("/2.2/answers") Call<AnswerDetailItem> getQuestionList(@Query("page") int page,
      @Query("pagesize") int pageSize, @Query("order") String order, @Query("sort") String sort,
      @Query("site") String site);
}
