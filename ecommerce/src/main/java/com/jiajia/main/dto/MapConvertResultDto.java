package com.jiajia.main.dto;


import java.util.List;

/**
 * 地图转换结果
 * Created by pyq on 2017-11-20.
 */
public class MapConvertResultDto {

    private String status;
    private List result;
    private double x;
    private double y;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

