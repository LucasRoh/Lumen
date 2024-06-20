
CREATE DATABASE lumen;


\c lumen


CREATE TABLE BLOG (
    ID_Blog SERIAL PRIMARY KEY,
    Title VARCHAR(100),
    Frage TEXT
);


CREATE TABLE POST (
    ID_Post SERIAL PRIMARY KEY,
    Answer TEXT,
    ID_Blog INT,
    FOREIGN KEY (ID_Blog) REFERENCES BLOG(ID_Blog)
);


CREATE TABLE COMMENT (
    ID_Comment SERIAL PRIMARY KEY,
    Comment TEXT,
    ID_Post INT,
    FOREIGN KEY (ID_Post) REFERENCES POST(ID_Post)
);
