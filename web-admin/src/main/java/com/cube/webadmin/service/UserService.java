package com.cube.webadmin.service;

import com.cube.mall.model.PageVO;
import com.cube.webadmin.vo.UserVO;
import com.github.pagehelper.PageInfo;

import java.text.ParseException;
import java.util.List;

/**
 * @Description:用户管理
 * @Author: yaochenglong
 * @Date: 16:55 2018/10/21
 */
public interface UserService {

    /**
     * 用户登录,返回token
     * @param vo
     * @return
     */
    boolean login(UserVO vo);

    /**
     * 获取所有用户数据
     * @return
     */
    List<UserVO> getAllUser();

    /**
     * 判断当前用户是否是管理员
     * @return
     */
    boolean isAdmin();


    /**
     * 通过roleCode获取拥有改roleCode的所有用户
     * @param roleCode
     * @return
     */
    List<UserVO> getAllUserByRoleCode(String roleCode);
    /**
     * @Description:查询某一个用户，如果有多个，则报错
     * @param vo
     * @return 返回唯一一个用户
     */
    UserVO getUser(UserVO vo);

    /**
     * 通过userName查找用户
     * @param username
     * @return
     */
    UserVO getUserByUserName(String username);

    /**
     * 通过主键id查询用户
     * @param id
     * @return
     */
    UserVO getUserById(String id);
    /**
     * @Description: 已分页方式获取用户
     * @param pageNow : 当前页
     * @param pageSize: 每页显示都条数
     * @Return: 返回带用户数据带分页对象
     * @Author: yaochenglong
     * @Date: Created in 16:57 2018/10/21
     */

    PageInfo<UserVO> getUserByPage(int pageNow, int pageSize);

    /**
     * @Description:
     * @param pageNow
     * @param pageSize
     * @param vo 额外都查询条件
     * @return
     */
    PageInfo<UserVO> getUserByPage(int pageNow, int pageSize, UserVO vo);

    /**
     * @Description:添加用户
     * @param vo
     */
    void addUser(UserVO vo);

    /**
     * 删除用户
     * @param id 用户唯一id
     */
    void delUser(String id);

    /**
     * 通过工号删除用户
     * @param workNum 工号
     */
    void delUserByWorkNum(String workNum);

    /**
     * 修改用户
     * @param vo
     */
    void editUser(UserVO vo);

    /**
     * 修改密码
     * @param UserVO
     */
    void updatePassord(UserVO UserVO);


    PageInfo<UserVO> findByCondition(PageVO<UserVO> pageVO) throws ParseException;

}
