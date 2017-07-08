package com.cxp.sql.model.db;

import android.content.Context;

import com.cxp.sql.model.DaoMaster;
import com.cxp.sql.model.DaoSession;
import com.cxp.sql.model.User;
import com.cxp.sql.model.UserDao;
import com.cxp.sql.utils.DBManager;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 文 件 名: UserDB
 * 创 建 人: CXP
 * 创建日期: 2017-01-20 9:35
 * 描    述: 用户类数据库操作
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class UserDB {

    private DBManager mDbManager;

    private static UserDB mInstance;

    public UserDB(Context context) {
        this.mDbManager = mDbManager.getInstance(context);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static UserDB getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new UserDB(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insert(User user) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao appUserDao = daoSession.getUserDao();
        appUserDao.insert(user);
    }

    /**
     * 批量插入数据
     */
    public void insertMore(List<User> list) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insertInTx(list);
    }

    /**
     * 删除一条记录
     *
     * @param user
     */
    public void delete(User user) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.delete(user);
    }

    /**
     * 删除全部记录
     */
    public void deleteAll() {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.deleteAll();
    }

    /**
     * 更新一条记录
     */
    public void update(User user) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.update(user);
    }

    /**
     * 批量修改数据
     */
    public void updateMore(List<User> list) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.updateInTx(list);
    }

    /**
     * 查询用户
     */
    public List<User> query() {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        List<User> list = qb.list();
        return list;
    }

    /**
     * 根据条件查询
     * eq 是字符串
     * gt 大于
     */
    public User query(String name) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.Name.eq(name)).orderAsc(UserDao.Properties.Age);
        List<User> list = qb.list();
        return list.size() != 0 ? list.get(0) : null;
    }

    /**
     * 多条件查询
     * eq 是字符串
     * gt 大于
     */
    public User queryMore(String name,int num) {
        DaoMaster daoMaster = new DaoMaster(mDbManager.getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        qb.where(qb.and(UserDao.Properties.Name.ge(name),UserDao.Properties.Age.le(num))
        ).orderAsc(UserDao.Properties.Age);
        qb.where(UserDao.Properties.Name.eq(name)).orderAsc(UserDao.Properties.Age);
        List<User> list = qb.list();
        return list.size() != 0 ? list.get(0) : null;
    }

}
