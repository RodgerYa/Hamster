package com.hamster.ak.api;

import java.util.List;

public interface PermissionService {

    /**
     * 取所有权限
     *
     * @return 权限列表
     */
    List<Permission> getAll();

    /**
     * 取用户已授权的权限
     *
     * @param userId not null
     *
     * @return 权限列表
     */
    List<Permission> getUserPermissions(Integer userId);

    /**
     * 根据id获取单个权限
     *
     * @param id not null
     *
     * @return
     */
    Permission getById(Integer id);

    /**
     * 赋予用户权限
     *
     * @param userId not null
     *
     * @param permissions 权限列表 not empty
     */
    void assignToUser(Integer userId, List<Permission> permissions);

    /**
     * 删除权限 考虑到创建通过配置文件，删除是否也通过对文件修改 ？？？
     *
     * @param permissionId
     *
 *   * void delete(String permissionId);
     */
}
