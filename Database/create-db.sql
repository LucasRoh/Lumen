-- Drop Foreign Key Constraints

-- Drop constraints from POST table
ALTER TABLE IF EXISTS POST DROP CONSTRAINT IF EXISTS fk_post_blog;
ALTER TABLE IF EXISTS POST DROP CONSTRAINT IF EXISTS fk_post_account;

-- Drop constraints from COMMENT table
ALTER TABLE IF EXISTS COMMENT DROP CONSTRAINT IF EXISTS fk_comment_post;
ALTER TABLE IF EXISTS COMMENT DROP CONSTRAINT IF EXISTS fk_comment_account;

-- Drop constraints from BLOG table
ALTER TABLE IF EXISTS BLOG DROP CONSTRAINT IF EXISTS fk_blog_account;

-- Drop Tables

DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS POST;
DROP TABLE IF EXISTS BLOG;
DROP TABLE IF EXISTS ACCOUNT;

-- Recreate Tables

CREATE TABLE ACCOUNT (
                         ID_Account SERIAL PRIMARY KEY,
                         Name VARCHAR(50),
                         Password TEXT
);

CREATE TABLE BLOG (
                      ID_Blog SERIAL PRIMARY KEY,
                      Title VARCHAR(100),
                      Question TEXT,
                      Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    ID_Account INT,
                      CONSTRAINT fk_blog_account
                          FOREIGN KEY (ID_Account) REFERENCES ACCOUNT(ID_Account)

);

CREATE TABLE POST (
                      ID_Post SERIAL PRIMARY KEY,
                      Answer TEXT,
                      ID_Blog INT,
                      Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      CONSTRAINT fk_post_blog
                          FOREIGN KEY (ID_Blog) REFERENCES BLOG(ID_Blog),

    ID_Account INT,
                      CONSTRAINT fk_post_account
                          FOREIGN KEY (ID_Account) REFERENCES ACCOUNT(ID_Account)

);

CREATE TABLE COMMENT (
                         ID_Comment SERIAL PRIMARY KEY,
                         Comment TEXT,
                         ID_Post INT,
                         Timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_comment_post
                             FOREIGN KEY (ID_Post) REFERENCES POST(ID_Post),

    ID_Account INT,
                         CONSTRAINT fk_comment_account
                             FOREIGN KEY (ID_Account) REFERENCES ACCOUNT(ID_Account)

);



