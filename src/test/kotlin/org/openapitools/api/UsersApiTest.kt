package org.openapitools.api

import org.openapitools.model.Errors
import org.openapitools.model.User
import org.junit.jupiter.api.Test
import org.springframework.http.ResponseEntity

class UsersApiTest {

    private val api: UsersApiController = UsersApiController()

    /**
     * To test UsersApiController.getUserById
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    fun getUserByIdTest() {
        val userId: kotlin.String = TODO()
        val response: ResponseEntity<User> = api.getUserById(userId)

        // TODO: test validations
    }
}
