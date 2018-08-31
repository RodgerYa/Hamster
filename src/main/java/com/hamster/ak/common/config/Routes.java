package com.hamster.ak.common.config;

public class Routes {

    // 用户
    public static final String LOGIN = "/api/user/login";
    public static final String LOGINOUT = "/api/user/loginout";
    public static final String GET_USER = "/api/user/{id}";
    public static final String CREATE_USER = "/api/user/create";
    public static final String USER_LIST = "/api/user/list";
    public static final String CHANGE_PASSWORD = "/api/user/changepassword";
    public static final String DELETE_USER = "/api/user/delete/{id}";

    // 账户
    public static final String CREATE_ACCOUNT = "/api/account/create";
    public static final String UPDATE_ACCOUNT = "/api/account/update";
    public static final String DELETE_ACCOUNT = "/api/account/delete/{id}";
    public static final String ACCOUNT_LIST = "/api/account/list";
    public static final String GET_ACCOUNT = "/api/account/{id}";

    public static final String CREATE_LIABILITY_ACCOUNT = "/api/account/liability/create";
    public static final String GET_LIABILITY_ACCOUNT = "/api/account/liability/{id}";
    public static final String LIABILITY_ACCOUNT_LIST = "/api/account/liability/list";
    public static final String UPDATE_LIABILITY_ACCOUNT = "/api/account/liability/update";
    public static final String DELETE_LIABILITY_ACCOUNT = "/api/account/liability/delete/{id}";

    public static final String CREATE_BILL = "/api/bill/create";
    public static final String UPDATE_BILL = "/api/bill/update";
    public static final String DELETE_BILL = "/api/bill/delete/{id}";
    public static final String BILL_LIST = "/api/bill/list";
    public static final String QUERY_BILL = "/api/bill/query";

    // 统计
    public static final String STATISITCS = "/api/statistics";
}
