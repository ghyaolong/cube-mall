package com.cube.webadmin.service.impl;
import com.cube.IDGenerator;
import com.cube.mall.model.PageVO;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TLogMapper;
import com.cube.webadmin.po.TLog;
import com.cube.webadmin.service.LogService;
import com.cube.webadmin.vo.LogVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private TLogMapper tLogMapper;

    @Override
    public PageInfo<LogVO> getAllPage(PageVO<LogVO> pageVO) {
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
        LogVO logVO = pageVO.getT();
        Example example = new Example(TLog.class);
        example.setOrderByClause("create_time desc");
        Example.Criteria criteria = example.createCriteria();
        if(logVO!=null){
            if(!StringUtils.isEmpty(logVO.getUsername())){
                criteria.andLike("username","%"+logVO.getUsername()+"%");
            }
            if(!StringUtils.isEmpty(logVO.getMethod())){
                criteria.andLike("method","%"+logVO.getMethod().trim()+"%");
            }
            if(!StringUtils.isEmpty(logVO.getMethodCode())){
                criteria.andLike("methodCode","%"+logVO.getMethodCode()+"%");
            }
            if(!StringUtils.isEmpty(logVO.getIp())){
                criteria.andLike("ip","%"+logVO.getIp()+"%");
            }
            if(!StringUtils.isEmpty(logVO.getCreator())){
                criteria.andLike("creator","%"+logVO.getCreator()+"%");
            }
            if(logVO.getStatus()!=null){
                criteria.andEqualTo("state","%"+logVO.getStatus()+"%");
            }
        }
        /*if(searchVo!=null){
            if(!StringUtils.isEmpty(searchVo.getStartDate())&&!StringUtils.isEmpty(searchVo.getEndDate())){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                try {
                    criteria.andBetween("createTime",sdf.parse(searchVo.getStartDate()+"  00:00:00"),sdf.parse(searchVo.getEndDate()+" 23:59:59"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }*/
        List<TLog> tLogInfoList = tLogMapper.selectByExample(example);
        //int count = tLogMapper.selectCountByExample(example);
        List<LogVO> logInfoVos = MyBeanUtils.copyList(tLogInfoList, LogVO.class);

        PageInfo<LogVO> page = new PageInfo<>(logInfoVos);
        /*page.setTotalElements(count);
        page.setPageNum(pageVo.getPageNumber());*/
        return page;
    }

    @Override
    public void add(LogVO logVO) {
        log.info("添加日志，输入参数："+logVO.toString());
        TLog tLogInfo = MyBeanUtils.copy(logVO, TLog.class);
        tLogInfo.setId(IDGenerator.UUID32());
        tLogInfo.setCreateTime(new Date());
        tLogInfo.setName(logVO.getUsername());
        tLogMapper.insertSelective(tLogInfo);
        log.info("添加日志成功");
    }

    @Override
    public void delAll() {
        tLogMapper.deleteByExample(null);
    }

    @Override
    public void delById(String s) {
        tLogMapper.deleteByPrimaryKey(s);
    }
}
