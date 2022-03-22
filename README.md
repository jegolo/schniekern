# schniekern

Hintergrund:

Seit neusten ist Stein, Schere Papier das meistgespielte  Glückspiel weltweit. Plattformen die die diese Spiel anbieten können aufgrund von Transfergebühren x% vom Kuchen abbekommen. Aber Vorsicht sind sie zu teuer gehen die Spieler woanders hin. Eine Plattform für das Stein Schere Papier Spiel muss folgende Schnittstellen anbieten.

1. GET Request OFFER zeigt die Konditionen des Servers
            Rückgabe: Transferfee, Anzahl Registrierter Spieler
2. PUT Register:
            Body: 
		  Name
		  Response URL
	Response: 200
		 UID des Spielers
	Businesslogik:
	        Jeden Spieler werden 100 Bucks als Credit gutgeschrieben
3. GET Highscore
                 Liste mit Name und Highscore
4. GET Amount
	1. Rückgabe des Erwirtschafteten Betrags
5. GET Play
	   Eine Spiel besteht aus n Runden.
	   In jeder Runde werden aus der Anzahl der Spieler jeweils zufällig zwei Spieler die noch ein Credit haben ausgesucht. Diese treten dann virtuell gegeneinader an. Dies geschieht durch eine Anforderung (GET Requests "call") mit den Informationen wer der aktuelle Gegner ist an die ausgewählten Spieler. Als Rückantwort sendet der Spieler seinen Einsatz und sein ausgewähltes Symbol. Der Server entscheidet nun wer gewonnen hat. Den Gewinner werden in jeder Runde Einsatz - Transfergebühren gut geschrieben. 
	
6. GET PLAYER/{PLAYERID}
	   Response:
	     Amount
	     Won
	     Lost
	     Games 

	
Client Schnittstelle:
1. GET call
	1. opponent
             Response:
		stake
		Stain Schere Papier
