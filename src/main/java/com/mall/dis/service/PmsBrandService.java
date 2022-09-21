package com.mall.dis.service;

import com.mall.dis.entity.PmsBrand;
import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author shujingping
 * @since 2022-09-15
 */
public interface PmsBrandService {
    /**
     * @return List<PmsBrand>
     */
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand pmsBrand);

    int updateBrand(Long id, PmsBrand pmsBrand);

}
