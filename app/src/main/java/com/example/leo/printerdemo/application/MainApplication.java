package com.example.leo.printerdemo.application;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.example.leo.printerdemo.model.PrinterModel;
import com.example.leo.printerdemo.utils.PrinterUtil;

import java.util.List;

/**
 * Created by lulei on 2016/10/18.
 */
public class MainApplication extends Application {

    private static MainApplication sMainApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sMainApplication = this;
        ActiveAndroid.initialize(this);
        initData();

    }

    private void initData() {
        List<PrinterModel> list = PrinterUtil.getPrinters();
        if (list == null || list.size() == 0) {

        }
    }


}
