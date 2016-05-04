package com.zly.mvplogin.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhuleiyue on 16/4/26.
 */
public class User implements Parcelable {

    public String id;
    public String name;

    public User(){

    }

    protected User(Parcel in) {
        id = in.readString();
        name = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
    }
}
