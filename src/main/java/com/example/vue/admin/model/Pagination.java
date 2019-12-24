package com.example.vue.admin.model;

import com.github.pagehelper.PageInfo;
import lombok.Data;

@Data
public class Pagination {

    private int currentPage;

    private int pageSize;

    private int pageCount;

    private Long total;

    public static Pagination fromPageInfo(PageInfo pageInfo) {
        Pagination p = new Pagination();
        p.setCurrentPage(pageInfo.getPageNum());
        p.setPageSize(pageInfo.getPageSize());
        p.setTotal(pageInfo.getTotal());
        return p;
    }

}