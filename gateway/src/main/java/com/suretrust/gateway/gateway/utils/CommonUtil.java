package com.suretrust.gateway.gateway.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CommonUtil {

    public static String getLoadBalancedPath(String path) {
        return "lb://" + path;
    }

    public static String getPrefixPath(String path) {
        return "/" + path;
    }
}
