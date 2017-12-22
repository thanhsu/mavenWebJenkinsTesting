package io.vertx.demo.utils;

import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.MessageCodec;

import java.io.*;

public class ObjectMessageCodec {

    public void encodeToWireObject(Buffer buffer, Object request) {
        ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
        ObjectOutput output = null;

        try {
            output = new ObjectOutputStream(byteOS);
            output.writeObject(request);
            output.flush();
            byte[] outBytes = byteOS.toByteArray();

            // Write data into given buffer
            buffer.appendInt(outBytes.length);
            buffer.appendBytes(outBytes);
        } catch (IOException e) {
            WTradeLogger.print(ObjectMessageCodec.class.toString(),
                    String.format("%s | %s",
                            e.getClass().getName(),
                            e.getMessage()),
                    WTradeLogger.ERROR_MESSAGE);
//            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    WTradeLogger.print(ObjectMessageCodec.class.toString(),
                            String.format("Encode | %s | %s",
                                    e.getClass(),
                                    e.getMessage()),
                            WTradeLogger.ERROR_MESSAGE);
                }
            }
            try {
                byteOS.close();
            } catch (IOException e) {
                WTradeLogger.print(ObjectMessageCodec.class.toString(),
                        String.format("Encode | %s | %s",
                                e.getClass(),
                                e.getMessage()),
                        WTradeLogger.ERROR_MESSAGE);
            }
        }

//        String json2String = jsonObj.encode();
//
//        int length = json2String.getBytes().length;

//        // Write data into given buffer
//        buffer.appendInt(length);
//        buffer.appendString(json2String);

    }

    public Object decodeFromWireObject(int i, Buffer buffer) {
        int length = buffer.getInt(i);

        Object request = null;
        byte[] bytes = buffer.getBytes(i += 4, i += length);
        ByteArrayInputStream byteIS = new ByteArrayInputStream(bytes);
        ObjectInput input = null;

        try {
            input = new ObjectInputStream(byteIS);
            request = input.readObject();

        } catch (IOException | ClassNotFoundException e) {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e1) {
                    WTradeLogger.print(ObjectMessageCodec.class.toString(),
                            String.format("Decode | %s | %s",
                                    e.getClass().getName(),
                                    e.getMessage()),
                            WTradeLogger.ERROR_MESSAGE);
//                    e1.printStackTrace();
                }
            }
            WTradeLogger.print(ObjectMessageCodec.class.toString(),
                    String.format("Decode | %s | %s",
                            e.getClass().getName(),
                            e.getMessage()),
                    WTradeLogger.ERROR_MESSAGE);
//            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    WTradeLogger.print(ObjectMessageCodec.class.toString(),
                            String.format("Decode | %s | %s",
                                    e.getClass().getName(),
                                    e.getMessage()),
                            WTradeLogger.ERROR_MESSAGE);
//                    e.printStackTrace();
                }
            }
            try {
                byteIS.close();
            } catch (IOException e) {
                WTradeLogger.print(ObjectMessageCodec.class.toString(),
                        String.format("Decode | %s | %s",
                                e.getClass().getName(),
                                e.getMessage()),
                        WTradeLogger.ERROR_MESSAGE);
//                    e.printStackTrace();
            }

        }
        return request;
    }
}
