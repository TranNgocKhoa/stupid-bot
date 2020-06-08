package com.khoa.bot.dialog;

import com.khoa.bot.context.Context;

public class BasicDialog<T> implements Dialog<T> {
    private Context context;

    @Override
    public void startDialog(Context context) {
        this.context = context;
    }

    @Override
    public void done(Object result) {
        context.onDone(this, result);
    }
}
