package com.healt.cloud.common.utils;

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum;
import com.github.houbb.pinyin.util.PinyinHelper;
import com.google.common.base.CaseFormat;
import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * @author GuYue
 * @date 2022-03-09 16:45
 * @description: TODO
 */
public class CommonUtils {

    /**
     * 下划线转驼峰
     * @return
     */
    public static String underline2Camel(String underline){
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, underline);
    }

    public static String firstUpper(String str){
        // 进行字母的ascii编码前移，效率要高于截取字符串进行转换的操作
        char[] cs=str.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    /**
     * 获取身份证出生日期
     * @return
     */
    public static String getBirthByIdCard(String idCard){
        return "";
    }

    /**
     * 根据身份证获取性别
     * @param idCard
     * @return
     */
    public static String getSexByIdCard(String idCard){
        return "";
    }

    /**
     * 根据姓名获取拼音全拼
     * @param name
     * @return
     */
    public static String getPYFull(String name){
        return PinyinHelper.toPinyin(name, PinyinStyleEnum.NORMAL);
    }

    public static String hl7ReplaceStr(String str){
        if(StringUtils.isEmpty(str)){
            return "";
        }
        return str.replace("\\X0D0A\\", "\r\n")
                .replace("\\X0D\\\\X0A\\", "\r\n")
                .replace("\\\\r\\\\n", "\r\n")
                .replace("\\S\\", "^");
    }


    public static void main(String[] args) {
        System.out.println(CommonUtils.getUUID());
        System.out.println(CommonUtils.getPYFull("顾越").toUpperCase());
        System.out.println(CommonUtils.hl7ReplaceStr("\\r\\n报告意见：未见上皮内病变及癌变,请在一年内复查。\\r\\n\\r\\n其他:炎性涂片中有非典型细胞"));
    }

}
