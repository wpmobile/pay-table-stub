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
* All possible values for bill.  `ready` - used to get the bill from order management   `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill 
* Values: inMinusProgress,partialMinusComplete,pending,complete,cancel,ready
*/
enum class BillStatus(val value: kotlin.String) {

    @JsonProperty("in-progress") inMinusProgress("in-progress"),
    @JsonProperty("partial-complete") partialMinusComplete("partial-complete"),
    @JsonProperty("pending") pending("pending"),
    @JsonProperty("complete") complete("complete"),
    @JsonProperty("cancel") cancel("cancel"),
    @JsonProperty("ready") ready("ready")
}

