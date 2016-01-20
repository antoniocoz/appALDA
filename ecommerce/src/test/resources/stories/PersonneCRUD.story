Scenario: Add Personne successfully
 
Given a personne with prenom coz nom antonio adresse avprevots ville bordeaux tel 646853149 mail cvantonio.07@gmail.com pass 123456
When I add personne
Then a personne with id 5 should be added into the database

