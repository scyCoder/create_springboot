package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class ActionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<?> rows;

    private Object data;

    private int page = 1;
    private int pageSize = 10;
    private int total;

    private boolean success;
    private int code;
    private String errorMsg;

    @JsonIgnore
    private Throwable throwable;


    public ActionResponse() {

    }

    public ActionResponse(boolean success) {
        this.success = success;
    }

    public ActionResponse(boolean success, List<?> rows) {
        this.success = success;
        this.rows = rows;
    }

    public ActionResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public ActionResponse(boolean success, String errorMsg) {
        this.success = success;
        this.errorMsg = errorMsg;
    }

    public ActionResponse(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.errorMsg = msg;
    }

    public static ActionResponse success(List<?> rows) {
        ActionResponse ret = new ActionResponse(true, rows);
        ret.total = rows.size();
        return ret;
    }

    public static ActionResponse successWithData(List<?> rows) {
        ActionResponse ret = new ActionResponse(true);
        ret.total = rows.size();
        ret.data = rows;
        return ret;
    }

    public static ActionResponse success() {
        ActionResponse ret = new ActionResponse(true);
        return ret;
    }

    public static ActionResponse success(int total) {
        ActionResponse ret = new ActionResponse(true);
        ret.total = total;
        return ret;
    }

    public static ActionResponse success(Object data) {
        ActionResponse ret = new ActionResponse(true, data);
        ret.success = true;
        return ret;
    }

    public static ActionResponse error(String errorMsg) {
//		throw new ActionResponseException(HttpStatus.BAD_REQUEST,errorMsg);
        return new ActionResponse(false, errorMsg);
    }

    public static ActionResponse feignError(String errorMsg) {
        return new ActionResponse(false, errorMsg);
    }

    public static ActionResponse error(Object data) {
        return new ActionResponse(false, data);
    }

    public static ActionResponse errorf(String errorMsg, Object... args) {
        return error(String.format(errorMsg, args));
    }

    public static ActionResponse error(Throwable e) {
        ActionResponse resp = new ActionResponse(false, e.getMessage());
        resp.setThrowable(e);
        return resp;
    }

    public static ActionResponse error(int code, String errorMsg) {
        ActionResponse ret = new ActionResponse(false, errorMsg);
        ret.code = code;
        return ret;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ActionResponse{" +
                "rows=" + rows +
                ", data=" + data +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", total=" + total +
                ", success=" + success +
                ", code=" + code +
                ", errorMsg='" + errorMsg +
                ", throwable=" + throwable +
                '}';
    }
}
