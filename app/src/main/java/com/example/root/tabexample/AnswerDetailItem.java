package com.example.root.tabexample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 10/4/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AnswerDetailItem  {
  @JsonProperty("items")
  private List<DetailItemList> itemListList = new ArrayList<>();
  @JsonProperty("is_accepted")
  private boolean isAccepted;
  @JsonProperty("score")
  private int score;
  @JsonProperty("last_activity_date")
  private int lastActivityDate;
  @JsonProperty("creation_date")
  private int creation_date;
  @JsonProperty("answer_id")
  private int answer_id;
  @JsonProperty("question_id")
  private int question_id;

  public List<DetailItemList> getItemListList() {
    return itemListList;
  }

  public void setItemListList(List<DetailItemList> itemListList) {
    this.itemListList = itemListList;
  }

  public boolean isAccepted() {
    return isAccepted;
  }

  public void setAccepted(boolean accepted) {
    isAccepted = accepted;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getLastActivityDate() {
    return lastActivityDate;
  }

  public void setLastActivityDate(int lastActivityDate) {
    this.lastActivityDate = lastActivityDate;
  }

  public int getCreation_date() {
    return creation_date;
  }

  public void setCreation_date(int creation_date) {
    this.creation_date = creation_date;
  }

  public int getAnswer_id() {
    return answer_id;
  }

  public void setAnswer_id(int answer_id) {
    this.answer_id = answer_id;
  }

  public int getQuestion_id() {
    return question_id;
  }

  public void setQuestion_id(int question_id) {
    this.question_id = question_id;
  }
}
