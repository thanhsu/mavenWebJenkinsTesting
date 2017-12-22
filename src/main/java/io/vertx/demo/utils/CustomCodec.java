package io.vertx.demo.utils;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;
import io.vertx.core.json.JsonObject;

public class CustomCodec implements MessageCodec<MessObj, MessObj> {
    public CustomCodec() {
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
    public void encodeToWire(Buffer buffer, MessObj messObj) {
        JsonObject jsonObj = new JsonObject();

        jsonObj.put("mess", messObj.getMess());
        jsonObj.put("key", messObj.getKey());
        jsonObj.put("value", messObj.getValue());

        String json2String = jsonObj.encode();

        int length = json2String.getBytes().length;

        buffer.appendInt(length);
        buffer.appendString(json2String);
    }

    @Override
    public MessObj decodeFromWire(int i, Buffer buffer) {

        int length = buffer.getInt(i);

        String jsonStr = buffer.getString(i += 4, i += length);

        JsonObject jsonObj = new JsonObject(jsonStr);

        String mess = jsonObj.getString("mess");
        String receiver = jsonObj.getString("receiver");
        String sender = jsonObj.getString("sender");


        return new MessObj(mess, receiver, sender);
    }

    @Override
    public MessObj transform(MessObj messObj) {
        return messObj;
    }

    @Override
    public String name() {
        return "customCodec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
