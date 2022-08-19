package com.tosan.bookstore.models;

import com.tosan.bookstore.utils.enums.EnumDescription;

public enum InvoiceState implements BaseEnum {
    @EnumDescription("پیش نویس")
    Draft,
    @EnumDescription("حذف شده")
    Deleted,
    @EnumDescription("صادر شده")
    Issued,
    @EnumDescription("انصراف داده  شده")
    Cancelled,
    @EnumDescription("منقضی شده")
    Expired,
    @EnumDescription("پرداخت شده")
    Paid;
}
