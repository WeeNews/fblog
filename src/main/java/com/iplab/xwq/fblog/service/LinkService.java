package com.iplab.xwq.fblog.service;

import com.iplab.xwq.fblog.entity.BlogLink;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;

public interface LinkService {

    PageResult getBlogLinkPage(PageUtil pageUtil);

    Boolean saveLink(BlogLink link);

    BlogLink selectById(Integer Id);

    Boolean updateLink(BlogLink link);

    Boolean deleteBatch(Integer[] ids);
}
