package com.code.mvp2;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.code.mvp2.bean.UserInfo;
import com.code.mvp2.presenter.UserLoginPresenter;

/*
MVC:
    View：对应于布局文件
    Model：业务逻辑和实体模型
    Controllor：对应于Activity
    弊端：
    View对应于布局文件，其实能做的事情特别少，实际上关于该布局文件中的数据绑定的操作，事件处理的代码都在Activity中，造成了Activity既像View又像Controller

MVP:
    View 对应于Activity，负责View的绘制以及与用户交互
    Model 依然是业务逻辑和实体模型
    Presenter 负责完成View于Model间的交互
    优点：
    Presenter的出现，将Actvity视为View层，Presenter负责完成View层与Model层的交互
    减少了Activity的职责，简化了Activity中的代码，将复杂的逻辑代码提取到了Presenter中进行处理。与之对应的好处就是，耦合度更低，更方便的进行测试。

区别：
    MVC中是允许Model和View进行交互的，而MVP中很明显，Model与View之间的交互由Presenter完成。还有一点就是Presenter与View之间的交互是通过接口的
* */

/*
* 登陆案例：
*
* 界面显示、用户输入、按钮点击、判断用户输入、显示进度条、耗时操作（联网验证）、隐藏进度条、提示用户
* */
public class MainActivity extends AppCompatActivity implements IuserLoginView{
    private EditText name;
    private EditText pwd;
    private ProgressDialog dialog;
    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        name = ((EditText) findViewById(R.id.name));
        pwd = ((EditText) findViewById(R.id.pwd));
        dialog = new ProgressDialog(this);
    }

    public void login(View view){
        presenter.login();
    }

    @Override
    public UserInfo getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.username = name.getText().toString();
        userInfo.userpwd = pwd.getText().toString();
        return userInfo;
    }

    @Override
    public void showProgress() {
        dialog.show();
    }

    @Override
    public void hideProgress() {
        dialog.dismiss();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFaied() {
        Toast.makeText(this, "登陆失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmpty() {
        Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
    }
}
