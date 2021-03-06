package com.iplab.xwq.fblog.service;

import com.iplab.xwq.fblog.entity.Blog;
import com.iplab.xwq.fblog.entity.vo.BlogDetailVO;
import com.iplab.xwq.fblog.entity.vo.SimpleBlogListVO;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;

import java.util.List;


public interface BlogService {
    String saveBlog(Blog blog);

    Blog getBlogById(Long blogId);

    /**
     * 后台修改
     *
     * @param blog
     * @return
     */
    String updateBlog(Blog blog);

    PageResult getBlogsPage(PageUtil pageUtil);

    Boolean deleteBatch(Integer[] ids);

    /**
     * 首页侧边栏数据列表
     * 0-点击最多 1-最新发布
     *
     * @param type
     * @return
     */
    List<SimpleBlogListVO> getBlogListForIndexPage(int type);

    /**
     * 获取首页文章列表
     *
     * @param page
     * @return
     */
    PageResult getBlogsForIndexPage(int page);

    PageResult getBlogsPageBySearch(String keyword, int page);

    /**
     * 根据分类获取文章列表
     *
     * @param categoryName
     * @param page
     * @return
     */
    PageResult getBlogsPageByCategory(String categoryName, int page);


    /**
     * 根据标签获取文章列表
     *
     * @param tagName
     * @param page
     * @return
     */
    PageResult getBlogsPageByTag(String tagName, int page);

    /**
     * 文章详情获取
     *
     * @param blogId
     * @return
     */
    BlogDetailVO getBlogDetail(Long blogId);
}
