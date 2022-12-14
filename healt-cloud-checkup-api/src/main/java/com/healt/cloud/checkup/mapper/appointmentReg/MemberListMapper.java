package com.healt.cloud.checkup.mapper.appointmentReg;

import com.healt.cloud.checkup.entity.CommonDict;
import com.healt.cloud.checkup.vo.member.MemberListVo;
import com.healt.cloud.checkup.vo.member.UserListVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-09 14:04
 */
@Mapper
public interface MemberListMapper {

    List<MemberListVo> findMemberList(@Param("hospitalId") String hospitalId);

    List<UserListVo> findUserList(@Param("hospitalId") String hospitalId);

    String findCardNo(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo);

    List<MemberListVo> findDataByCardNo(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo);

    void updateMemberInfo(@Param("hospitalId") String hospitalId,@Param("cardNo") String cardNo,@Param("status") String status);

    List<CommonDict> findCardTypeList(@Param("hospitalId") String hospitalId);
}
