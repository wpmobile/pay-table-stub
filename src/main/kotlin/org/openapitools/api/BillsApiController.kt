package org.openapitools.api

import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
import org.openapitools.model.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.*
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class BillsApiController() {

    private val bill1 = BillDetails(BillStatus.ready,"1234", "Outside",1000L, "123")
    private val bill2 = BillDetails(BillStatus.ready,"1235", "Outside",1200L, "123")
    private val bill3 = BillDetails(BillStatus.ready,"1235", "Outside",1200L, "123")
    @Operation(
        summary = "Create a new Bill",
        operationId = "createBill",
        description = "",
        responses = [
            ApiResponse(responseCode = "201", description = "A JSON returning the created bill.", content = [Content(schema = Schema(implementation = BillDetails::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Request", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error", content = [Content(schema = Schema(implementation = Errors::class))]) ],
        security = [ SecurityRequirement(name = "bearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/bills"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"],
        consumes = ["application/vnd.worldpay.bill-v1+json"]
    )
    fun createBill(@Parameter(description = "Bill that needs to be generated", required = true) @Valid @RequestBody createBillRequest: CreateBillRequest,@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?): ResponseEntity<BillDetails> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }

    @Operation(
        summary = "Find bill by billId",
        operationId = "getBillById",
        description = "Returns a single Bill",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = BillDetails::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Request", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "404", description = "Resource Not Found", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error", content = [Content(schema = Schema(implementation = Errors::class))]) ],
        security = [ SecurityRequirement(name = "bearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bills/{billId}"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"]
    )
    fun getBillById(@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "Bill ID to be provided", required = true) @PathVariable("billId") billId: kotlin.String,@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?): ResponseEntity<BillDetails> {
        return ResponseEntity( bill1, null, HttpStatus.OK)
    }

    @Operation(
        summary = "List Bills by status and/or billTag",
        operationId = "listBills",
        description = "Default all pending status bills be returned. Multiple status values can be provided with comma separated strings ",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = BillDetails::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Request", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "404", description = "Resource Not Found", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error", content = [Content(schema = Schema(implementation = Errors::class))]) ],
        security = [ SecurityRequirement(name = "bearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/bills"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"]
    )
    fun listBills(@Parameter(description = "All possible values for bill.  `ready` - used to get the bill from order management   `pending` - once bill is open to be processed  `in-progress` - used to update once bill is picked-up for payment.  `complete` - once bill is completely paid  `partial-complete` - if bill is partially paid(in split payment) and wants to pay to the counter OR customer wants to update the bill in un-happy path  `cancel` - to cancel a bill ") @Valid @RequestParam(value = "billStatus", required = false) billStatus: BillStatus?,@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "Bill tag of bill to be provided") @Valid @RequestParam(value = "billTag", required = false) billTag: kotlin.String?,@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?): ResponseEntity<List<BillDetails>> {
        return ResponseEntity(listOf(bill1, bill2), null, HttpStatus.OK)
    }

    @Operation(
        summary = "Update an existing Bill by billId",
        operationId = "updateBill",
        description = "",
        responses = [
            ApiResponse(responseCode = "200", description = "A JSON returning the updated Bill.", content = [Content(schema = Schema(implementation = BillDetails::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Request", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "404", description = "Resource Not Found", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error", content = [Content(schema = Schema(implementation = Errors::class))]) ],
        security = [ SecurityRequirement(name = "bearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/bills/{billId}"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"],
        consumes = ["application/vnd.worldpay.bill-v1+json"]
    )
    fun updateBill(@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "Bill ID to be provided", required = true) @PathVariable("billId") billId: kotlin.String,@Parameter(description = "Bill that needs to be updated", required = true) @Valid @RequestBody updateBillRequest: UpdateBillRequest,@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "", `in` = ParameterIn.HEADER) @RequestHeader(value = "X-WP-User-Id", required = false) xWPUserId: kotlin.String?): ResponseEntity<BillDetails> {
        return ResponseEntity(bill3, null, HttpStatus.CREATED)
    }
}
