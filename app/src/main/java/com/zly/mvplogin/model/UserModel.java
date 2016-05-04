package com.zly.mvplogin.model;

import com.zly.mvplogin.bean.User;

import java.util.concurrent.TimeUnit;

import rx.Single;
import rx.SingleSubscriber;

/**
 * Created by zhuleiyue on 16/4/26.
 */
public class UserModel {

    public Single<User> login(String username, String password) {
        return Single.create(new Single.OnSubscribe<User>() {
            @Override
            public void call(SingleSubscriber<? super User> singleSubscriber) {
                User user = new User();
                user.id = "001";
                user.name = "zly394";
                singleSubscriber.onSuccess(user);
            }
        }).delay(3, TimeUnit.SECONDS);
    }

}
