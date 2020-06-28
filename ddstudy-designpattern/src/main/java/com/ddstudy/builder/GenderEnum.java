package com.ddstudy.builder;

/**
 * @Classname GenderEnum
 * @Description TODO
 * @Date 2020/6/28
 * @Author Grain Rain
 */
public enum GenderEnum {

    MALE("男性"), FEMALE("女性");

    public final String value;

    GenderEnum(String value) {
        this.value = value;
    }

}
