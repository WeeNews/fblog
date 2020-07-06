package com.iplab.xwq.fblog.dao;

import com.iplab.xwq.fblog.entity.BlogLink;
import com.iplab.xwq.fblog.utils.PageUtil;

import java.util.List;

public interface BlogLinkMapper {
    int deleteByPrimaryKey(Integer linkId);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    BlogLink selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);

    List<BlogLink> findLinkList(PageUtil pageUtil);

    int getTotalLinks(PageUtil pageUtil);

    int deleteBatch(Integer[] ids);
}