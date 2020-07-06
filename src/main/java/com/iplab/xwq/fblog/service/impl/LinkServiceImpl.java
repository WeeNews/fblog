package com.iplab.xwq.fblog.service.impl;

import com.iplab.xwq.fblog.dao.BlogLinkMapper;
import com.iplab.xwq.fblog.entity.BlogLink;
import com.iplab.xwq.fblog.service.LinkService;
import com.iplab.xwq.fblog.utils.PageResult;
import com.iplab.xwq.fblog.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LinkServiceImpl implements LinkService {

    @Resource
    private BlogLinkMapper blogLinkMapper;

    @Override
    public PageResult getBlogLinkPage(PageUtil pageUtil) {
        List<BlogLink> blogLinks = blogLinkMapper.findLinkList(pageUtil);
        int total = blogLinkMapper.getTotalLinks(pageUtil);
        PageResult pageResult = new PageResult(blogLinks,total,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean saveLink(BlogLink link) {
        return blogLinkMapper.insertSelective(link) > 0;
    }

    @Override
    public BlogLink selectById(Integer Id) {
        return blogLinkMapper.selectByPrimaryKey(Id);
    }

    @Override
    public Boolean updateLink(BlogLink link) {
        return blogLinkMapper.updateByPrimaryKeySelective(link) > 0;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return blogLinkMapper.deleteBatch(ids) > 0;
    }
}
