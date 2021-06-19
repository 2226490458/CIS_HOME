package com.example.demo.dtos.sys;

/**
 * @author 青菜白玉堂
 * @create 2021-06-19
 */
public class UserPermDTO {
    private String permName;
    private Integer code;

    @Override
    public String toString() {
        return "UserPermDTO{" +
                "permName='" + permName + '\'' +
                ", code=" + code +
                '}';
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
