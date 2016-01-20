Scenario: Add Annonce successfully
 
Given a annonce with photo photo prix 200000 surface 200 adresse test ville bordeaux description test
When I add annonce
Then a annonce with id 5 should be added into the database

