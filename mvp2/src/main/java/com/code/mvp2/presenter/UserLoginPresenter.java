package com.code.mvp2.presenter;

import android.os.Handler;

import com.code.mvp2.IuserLoginView;
import com.code.mvp2.login.OnUserLoginListener;
import com.code.mvp2.login.UserLogin;

/**
 * 业务
 * Created by code on 2017/8/30.
 */
public class UserLoginPresenter {
    private final IuserLoginView loginView;
    private final UserLogin userLogin;
    private Handler handler = new Handler();

    public UserLoginPresenter(IuserLoginView loginView){
        this.loginView = loginView;
        userLogin = new UserLogin();
    }

    public void login() {
//        final UserInfo userInfo = loginView.getUserInfo();
//        if (userInfo.username.isEmpty() || userInfo.userpwd.isEmpty()) {
//            loginView.showEmpty();
//        }else {
//            //联网验证！
//            loginView.showProgress();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    SystemClock.sleep(2000);
//
//                    if ("123".equals(userInfo.username) && "123".equals(userInfo.userpwd)) {
//                        //主线程更新UI
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                loginView.hideProgress();
//                                loginView.showSuccess();
//                            }
//                        });
//                    }else {
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                loginView.hideProgress();
//                                loginView.showFaied();
//                            }
//                        });
//                    }
//                }
//            }).start();
//        }

        loginView.showProgress();
        userLogin.login(loginView.getUserInfo(), new OnUserLoginListener() {
            @Override
            public void success() {
                handler.post(new Runnable() {
                            @Override
                            public void run() {
                                loginView.hideProgress();
                                loginView.showSuccess();
                            }
                        });
            }

            @Override
            public void faied() {
                handler.post(new Runnable() {
                            @Override
                            public void run() {
                                loginView.hideProgress();
                                loginView.showFaied();
                            }
                        });
            }

            @Override
            public void empty() {
                loginView.hideProgress();
                loginView.showEmpty();
            }
        });
    }
}
