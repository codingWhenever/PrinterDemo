package com.example.leo.printerdemo.utils;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.example.leo.printerdemo.model.PrinterModel;

import java.util.List;

/**
 * Created by lulei on 2016/10/18.
 */
public class PrinterUtil {

    /**
     * 查询所有打印机
     *
     * @return
     */
    public static List<PrinterModel> getPrinters() {
        return new Select().
                from(PrinterModel.class).
                execute();
    }

    /**
     * 根据id查询打印机
     *
     * @param printerId
     * @return
     */
    public static PrinterModel getPrinterByID(int printerId) {
        PrinterModel model = new Select()
                .from(PrinterModel.class)
                .where("printer_id=?", printerId)
                .executeSingle();

        return model;

    }

    /**
     * 删除打印机
     *
     * @param printerId
     */
    public static void removePrinter(int printerId) {
//        PrinterModel printerModel = PrinterModel.load(PrinterModel.class, printerId);
//        printerModel.delete();
        //or, you can use like this
        new Delete().from(PrinterModel.class)
                .where("printer_id=?", printerId)
                .execute();
    }

    /**
     * 添加打印机
     * @param printer
     */
    public static void addPrinter(PrinterModel printer) {
        List<PrinterModel> list = getPrinters();
        if (list != null && list.size() < 3) {
            if (!list.contains(printer)) {
                printer.save();
            }

        }
    }

}
