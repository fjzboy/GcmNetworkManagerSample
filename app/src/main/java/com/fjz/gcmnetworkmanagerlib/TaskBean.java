package com.fjz.gcmnetworkmanagerlib;

import org.litepal.crud.DataSupport;

/**
 * Created by fjz on 06/01/2017.
 */

public class TaskBean extends DataSupport {

    private int id;
    private long timestamp;

    public TaskBean(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
