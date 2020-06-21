package com.iplab.xwq.fblog.service;

import com.iplab.xwq.fblog.entity.BlogTag;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;

public interface TagService {

    PageResult getBlogTagPage(PageUtil pageUtil);
    Boolean saveTag(String tagName);
    Boolean deleteBatch(Integer[] ids);
}
