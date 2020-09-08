package com.global.api.terminals.ingenico.responses;

import com.global.api.terminals.ingenico.variables.DynamicCurrencyStatus;
import com.global.api.terminals.ingenico.variables.PaymentMethod;
import com.global.api.terminals.ingenico.variables.RepFieldCode;
import com.global.api.terminals.ingenico.variables.TransactionSubTypes;
import com.global.api.utils.TypeLengthValue;
import java.math.BigDecimal;

public class DataResponse {

    private String _authCode;
    private BigDecimal _finalAmount;
    private PaymentMethod _paymentMethod;
    private BigDecimal _cashbackAmount;
    private BigDecimal _gratuityAmount;
    private BigDecimal _availableAmount;
    private String _dccCode;
    private BigDecimal _dccAmount;
    private TransactionSubTypes _txnSubType;
    private BigDecimal _splitSaleAmount;
    private DynamicCurrencyStatus _dccStatus;
    private TypeLengthValue _tlv;

    private byte[] _buffer;

    public DataResponse(byte[] buffer) {
        _tlv = new TypeLengthValue(buffer);
        ParseData();
    }

    public String getAuthorizationCode() {
        return _authCode != null ? _authCode : "";
    }

    private void setAuthorizationCode(String value) {
        _authCode = value;
    }

    public BigDecimal getFinalAmount() {
        return _finalAmount;
    }

    public void setFinalAmount(BigDecimal value) {
        _finalAmount = value;
    }

    public PaymentMethod getPaymentMethod() {
        return _paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod value) {
        _paymentMethod = value;
    }

    public BigDecimal getCashbackAmount() {

        return _cashbackAmount;
    }

    public void setCashbackAmount(BigDecimal value) {
        _cashbackAmount = value;
    }

    public BigDecimal getGratuityAmount() {
        return _gratuityAmount;
    }

    public void setGratuityAmount(BigDecimal value) {
        _gratuityAmount = value;
    }

    public BigDecimal getAvailableAmount() {
        return _availableAmount;
    }

    public void setAvailableAmount(BigDecimal value) {
        _availableAmount = value;
    }

    public String getDccCode() {
        return _dccCode;
    }

    public void setDccCode(String value) {
        _dccCode = value;
    }

    public BigDecimal getDccAmount() {
        return _dccAmount;
    }

    public void setDccAmount(BigDecimal value) {
        _dccAmount = value;
    }

    public TransactionSubTypes getTransactionSubType() {
        return _txnSubType;
    }

    public void setTransactionSubType(TransactionSubTypes value) {
        _txnSubType = value;
    }

    public BigDecimal getSplitSaleAmount() {
        return _splitSaleAmount;
    }

    public void setSplitSaleAmount(BigDecimal value) {
        _splitSaleAmount = value;
    }

    public DynamicCurrencyStatus getDccStatus() {
        return _dccStatus;
    }

    public void setDccStatus(DynamicCurrencyStatus value) {
        _dccStatus = value;
    }

    private void ParseData() {
        try {
            _authCode = (String) _tlv.getValue((byte) RepFieldCode.Authcode.getRepFieldCode(), String.class, null);
            _cashbackAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.CashbackAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _gratuityAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.GratuityAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _finalAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.FinalTransactionAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _availableAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.AvailableAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _dccCode = (String) _tlv.getValue((byte) RepFieldCode.DccCurrency.getRepFieldCode(), String.class, null);
            _dccAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.DccConvertedAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _txnSubType = (TransactionSubTypes) _tlv.getValue((byte) RepFieldCode.TransactionSubType.getRepFieldCode(),
                    TransactionSubTypes.class, null);
            _dccStatus = (DynamicCurrencyStatus) _tlv.getValue((byte) RepFieldCode.DccOperationStatus.getRepFieldCode(),
                    DynamicCurrencyStatus.class, null);
            _splitSaleAmount = (BigDecimal) _tlv.getValue((byte) RepFieldCode.SplitSalePaidAmount.getRepFieldCode(),
                    BigDecimal.class, null);
            _paymentMethod = (PaymentMethod) _tlv.getValue((byte) RepFieldCode.PaymentMethod.getRepFieldCode(),
                    PaymentMethod.class, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
