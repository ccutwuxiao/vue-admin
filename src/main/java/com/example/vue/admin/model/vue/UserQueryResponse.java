package com.example.vue.admin.model.vue;

import com.example.vue.admin.model.Pagination;
import lombok.Data;

import java.util.List;

@Data
public class UserQueryResponse {
    private Pagination pagination;
    private List<User> list;
}
