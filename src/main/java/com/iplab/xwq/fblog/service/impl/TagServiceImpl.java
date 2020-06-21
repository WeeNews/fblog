package com.iplab.xwq.fblog.service.impl;

import com.iplab.xwq.fblog.dao.BlogTagMapper;
import com.iplab.xwq.fblog.dao.BlogTagRelationMapper;
import com.iplab.xwq.fblog.entity.BlogTag;
import com.iplab.xwq.fblog.service.TagService;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private BlogTagMapper blogTagMapper;
    @Autowired
    private BlogTagRelationMapper blogTagRelationMapper;


    @Override
    public PageResult getBlogTagPage(PageUtil pageUtil) {
        List<BlogTag> list = blogTagMapper.findTagList(pageUtil);
        int total = blogTagMapper.getTotalTags(pageUtil);
        PageResult pageResult = new PageResult(list,total,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean saveTag(String tagName) {
        BlogTag blogTag = blogTagMapper.selectByTagName(tagName);
        if (blogTag == null){
            BlogTag record = new BlogTag();
            record.setTagName(tagName);
            return blogTagMapper.insertSelective(record) > 0;
        }
        return false;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        List<Long> relations = blogTagRelationMapper.selectDistinctTagIds(ids);
        //正在使用中，不可以删除
        if (!CollectionUtils.isEmpty(relations))
            return false;
        return blogTagMapper.deleteBatch(ids) > 0;
    }
}
