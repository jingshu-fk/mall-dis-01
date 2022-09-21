package com.mall.dis.service.impl;

import com.mall.dis.entity.PmsBrand;
import com.mall.dis.mapper.PmsBrandMapper;
import com.mall.dis.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hc
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    private static final Logger logger = LoggerFactory.getLogger(PmsBrandServiceImpl.class);

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        List<PmsBrand> pmsBrands = pmsBrandMapper.selectList(null);
        logger.info("查询成功");
        return pmsBrands;
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return pmsBrandMapper.updateById(pmsBrand);
    }
}
