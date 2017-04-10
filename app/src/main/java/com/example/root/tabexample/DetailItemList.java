package com.example.root.tabexample;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by root on 10/4/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailItemList implements Parcelable {
  @JsonProperty("owner")
  private Owner owner;
  @JsonProperty("is_accepted")
  private boolean isAccepted;
  @JsonProperty("score")
  private int score;
  @JsonProperty("last_activity_date")
  private int lastActivityDate;
  @JsonProperty("creation_date")
  private int creationDate;
  @JsonProperty("answer_id")
  private int answerId;
  @JsonProperty("question_id")
  private int questionId;

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
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

  public int getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(int creationDate) {
    this.creationDate = creationDate;
  }

  public int getAnswerId() {
    return answerId;
  }

  public void setAnswerId(int answerId) {
    this.answerId = answerId;
  }

  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelable(this.owner, flags);
    dest.writeByte(this.isAccepted ? (byte) 1 : (byte) 0);
    dest.writeInt(this.score);
    dest.writeInt(this.lastActivityDate);
    dest.writeInt(this.creationDate);
    dest.writeInt(this.answerId);
    dest.writeInt(this.questionId);
  }

  public DetailItemList() {
  }

  protected DetailItemList(Parcel in) {
    this.owner = in.readParcelable(Owner.class.getClassLoader());
    this.isAccepted = in.readByte() != 0;
    this.score = in.readInt();
    this.lastActivityDate = in.readInt();
    this.creationDate = in.readInt();
    this.answerId = in.readInt();
    this.questionId = in.readInt();
  }

  public static final Parcelable.Creator<DetailItemList> CREATOR =
      new Parcelable.Creator<DetailItemList>() {
        @Override public DetailItemList createFromParcel(Parcel source) {
          return new DetailItemList(source);
        }

        @Override public DetailItemList[] newArray(int size) {
          return new DetailItemList[size];
        }
      };
}
