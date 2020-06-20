package com.iplab.xwq.fblog.service;

import com.iplab.xwq.fblog.entity.BlogCategory;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;

import java.util.List;

public interface CategoryService {

    /**
     * @Author xwq
     * @Description  查询分类的分页数据
     * @Date 下午4:47 2020/6/19
     * @Params
     *		@param pageUtil
     * @Return
     *   	@return: com.iplab.xwq.fblog.utils.PageResult
     */
    PageResult getBlogCategoryPage(PageUtil pageUtil);

    int getTotalCategories();

    /**
     * @Author xwq
     * @Description   添加分类数据
     * @Date 下午4:49 2020/6/19
     * @Params
     *		@param categoryName
    	 	@param categoryIcon
     * @Return
     *   	@return: java.lang.Boolean
     */
    Boolean saveCategory(String categoryName,String categoryIcon);

    Boolean updateCategory(Integer categoryId,String categoryName,String categoryIcon);

    Boolean deleteBatch(Integer[] ids);

    List<BlogCategory> getAllCategories();

    BlogCategory selectById(Integer id);

}
