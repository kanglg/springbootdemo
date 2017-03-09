
DROP TABLE B_SYS_USER_ROLE_REL;

DROP TABLE B_SYS_USER;

DROP TABLE B_SYS_ROLE_RES_REL;

DROP TABLE B_SYS_RES;

DROP TABLE B_SYS_ROLE;

CREATE TABLE B_SYS_RES
(
	RES_ID               VARCHAR(32) NOT NULL,
	RES_NAME             VARCHAR(50) NULL,
	RES_TYPE             VARCHAR(50) NULL,
	ORDER_NUM            INTEGER NULL,
	PID                  VARCHAR(32) NULL,
	PIDS                 VARCHAR(32) NULL,
	AVAILABLE            boolean NULL
);

ALTER TABLE B_SYS_RES
ADD PRIMARY KEY (RES_ID);

CREATE TABLE B_SYS_ROLE
(
	ROLE_ID              VARCHAR(32) NOT NULL,
	ROLE_NAME            VARCHAR(50) NULL,
	REMARK               VARCHAR(500) NULL,
	AVAILABLE            boolean NULL
);

ALTER TABLE B_SYS_ROLE
ADD PRIMARY KEY (ROLE_ID);

CREATE TABLE B_SYS_ROLE_RES_REL
(
	PERMISION            VARCHAR(500) NULL,
	ROLE_ID              VARCHAR(32) NOT NULL,
	RES_ID               VARCHAR(32) NOT NULL
);

ALTER TABLE B_SYS_ROLE_RES_REL
ADD PRIMARY KEY (ROLE_ID,RES_ID);

CREATE TABLE B_SYS_USER
(
	USER_ID              VARCHAR(32) NOT NULL,
	USER_NAME            VARCHAR(50) NULL,
	USER_ACCOUNT         CHAR(18) NULL,
	USER_PASSWORD        CHAR(18) NULL
);

ALTER TABLE B_SYS_USER
ADD PRIMARY KEY (USER_ID);

CREATE TABLE B_SYS_USER_ROLE_REL
(
	USER_ID              VARCHAR(32) NOT NULL,
	ROLE_ID              VARCHAR(32) NOT NULL
);

ALTER TABLE B_SYS_USER_ROLE_REL
ADD PRIMARY KEY (USER_ID,ROLE_ID);