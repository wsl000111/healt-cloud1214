package com.healt.cloud.checkup.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.healt.cloud.checkup.entity.UsersDict;
import com.healt.cloud.checkup.entity.VUsersDict;
import com.healt.cloud.checkup.service.UserService;
import com.healt.cloud.checkup.service.UsersDictService;
import com.healt.cloud.checkup.service.VUsersDictService;
import com.healt.cloud.checkup.service.ws.WebServiceClient;
import com.healt.cloud.checkup.service.ws.his.BcsUumUser;
import com.healt.cloud.checkup.vo.sys.user.SaveUsersDictListVo;
import com.healt.cloud.checkup.vo.sys.user.UsersDictVo;
import com.healt.cloud.checkup.vo.sys.user.UsersVo;
import com.healt.cloud.common.utils.PropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GuYue
 * @date 2022-03-05 14:17
 * @description: TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private VUsersDictService vUsersDictService;
    @Autowired
    private UsersDictService usersDictService;

    @Autowired
    private WebServiceClient client;

    private String isHis = PropertiesUtils.ISHIS;

    private String areaCode = PropertiesUtils.AREACODE;

    @Override
    public List<VUsersDict> findUsersDict(UsersVo usersVo) {
        QueryWrapper<VUsersDict> queryWarpper = new QueryWrapper<>();
        queryWarpper.eq("hospital_id", usersVo.getHosId());
        if (usersVo.getDeptId()!=null && !"".equalsIgnoreCase(usersVo.getDeptId())){
            queryWarpper.eq("dept_id", usersVo.getDeptId());
        }if(usersVo.getUserId()!=null && !"".equalsIgnoreCase(usersVo.getUserId())){
            queryWarpper.eq("user_id", usersVo.getUserId());
        }
        List<VUsersDict> list = vUsersDictService.list(queryWarpper);
        if(list.size() == 0){
            list.add(new VUsersDict());
        }
        return list;
    }

    @Override
    @Transactional
    public void saveUsersDict(SaveUsersDictListVo saveUsersDictListVo) {
        for(UsersDictVo usersDictVo : saveUsersDictListVo.getUsersDictList()){
            switch (usersDictVo.getStat()){
                case "delete" :
                    for(UsersDict usersDict : usersDictVo.getUsersDict()){
                        QueryWrapper<UsersDict> queryWrapper = new QueryWrapper<>();
                        //queryWrapper.eq("DEPT_ID", usersDict.getDeptId());
                        queryWrapper.eq("USER_ID", usersDict.getUserId());
                        queryWrapper.eq("HOSPITAL_ID", usersDict.getHospitalId());
                        usersDictService.remove(queryWrapper);
                    }
                    break;
                case "add":
                    usersDictService.saveBatch(usersDictVo.getUsersDict());
                    break;
                case "update":
                    for(UsersDict usersDict : usersDictVo.getUsersDict()){
                        UpdateWrapper<UsersDict> updateWrapper= new UpdateWrapper<>();
                        //updateWrapper.eq("DEPT_ID", usersDict.getDeptId());
                        updateWrapper.eq("USER_ID", usersDict.getUserId());
                        updateWrapper.eq("HOSPITAL_ID", usersDict.getHospitalId());
                        usersDictService.update(usersDict, updateWrapper);
                    }
                    break;
            }
        }
    }

    @Override
    public List<VUsersDict> getVUsersDict(String userId) {
        QueryWrapper<VUsersDict> queryWarpper = new QueryWrapper<>();
        queryWarpper.eq("upper(user_id)", userId.toUpperCase());
        List<VUsersDict> list = vUsersDictService.list(queryWarpper);
        if(list.size() == 0){
            list.add(new VUsersDict());
        }
        return list;
    }

    @Override
    @Transactional
    public void updatePassword(String userId, String password) {
        UpdateWrapper<UsersDict> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("PWD", password);
        updateWrapper.eq("USER_ID", userId);
        usersDictService.update(updateWrapper);
    }

    @Override
    public void reloadUsersDict(String deptName) {
        List<UsersDict> list = new ArrayList<>();
        List<BcsUumUser> bcsUumUserList = client.userQueryList(deptName,"reloadUsersDict");
        if(bcsUumUserList == null){
            return;
            //throw new CommonException(500, "没有可更新的科室人员信息");
        }
        String hospitalId = "0001";
        for (BcsUumUser bcsUumUser : bcsUumUserList) {
            UsersDict usersDict = new UsersDict();
            usersDict.setUserId(bcsUumUser.getUserName());
            usersDict.setUserName(bcsUumUser.getPeopleName());
            usersDict.setInputCode(bcsUumUser.getPyCode());
            usersDict.setDeptName(bcsUumUser.getWorkDept());

            usersDict.setHospitalId(hospitalId);
//                usersDict.setAddr();
//                usersDict.setBarthday();
//                usersDict.setDoctorImg();
            usersDict.setCreateDate(new Date());
            usersDict.setIdNo(bcsUumUser.getIdNo());
//                usersDict.setIsDoctor();
//                usersDict.getNote();
//                usersDict.setSex();
//                usersDict.setPwd();
            usersDict.setTel(bcsUumUser.getMobile());
            if(!"A".equals(bcsUumUser.getStatus())){//未激活状态处理
                usersDictService.removeById(usersDict.getUserId());
                continue;
            }
            list.add(usersDict);
        }
        usersDictService.saveOrUpdateBatch(list);
    }
}
