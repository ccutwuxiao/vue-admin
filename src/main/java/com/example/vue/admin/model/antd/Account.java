package com.example.vue.admin.model.antd;

public class Account {
    /**
     * status : ok
     * type : null
     * currentAuthority : admin
     */

    private String status;
    private String type;
    private String currentAuthority;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }
}
