Scenario: Add Role successfully
 
Given a role with nom test description test
When I add role
Then a role with id 2 should be added into the database

