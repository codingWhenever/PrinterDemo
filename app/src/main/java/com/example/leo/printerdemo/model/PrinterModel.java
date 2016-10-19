package com.example.leo.printerdemo.model;

import com.activeandroid.Model;

/**
 * Created by lulei on 2016/10/18.
 */
public class PrinterModel extends Model{
    private String ip;
    private int port;
    private int repeat;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
