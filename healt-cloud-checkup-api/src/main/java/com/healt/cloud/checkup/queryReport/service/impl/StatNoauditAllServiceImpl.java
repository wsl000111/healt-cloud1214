package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.StatNoauditAllMapper;
import com.healt.cloud.checkup.queryReport.service.StatNoauditAllService;
import com.healt.cloud.checkup.queryReport.vo.PersonNotFinalListVo;
import com.healt.cloud.checkup.queryReport.vo.StrWherePageVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linklee
 * @create 2022-05-26 15:30
 */
@Service
@AllArgsConstructor
public class StatNoauditAllServiceImpl implements StatNoauditAllService {

    private StatNoauditAllMapper statNoauditAllMapper;

    @Override
    public PageResult findPersonNotFinalList(StrWherePageVo strWherePageVo) {
        List<PersonNotFinalListVo> listTotal = statNoauditAllMapper.findPersonNotFinalListTotal(strWherePageVo);
        int totalSize = listTotal.size();

        List<PersonNotFinalListVo> list = statNoauditAllMapper.findPersonNotFinalList(strWherePageVo);
        if (list.size() == 0) {
            list.add(new PersonNotFinalListVo());
        }
        int totalPages = totalSize%strWherePageVo.getPageSize() == 0 ? totalSize / strWherePageVo.getPageSize() : totalSize / strWherePageVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonNotFinalListVo>(strWherePageVo.getPageNum(), strWherePageVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }

    @Override
    public List findUnitCount(String unitId) {
        String max = statNoauditAllMapper.findUnitCount(unitId);
        if (max == null) {
            max = "";
        }
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("max",max);
        list.add(map);
        return list;
    }
}
