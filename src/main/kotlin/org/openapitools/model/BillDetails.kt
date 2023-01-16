package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.model.BillStatus
import org.openapitools.model.PaymentDetails
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
 * @param status 
 * @param billId A unique Id associated with this bill 
 * @param billTag A Tag associated with the given BillId. e.g. Table/Room 
 * @param totalAmount The total amount of the Bill in minor currency units. A bill with a negative represents a refund. 
 * @param userId User who is assigned to this bill. 
 * @param billDateTime The most recent timestamp associated with bill. 
 * @param itemizedBill An itemized bill from Order management. 
 * @param paymentDetails 
 */
data class BillDetails(

    @field:Valid
    @Schema(example = "null", required = true, description = "")
    @field:JsonProperty("status", required = true) val status: BillStatus,

    @Schema(example = "null", readOnly = true, description = "A unique Id associated with this bill ")
    @field:JsonProperty("billId") val billId: kotlin.String? = null,

    @Schema(example = "null", readOnly = true, description = "A Tag associated with the given BillId. e.g. Table/Room ")
    @field:JsonProperty("billTag") val billTag: kotlin.String? = null,

    @get:DecimalMin("-999999999")
    @Schema(example = "null", readOnly = true, description = "The total amount of the Bill in minor currency units. A bill with a negative represents a refund. ")
    @field:JsonProperty("totalAmount") val totalAmount: kotlin.Long? = null,

    @Schema(example = "null", readOnly = true, description = "User who is assigned to this bill. ")
    @field:JsonProperty("userId") val userId: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", readOnly = true, description = "The most recent timestamp associated with bill. ")
    @field:JsonProperty("billDateTime") val billDateTime: java.time.OffsetDateTime? = null,

    @get:Pattern(regexp="^[?@+'\"`~^%&\\*\\[\\]\\{\\}.!#|\\\\\\($¢€£₽₹¥₿฿元);,:;=/\\(\\),\\-\\w\\s+]*$")
    @get:Size(min=0,max=10000)
    @Schema(example = "null", readOnly = true, description = "An itemized bill from Order management. ")
    @field:JsonProperty("itemizedBill") val itemizedBill: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("paymentDetails") val paymentDetails: kotlin.collections.List<PaymentDetails>? = null
) {
}

