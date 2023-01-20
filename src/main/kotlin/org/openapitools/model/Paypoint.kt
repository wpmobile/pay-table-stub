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
 * The paypoint the request has been performed on. 
 * @param paypointId The unique payment ID assigned to this paypoint by the merchant. 
 * @param terminalId The payment gateway's unique terminal ID the paypoint is registered with. 
 */
data class Paypoint(

    @Schema(example = "null", description = "The unique payment ID assigned to this paypoint by the merchant. ")
    @field:JsonProperty("paypointId") val paypointId: kotlin.String? = null,

    @get:Size(min=8,max=10)
    @Schema(example = "987654321", description = "The payment gateway's unique terminal ID the paypoint is registered with. ")
    @field:JsonProperty("terminalId") val terminalId: kotlin.String? = null
) {

}

