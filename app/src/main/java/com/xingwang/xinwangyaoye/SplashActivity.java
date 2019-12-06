package com.xingwang.xinwangyaoye;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

import com.xingwang.classroom.ClassRoomLibUtils;
import com.xingwang.classroom.R;
import com.xingwang.classroom.bean.UserBean;
import com.xingwang.classroom.http.ApiParams;
import com.xingwang.classroom.http.HttpCallBack;
import com.xingwang.classroom.http.HttpUrls;
import com.xingwang.classroom.ui.BaseNetActivity;
import com.xingwang.classroom.ui.ClassRoomHomeActivity;


/**
 * Date:2019/8/19
 * Time;14:22
 * author:baiguiqiang
 */
public class SplashActivity extends BaseNetActivity {
    @Override
    protected int layoutResId() {
        return R.layout.activity_splash_classroom;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 防止再次进入app出现启动页
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
       /* requestGet(HttpUrls.URL_GETAUTHSTR, new ApiParams().with("phone", "15281046619").with("code", "123"), UserBean.class, new HttpCallBack<UserBean>() {
            @Override
            public void onFailure(String message) {

            }

            @Override
            public void onSuccess(UserBean commentEntity) {
                SplashActivity.this.getSharedPreferences("module_auth", Context.MODE_PRIVATE).edit().putString("auth",commentEntity.getData().getAuthstr()).apply();
                startActivity(new Intent(SplashActivity.this, ClassRoomHomeActivity.class));
            }
        });*/
        ClassRoomLibUtils.startListActivity(this,"栏目");

        finish();
    }
}
