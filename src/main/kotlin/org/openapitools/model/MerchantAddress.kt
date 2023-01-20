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
 * The merchant's address. 
 * @param line1 Line 1 of the address 
 * @param line2 Line 2 of the address 
 * @param line3 Line 3 of the address 
 * @param city City of the address 
 * @param state State/County/Region of the address 
 * @param postalCode Postal code (Post/Zip code) of the address 
 * @param countryCode The 2-letter ISO-3166-1 country code of the address 
 */
data class MerchantAddress(

    @get:Size(min=1,max=140)
    @Schema(example = "Worldpay", description = "Line 1 of the address ")
    @field:JsonProperty("line1") val line1: kotlin.String? = null,

    @get:Size(min=1,max=140)
    @Schema(example = "The Walbrook Building", description = "Line 2 of the address ")
    @field:JsonProperty("line2") val line2: kotlin.String? = null,

    @get:Size(min=1,max=140)
    @Schema(example = "25, Walbrook", description = "Line 3 of the address ")
    @field:JsonProperty("line3") val line3: kotlin.String? = null,

    @get:Size(min=1,max=140)
    @Schema(example = "City of London", description = "City of the address ")
    @field:JsonProperty("city") val city: kotlin.String? = null,

    @get:Size(min=1,max=140)
    @Schema(example = "Greater London", description = "State/County/Region of the address ")
    @field:JsonProperty("state") val state: kotlin.String? = null,

    @get:Size(min=1,max=8)
    @Schema(example = "EC4N 8AF", description = "Postal code (Post/Zip code) of the address ")
    @field:JsonProperty("postalCode") val postalCode: kotlin.String? = null,

    @get:Size(min=2,max=2)
    @Schema(example = "GB", description = "The 2-letter ISO-3166-1 country code of the address ")
    @field:JsonProperty("countryCode") val countryCode: kotlin.String? = null
) {

}

