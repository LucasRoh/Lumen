/*
	WICHTIG: ZUERST CREATE-FILE AUSFÜHREN, BEVOR INSERT-FILE, SONST FUNKTIONIERT FOREIGN KEY NICHT
*/

INSERT INTO Account (name, password) VALUES
    ('Banana-MAN','1234'),
    ('Display: Flex','1234'),
    ('Lay-Z','1234'),
    ('RumbleInTheJungle','1234');

INSERT INTO Blog (title, question, id_account ) VALUES
    ('Wie installiere ich Linux?', 'Kann jemand die Schritte zur Installation von Linux erläutern? Welche Version von Linux soll ich kaufen? Ich habe so viel positive Sachen gehört, dass ich es selbst ausprobieren will. Wär toll, wenn mir jemand da weiterhelfen kann!', 2),
    ('Was ist der Unterschied zwischen HTTPS und HTTP?', 'Welche Vorteile bietet HTTPS gegenüber HTTP?', 1),
    ('Wie backe ich einen perfekten Kuchen?', 'Welche Tipps gibt es, um einen Kuchen luftig und lecker zu machen?', 3),
    ('Wie verbessere ich meine Ausdauer beim Laufen?', 'Welche Trainingsmethoden helfen, die Ausdauer beim Laufen zu steigern?', 2),
    ('Effektive Methoden zum Fensterputzen?', 'Wie kann man Fenster streifenfrei putzen?', 4);

INSERT INTO Post (answer, id_blog, id_account) VALUES
     ('Du kannst Linux von einer Live-CD oder einem USB-Stick installieren. Folge den Anweisungen auf dem Bildschirm.', 1, 1),
     ('HTTPS ist sicherer als HTTP, da es die Kommunikation zwischen dem Client und dem Server verschlüsselt.', 2, 2),
     ('Verwende frische Zutaten und sorge dafür, dass alle Zutaten Raumtemperatur haben, bevor du sie mischst.', 3, 3),
     ('Intervalltraining ist eine gute Methode, um die Ausdauer zu steigern.', 4, 4 ),
     ('Verwende warmes Wasser mit etwas Essig und trockne die Fenster mit einem Mikrofasertuch.', 5, 1),
     ('Eventuell könntest du auch mit Zahnpasta versuchen, es kommt aber darauf an, welche Marke!!!', 5, 2),
     ('Aber beachte: Wenn du die Fenster nicht putzen tust, brauchst du keine Vorhänge zu kaufen :DDD', 5, 3),
     ('Kommt nicht auf die Version drauf an, am Besten gehts mit dem USB-Stick. Lade dir Rufus spezifisch für dein OS herunter, installiere es auf dem USB-Stick, entscheide dich für ein Image einer Distribution und wähle ein Dateisystem. Dann kannst du einfach den USB-Stick einstecken und im Boot-Vorgang den USB-Stick auswählen.', 1, 3);

INSERT INTO Comment (comment, id_post, id_account) VALUES
     ('Danke, das hat bei der Installation geholfen!', 1, 1),
     ('Ich wusste nicht, dass HTTPS so wichtig ist. Danke für die Info!', 2, 1),
     ('Toller Tipp! Mein Kuchen war noch nie so gut.', 3, 1),
     ('Intervalltraining hat wirklich meine Ausdauer verbessert, danke!', 4,1),
     ('Der Essig hat Wunder gewirkt. Danke für den Tipp!', 5,1 ),
     ('Kommentar 2 zu Post_id nr. 1', 1, 1),
     ('Kommentar 3 zu Post_id nr.1',1,1 ),
     ('Kommentar 2 zu Post nr 2', 2, 1);


