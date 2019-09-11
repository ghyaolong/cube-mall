package com.cube.webadmin.service;

import com.cube.mall.model.PageVO;
import com.cube.webadmin.vo.LogVO;
import com.cube.webadmin.vo.SearchVO;
import com.github.pagehelper.PageInfo;

public interface LogService {


    /**
     * 分页获取日志信息
     * @param pageVO
     * @return
     */
    PageInfo<LogVO> getAllPage(PageVO<LogVO> pageVO);

    /**
     * 保存日志
     * @param logVO
     */
    void add(LogVO logVO);

    void delAll();

    void delById(String s);
}
