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
 * Data for Dynamic Currency Conversion if relevant to the payment. 
 * @param convertedCurrencyCode The 3-letter ISO 4217 currency code which amounts are specified in. 
 * @param convertedAmount An amount of money in minor currency units. 
 * @param conversionRate The conversion rate from the merchant's currency to the cardholder's local currency. 
 */
data class PaymentDetailsValueDcc(

    @get:Size(min=3,max=3)
    @Schema(example = "GBP", required = true, description = "The 3-letter ISO 4217 currency code which amounts are specified in. ")
    @field:JsonProperty("convertedCurrencyCode", required = true) val convertedCurrencyCode: kotlin.String,

    @get:Min(0L)
    @get:Max(999999999L)
    @Schema(example = "1099", required = true, description = "An amount of money in minor currency units. ")
    @field:JsonProperty("convertedAmount", required = true) val convertedAmount: kotlin.Long,

    @get:DecimalMin("0")
    @Schema(example = "1.11647", required = true, description = "The conversion rate from the merchant's currency to the cardholder's local currency. ")
    @field:JsonProperty("conversionRate", required = true) val conversionRate: kotlin.Double
) {

}

