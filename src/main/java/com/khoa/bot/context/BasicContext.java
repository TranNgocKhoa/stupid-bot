package com.khoa.bot.context;

import com.khoa.bot.callback.DialogResumeCallBack;
import com.khoa.bot.client.SendApiClient;
import com.khoa.bot.dialog.BasicDialog;
import com.khoa.bot.dialog.Dialog;
import com.khoa.bot.model.Message;
import com.khoa.bot.model.MessageRequest;
import com.khoa.bot.model.Recipient;
import com.khoa.bot.model.User;

import java.util.Stack;

public class BasicContext implements Context {
    private final User user;
    private Stack<Dialog<?>> dialogStack;
    private Stack<DialogResumeCallBack> callBackStack;
    private final SendApiClient sendApiClient;

    public BasicContext(User user, SendApiClient sendApiClient) {
        this.callBackStack = new Stack<>();
        this.dialogStack = new Stack<>();
        this.sendApiClient = sendApiClient;
        this.user = user;
    }

    public Stack<Dialog<?>> getDialogStack() {
        return dialogStack;
    }

    public void setDialogStack(Stack<Dialog<?>> dialogStack) {
        this.dialogStack = dialogStack;
    }

    public SendApiClient getSendApiClient() {
        return sendApiClient;
    }

    @Override
    public void post(String message) {
        MessageRequest messageRequest = this.getContextMessageRequest();
        messageRequest.setMessage(Message.text(message));

        this.post(messageRequest);
    }

    @Override
    public void post(Message message) {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessage(message);

        this.post(messageRequest);
    }

    @Override
    public void call(Dialog<?> dialog, DialogResumeCallBack callBack) {
        this.dialogStack.push(dialog);
        dialog.startDialog(this);
    }

    @Override
    public void onDone(BasicDialog<?> tBasicDialog, Object result) {
        this.dialogStack.pop();
        this.callBackStack.pop().accept(this, result);
    }

    private void post(MessageRequest messageRequest) {
        sendApiClient.sendApi(messageRequest);
    }

    private MessageRequest getContextMessageRequest() {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setRecipient(Recipient.of(this.user.getPSId()));

        return messageRequest;
    }
}
