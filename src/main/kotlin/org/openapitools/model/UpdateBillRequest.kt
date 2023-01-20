package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import org.openapitools.model.PaymentDetails
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
 * 
 * @param userId The userId defined by the merchant to uniquely identify  user. Must contain only alpha numeric, hypen (-) and underscore (_) characters. 
 * @param status All possible values for bill.  `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill 
 * @param paymentDetails 
 */
data class UpdateBillRequest(

    @get:Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$")
    @get:Size(min=1,max=30)
    @Schema(example = "user_123-A54B3DF", required = true, description = "The userId defined by the merchant to uniquely identify  user. Must contain only alpha numeric, hypen (-) and underscore (_) characters. ")
    @field:JsonProperty("userId", required = true) val userId: kotlin.String,

    @Schema(example = "null", required = true, description = "All possible values for bill.  `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill ")
    @field:JsonProperty("status", required = true) val status: UpdateBillRequest.Status,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("paymentDetails") val paymentDetails: kotlin.collections.List<PaymentDetails>? = null
) {

    /**
    * All possible values for bill.  `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill 
    * Values: inMinusProgress,partialMinusComplete,pending,complete,cancel
    */
    enum class Status(val value: kotlin.String) {

        @JsonProperty("in-progress") inMinusProgress("in-progress"),
        @JsonProperty("partial-complete") partialMinusComplete("partial-complete"),
        @JsonProperty("pending") pending("pending"),
        @JsonProperty("complete") complete("complete"),
        @JsonProperty("cancel") cancel("cancel")
    }

}

