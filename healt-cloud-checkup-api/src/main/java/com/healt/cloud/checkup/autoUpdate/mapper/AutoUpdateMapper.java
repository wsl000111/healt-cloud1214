package com.healt.cloud.checkup.autoUpdate.mapper;

import com.healt.cloud.checkup.entity.HealtUpdatePara;
import com.healt.cloud.checkup.autoUpdate.vo.AppParsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author GuYue
 * @date 2022-06-07 17:49
 * @description: TODO
 */
@Mapper
public interface AutoUpdateMapper {
    @Select(" SELECT LASTUPLOADTIME FROM healt_applications_para ${strWhere}")
    String selectLastUpLoadTime(String strWhere);

    @Select("select code,name,'['||code||'] '||name codename,isdownload from healt_applications_para where isdownload = 'Y'")
    List<AppParsVo> getAppPars(String isdownload);

    @Select( "select value From healt_update_para Where CODE=#{code} and his_unit_code = #{hospitalId}")
    String getFtpValue(String hospitalId, String code);

    @Select("select code,name,value,bz,his_unit_code hisUnitCode from healt_update_para where bz=#{bz} and his_unit_code=#{hospitalId}")
    List<HealtUpdatePara> getUpdatePara(String hospitalId, String bz);

    @Select("select remotepath from healt_applications_para where code=#{code} and his_unit_code=#{hospitalId}")
    String getRemotepath(String hospitalId, String code);

    @Update( "update healt_applications_para set lastuploadtime = to_char(sysdate,'yyyymmddhh24miss') where code=#{code} and his_unit_code =#{hospitalId}")
    boolean updateLastuploadtime(String hospitalId, String code);

    @Select(" SELECT LASTUPLOADTIME FROM healt_applications_para WHERE CODE = #{code} AND ISDOWNLOAD ='Y' ")
    String selectLastUpLoadTimeByCode(String code);
}
