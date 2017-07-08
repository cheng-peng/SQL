package com.cxp.sql;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cxp.sql.model.User;
import com.cxp.sql.model.db.UserDB;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "SQL";

    private UserDB mUserDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserDB = UserDB.getInstance(getApplicationContext());
    }

    public void clickLis(View view) {
        switch (view.getId()) {
            case R.id.bt_add_one:
                //增加一条数据
                addOne();
                break;
            case R.id.bt_add_more:
                //增加多条数据
                addMore();
                break;
            case R.id.bt_delete_one:
                //删除一条数据
                deleteOne();
                break;
            case R.id.bt_delete_all:
                //删除多条数据
                deleteAll();
                break;
            case R.id.bt_update_one:
                //修改一条数据
                updateOne();
                break;
            case R.id.bt_update_more:
                //修改多条数据
                updateMore();
                break;
            case R.id.bt_query:
                //查询数据
                query();
                break;
            case R.id.bt_query_param:
                //条件查询数据
                queryParam();
                break;
            case R.id.bt_query_param_more:
                //多条件查询数据
                queryParamMore();
                break;
        }
    }

    //增加一条数据
    private void addOne() {
        User user = new User();
        user.setName("CXP");
        user.setAge(18);
        mUserDB.insert(user);
    }

    //增加多条数据
    private void addMore() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("CXP" + (1 + i));
            user.setAge(10);
            list.add(user);
        }
        mUserDB.insertMore(list);
    }

    //删除一条数据
    private void deleteOne() {
        mUserDB.delete(mUserDB.query("CXP1"));
    }


    //删除多条数据
    private void deleteAll() {
        mUserDB.deleteAll();
    }

    //修改一条数据
    private void updateOne() {
        User user = mUserDB.query("CXP");
        user.setName("CXP1");
        user.setAge(20);
        mUserDB.update(user);
    }

    //修改多条数据
    private void updateMore() {
        List<User> list = mUserDB.query();
        for (User user : list) {
            user.setName("程小鹏");
        }
        mUserDB.updateMore(list);
    }

    //查询多条数据
    private void query() {
        List<User> list = mUserDB.query();
        Log.e(TAG, "集合数:" + list.size());
    }

    //条件查询数据
    private void queryParam() {
        User user = mUserDB.query("CXP1");
        if (user!=null) {
            Log.e(TAG, "name:" + user.getName() + "\nage:" + user.getAge());
        }
    }

    //多条件查询数据
    private void queryParamMore() {
        User user = mUserDB.queryMore("CXP1",20);
        if (user!=null) {
            Log.e(TAG, "name:" + user.getName() + "\nage:" + user.getAge());
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUserDB != null) {
            mUserDB = null;
        }
    }
}