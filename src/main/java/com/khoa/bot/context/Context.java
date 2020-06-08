package com.khoa.bot.context;

import com.khoa.bot.callback.DialogResumeCallBack;
import com.khoa.bot.dialog.BasicDialog;
import com.khoa.bot.dialog.Dialog;
import com.khoa.bot.model.Message;

public interface Context {
    void post(String message);

    void post(Message message);

    void call(Dialog<?> dialog, DialogResumeCallBack callBack);

    void onDone(BasicDialog<?> tBasicDialog, Object result);
}
