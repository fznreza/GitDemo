Feature: Add a Place
@addplace
  Scenario Outline: Add a Place through Api and Validate that place is added
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When send the https "AddPlace" request and hit the server by using "Post"
    Then It should give successful response
    And the response "status" code should be "OK"
    And the response "scope" code should be "APP"
    And After Addplace Validate through "getPlace" that "<name>" is added 
    Examples:
    |name    | language    | address             |
    |Rabina  | Hindi       | Mumbai,Maharastra   |
    #|Sahina	 | English	   | Kolkata,West bengal |
 @deleteplace
   Scenario: Delete Place Api
   Given Delete place payload
   When send the https "deletePlace" request and hit the server by using "POST"
   Then It should give successful response
   And the response "status" code should be "OK"
   
   
   