package com.example.leo.printerdemo;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leo.printerdemo.model.PrinterModel;
import com.example.leo.printerdemo.utils.PrinterUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Dialog mDialog;

    private EditText et_IP, et_port, et_repeat;
    private TextView tv_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (PrinterUtil.getPrinters() == null || PrinterUtil.getPrinters().size() == 0) {
            showSettingDialog();
        } else {
            initView();
        }

    }

    private void initView() {
        et_IP = (EditText) findViewById(R.id.et_ip);
        et_port = (EditText) findViewById(R.id.et_port);
        et_repeat = (EditText) findViewById(R.id.et_repeat);

        tv_count = (TextView) findViewById(R.id.tv_count);
        List<PrinterModel> list = PrinterUtil.getPrinters();
        tv_count.setText("已设置打印机：" + list.size());
        PrinterModel printerModel = list.get(0);
        et_IP.setText(String.valueOf(printerModel.getIp()));
        et_port.setText(String.valueOf(printerModel.getPort()));
        et_repeat.setText(String.valueOf(printerModel.getRepeat()));

    }

    private void showSettingDialog() {
        if (mDialog == null) {
            mDialog = new Dialog(this, android.R.style.Theme_Holo_Dialog_NoActionBar);
            mDialog.setContentView(R.layout.dialog_printer_config);
            mDialog.setCanceledOnTouchOutside(true);
            mDialog.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveData();
                }
            });
        }

        mDialog.show();

    }

    private void saveData() {
        if (mDialog != null) {
            String ip = ((EditText) mDialog.findViewById(R.id.et_ip)).getText().toString();

            String port = ((EditText) mDialog.findViewById(R.id.et_port)).getText().toString();
            String repeat = ((EditText) mDialog.findViewById(R.id.et_repeat)).getText().toString();

            if (TextUtils.isEmpty(ip)) {
                Toast.makeText(this, "请正确输入ip", Toast.LENGTH_SHORT).show();
            }
            if (TextUtils.isEmpty(port)) {
                Toast.makeText(this, "请正确输入端口号", Toast.LENGTH_SHORT).show();
            }
            if (TextUtils.isEmpty(repeat)) {
                Toast.makeText(this, "请正确输入打印份数", Toast.LENGTH_SHORT).show();
            }


            PrinterModel printerModel = new PrinterModel();
            printerModel.setIp(ip);
            printerModel.setPort(Integer.parseInt(port));
            printerModel.setRepeat(Integer.parseInt(repeat));

            PrinterUtil.addPrinter(printerModel);
            mDialog.dismiss();


            initView();
        }
    }
}
