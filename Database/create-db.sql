-- Drop Foreign Key Constraints

-- Drop constraints from POST table
ALTER TABLE IF EXISTS POST DROP CONSTRAINT IF EXISTS fk_post_blog;
ALTER TABLE IF EXISTS POST DROP CONSTRAINT IF EXISTS fk_post_benutzer;

-- Drop constraints from COMMENT table
ALTER TABLE IF EXISTS COMMENT DROP CONSTRAINT IF EXISTS fk_comment_post;
ALTER TABLE IF EXISTS COMMENT DROP CONSTRAINT IF EXISTS fk_comment_benutzer;

-- Drop constraints from BLOG table
ALTER TABLE IF EXISTS BLOG DROP CONSTRAINT IF EXISTS fk_blog_benutzer;

-- Drop Tables

DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS POST;
DROP TABLE IF EXISTS BLOG;
DROP TABLE IF EXISTS BENUTZER;

-- Recreate Tables

CREATE TABLE BENUTZER (
                          ID_Benutzer SERIAL PRIMARY KEY,
                          Name VARCHAR(50),
                          Password TEXT
);

CREATE TABLE BLOG (
                      ID_Blog SERIAL PRIMARY KEY,
                      Title VARCHAR(100),
                      Question TEXT,
                      ID_Benutzer INT,
                      CONSTRAINT fk_blog_benutzer
                          FOREIGN KEY (ID_Benutzer) REFERENCES BENUTZER(ID_Benutzer)
);

CREATE TABLE POST (
                      ID_Post SERIAL PRIMARY KEY,
                      Answer TEXT,
                      ID_Blog INT,
                      ID_Benutzer INT,
                      CONSTRAINT fk_post_blog
                          FOREIGN KEY (ID_Blog) REFERENCES BLOG(ID_Blog),
                      CONSTRAINT fk_post_benutzer
                          FOREIGN KEY (ID_Benutzer) REFERENCES BENUTZER(ID_Benutzer)
);

CREATE TABLE COMMENT (
                         ID_Comment SERIAL PRIMARY KEY,
                         Comment TEXT,
                         ID_Post INT,
                         ID_Benutzer INT,
                         CONSTRAINT fk_comment_post
                             FOREIGN KEY (ID_Post) REFERENCES POST(ID_Post),
                         CONSTRAINT fk_comment_benutzer
                             FOREIGN KEY (ID_Benutzer) REFERENCES BENUTZER(ID_Benutzer)
);


-- SELECT * FROM Comment;
-- SELECT * FROM POST;
-- SELECT * FROM BLOG;
-- SELECT * FROM Benutzer;