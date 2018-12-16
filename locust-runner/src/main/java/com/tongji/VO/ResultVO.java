package com.tongji.VO;

import java.io.Serializable;

public class ResultVO {
    private int state;
    private String msg;
    private Object data;

    public int getState() {

        return state;
        }

    public void setState(int state) {

        this.state = state;
        }

    public String getMsg() {

        return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
}
