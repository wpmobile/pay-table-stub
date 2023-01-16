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
 * @param userId The userId defined by the merchant to uniquely identify  user. Must contain only alpha numeric, hypen (-) and underscore (_) characters. 
 * @param billTag The bill tag reference defined by the merchant to uniquely identify the bill with reference to tag say - table or room or invoice. 
 * @param totalAmount The total amount of the Bill in minor currency units. A bill with a negative represents a refund. 
 */
data class CreateBillRequest(

    @get:Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$")
    @get:Size(min=1,max=30)
    @Schema(example = "user_123-A54B3DF", required = true, description = "The userId defined by the merchant to uniquely identify  user. Must contain only alpha numeric, hypen (-) and underscore (_) characters. ")
    @field:JsonProperty("userId", required = true) val userId: kotlin.String,

    @get:Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$")
    @get:Size(min=1,max=30)
    @Schema(example = "TABLE-11 or ROOM-101", description = "The bill tag reference defined by the merchant to uniquely identify the bill with reference to tag say - table or room or invoice. ")
    @field:JsonProperty("billTag") val billTag: kotlin.String? = null,

    @get:DecimalMin("-999999999")
    @Schema(example = "null", description = "The total amount of the Bill in minor currency units. A bill with a negative represents a refund. ")
    @field:JsonProperty("totalAmount") val totalAmount: kotlin.Long? = null
) {

}

