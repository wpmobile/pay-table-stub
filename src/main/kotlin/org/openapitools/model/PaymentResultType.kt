package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
* The type of payment that was requested. * `sale` - *Authorise and settle a payment from a customer for goods/services.* * `refund` - *Authorise and settle a payment to a customer for the return of goods/services.* * `pre-auth` - *Authorise a payment from a customer, but settle the payment separately using the `payment/settle` channel.* * `check-card` - *Check and retrieve details of the customer's card, without taking a payment.* * `check-card-payment` - *Check and retrieve details of the customer's card, and wait for the payment request on this card.* * `cancel` - *The cancellation of a previously requested `sale`, `refund`, or `pre-auth`.* * `settle` - *The settlement of a previously requested `pre-auth`.* 
* Values: sale,refund,preMinusAuth,checkMinusCard,checkMinusCardMinusPayment,cancel,settle
*/
enum class PaymentResultType(val value: kotlin.String) {

    @JsonProperty("sale") sale("sale"),
    @JsonProperty("refund") refund("refund"),
    @JsonProperty("pre-auth") preMinusAuth("pre-auth"),
    @JsonProperty("check-card") checkMinusCard("check-card"),
    @JsonProperty("check-card-payment") checkMinusCardMinusPayment("check-card-payment"),
    @JsonProperty("cancel") cancel("cancel"),
    @JsonProperty("settle") settle("settle")
}

