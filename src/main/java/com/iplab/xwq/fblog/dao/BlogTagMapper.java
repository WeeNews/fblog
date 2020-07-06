package com.iplab.xwq.fblog.dao;

import com.iplab.xwq.fblog.entity.BlogTag;
import com.iplab.xwq.fblog.entity.BlogTagCount;
import com.iplab.xwq.fblog.utils.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    List<BlogTag> findTagList(PageUtil pageUtil);

    int getTotalTags(PageUtil pageUtil);

    int deleteBatch(Integer[] ids);

    int batchInsertBlogTag(List<BlogTag> tagList);

    List<BlogTagCount> getTagCount();
}