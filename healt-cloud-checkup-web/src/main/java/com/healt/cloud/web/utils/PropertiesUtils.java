package com.healt.cloud.web.utils;

/**
 * @author GuYue
 * @date 2022-09-14 13:59
 * @description: TODO
 */
public class PropertiesUtils {

    /**
     * 短信验证码
     */
    //生产
    public static final String SMS_HTTPS_URL = "https://112.35.10.201:58888/sms/submit";
    public static final String EC_NAME = "威海高区利民医院有限公司.";
    public static final String AP_ID = "gqlmtj";
    public static final String CONTENT = "【健康管理中心】验证码为：code，10分钟内有效。切勿将验证码提供给他人。";
    public static final String SIGN = "QCi5wgISc";
    public static final String ADD_SERIAL = "106575371130";
    public static final String SECRET_KEY= "GQlm_tj@2022";

    //测试
//    public static final String SMS_HTTPS_URL = "https://112.35.10.201:28888/sms/submit";
//    public static final String EC_NAME = "接口联调账号";
//    public static final String AP_ID = "whlmyy";
//    public static final String CONTENT = "【威海高区利民医院健康管理中心】验证码为：code，10分钟内有效。切勿将验证码提供给他人。";
//    public static final String SIGN = "bM16CfN2B";
//    public static final String ADD_SERIAL = "10657204006";
//    public static final String SECRET_KEY= "passwd@1342H";


    /**
     * 接口
     */

    //测试
    public static final String HOME_PAGE_INFO = "http://192.168.40.194:8085/pdf/homePageInfo";
    public static final String PERSON_REPORT_LIST = "http://192.168.40.194:8085/pdf/personReportList";
    public static final String PERSON_REPORT_LIST_BIND = "http://192.168.40.194:8085/pdf/personReportListBind";
    public static final String WEB_PERSON_ORDERS_LIST = "http://192.168.40.194:8085/pdf/webPersonOrdersList";
    public static final String WEB_PERSON_ORDERS_LIST_BIND = "http://192.168.40.194:8085/pdf/webPersonOrdersListBind";
    public static final String DOWNLOAD_PDF_FILE = "http://192.168.40.194:8085/pdf/downloadPdfFile";
    public static final String LOGIN = "http://192.168.40.194:8085/pdf/login";
    public static final String REGEIST = "http://192.168.40.194:8085/pdf/regeist";
    public static final String TARGET_URL = "http://192.168.40.194:8081/download/";
    public static final String ADD_BIND_PERSON = "http://192.168.40.194:8085/bind/addBindPerson";
    public static final String SELECT_BIND_PERSON = "http://192.168.40.194:8085/bind/selectBindPerson";
    public static final String DELETE_BIND_PERSON = "http://192.168.40.194:8085/bind/deleteBindPerson";

    public static final String HC_PACK_SET_DICT_LIST = "http://192.168.40.194:8085/pdf/hcPackSetDictList";
    public static final String HC_ITEM_PACK_DICT_LIST = "http://192.168.40.194:8085/pdf/hcItemPackDictList";
    public static final String WEB_PACK_SET_VIEW_LIST = "http://192.168.40.194:8085/pdf/webPackSetViewList";
    public static final String WEB_PACK_SET_LIST = "http://192.168.40.194:8085/pdf/webPackSetList";

    public static final String CHECK_UP_ORDER = "http://192.168.40.194:8085/pdf/checkUpOrder";

    //生产
//    public static final String HOME_PAGE_INFO = "http://10.131.3.216:8085/pdf/homePageInfo";
//    public static final String PERSON_REPORT_LIST = "http://10.131.3.216:8085/pdf/personReportList";
//    public static final String PERSON_REPORT_LIST_BIND = "http://10.131.3.216:8085/pdf/personReportListBind";
//    public static final String WEB_PERSON_ORDERS_LIST = "http://10.131.3.216:8085/pdf/webPersonOrdersList";
//    public static final String WEB_PERSON_ORDERS_LIST_BIND = "http://10.131.3.216:8085/pdf/webPersonOrdersListBind";
//    public static final String DOWNLOAD_PDF_FILE = "http://10.131.3.216:8085/pdf/downloadPdfFile";
//    public static final String LOGIN = "http://10.131.3.216:8085/pdf/login";
//    public static final String REGEIST = "http://10.131.3.216:8085/pdf/regeist";
//    public static final String TARGET_URL = "http://tj.whgqyy.cn:8081/download/";
//    public static final String ADD_BIND_PERSON = "http://10.131.3.216:8085/bind/addBindPerson";
//    public static final String SELECT_BIND_PERSON = "http://10.131.3.216:8085/bind/selectBindPerson";
//    public static final String DELETE_BIND_PERSON = "http://10.131.3.216:8085/bind/deleteBindPerson";
//
//    public static final String HC_PACK_SET_DICT_LIST = "http://10.131.3.216:8085/pdf/hcPackSetDictList";
//    public static final String HC_ITEM_PACK_DICT_LIST = "http://10.131.3.216:8085/pdf/hcItemPackDictList";
//    public static final String WEB_PACK_SET_VIEW_LIST = "http://10.131.3.216:8085/pdf/webPackSetViewList";
//    public static final String WEB_PACK_SET_LIST = "http://10.131.3.216:8085/pdf/webPackSetList";
//
//    public static final String CHECK_UP_ORDER = "http://10.131.3.216:8085/pdf/checkUpOrder";

}
