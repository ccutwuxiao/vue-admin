package com.example.vue.admin.model;

import lombok.Data;

@Data
public class UserQueryRequest {
    private Pagination pagination;
    private String name;
}
