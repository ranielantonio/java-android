package com.global.api.terminals.abstractions;

import com.global.api.entities.enums.PaymentMethodType;
import com.global.api.entities.enums.SendFileType;
import com.global.api.entities.exceptions.ApiException;
import com.global.api.terminals.builders.TerminalAuthBuilder;
import com.global.api.terminals.builders.TerminalManageBuilder;
import com.global.api.terminals.builders.TerminalReportBuilder;
import com.global.api.terminals.ingenico.variables.ReceiptType;
import com.global.api.terminals.ingenico.variables.ReportTypes;
import com.global.api.terminals.messaging.IBroadcastMessageInterface;
import com.global.api.terminals.messaging.IMessageSentInterface;
import com.global.api.terminals.messaging.IOnPayAtTableRequestInterface;

import java.math.BigDecimal;

public interface IDeviceInterface extends IDisposable {
    void setOnMessageSent(IMessageSentInterface onMessageSent);

    void setOnBroadcastMessageReceived(IBroadcastMessageInterface onBroadcastReceived);

    void setOnPayAtTableRequest(IOnPayAtTableRequestInterface onPayAtTableRequest);

    // admin calls
    IDeviceResponse disableHostResponseBeep() throws ApiException;

    IInitializeResponse initialize() throws ApiException;

    IDeviceResponse reboot() throws ApiException;

    IDeviceResponse reset() throws ApiException;

    IDeviceResponse cancel() throws ApiException;

    IDeviceResponse openLane() throws ApiException;

    IDeviceResponse closeLane() throws ApiException;

    IDeviceResponse startCard(PaymentMethodType paymentMethodType) throws ApiException;

    IDeviceResponse addLineItem(String leftText, String rightText, String runningLeftText, String runningRightText) throws ApiException;

    IDeviceResponse setStoreAndForwardMode(boolean enabled) throws ApiException;

    IDeviceResponse sendFile(SendFileType fileType, String filePath) throws ApiException;

    IDeviceResponse getTerminalConfiguration() throws ApiException;

    IDeviceResponse testConnection() throws ApiException;

    IDeviceResponse getTerminalStatus() throws ApiException;

    // credit calls
    TerminalAuthBuilder creditAuth(BigDecimal amount) throws ApiException;

    TerminalManageBuilder creditCapture(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder creditRefund(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder creditSale(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder creditAuth() throws ApiException;

    TerminalManageBuilder creditCapture() throws ApiException;

    TerminalAuthBuilder creditRefund() throws ApiException;

    TerminalAuthBuilder creditSale() throws ApiException;

    TerminalAuthBuilder creditVerify() throws ApiException;

    TerminalManageBuilder creditVoid() throws ApiException;

    // debit calls
    TerminalAuthBuilder debitSale(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder debitRefund(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder debitSale() throws ApiException;

    TerminalAuthBuilder debitRefund() throws ApiException;

    // gift calls
    TerminalAuthBuilder giftSale(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder giftSale() throws ApiException;

    TerminalAuthBuilder giftAddValue() throws ApiException;

    TerminalAuthBuilder giftAddValue(BigDecimal amount) throws ApiException;

    TerminalManageBuilder giftVoid() throws ApiException;

    TerminalAuthBuilder giftBalance() throws ApiException;

    // ebt calls
    TerminalAuthBuilder ebtBalance() throws ApiException;

    TerminalAuthBuilder ebtPurchase() throws ApiException;

    TerminalAuthBuilder ebtPurchase(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder ebtRefund() throws ApiException;

    TerminalAuthBuilder ebtRefund(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder ebtWithdrawal() throws ApiException;

    TerminalAuthBuilder ebtWithdrawal(BigDecimal amount) throws ApiException;

    // report calls
    // SAFSummaryReport safSummaryReport(SafReportSummary safReportIndicator) throws ApiException;

    // generic calls
    TerminalAuthBuilder authorize(BigDecimal amount) throws ApiException;

    TerminalManageBuilder capture(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder refund(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder sale(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder verify() throws ApiException;

    TerminalManageBuilder referralConfirmation() throws ApiException;

    // reporting
    TerminalReportBuilder getReport(ReportTypes reportTypes) throws ApiException;

    TerminalReportBuilder getLastReceipt(ReceiptType receiptType) throws ApiException;

    // transaction management
    IDeviceResponse duplicate() throws ApiException;

    TerminalManageBuilder reverse(BigDecimal amount) throws ApiException;

    TerminalAuthBuilder payAtTableResponse() throws ApiException;
}
