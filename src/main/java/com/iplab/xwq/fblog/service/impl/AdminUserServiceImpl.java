package com.iplab.xwq.fblog.service.impl;


import com.iplab.xwq.fblog.dao.AdminUserMapper;
import com.iplab.xwq.fblog.entity.AdminUser;
import com.iplab.xwq.fblog.service.AdminUserService;
import com.iplab.xwq.fblog.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xwq
 * @Description
 * @Date 下午1:54 2020/6/17
 */
@Service("adminUserService")
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserDao;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password,"UTF-8");
        return adminUserDao.login(userName,passwordMd5);
    }

    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserDao.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserDao.selectByPrimaryKey(loginUserId);
        if (adminUser != null){
            String originPasswordMd5 = MD5Util.MD5Encode(originalPassword,"UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword,"UTF-8");
            if (originPasswordMd5.equals(adminUser.getLoginPassword())){
                adminUser.setLoginPassword(newPassword);
                if (adminUserDao.updateByPrimaryKeySelective(adminUser) > 0)
                    return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserDao.selectByPrimaryKey(loginUserId);
        if (adminUser != null){
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserDao.updateByPrimaryKeySelective(adminUser) > 0)
                return true;
        }
        return false;
    }


}
