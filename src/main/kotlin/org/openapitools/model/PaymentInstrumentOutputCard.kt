package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue
import org.openapitools.model.PaymentCard
import org.openapitools.model.PaymentInstrumentOutputCardAuthorisation
import org.openapitools.model.PaymentInstrumentOutputCardDebug
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
 * Details for a card-based payment instrument. This payment instrument is supported for `sale`, `refund`, `pre-auth`, `check-card` and `check-card-payment` payment types. #        This payment instrument is supported for `sale`, `refund`, `pre-auth`, `check-card`, #        `check-card-payment`, `account-verification` and `account-payment` payment types. 
 * @param type The type of payment instrument. This will also dictate which other payment instrument fields are required to fulfil the payment. 
 * @param card 
 * @param posEntryMode The method of reading the card. The current possible values are: * `keyed` * `magstripe` * `integrated-circuit-chip` * `contactless-chip` * `contactless-magstripe` * `contactless-on-device` * `cardholder-not-present` New values may be added in future without a software release. 
 * @param cardVerificationMethod The verification method used for the cardholder. The current possible values are: * `signature` * `pin-or-consumer-device` * `pin-and-signature` * `cardholder-not-present` * `none` * `unknown` New values may be added in future without a software release. 
 * @param isHandledOnline Indicates whether the payment should be, or has been, performed online or not. 
 * @param authorisation 
 * @param debug 
 */
data class PaymentInstrumentOutputCard(

    @Schema(example = "null", required = true, description = "The type of payment instrument. This will also dictate which other payment instrument fields are required to fulfil the payment. ")
    @field:JsonProperty("type", required = true) val type: PaymentInstrumentOutputCard.Type,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("card") val card: PaymentCard? = null,

    @get:Pattern(regexp="^[a-zA-Z0-9\\-]{1,50}$")
    @Schema(example = "contactless-chip", description = "The method of reading the card. The current possible values are: * `keyed` * `magstripe` * `integrated-circuit-chip` * `contactless-chip` * `contactless-magstripe` * `contactless-on-device` * `cardholder-not-present` New values may be added in future without a software release. ")
    @field:JsonProperty("posEntryMode") val posEntryMode: kotlin.String? = null,

    @get:Pattern(regexp="^[a-zA-Z0-9\\-]{1,50}$")
    @Schema(example = "pin-or-consumer-device", description = "The verification method used for the cardholder. The current possible values are: * `signature` * `pin-or-consumer-device` * `pin-and-signature` * `cardholder-not-present` * `none` * `unknown` New values may be added in future without a software release. ")
    @field:JsonProperty("cardVerificationMethod") val cardVerificationMethod: kotlin.String? = null,

    @Schema(example = "true", description = "Indicates whether the payment should be, or has been, performed online or not. ")
    @field:JsonProperty("isHandledOnline") val isHandledOnline: kotlin.Boolean? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("authorisation") val authorisation: PaymentInstrumentOutputCardAuthorisation? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("debug") val debug: PaymentInstrumentOutputCardDebug? = null
) {

    /**
    * The type of payment instrument. This will also dictate which other payment instrument fields are required to fulfil the payment. 
    * Values: present,keyed,notMinusPresent,token
    */
    enum class Type(val value: kotlin.String) {

        @JsonProperty("card/present") present("card/present"),
        @JsonProperty("card/keyed") keyed("card/keyed"),
        @JsonProperty("card/not-present") notMinusPresent("card/not-present"),
        @JsonProperty("card/token") token("card/token")
    }

}

