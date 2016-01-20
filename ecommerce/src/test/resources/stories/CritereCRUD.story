Scenario: Add Annonce successfully
 
Given a critere with type maison ville bordeaux prix_min 200000 prix_max 500000 surface_min 80000 surface_max 100000
When I add critere
Then a critere with id 2 should be added into the database

