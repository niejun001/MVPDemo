package com.code.mvp2;

import com.code.mvp2.bean.UserInfo;

/**
 * Created by code on 2017/8/30.
 */
public interface IuserLoginView {
    //获取用户输入
    UserInfo getUserInfo();
    //显示进度条
    void showProgress();
    //隐藏进度条
    void hideProgress();
    //成功
    void showSuccess();
    //失败
    void showFaied();
    /*
    * 输入为空
    * */
    void showEmpty();
}
