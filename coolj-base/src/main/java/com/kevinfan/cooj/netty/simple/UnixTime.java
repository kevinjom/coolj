package com.kevinfan.cooj.netty.simple;

import java.util.Date;

/**
 * Created by kevinjom on 14-10-13.
 */
public class UnixTime {
    private int timestamp;

    public UnixTime(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return new Date(timestamp * 1000).toString();
    }
}
