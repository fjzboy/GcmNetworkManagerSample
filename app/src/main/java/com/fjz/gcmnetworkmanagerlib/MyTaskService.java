package com.fjz.gcmnetworkmanagerlib;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;
import com.orhanobut.logger.Logger;

/**
 * Created by fjz on 06/01/2017.
 */

public class MyTaskService extends GcmTaskService {
    public static int count = 0;
    @Override
    public int onRunTask(TaskParams taskParams) {

        Logger.d("abcdefg = %d", count++);

        long ts = System.currentTimeMillis();

        TaskBean tb = new TaskBean(ts);
        tb.save();

        return GcmNetworkManager.RESULT_SUCCESS;
    }
}
