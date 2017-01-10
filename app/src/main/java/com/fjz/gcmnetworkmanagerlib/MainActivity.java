package com.fjz.gcmnetworkmanagerlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;
import com.orhanobut.logger.Logger;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TASK_TAG_PERIODIC = "gcmnetwork_task_service";

    private GcmNetworkManager mGcmNetworkManager= null;
    private TextView tvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvList = (TextView) findViewById(R.id.tv_list);

        mGcmNetworkManager = GcmNetworkManager.getInstance(getApplicationContext());
    }

    public void startBgTask(View view) {
        Logger.d("button is clicked");

        PeriodicTask task = new PeriodicTask.Builder()
                .setService(MyTaskService.class)
                .setTag(TASK_TAG_PERIODIC)
                .setPeriod(30L)
                .setRequiredNetwork(Task.NETWORK_STATE_UNMETERED)
                .setPersisted(true)
                .build();


        mGcmNetworkManager.schedule(task);
    }

    public void showTasks(View view) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<TaskBean> list  = DataSupport.findAll(TaskBean.class);

        StringBuilder sb = new StringBuilder();

        for (TaskBean bean : list) {
            sb.append(sdf.format(bean.getTimestamp())).append("\n");
        }

        tvList.setText(sb.toString());
    }
}
