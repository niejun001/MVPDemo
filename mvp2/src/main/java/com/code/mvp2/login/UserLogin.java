package com.code.mvp2.login;

import android.os.SystemClock;

import com.code.mvp2.bean.UserInfo;

/**
 * Created by code on 2017/8/30.
 */

public class UserLogin {

    public void login(final UserInfo userInfo, final OnUserLoginListener listener){
        if (userInfo.username.isEmpty() || userInfo.userpwd.isEmpty()) {
            listener.empty();
        }else {
            //联网验证！
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);

                    if ("123".equals(userInfo.username) && "123".equals(userInfo.userpwd)) {
                        //主线程更新UI
                        listener.success();
                    }else {
                        listener.faied();
                    }
                }
            }).start();
        }
    }
}
