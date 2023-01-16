package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonValue
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
* The code representing the result of payment request. 
* Values: authorisedMinusOnline,authorisedMinusOffline,authorisedMinusReferral,keyedMinusRecoveryMinusSuccess,preMinusAuthMinusCompleted,succeeded,refusedMinusOnline,refusedMinusOffline,refusedMinusOnlineMinusCaptureMinusCard,refusedMinusAvsMinusRequired,cancelled,aborted,abortedMinusDeviceMinusUnavailable,abortedMinusBusy,started,inMinusProgress,authMinusCompleted,rejectedMinusPreMinusAuth,rejectedMinusCardMinusNumberMinusNotMinusMatched,rejectedMinusCardMinusExpiryMinusDateMinusNotMinusMatched,rejectedMinusCardMinusNotMinusAccepted,invalidMinusTransactionMinusState,invalidMinusOperation,invalidMinusGatewayMinusTransactionsMinusReference,invalidMinusMerchant,invalidMinusTerminal,invalidMinusMerchantMinusStatus,invalidMinusCardMinusNumber,invalidMinusExpiredMinusCard,invalidMinusIssueMinusNumber,invalidMinusCardMinusExpiryMinusDate,deniedMinusTransaction,deniedMinusCashback,preMinusValidMinusCard,failed
*/
enum class TransactionResultCode(val value: kotlin.String) {

    @JsonProperty("authorised-online") authorisedMinusOnline("authorised-online"),
    @JsonProperty("authorised-offline") authorisedMinusOffline("authorised-offline"),
    @JsonProperty("authorised-referral") authorisedMinusReferral("authorised-referral"),
    @JsonProperty("keyed-recovery-success") keyedMinusRecoveryMinusSuccess("keyed-recovery-success"),
    @JsonProperty("pre-auth-completed") preMinusAuthMinusCompleted("pre-auth-completed"),
    @JsonProperty("succeeded") succeeded("succeeded"),
    @JsonProperty("refused-online") refusedMinusOnline("refused-online"),
    @JsonProperty("refused-offline") refusedMinusOffline("refused-offline"),
    @JsonProperty("refused-online-capture-card") refusedMinusOnlineMinusCaptureMinusCard("refused-online-capture-card"),
    @JsonProperty("refused-avs-required") refusedMinusAvsMinusRequired("refused-avs-required"),
    @JsonProperty("cancelled") cancelled("cancelled"),
    @JsonProperty("aborted") aborted("aborted"),
    @JsonProperty("aborted-device-unavailable") abortedMinusDeviceMinusUnavailable("aborted-device-unavailable"),
    @JsonProperty("aborted-busy") abortedMinusBusy("aborted-busy"),
    @JsonProperty("started") started("started"),
    @JsonProperty("in-progress") inMinusProgress("in-progress"),
    @JsonProperty("auth-completed") authMinusCompleted("auth-completed"),
    @JsonProperty("rejected-pre-auth") rejectedMinusPreMinusAuth("rejected-pre-auth"),
    @JsonProperty("rejected-card-number-not-matched") rejectedMinusCardMinusNumberMinusNotMinusMatched("rejected-card-number-not-matched"),
    @JsonProperty("rejected-card-expiry-date-not-matched") rejectedMinusCardMinusExpiryMinusDateMinusNotMinusMatched("rejected-card-expiry-date-not-matched"),
    @JsonProperty("rejected-card-not-accepted") rejectedMinusCardMinusNotMinusAccepted("rejected-card-not-accepted"),
    @JsonProperty("invalid-transaction-state") invalidMinusTransactionMinusState("invalid-transaction-state"),
    @JsonProperty("invalid-operation") invalidMinusOperation("invalid-operation"),
    @JsonProperty("invalid-gateway-transactions-reference") invalidMinusGatewayMinusTransactionsMinusReference("invalid-gateway-transactions-reference"),
    @JsonProperty("invalid-merchant") invalidMinusMerchant("invalid-merchant"),
    @JsonProperty("invalid-terminal") invalidMinusTerminal("invalid-terminal"),
    @JsonProperty("invalid-merchant-status") invalidMinusMerchantMinusStatus("invalid-merchant-status"),
    @JsonProperty("invalid-card-number") invalidMinusCardMinusNumber("invalid-card-number"),
    @JsonProperty("invalid-expired-card") invalidMinusExpiredMinusCard("invalid-expired-card"),
    @JsonProperty("invalid-issue-number") invalidMinusIssueMinusNumber("invalid-issue-number"),
    @JsonProperty("invalid-card-expiry-date") invalidMinusCardMinusExpiryMinusDate("invalid-card-expiry-date"),
    @JsonProperty("denied-transaction") deniedMinusTransaction("denied-transaction"),
    @JsonProperty("denied-cashback") deniedMinusCashback("denied-cashback"),
    @JsonProperty("pre-valid-card") preMinusValidMinusCard("pre-valid-card"),
    @JsonProperty("failed") failed("failed")
}

