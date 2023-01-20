package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.model.PaymentDetailsValueDcc
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
 * The monetary value of the payment. 
 * @param amount An amount of money in minor currency units. 
 * @param currencyCode The 3-letter ISO 4217 currency code which amounts are specified in. 
 * @param cashbackAmount An amount of money in minor currency units. 
 * @param gratuityAmount An amount of money in minor currency units. 
 * @param donationAmount An amount of money in minor currency units. 
 * @param dcc 
 */
data class PaymentDetailsValue(

    @get:Min(0L)
    @get:Max(999999999L)
    @Schema(example = "1099", required = true, description = "An amount of money in minor currency units. ")
    @field:JsonProperty("amount", required = true) val amount: kotlin.Long,

    @get:Size(min=3,max=3)
    @Schema(example = "GBP", required = true, description = "The 3-letter ISO 4217 currency code which amounts are specified in. ")
    @field:JsonProperty("currencyCode", required = true) val currencyCode: kotlin.String,

    @get:Min(0L)
    @get:Max(999999999L)
    @Schema(example = "1099", description = "An amount of money in minor currency units. ")
    @field:JsonProperty("cashbackAmount") val cashbackAmount: kotlin.Long? = null,

    @get:Min(0L)
    @get:Max(999999999L)
    @Schema(example = "1099", description = "An amount of money in minor currency units. ")
    @field:JsonProperty("gratuityAmount") val gratuityAmount: kotlin.Long? = null,

    @get:Min(0L)
    @get:Max(999999999L)
    @Schema(example = "1099", description = "An amount of money in minor currency units. ")
    @field:JsonProperty("donationAmount") val donationAmount: kotlin.Long? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("dcc") val dcc: PaymentDetailsValueDcc? = null
) {

}

