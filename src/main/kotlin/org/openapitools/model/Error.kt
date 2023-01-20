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
 * @param errorName A machine and human readable error type for clarity and semantic understanding of the error.
 * @param message A human readable message giving a corrective action for the error. This is not for machine consumption.
 */
data class Error(

    @Schema(example = "null", required = true, description = "A machine and human readable error type for clarity and semantic understanding of the error.")
    @field:JsonProperty("errorName", required = true) val errorName: kotlin.String,

    @Schema(example = "null", required = true, description = "A human readable message giving a corrective action for the error. This is not for machine consumption.")
    @field:JsonProperty("message", required = true) val message: kotlin.String
) {

}

