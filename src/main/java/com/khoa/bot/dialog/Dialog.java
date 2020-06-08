package com.khoa.bot.dialog;

import com.khoa.bot.context.Context;

public interface Dialog<T> {
    void startDialog(Context context);

    void done(Object result);
}
