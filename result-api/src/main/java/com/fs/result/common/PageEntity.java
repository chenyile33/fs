package com.fs.result.common;

/**
 * @author chenyile
 * @date 2022/5/23  18:27
 * @description: 统一分页信息
 */
public class PageEntity {
    //总数量
    private int total;
    //总页数
    private int pages;
    //页码
    private int pageNum = 1;
    //每页大小
    private int pageSize = 10;

    public PageEntity() {

    }

    public PageEntity(int total, int pages, int pageNum, int pageSize) {
        this.total = total;
        this.pages = pages;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        pages = total / pageSize;
        if (total % this.pageSize != 0) {
            ++pages;
        }
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum > 0) {
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
    }
}
