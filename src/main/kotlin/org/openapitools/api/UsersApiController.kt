package org.openapitools.api

import org.openapitools.model.Errors
import org.openapitools.model.User
import io.swagger.v3.oas.annotations.*
import io.swagger.v3.oas.annotations.enums.*
import io.swagger.v3.oas.annotations.media.*
import io.swagger.v3.oas.annotations.responses.*
import io.swagger.v3.oas.annotations.security.*
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
class UsersApiController() {

    @Operation(
        summary = "Verify user ID",
        operationId = "getUserById",
        description = "Returns a user details",
        responses = [
            ApiResponse(responseCode = "200", description = "successful operation", content = [Content(schema = Schema(implementation = User::class))]),
            ApiResponse(responseCode = "400", description = "Invalid Request", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "401", description = "Unauthorized", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "403", description = "Forbidden", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "404", description = "Resource Not Found", content = [Content(schema = Schema(implementation = Errors::class))]),
            ApiResponse(responseCode = "500", description = "Internal Server Error", content = [Content(schema = Schema(implementation = Errors::class))]) ],
        security = [ SecurityRequirement(name = "bearerAuth") ]
    )
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/users/{userId}"],
        produces = ["application/vnd.worldpay.bill-v1+json", "application/json"]
    )
    fun getUserById(@Pattern(regexp="^[a-zA-Z0-9_-]{1,30}$") @Size(min=1,max=30) @Parameter(description = "", required = true) @PathVariable("userId") userId: kotlin.String): ResponseEntity<User> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
