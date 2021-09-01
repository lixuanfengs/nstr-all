package com.nstr.common.core.utils;

import java.util.HashMap;

/**
 * @author MrBird
 */
public class NstrResponse extends HashMap<String, Object> {

    private static final long serialVersionUID = -8713837118340960775L;

    public NstrResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public NstrResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    @Override
    public NstrResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getMessage() {
        return String.valueOf(get("message"));
    }

    public Object getData() {
        return get("data");
    }
}
