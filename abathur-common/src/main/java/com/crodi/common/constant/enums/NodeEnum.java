package com.crodi.common.constant.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Crodi
 */

@Getter
public enum NodeEnum {


    TAS("TAS", "ACS"),

    ACS("ACS", "DCS"),

    DCS("DCS", null),

    ;


    private final String node;

    private final String nextNode;


    NodeEnum(String node, String nextNode) {
        this.node = node;
        this.nextNode = nextNode;
    }


    public static String getNextNode(String node) {
        return Arrays.stream(NodeEnum.values()).filter(nodeEnum -> Objects.equals(nodeEnum.node, node)).findFirst().map(nodeEnum -> nodeEnum.nextNode).orElse(null);
    }


}
