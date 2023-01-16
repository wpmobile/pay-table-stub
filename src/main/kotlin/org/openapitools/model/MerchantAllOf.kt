package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.model.MerchantAddress
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
 * Full details of the merchant. 
 * @param name The merchant's name. 
 * @param address 
 */
data class MerchantAllOf(

    @get:Size(min=1,max=40)
    @Schema(example = "Worldpay", description = "The merchant's name. ")
    @field:JsonProperty("name") val name: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("address") val address: MerchantAddress? = null
) {

}

