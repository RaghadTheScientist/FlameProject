/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Invoice {
    private int invoiceId;
    private int cashierId; // Foreign key reference
    private int preparerId; //Foreign key
    private String invoiceDate;
    private String invoiceTime;
    private boolean completionState;
    private double totalPrice;
    private String orderType;
    private String paymentType;
  

    // Constructor
    public Invoice(int invoiceId, int cashierId, int preparerId, String invoiceDate, String invoiceTime,
                   boolean completionState, double totalPrice, String orderType, String paymentType) {
        this.invoiceId = invoiceId;
        this.cashierId = cashierId;
        this.preparerId = preparerId;
        this.invoiceDate = invoiceDate;
        this.invoiceTime = invoiceTime;
        this.completionState = completionState;
        this.totalPrice = totalPrice;
        this.orderType = orderType;
        this.paymentType = paymentType;
    }

    // Getters and setters
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId(int cashierId) {
        this.cashierId = cashierId;
    }

    public int getPreparerId() {
        return preparerId;
    }

    public void setPreparerId(int preparerId) {
        this.preparerId = preparerId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public boolean isCompletionState() {
        return completionState;
    }

    public void setCompletionState(boolean completionState) {
        this.completionState = completionState;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    
}
