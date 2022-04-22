--liquibase formatted sql
--changeset vemedvedev:USERS
CREATE TABLE CACHE.USERS (
	ID BIGINT generated always as identity,
	NAME VARCHAR(255),
	EMAIL VARCHAR(255),
	CREATED_AT TIMESTAMP(6) DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ID)
);
CREATE UNIQUE INDEX USER_ID_INDX ON CACHE.USERS (ID);
CREATE UNIQUE INDEX USER_NAME_INDX ON CACHE.USERS (NAME);