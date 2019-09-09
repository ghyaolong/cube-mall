package com.cube.webadmin.service;

import com.cube.mall.model.PageVO;
import com.cube.webadmin.vo.LogInfoVO;
import com.cube.webadmin.vo.SearchVO;
import com.github.pagehelper.PageInfo;

public interface LogInfoService {


    /**
     * 分页获取日志信息
     * @param pageVO
     * @return
     */
    PageInfo<LogInfoVO> getAllPage(PageVO pageVO, SearchVO searchVO, LogInfoVO logInfoVO);

    /**
     * 保存日志
     * @param logInfoVo
     */
    void add(LogInfoVO logInfoVo);

    void delAll();

    void delById(String s);
}
