package com.khoa.bot.callback;

import com.khoa.bot.context.Context;

@FunctionalInterface
public interface DialogResumeCallBack {
    void accept(Context context, Object result);
}
