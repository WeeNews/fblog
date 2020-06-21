package com.iplab.xwq.fblog.service;

import com.iplab.xwq.fblog.entity.Blog;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;


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
}
