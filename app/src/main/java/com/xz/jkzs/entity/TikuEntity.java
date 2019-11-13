package com.xz.jkzs.entity;

import java.util.List;

public class TikuEntity {

    /**
     * total : 950
     * pagenum : 1
     * pagesize : 3
     * subject : 1
     * type : C1
     * sort : normal
     * list:
     */

    private String total;
    private String pagenum;
    private String pagesize;
    private String subject;
    private String type;
    private String sort;
    private List<TikuListEntity> list;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPagenum() {
        return pagenum;
    }

    public void setPagenum(String pagenum) {
        this.pagenum = pagenum;
    }

    public String getPagesize() {
        return pagesize;
    }

    public void setPagesize(String pagesize) {
        this.pagesize = pagesize;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<TikuListEntity> getList() {
        return list;
    }

    public void setList(List<TikuListEntity> list) {
        this.list = list;
    }
}
