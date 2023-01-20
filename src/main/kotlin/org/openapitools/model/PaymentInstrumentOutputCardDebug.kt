package org.openapitools.model

import java.util.Objects
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
 * 
 * @param transactionStatusInfo Transaction Status Information (TSI), present only in case of an ICC payment. Used for debug purpose only. 
 * @param transactionVerificationResults Transaction Verification Results (TVR), present only in case of an ICC payment. Used for debug purpose only. 
 */
data class PaymentInstrumentOutputCardDebug(

    @get:Pattern(regexp="^[0-9A-F]{1,4}$")
    @get:Size(min=1,max=4)
    @Schema(example = "F800", description = "Transaction Status Information (TSI), present only in case of an ICC payment. Used for debug purpose only. ")
    @field:JsonProperty("transactionStatusInfo") val transactionStatusInfo: kotlin.String? = null,

    @get:Pattern(regexp="^[0-9A-F]{1,10}$")
    @get:Size(min=1,max=10)
    @Schema(example = "4000008000", description = "Transaction Verification Results (TVR), present only in case of an ICC payment. Used for debug purpose only. ")
    @field:JsonProperty("transactionVerificationResults") val transactionVerificationResults: kotlin.String? = null
) {

}

