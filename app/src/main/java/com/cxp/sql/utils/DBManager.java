package com.cxp.sql.utils;

import android.content.Context;

import com.cxp.sql.model.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * 文 件 名: DBManager
 * 创 建 人: CXP
 * 创建日期: 2017-01-18 10:01
 * 描    述: 数据库管理
 * 修 改 人:
 * 修改时间：
 * 修改备注：
 */
public class DBManager {

    private final static String dbName = "sql_db";
    private static DBManager mInstance;
    private  DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper=new DaoMaster.DevOpenHelper(context,dbName,null);
    }

    /**
     * 获取单例引用
     * @param context
     * @return
     */
    public  static DBManager getInstance(Context context){
        if (mInstance==null) {
            synchronized (DBManager.class){
                if (mInstance==null) {
                    mInstance =new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    public Database getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        Database db = openHelper.getReadableDb();
        return db;
    }

    /**
     * 获取可写数据库
     */
    public  Database getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        Database db = openHelper.getWritableDb();
        return db;
    }

//    /**
//     * 插入一条记录
//     *
//     * @param user
//     */
//    public void insertUser(User user) {
//        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao appUserDao = daoSession.getUserDao();
//        appUserDao.insert(user);
//    }
//    public void insertBook(Book book) {
//        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        BookDao bookDao = daoSession.getBookDao();
//        bookDao.insert(book);
//    }
//    public List<Book> queryBookList() {
//        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        BookDao bookDao = daoSession.getBookDao();
//        QueryBuilder<Book> qb = bookDao.queryBuilder();
//        List<Book> list = qb.list();
//        return list;
//    }
//
//
//
//    /**
//     * 插入用户集合
//     *
//     * @param users
//     */
//    public void insertUserList(List<User> users) {
//        if (users == null || users.isEmpty()) {
//            return;
//        }
//        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao userDao = daoSession.getUserDao();
//        userDao.insertInTx(users);
//    }
//
//    /**
//     * 删除一条记录
//     *
//     * @param user
//     */
//    public void deleteUser(User user) {
//        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao userDao = daoSession.getUserDao();
//        userDao.delete(user);
//    }
//
//    /**
//     * 更新一条记录
//     *
//     * @param user
//     */
//    public void updateUser(User user) {
//        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao userDao = daoSession.getUserDao();
//        userDao.update(user);
//    }
//
//    /**
//     * 查询用户列表
//     */
//    public List<User> queryUserList() {
//        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao userDao = daoSession.getUserDao();
//        QueryBuilder<User> qb = userDao.queryBuilder();
//        List<User> list = qb.list();
//        return list;
//    }
//
//    /**
//     * 根据条件查询用户列表
//     * eq 是字符串
//     * gt 大于
//     */
//    public List<User> queryUserList(String name) {
//        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
//        DaoSession daoSession = daoMaster.newSession();
//        UserDao userDao = daoSession.getUserDao();
//        QueryBuilder<User> qb = userDao.queryBuilder();
//        qb.where(UserDao.Properties.Name.eq(name)).orderAsc(UserDao.Properties.Name);
//        List<User> list = qb.list();
//        return list;
//    }
}
