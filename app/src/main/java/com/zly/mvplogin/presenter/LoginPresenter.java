package com.zly.mvplogin.presenter;

import android.text.TextUtils;

import com.zly.mvplogin.bean.User;
import com.zly.mvplogin.contract.LoginContract;
import com.zly.mvplogin.model.UserModel;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhuleiyue on 16/4/26.
 */
public class LoginPresenter implements LoginContract.Presenter {
    private final LoginContract.View mView;
    private final UserModel mModel;

    public LoginPresenter(LoginContract.View view) {
        mView = view;
        mModel = new UserModel();
    }

    @Override
    public void login() {
        if (verify(mView.getUsername(), mView.getPassword())) {
            mView.showProgress();
            mModel.login(mView.getUsername(), mView.getPassword())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleSubscriber<User>() {
                        @Override
                        public void onSuccess(User value) {
                            mView.hideProgress();
                        }

                        @Override
                        public void onError(Throwable error) {
                            mView.hideProgress();
                        }
                    });
        }
    }

    private boolean verify(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            mView.showUsernameErr("用户名不能为空！");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            mView.showPasswordErr("密码不能为空！");
            return false;
        }
        if (password.length() < 6) {
            mView.showPasswordErr("密码不能小于6位！");
            return false;
        }
        return true;
    }


}
