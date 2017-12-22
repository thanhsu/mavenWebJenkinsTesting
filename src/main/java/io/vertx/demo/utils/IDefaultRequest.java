package io.vertx.demo.utils;

import java.io.Serializable;

public interface IDefaultRequest extends Serializable {
    boolean validate();
}
