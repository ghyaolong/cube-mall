package com.cube.productcenter.service.impl;

import com.cube.mall.exception.BizException;
import com.cube.productcenter.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author tututu
 * @desc todo
 * @Date 2019/9/6 18:06
 * @email 289911401@qq.com
 */
public class BaseServiceImpl<T> implements BaseService<T> {

    // 注入mapper
    @Autowired
    private Mapper<T> mapper;

    // 缓存子类泛型类型
    private Class<T> cache=null;


    /**
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     *
     *
     * @Param: id  主键id
     * @return: pojo单个实体对象
     **/
    public T queryByPrimaryKey( Object key){
        return this.mapper.selectByPrimaryKey(key);
    }

    /**
     * @Description: 查询所有对象
     *
     *
     * @Param: 无
     * @return: java.util.List<T> list对象
     **/
    public List<T> queryAll(){
        return this.mapper.select(null);
    }


    /**
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     *
     *
     * @Param: param 条件
     * @return: java.util.List<T> 返回多条记录
     **/
    public List<T> queryListByWhere(T pojo){
        return this.mapper.select(pojo);
    }


    /**
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     *
     *
     * @Param: pojo 实体对象
     * @return: 记录数
     **/
    public int queryCount(T pojo){
        return this.mapper.selectCount(pojo);
    }



    public T queryOne(T pojo){
        return this.mapper.selectOne(pojo);
    }


    public PageInfo<T> queryPageListByWhere(T pojo, int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<T> list =  this.mapper.select(pojo);
        return new PageInfo<T>(list);

    }


    public PageInfo<T>  queryPageListByField(Integer pageNo, Integer pageSize, Sqls whereSqls, String orderByField, String ascOrDesc, String ...fields){
        return new PageInfo<T>(queryByFiledBase(pageNo,pageSize,whereSqls,orderByField, ascOrDesc, fields));
    }


    private List<T> queryByFiledBase(Integer pageNo,Integer pageSize,Sqls whereSqls,String orderByField, String ascOrDesc, String ...fields){
        Example.Builder builder=null;
        if(null==fields||fields.length==0){
            //查询所有
            builder = Example.builder(getTypeArguement());

        }else{
            //查询指定字段,where的内容拿出来进行动态sql拼接
            builder= Example.builder(getTypeArguement()).select(fields);
        }
        if(whereSqls!=null){
            builder=builder.where(whereSqls);
        }

        if(orderByField!=null){
            if (ascOrDesc.toUpperCase().equals("DESC")){
                builder= builder
                        .orderByDesc(orderByField);
            }else{
                builder= builder
                        .orderByAsc(orderByField);
            }
        }
        Example example=builder.build();

        if(pageNo!=null&&pageSize!=null) {
            // 分页插件
            PageHelper.startPage(pageNo, pageSize);
        }
        List list = this.mapper.selectByExample(example);
        return  list;
    }


    public Class<T> getTypeArguement() {
        if(cache==null)
            cache= (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return  cache;
    }

    /**
     * @Description: 插入一个pojo对象,null的属性也会保存，不会使用数据库默认值
     *
     *
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int save(T pojo){
        return this.mapper.insert(pojo);
    }

    /**
     * @Description: 插入非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Param: pojo 实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int saveSelect(T pojo){
        return this.mapper.insertSelective(pojo);
    }

    /**
     * @Description: 批量插入对象，非空字段,null的属性不会保存，会使用数据库默认值
     *
     *
     * @Param:  list 实体对象集合
     * @return: 如果数值大于0 则成功，null为失败
     **/
    public int batchSave(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = mapper.insertSelective(record);
            result += count;
        }
        return result;
    }

    /**
     * @Description: 根据主键更新实体全部字段，null值会被更新
     *
     *
     * @Param: pojo  实体对象
     * @return: 如果数值大于0则成功，null为失败
     **/
    public int update(T pojo){
        return this.mapper.updateByPrimaryKey(pojo);
    }

    /**
     * @Description: 根据主键更新属性不为null的值
     *
     *
     * @Param: pojo 实体对象
     * @return:  如果数值大于0 则成功，null为失败
     **/
    public int updateSelective(T pojo){
        return this.mapper.updateByPrimaryKeySelective(pojo);
    }

    /**
     * @Description: 根据主键删除记录
     *
     *
     * @Param: id 主键id
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByPrimaryKey(T key){
        return this.mapper.deleteByPrimaryKey(key);
    }

    /**
     * @Description: 根据主键的list集合,批量删除对象
     *
     *
     * @Param: clazz 实体对象
     * @Param: ids 主键的list集合
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByIds(Class<T> clazz,List<Object> ids){
        // where条件
        Example example = new Example(clazz);
        example.createCriteria().andIn("id", ids);
        return this.mapper.deleteByExample(example);
        /*
           等效于where id in (#{ids})
         */
    }

    /**
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     *
     *
     * @Param: pojo 实体对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int  deleteByWhere(T pojo){
        return this.mapper.delete(pojo);
    }

    /**
     * @Description: 批量删除对象，根据实体属性作为条件进行删除，查询条件使用等号
     * @Param:
     * @Param:
     * @return:
     **/
    public int batchDelete(List<T> list) {
        int result = 0;
        for (T record : list) {
            int count = mapper.delete(record);
            if (count < 1) {
                throw new BizException("500","删除数据失败!");
            }
            result += count;
        }
        return result;
    }

    /**
     * @Description: 根据Example条件进行删除
     *
     *
     * @Param:  example 查询条件对象
     * @return: 删除的记录数量,如果数值大于0 则成功，null为失败
     **/
    public int deleteByExample(Object example){
        return this.mapper.deleteByPrimaryKey(example);
    }

}
