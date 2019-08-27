package com.cube.productcenter.po;

import javax.persistence.*;

@Table(name = "t_specifications")
public class TSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 参数名称
     */
    @Column(name = "parameter_name")
    private String parameterName;

    /**
     * 规格组
     */
    @Column(name = "specific_group_id")
    private String specificGroupId;

    /**
     * 分类Id
     */
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 显示位置
     */
    @Column(name = "show_position")
    private String showPosition;

    /**
     * 是否参与查询  0：参与   1：不参与
     */
    @Column(name = "is_query")
    private Integer isQuery;

    /**
     * 是否可见   0：可见   1：隐藏
     */
    @Column(name = "is_visable")
    private Integer isVisable;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取参数名称
     *
     * @return parameter_name - 参数名称
     */
    public String getParameterName() {
        return parameterName;
    }

    /**
     * 设置参数名称
     *
     * @param parameterName 参数名称
     */
    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    /**
     * 获取规格组
     *
     * @return specific_group_id - 规格组
     */
    public String getSpecificGroupId() {
        return specificGroupId;
    }

    /**
     * 设置规格组
     *
     * @param specificGroupId 规格组
     */
    public void setSpecificGroupId(String specificGroupId) {
        this.specificGroupId = specificGroupId;
    }

    /**
     * 获取分类Id
     *
     * @return category_id - 分类Id
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置分类Id
     *
     * @param categoryId 分类Id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取显示位置
     *
     * @return show_position - 显示位置
     */
    public String getShowPosition() {
        return showPosition;
    }

    /**
     * 设置显示位置
     *
     * @param showPosition 显示位置
     */
    public void setShowPosition(String showPosition) {
        this.showPosition = showPosition;
    }

    /**
     * 获取是否参与查询  0：参与   1：不参与
     *
     * @return is_query - 是否参与查询  0：参与   1：不参与
     */
    public Integer getIsQuery() {
        return isQuery;
    }

    /**
     * 设置是否参与查询  0：参与   1：不参与
     *
     * @param isQuery 是否参与查询  0：参与   1：不参与
     */
    public void setIsQuery(Integer isQuery) {
        this.isQuery = isQuery;
    }

    /**
     * 获取是否可见   0：可见   1：隐藏
     *
     * @return is_visable - 是否可见   0：可见   1：隐藏
     */
    public Integer getIsVisable() {
        return isVisable;
    }

    /**
     * 设置是否可见   0：可见   1：隐藏
     *
     * @param isVisable 是否可见   0：可见   1：隐藏
     */
    public void setIsVisable(Integer isVisable) {
        this.isVisable = isVisable;
    }
}