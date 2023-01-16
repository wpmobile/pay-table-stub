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
 * The date (month and year) associated with the card. 
 * @param month 
 * @param year 
 */
data class CardDate(

    @get:Min(1)
    @get:Max(12)
    @Schema(example = "12", required = true, description = "")
    @field:JsonProperty("month", required = true) val month: kotlin.Int,

    @get:Min(0)
    @get:Max(99)
    @Schema(example = "20", required = true, description = "")
    @field:JsonProperty("year", required = true) val year: kotlin.Int
) {

}

