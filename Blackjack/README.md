Oppgave 1b - Blackjack

Løsningen består primært av 5 java filer: 
	Card.java - Entitets klasse med rank og sort for et kort, i tillegg til metode for å estimere verdi.
	Game.java - Klassen som kjøres med komando java Game (alternativ filepath, TestDeck.txt er vedlagt) fra /bin mappen. Dette krever at Java er installert på maskin.
	Blackjack.java - Klassen som tar for seg selve spillet sammen med game logic og brukerhandlinger.
	GameGUI.java - Klasse som håndterer grafisk brukergrensesnitt. 
	GameTest.java - Noen tester som er skrevet.
	
Game.java sjekker om det er lagt ved en path til en kortstokk. Det er lagt til et par stokker som benyttes i testing.
Blackjack oppretter et GameGUI objekt når Blackjack objektet blir opprettet. Deretter lages en stokk eller hentes stokken inn via argument.
StartGame metoden setter så i gang spillet og checkCondition metoden sjekker spill logikk. Spillet avsluttes dersom en av reglene som er satt intreffer.
Dersom spilleren treker 17 eller mer men mindre enn 21 stoppes spiller automatisk fra å trekke flere kort. 
Det er implimentert et par tester for å sjekke ulike scenariorer. Testene kan kjøres fra /bin mappen med kommando:
java -cp .;junit-4.13.jar.;hamcrest-core-1.3.jar org.junit.runner.JUnitCore GameTest