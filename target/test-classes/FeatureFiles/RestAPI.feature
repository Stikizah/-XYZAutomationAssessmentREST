Feature: Te validate Rest API Test

Scenario: Validate rest output
When POST a new user to the users Endpoint
And Validate the Response
When GET a single user from the users Endpoint
And Validate the Response
When GET ten users from the users Endpoint
And Validate the Response
