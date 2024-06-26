


/*
	WICHTIG: ZUERST CREATE-FILE AUSFÜHREN, BEVOR INSERT-FILE, SONST FUNKTIONIERT FOREIGN KEY NICHT
*/

INSERT INTO Account (name, password) VALUES
    ('User1','1234');

INSERT INTO Blog (title, question, id_account ) VALUES
                                                    ('Wie installiere ich Linux?', 'Kann jemand die Schritte zur Installation von Linux erläutern?', 1),
                                                    ('Was ist der Unterschied zwischen HTTPS und HTTP?', 'Welche Vorteile bietet HTTPS gegenüber HTTP?', 1),
                                                    ('Wie backe ich einen perfekten Kuchen?', 'Welche Tipps gibt es, um einen Kuchen luftig und lecker zu machen?', 1),
                                                    ('Wie verbessere ich meine Ausdauer beim Laufen?', 'Welche Trainingsmethoden helfen, die Ausdauer beim Laufen zu steigern?', 1),
                                                    ('Effektive Methoden zum Fensterputzen?', 'Wie kann man Fenster streifenfrei putzen?', 1);

INSERT INTO Post (answer, id_blog, id_account) VALUES
                                                   ('Du kannst Linux von einer Live-CD oder einem USB-Stick installieren. Folge den Anweisungen auf dem Bildschirm.', 1, 1),
                                                   ('HTTPS ist sicherer als HTTP, da es die Kommunikation zwischen dem Client und dem Server verschlüsselt.', 2, 1),
                                                   ('Verwende frische Zutaten und sorge dafür, dass alle Zutaten Raumtemperatur haben, bevor du sie mischst.', 3, 1),
                                                   ('Intervalltraining ist eine gute Methode, um die Ausdauer zu steigern.', 4, 1 ),
                                                   ('Verwende warmes Wasser mit etwas Essig und trockne die Fenster mit einem Mikrofasertuch.', 5, 1);

INSERT INTO Comment (comment, id_post, id_account) VALUES
                                                       ('Danke, das hat bei der Installation geholfen!', 1, 1),
                                                       ('Ich wusste nicht, dass HTTPS so wichtig ist. Danke für die Info!', 2, 1),
                                                       ('Toller Tipp! Mein Kuchen war noch nie so gut.', 3, 1),
                                                       ('Intervalltraining hat wirklich meine Ausdauer verbessert, danke!', 4,1),
                                                       ('Der Essig hat Wunder gewirkt. Danke für den Tipp!', 5,1 );

SELECT * FROM BLog;
SELECT * FROM POST;
SELECT * FROM Comment;
SELECT * FROM Account;
