
INSERT INTO Blog (title, question) VALUES
                                       ('Wie installiere ich Linux?', 'Kann jemand die Schritte zur Installation von Linux erläutern?'),
                                       ('Was ist der Unterschied zwischen HTTPS und HTTP?', 'Welche Vorteile bietet HTTPS gegenüber HTTP?'),
                                       ('Wie backe ich einen perfekten Kuchen?', 'Welche Tipps gibt es, um einen Kuchen luftig und lecker zu machen?'),
                                       ('Wie verbessere ich meine Ausdauer beim Laufen?', 'Welche Trainingsmethoden helfen, die Ausdauer beim Laufen zu steigern?'),
                                       ('Effektive Methoden zum Fensterputzen?', 'Wie kann man Fenster streifenfrei putzen?');

INSERT INTO Post (antwort, blog_id) VALUES
                                        ('Du kannst Linux von einer Live-CD oder einem USB-Stick installieren. Folge den Anweisungen auf dem Bildschirm.', 1),
                                        ('HTTPS ist sicherer als HTTP, da es die Kommunikation zwischen dem Client und dem Server verschlüsselt.', 2),
                                        ('Verwende frische Zutaten und sorge dafür, dass alle Zutaten Raumtemperatur haben, bevor du sie mischst.', 3),
                                        ('Intervalltraining ist eine gute Methode, um die Ausdauer zu steigern.', 4),
                                        ('Verwende warmes Wasser mit etwas Essig und trockne die Fenster mit einem Mikrofasertuch.', 5);

INSERT INTO Comment (comment, blog_id) VALUES
                                           ('Danke, das hat bei der Installation geholfen!', 1),
                                           ('Ich wusste nicht, dass HTTPS so wichtig ist. Danke für die Info!', 2),
                                           ('Toller Tipp! Mein Kuchen war noch nie so gut.', 3),
                                           ('Intervalltraining hat wirklich meine Ausdauer verbessert, danke!', 4),
                                           ('Der Essig hat Wunder gewirkt. Danke für den Tipp!', 5);