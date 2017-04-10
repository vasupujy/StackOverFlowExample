package com.example.root.tabexample;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by root on 10/4/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner implements Parcelable {
  @JsonProperty("reputation")
  int reputation;
  @JsonProperty("user_id")
  int user_id;
  @JsonProperty("user_type")
  String user_type;
  @JsonProperty("profile_image")
  String profile_image;
  @JsonProperty("display_name")
  String display_name;
  @JsonProperty("link")
  String link;

  public int getReputation() {
    return reputation;
  }

  public void setReputation(int reputation) {
    this.reputation = reputation;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public String getUser_type() {
    return user_type;
  }

  public void setUser_type(String user_type) {
    this.user_type = user_type;
  }

  public String getProfile_image() {
    return profile_image;
  }

  public void setProfile_image(String profile_image) {
    this.profile_image = profile_image;
  }

  public String getDisplay_name() {
    return display_name;
  }

  public void setDisplay_name(String display_name) {
    this.display_name = display_name;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.reputation);
    dest.writeInt(this.user_id);
    dest.writeString(this.user_type);
    dest.writeString(this.profile_image);
    dest.writeString(this.display_name);
    dest.writeString(this.link);
  }

  public Owner() {
  }

  protected Owner(Parcel in) {
    this.reputation = in.readInt();
    this.user_id = in.readInt();
    this.user_type = in.readString();
    this.profile_image = in.readString();
    this.display_name = in.readString();
    this.link = in.readString();
  }

  public static final Parcelable.Creator<Owner> CREATOR = new Parcelable.Creator<Owner>() {
    @Override public Owner createFromParcel(Parcel source) {
      return new Owner(source);
    }

    @Override public Owner[] newArray(int size) {
      return new Owner[size];
    }
  };
}
