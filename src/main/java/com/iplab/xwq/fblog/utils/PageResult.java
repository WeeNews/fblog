package com.iplab.xwq.fblog.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author xwq
 * @Description
 * @Date 下午12:10 2020/6/17
 */
public class PageResult implements Serializable {

    private int totalCount;//总记录数
    private int pageSize; //每页记录数
    private int totalPage;//总页数
    private int currPage; //当前页数
    private List<?> list; //列表数据

    public PageResult(List<?> list,int totalCount,int pageSize,int currPage){
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
