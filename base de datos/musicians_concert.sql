CREATE DATABASE "MUSICIANS_CONCERTS"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE CONCERTS (
    ID_CONCERT BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    CONCERT_DATE DATE NULL,
    LOCATION VARCHAR(255) NULL,
    UNIQUE(NAME)
);

CREATE INDEX IDX_CONCERT_NAME ON CONCERTS(NAME);

CREATE TABLE CONCERTS_SCORE (
	ID_CONCERTS_SCORE BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	ID_CONCERT BIGINT NOT NULL,
	SCORE INTEGER NOT NULL CHECK (SCORE >= 1 AND SCORE <= 5),
	FOREIGN KEY (ID_CONCERT) REFERENCES CONCERTS(ID_CONCERT) ON DELETE CASCADE
);

CREATE TABLE USERS (
	ID_USER BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
	USERNAME VARCHAR(12) NOT NULL,
	PASSWORD VARCHAR(255) NOT NULL,
	UNIQUE (USER_NAME)
);