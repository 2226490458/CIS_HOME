package com.example.demo.common.entityEnum;

/**
 * @author 青菜白玉堂
 * @create 2021-06-18
 */
public enum PermEnum {
    admin("管理员", 1),
    common("普通用户", 2)
    ;
    private String name;
    private Integer code;
    private PermEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public static String getSexName(Integer code) {
        for (SexEnum sexEnum: SexEnum.values()) {
            if (sexEnum.getCode().equals(code)) {
                return sexEnum.getName();
            }
        }
        return null;
    }

    public static Integer getSexCode(String name) {
        for (SexEnum sexEnum: SexEnum.values()) {
            if (sexEnum.getName().equals(name)) {
                return sexEnum.getCode();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
