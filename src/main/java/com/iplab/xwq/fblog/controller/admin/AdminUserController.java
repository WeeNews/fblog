//package com.iplab.xwq.fblog.controller.admin;
//
//import com.iplab.xwq.fblog.common.Constants;
//import com.iplab.xwq.fblog.common.Result;
//import com.iplab.xwq.fblog.common.ResultGenerator;
//import com.iplab.xwq.fblog.entity.AdminUser;
//import com.iplab.xwq.fblog.service.AdminUserService;
//import com.iplab.xwq.fblog.utils.PageUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.util.StringUtils;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/users")
//public class AdminUserController {
//    @Autowired
//    private AdminUserService adminUserService;
//
//    /**
//     *  列表
//     */
//    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public Result list(@RequestParam Map<String,Object> params){
//        if(StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit")))
//            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR,"参数异常");
//        //查询列表数据
//        PageUtil pageUtil = new PageUtil(params);
//        return ResultGenerator.genSuccessResult(adminUserService.getAdminUserPage(pageUtil));
//    }
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Result login(@RequestBody AdminUser user){
//        Result result = ResultGenerator.genFailResult("登录失败");
//        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword()))
//            result.setMessage("请填写登录信息");
//        AdminUser loginUser = adminUserService.updateTokenAndLogin(user.getUserName(),user.getPassword());
//        if (loginUser != null)
//            result = ResultGenerator.genSuccessResult(loginUser);
//        return result;
//    }
//}
