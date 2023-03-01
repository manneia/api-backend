package com.luo.project.model.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description 帖子审核状态枚举
 * @author lkx
 */
public enum PostReviewStatusEnum {

    /**
     * 待审核
     */
    REVIEWING("待审核", 0),
    /**
     * 通过
     */
    PASS("通过", 1),
    /**
     * 拒绝
     */
    REJECT("拒绝", 2);

    private final String text;

    private final int value;

    PostReviewStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * @Description 获取返回值
     * @return 返回值列表
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
