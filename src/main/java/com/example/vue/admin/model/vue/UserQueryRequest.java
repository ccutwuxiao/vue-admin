package com.example.vue.admin.model.vue;

import com.example.vue.admin.model.Pagination;
import lombok.Data;

@Data
public class UserQueryRequest {
    private Pagination pagination;
    private String name;
}
