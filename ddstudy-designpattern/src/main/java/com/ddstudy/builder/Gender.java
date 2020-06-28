package com.ddstudy.builder;

/**
 * @Classname Gender
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public enum Gender {

    MALE("男性"), FEMALE("女性");

    public final String value;

    Gender(String value) {
        this.value = value;
    }

}
