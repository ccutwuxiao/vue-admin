package com.example.vue.admin.model;

import lombok.Data;

import java.util.List;

@Data
public class UserQueryResponse {
    private Pagination pagination;
    private List<User> list;
}
