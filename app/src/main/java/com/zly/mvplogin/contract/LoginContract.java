package com.zly.mvplogin.contract;

import com.zly.mvplogin.BasePresenter;
import com.zly.mvplogin.BaseView;

/**
 * Created by zhuleiyue on 16/4/26.
 */
public interface LoginContract {

    interface View extends BaseView {

        String getUsername();

        String getPassword();

        void showProgress();

        void hideProgress();

        void showUsernameErr(String msg);

        void showPasswordErr(String msg);
    }

    interface Presenter extends BasePresenter {

        void login();
    }
}
