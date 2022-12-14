package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.UnitResultSearchMapper;
import com.healt.cloud.checkup.queryReport.service.UnitResultSearchService;
import com.healt.cloud.checkup.queryReport.vo.PersonListVo;
import com.healt.cloud.checkup.queryReport.vo.PersonTztListDictVo;
import com.healt.cloud.checkup.queryReport.vo.UnitInfoVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 16:21
 */
@Service
@AllArgsConstructor
public class UnitResultSearchServiceImpl implements UnitResultSearchService {

    private UnitResultSearchMapper unitResultSearchMapper;

    @Override
    public List<UnitInfoVo> findUnitInfo(String hospitalId, String unitId) {
        List<UnitInfoVo> list = unitResultSearchMapper.findUnitInfo(hospitalId,unitId);
        if (list.size() == 0) {
            list.add(new UnitInfoVo());
        }
        return list;
    }

    @Override
    public PageResult findPersonList(PersonTztListDictVo personTztListDictVo) {
        List<PersonListVo> listTotal = unitResultSearchMapper.findPersonListTotal(personTztListDictVo);
        int totalSize = listTotal.size();

        List<PersonListVo> list = unitResultSearchMapper.findPersonList(personTztListDictVo);
        if (list.size() == 0) {
            list.add(new PersonListVo());
        }
        int totalPages = totalSize%personTztListDictVo.getPageSize() == 0 ? totalSize / personTztListDictVo.getPageSize() : totalSize / personTztListDictVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonListVo>(personTztListDictVo.getPageNum(), personTztListDictVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }
}
