package com.school.service.impl;

import com.school.entity.TIntegralIco;
import com.school.entity.TIntegralIcoExample;
import com.school.mapper.TIntegralIcoMapper;
import com.school.service.IntegralIcoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/12/26.
 */
@Service
public class IntegralIcoServiceImpl implements IntegralIcoService {

    @Autowired
    TIntegralIcoMapper tIntegralIcoMapper;

    @Override
    public TIntegralIco selectFkIdICO(int id) {
        TIntegralIcoExample tIntegralIcoExample = new TIntegralIcoExample();
        tIntegralIcoExample.or().andIdEqualTo(id);
        List<TIntegralIco> list =  tIntegralIcoMapper.selectByExample(tIntegralIcoExample);
        if (list != null && list.size() != 0) {
            for (TIntegralIco tIntegralIco : list) {
                return   tIntegralIco;
            }
        }
        return null;
    }
}
