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
 * Identifies the merchant that originates the payment. 
 * @param merchantId The payment gateway's merchant ID to identify the merchant. 
 */
data class MerchantIdentifier(

    @get:Size(min=8,max=10)
    @Schema(example = "12345678", required = true, description = "The payment gateway's merchant ID to identify the merchant. ")
    @field:JsonProperty("merchantId", required = true) val merchantId: kotlin.String
) {

}

