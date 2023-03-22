package org.openapitools.model

class GetBillsResponse(
    val billId: String,
    val billTag: String,
    val totalAmount: Int,
    val userId: String,
    val billDateTime: String,
    val status: String,
    val itemizedBill: String,
    val paymentDetails: List<PaymentDetails>?
)