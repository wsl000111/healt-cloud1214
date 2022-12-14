package com.healt.cloud.checkup.service.member;

import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.vo.member.MemberDictVo;
import com.healt.cloud.checkup.vo.member.MemberListVo;
import com.healt.cloud.checkup.vo.member.UserListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveCommonDictListVo;
import com.healt.cloud.checkup.vo.member.vo.SaveHcMemberInfoListVo;
import com.healt.cloud.common.pages.PageResult;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author linklee
 * @create 2022-05-09 13:59
 */
public interface MemberListService {

    public PageResult findMemberListPage(MemberDictVo memberDictVo);

    public List<UserListVo> findUserList(String hospitalId);

    public List findCardNo(String hospitalId, String cardNo);

    public void saveHcMemberInfo(SaveHcMemberInfoListVo saveHcMemberInfoList);

    public List<MemberListVo> findDataByCardNo(String hospitalId, String cardNo);

    public void updateMemberInfo(String hospitalId, String cardNo,String status);

    public List<CommonDict> findCardTypeList(String hospitalId);


    public void updateMemberInfoMoney(String hospitalId, String cardNo, BigDecimal decTransMoney, String transType, String pay);


    public void saveCommonDict(SaveCommonDictListVo saveCommonDictList);
}
