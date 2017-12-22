package io.vertx.demo.utils;

import io.vertx.demo.utils.WTradeRequest;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

import java.io.*;

public class ActionRequestCodec extends ObjectMessageCodec implements MessageCodec<WTradeRequest, WTradeRequest> {
    public ActionRequestCodec() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void encodeToWire(Buffer buffer, WTradeRequest request) {
        super.encodeToWireObject(buffer, request);

//        String json2String = jsonObj.encode();
//
//        int length = json2String.getBytes().length;

//        // Write data into given buffer
//        buffer.appendInt(length);
//        buffer.appendString(json2String);

    }

    @Override
    public WTradeRequest decodeFromWire(int i, Buffer buffer) {
        return (WTradeRequest) super.decodeFromWireObject(i, buffer);
    }

    @Override
    public WTradeRequest transform(WTradeRequest request) {
        return request;
    }

    @Override
    public String name() {
        return "actionRequestCodec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
