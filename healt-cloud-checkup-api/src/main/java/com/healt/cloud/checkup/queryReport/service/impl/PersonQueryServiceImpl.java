package com.healt.cloud.checkup.queryReport.service.impl;

import com.healt.cloud.checkup.mapper.appointmentReg.PersonQueryMapper;
import com.healt.cloud.checkup.queryReport.service.PersonQueryService;
import com.healt.cloud.checkup.queryReport.vo.PersonQueryDictVo;
import com.healt.cloud.checkup.queryReport.vo.PersonQueryVo;
import com.healt.cloud.common.pages.PageResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author linklee
 * @create 2022-05-26 10:27
 */
@Service
@AllArgsConstructor
public class PersonQueryServiceImpl implements PersonQueryService {

    private PersonQueryMapper personQueryMapper;

    @Override
    public PageResult findPersonQuery(PersonQueryDictVo personQueryDictVo) {
        List<PersonQueryVo> listTotal = personQueryMapper.findPersonQueryTotal(personQueryDictVo);
        int totalSize = listTotal.size();

        List<PersonQueryVo> list = personQueryMapper.findPersonQuery(personQueryDictVo);
        if (list.size() == 0) {
            list.add(new PersonQueryVo());
        }
        int totalPages = totalSize%personQueryDictVo.getPageSize() == 0 ? totalSize / personQueryDictVo.getPageSize() : totalSize / personQueryDictVo.getPageSize() + 1;
        PageResult result = new PageResult<PersonQueryVo>(personQueryDictVo.getPageNum(), personQueryDictVo.getPageSize(), totalSize, totalPages, list);
        return result;
    }
}
