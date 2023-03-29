package org.openapitools.api

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.openapitools.model.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

import javax.validation.Valid
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class BillsApiController() {

    private val bill1 = BillDetails(BillStatus.pending, "1234", "Table1", 1000L, "123", itemizedBill = "Burger:£5.00;Fries:£3.00;Coke:£2.00;;Subtotal:£10.00;;Service not included")
    private val bill2 = BillDetails(BillStatus.pending, "2345", "Table2", 1200L, itemizedBill = "Pizza")
    private var billpaid = BillDetails(billId = "123", billTag = "Table1", totalAmount = 1200L, itemizedBill = "Pizza", status = BillStatus.complete, userId = "1", billDateTime = OffsetDateTime.now(), paymentDetails = listOf(PaymentDetails(PaymentResultType.sale,
        OffsetDateTime.now(),TransactionResultCode.authorisedMinusOnline,"123",
        Merchant("111","1111"),Paypoint("1", "11111"),  value = PaymentDetailsValue(1000L,"GBP", 0, 0), paymentInstrument = PaymentDetailsPaymentInstrument(PaymentDetailsPaymentInstrument.Type.cardPresent,card = PaymentCard("111", cardNumber = "12000000000434", expiryDate = CardDate(10,25), type = CardType.credit, applicationLabel = "01", panSequenceNumber = "01", applicationIdentifier = "000000001"), barcode = "")
    )))
    private val bill3ToRefund = BillDetails(status = BillStatus.pending, billId ="3456", billTag ="Table3", totalAmount = -1200L, itemizedBill = "Pizza          £12.00")

    @Operation(
        summary = "Create a new Bill",
        operationId = "createBill",
        description = "",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "A JSON returning the created bill.",
                content = [Content(schema = Schema(implementation = BillDetails::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Invalid Request",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "Forbidden",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = [Content(schema = Schema(implementation = Errors::class))]
            )],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bills"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"],
        consumes = ["application/vnd.worldpay.bill-v1+json", "application/json;charset=UTF-8"]
    )
    fun createBill(
        @Parameter(
            description = "Bill that needs to be generated",
            required = true
        ) @Valid @RequestBody createBillRequest: CreateBillRequest,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(min = 1, max = 30) @Parameter(
            description = "",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?
    ): ResponseEntity<BillDetails> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Find bill by billId",
        operationId = "getBillById",
        description = "Returns a single Bill",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(schema = Schema(implementation = GetBillsResponse::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Invalid Request",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Resource Not Found",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = [Content(schema = Schema(implementation = Errors::class))]
            )],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bills/{billId}"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"],
        consumes = ["application/vnd.worldpay.bill-v1+json", "application/json;charset=UTF-8"]

    )
    fun getBillById(
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(
            min = 1,
            max = 30
        ) @Parameter(
            description = "Bill ID to be provided",
            required = true
        ) @PathVariable("billId") billId: kotlin.String,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(min = 1, max = 30) @Parameter(
            description = "",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?
    ): ResponseEntity<BillDetails> {
        return ResponseEntity(billpaid, null, HttpStatus.OK)
    }

    @Operation(
        summary = "List Bills by status and/or billTag",
        operationId = "listBills",
        description = "Default all pending status bills be returned. Multiple status values can be provided with comma separated strings ",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "successful operation",
                content = [Content(schema = Schema(implementation = BillDetails::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Invalid Request",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "Forbidden",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Resource Not Found",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = [Content(schema = Schema(implementation = Errors::class))]
            )],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bills"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"]
    )
    fun listBills(
        @Parameter(description = "All possible values for bill.  `ready` - used to get the bill from order management   `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill ") @Valid @RequestParam(
            value = "billStatus",
            required = false
        ) billStatus: BillStatus? = BillStatus.ready,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(
            min = 1,
            max = 30
        ) @Parameter(description = "Bill tag of bill to be provided") @Valid @RequestParam(
            value = "billTag",
            required = false
        ) billTag: kotlin.String?,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(
            min = 1,
            max = 30
        ) @Parameter(
            description = "Bill ID to be provided",
            required = true
        ) @PathVariable("billId", required = false) billId: kotlin.String?,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(min = 1, max = 30) @Parameter(
            description = "",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?
    ): ResponseEntity<List<BillDetails>> {
        println(billId)
        println("here")
        return if(billStatus == null){
            ResponseEntity(listOf(billpaid), null, HttpStatus.OK)

        } else{
            ResponseEntity(listOf(bill1, bill2, bill3ToRefund).filter { it.status == billStatus }, null, HttpStatus.OK)
        }
    }

    @Operation(
        summary = "Update an existing Bill by billId",
        operationId = "updateBill",
        description = "",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "A JSON returning the updated Bill.",
                content = [Content(schema = Schema(implementation = BillDetails::class))]
            ),
            ApiResponse(
                responseCode = "400",
                description = "Invalid Request",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "401",
                description = "Unauthorized",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "403",
                description = "Forbidden",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Resource Not Found",
                content = [Content(schema = Schema(implementation = Errors::class))]
            ),
            ApiResponse(
                responseCode = "500",
                description = "Internal Server Error",
                content = [Content(schema = Schema(implementation = Errors::class))]
            )],
        security = [SecurityRequirement(name = "bearerAuth")]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/bills/{billId}"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"],
        consumes = ["application/vnd.worldpay.bill-v1+json", "application/json;charset=UTF-8"]
    )
    fun updateBill(
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(
            min = 1,
            max = 30
        ) @Parameter(
            description = "Bill ID to be provided",
            required = true
        ) @PathVariable("billId") billId: kotlin.String,
        @Parameter(
            description = "Bill that needs to be updated",
            required = true
        ) @Valid @RequestBody updateBillRequest: UpdateBillRequest,
        @Pattern(regexp = "^[a-zA-Z0-9_-]{1,30}$") @Size(min = 1, max = 30) @Parameter(
            description = "",
            `in` = ParameterIn.HEADER
        ) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?
    ): ResponseEntity<BillDetails> {
        println("put bill")
        updateBillRequest.paymentDetails.takeIf { it.isNullOrEmpty().not() }?.run{billpaid.paymentDetails =  updateBillRequest.paymentDetails}
        return ResponseEntity(billpaid, null, HttpStatus.CREATED)
    }
}
