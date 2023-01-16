package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.model.CardDate
import org.openapitools.model.CardType
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
 * Data for the card used in the payment. 
 * @param tokenId A token representing a card used in a payment. This will be returned in the result of a card payment if tokenisation is enabled, and can be sent in the request for payment with a `card/token` payment instrument. The following token formats are supported: * **Alphanumeric token** – this token uses an alternating sequence of upper case letters and numbers, and is always 15 digits long. The letters I and O are never used due to their similarity with numbers. Useful if you do not require a numeric token, and prefer the token  to be clearly distinguished from card numbers. * **Wrapped luhn fail token** – this token consists of between 16 and 21 digits, and the first two digits are always 99. These tokens will not pass through luhn (modulus 10) checks. Useful if you want to avoid possible issues with regard to PCI DSS compliance checks, because tokens will not be mistaken for a card number. * **Wrapped luhn pass token** – this token consists of between 16 and 21 digits, and the first two digits are always 99. These tokens will pass through luhn (modulus 10) checks. Useful if you have system validation that requires your token to be similar to a card number. * **Format preserving token** – this token uses a part of the card number used to create it, and is always 20 digits long. The first two digits are always 99. The next six digits are the first six numbers on the card used. The final four digits are the last four numbers on the card used. 
 * @param cardNumber The Primary Account Number of the card. For whitelisted cards the full card number can be returned, for all other cards the number is masked. The first 6 digits and last 4 digits are returned, the middle digits are replaced by `X`. 
 * @param expiryDate 
 * @param track2Data The Track 2 data of the card as defined by ISO 7813. Available for whitelisted BIN ranges for `check-card` and `check-card-payment` transactions. 
 * @param type 
 * @param issuerCode A reference which can be used to identify the issuer of card. ##### Major card schemes * `amex` - *Amex* * `bank-of-america` - *Bank of America* * `dankort` - *DANKORT* * `diners` - *Diners Club International* * `discover` - *Discover* * `jcb` - *JCB* * `maestro-uk` - *UK Maestro* * `maestro` - *Maestro* * `mastercard-debit` - *Debit Mastercard* * `mastercard-purchasing` - *Mastercard Purchasing* * `mastercard` - *Mastercard* * `us-debit` - *US Debit* * `visa-debit` - *VISA DEBIT* * `visa-electron-uk` - *UK Electron* * `visa-purchasing` - *Visa Purchasing* * `visa` - *Visa* * `visa-atm` - *VISA ATM* ##### Store cards and gift cards * `arval-phh` - *ARVAL PHH* * `flexecash-love-2-reward` - *Flexecash Love 2 Reward* * `harvey-nichols` - *HN PLCC* * `harvey-nichols-mastercard` - *HN Mastercard* * `newday-mastercard` - *Newday MasterCard* * `newday-staff` - *Newday Staff Card* * `newday-store` - *Newday Store PLC* * `newday-temporary` - *Newday Temporary* * `pps-gift` - *PPS Gift Card* * `tesco-clubcard` - *Tesco Clubcard* New values may be added without a software release. 
 * @param countryCode The 3-digit numeric ISO 3166 code for the country the card was issued in. 
 * @param panSequenceNumber The PAN Sequence number for ICC payments, and the card's issue number for swiped UK Maestro/Solo card payments. 
 * @param applicationLabel The mnemonic associated with the application ID (AID) of the card used for the payment according to ISO/IEC 7816-5. 
 * @param applicationIdentifier The application ID (AID) of the card used for the payment according to ISO/IEC 7816-5.  *Note – For VISA Contactless Cards, truncated EMV Card Data Element Application Identifier (AID) will be received instead Extended AID.* 
 * @param applicationEffectiveDate The date from which the application can be used. Represented as a full-date according to RFC 3339, section 5.6. 
 */
data class PaymentCard(

    @get:Pattern(regexp="^[0-9a-zA-Z]{15,21}$")
    @get:Size(min=15,max=21)
    @Schema(example = "532931432DB44ABB5", description = "A token representing a card used in a payment. This will be returned in the result of a card payment if tokenisation is enabled, and can be sent in the request for payment with a `card/token` payment instrument. The following token formats are supported: * **Alphanumeric token** – this token uses an alternating sequence of upper case letters and numbers, and is always 15 digits long. The letters I and O are never used due to their similarity with numbers. Useful if you do not require a numeric token, and prefer the token  to be clearly distinguished from card numbers. * **Wrapped luhn fail token** – this token consists of between 16 and 21 digits, and the first two digits are always 99. These tokens will not pass through luhn (modulus 10) checks. Useful if you want to avoid possible issues with regard to PCI DSS compliance checks, because tokens will not be mistaken for a card number. * **Wrapped luhn pass token** – this token consists of between 16 and 21 digits, and the first two digits are always 99. These tokens will pass through luhn (modulus 10) checks. Useful if you have system validation that requires your token to be similar to a card number. * **Format preserving token** – this token uses a part of the card number used to create it, and is always 20 digits long. The first two digits are always 99. The next six digits are the first six numbers on the card used. The final four digits are the last four numbers on the card used. ")
    @field:JsonProperty("tokenId") val tokenId: kotlin.String? = null,

    @get:Pattern(regexp="^[0-9]{6}[X0-9]{3,9}[0-9]{4}$")
    @get:Size(min=13,max=19)
    @Schema(example = "492949XXXXXX0002", description = "The Primary Account Number of the card. For whitelisted cards the full card number can be returned, for all other cards the number is masked. The first 6 digits and last 4 digits are returned, the middle digits are replaced by `X`. ")
    @field:JsonProperty("cardNumber") val cardNumber: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("expiryDate") val expiryDate: CardDate? = null,

    @get:Pattern(regexp="^\\;([0-9]{1,19})\\=([0-9]{4}|\\=)([0-9]{3}|\\=)([^\\?]+)\\?$")
    @get:Size(min=7,max=40)
    @Schema(example = ";1234567890123445=99011200XXXX00000000?*", description = "The Track 2 data of the card as defined by ISO 7813. Available for whitelisted BIN ranges for `check-card` and `check-card-payment` transactions. ")
    @field:JsonProperty("track2Data") val track2Data: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "")
    @field:JsonProperty("type") val type: CardType? = null,

    @get:Pattern(regexp="^[a-zA-Z0-9\\-]{1,256}$")
    @get:Size(min=1,max=256)
    @Schema(example = "visa-debit", description = "A reference which can be used to identify the issuer of card. ##### Major card schemes * `amex` - *Amex* * `bank-of-america` - *Bank of America* * `dankort` - *DANKORT* * `diners` - *Diners Club International* * `discover` - *Discover* * `jcb` - *JCB* * `maestro-uk` - *UK Maestro* * `maestro` - *Maestro* * `mastercard-debit` - *Debit Mastercard* * `mastercard-purchasing` - *Mastercard Purchasing* * `mastercard` - *Mastercard* * `us-debit` - *US Debit* * `visa-debit` - *VISA DEBIT* * `visa-electron-uk` - *UK Electron* * `visa-purchasing` - *Visa Purchasing* * `visa` - *Visa* * `visa-atm` - *VISA ATM* ##### Store cards and gift cards * `arval-phh` - *ARVAL PHH* * `flexecash-love-2-reward` - *Flexecash Love 2 Reward* * `harvey-nichols` - *HN PLCC* * `harvey-nichols-mastercard` - *HN Mastercard* * `newday-mastercard` - *Newday MasterCard* * `newday-staff` - *Newday Staff Card* * `newday-store` - *Newday Store PLC* * `newday-temporary` - *Newday Temporary* * `pps-gift` - *PPS Gift Card* * `tesco-clubcard` - *Tesco Clubcard* New values may be added without a software release. ")
    @field:JsonProperty("issuerCode") val issuerCode: kotlin.String? = null,

    @get:Pattern(regexp="^[0-9]{3}$")
    @get:Size(min=3,max=3)
    @Schema(example = "826", description = "The 3-digit numeric ISO 3166 code for the country the card was issued in. ")
    @field:JsonProperty("countryCode") val countryCode: kotlin.String? = null,

    @get:Pattern(regexp="^[0-9]{2}$")
    @get:Size(min=2,max=2)
    @Schema(example = "01", description = "The PAN Sequence number for ICC payments, and the card's issue number for swiped UK Maestro/Solo card payments. ")
    @field:JsonProperty("panSequenceNumber") val panSequenceNumber: kotlin.String? = null,

    @get:Size(min=1,max=16)
    @Schema(example = "VISA BARCLAYCARD", description = "The mnemonic associated with the application ID (AID) of the card used for the payment according to ISO/IEC 7816-5. ")
    @field:JsonProperty("applicationLabel") val applicationLabel: kotlin.String? = null,

    @get:Pattern(regexp="^[A-Z0-9]{10,32}$")
    @get:Size(min=10,max=32)
    @Schema(example = "A0000000031010", description = "The application ID (AID) of the card used for the payment according to ISO/IEC 7816-5.  *Note – For VISA Contactless Cards, truncated EMV Card Data Element Application Identifier (AID) will be received instead Extended AID.* ")
    @field:JsonProperty("applicationIdentifier") val applicationIdentifier: kotlin.String? = null,

    @field:Valid
    @Schema(example = "null", description = "The date from which the application can be used. Represented as a full-date according to RFC 3339, section 5.6. ")
    @field:JsonProperty("applicationEffectiveDate") val applicationEffectiveDate: java.time.LocalDate? = null
) {

}

