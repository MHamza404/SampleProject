Feature: Post API Testing

  Scenario: Sending a GET request and verifying the response

    Given I have the GET API endpoint
    When I send a GET request
    Then I should receive a successful response