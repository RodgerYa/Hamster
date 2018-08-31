package com.hamster.ak.common.exception;

public interface HmError {
    ApiError TOKEN_NOT_EXIST = ApiError.with("token 不存在", 10);
    ApiError TOKEN_ENCODE_ERROR = ApiError.with("token 加密失败", 11);
    ApiError TOKEN_EXPIRED = ApiError.with("token 过期", 12);
    ApiError TOKEN_INVALID = ApiError.with("token 已失效", 12);

    ApiError ACCOUNT_EXISTED = ApiError.with("当前负债账户已存在", 20);
    ApiError ACCOUNT_NOT_EXIST = ApiError.with("当前负债账户不存在", 21);

    ApiError ADD_FAIL = ApiError.with("新增失败", 30);
    ApiError UPDATE_FAIL = ApiError.with("更新失败", 31);
    ApiError DELETE_FAIL = ApiError.with("修改失败", 32);
    ApiError QUERY_RESULT_EMPTY = ApiError.with("查询结果为空", 32);

    ApiError USER_EXISTED = ApiError.with("当前用户已存在，不可重复注册", 40);
    ApiError USER_NOT_EXIST = ApiError.with("用户不存在", 41);
    ApiError PASSWORD_WRONG = ApiError.with("密码错误", 42);
    ApiError USER_NOT_LOGIN = ApiError.with("该用户未登录", 43);

    ApiError WS_SEND_MESSAGE_ERROR = ApiError.with("发送消息失败", 50);
    ApiError WS_RECEIVE_MESSAGE_ERROR = ApiError.with("接收消息失败", 51);
    ApiError WS_CONNECT_ERROR = ApiError.with("webSocket 连接失败", 52);
    ApiError WS_ERROR = ApiError.with("webSocket 发生异常", 53);


}
