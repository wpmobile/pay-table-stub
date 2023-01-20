package org.openapitools

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.security.SecurityScheme

@jakarta.annotation.Generated(value = ["org.openapitools.codegen.languages.KotlinSpringServerCodegen"])
@Configuration
class SpringDocConfiguration {

    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Bill Management")
                    .description("# Summary   Given set of APIs for Bill management process # Versioning   By default, all requests receive the latest version of the REST API.  We encourage you to explicitly request this version via the Accept header. Example                  \"Accept: application/vnd.worldpay.bill-v1+json\"    # Security  APIs use JWT Based Bearer Authentication. JWT Token must contain claims to merchant and terminal operator identifiers at minimum.  # Response Codes   A list of the  common HTTP response codes used in POS API is given below:    |HTTP Code|HTTP Verb|Description|   |--- |--- |--- |   |200|GET POST PUT|The request has succeeded.|   |201|POST|The request has succeeded and a new resource has been created as a result.|   |202|GET POST|The request has succeeded, but the response body is incomplete.|   |204|PUT DELETE|The request has succeeded, an existing resource has been updated/deleted and the response body is empty.|   |400|POST PUT|The service could not understand the request.|   |401|Any|The client must authenticate itself.|   |404|GET PUT DELETE|The service can not find requested resource.|   |409|POST|The service has experienced a conflict between the data provided in the request and the data on file.|   |415|Any|Content-Type and/or Accept headers are missing or invalid|   |422|Any|The request was well-formed but could not be processed due to semantic errors.|   |500|Any|An error occurred within the service which hasn’t been accounted for.|   |503|Any|The service is not ready to handle the request.|  # Errors    The response contains an errorName that is both human-readable and machine-readable, with a human-readable message to add context to help you diagnose the error.  If there are multiple errors, the response includes all the errors in a nested list within the top-level error.  ### Generic Error Format   ``` {   \"errorName\": \"errorName\",   \"message\": \"human readable message\" } ```  ### Specific Error Format     Validation errors must also contain a path to the location of the value that caused the error. The field to use here depends on whether the error ocurred on the URL or in the JSON request body:   ``` {   \"errorName\": \"bodyDoesNotMatchSchema\",   \"message\": \"The json body provided does not match the expected schema\",   \"validationErrors\": [       {         \"errorName\": \"fieldMustBeNumber\",         \"message\": \"Field at path must be a number\",         \"jsonPath\": \"$.amount\"       }     ]   } ")
                    .version("0.0.6")
            )
            .components(
                Components()
                    .addSecuritySchemes("bearerAuth", SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                    )
            )
    }
}
