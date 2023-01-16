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
 * @param userId user id
 * @param userName user name
 */
data class User(

    @Schema(example = "null", description = "user id")
    @field:JsonProperty("userId") val userId: kotlin.String? = null,

    @Schema(example = "null", description = "user name")
    @field:JsonProperty("userName") val userName: kotlin.String? = null
) {

}

