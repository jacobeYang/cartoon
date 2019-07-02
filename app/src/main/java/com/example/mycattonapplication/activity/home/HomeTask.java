package com.example.mycattonapplication.activity.home;

import android.os.AsyncTask;

//void 不需要给后台任务传参数   Integer整数作为进度条显示单位   Boolean作为执行结果类型
public class HomeTask extends AsyncTask<Void,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);

    }
}
