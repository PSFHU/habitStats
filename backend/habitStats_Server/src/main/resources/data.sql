-- USERS
Insert INTO USER(USERNAME, PASSWORD)
VALUES ('kispista','teszt');

-- UNIT TYPES
INSERT INTO UNIT_TYPE(UNIT_TYPE_NAME)
VALUES ('db');

INSERT INTO UNIT_TYPE(UNIT_TYPE_NAME)
VALUES ('km');

-- CATEGORIES
INSERT INTO STAT_CATEGORY(STAT_CATEGORY_NAME)
VALUES ('Edzés');

-- STATS
INSERT INTO STAT(STAT_NAME, UNIT_TYPE_ID, STAT_CATEGORY_ID, USER_ID)
VALUES ('Felülés',
        (SELECT ID FROM UNIT_TYPE WHERE UNIT_TYPE_NAME = 'db'),
        (SELECT ID FROM STAT_CATEGORY WHERE STAT_CATEGORY_NAME = 'Edzés'),
        (SELECT ID FROM USER WHERE USERNAME = 'kispista'));

-- PROGRESS
INSERT INTO PROGRESS(STAT_ID, PROGRESS_VALUE)
VALUES ((SELECT ID FROM STAT WHERE STAT_NAME = 'Felülés' AND USER_ID = (SELECT ID FROM USER WHERE USERNAME = 'kispista')),
        10);

INSERT INTO PROGRESS(STAT_ID, PROGRESS_VALUE)
VALUES ((SELECT ID FROM STAT WHERE STAT_NAME = 'Felülés' AND USER_ID = (SELECT ID FROM USER WHERE USERNAME = 'kispista')),
        15);

INSERT INTO PROGRESS(STAT_ID, PROGRESS_VALUE)
VALUES ((SELECT ID FROM STAT WHERE STAT_NAME = 'Felülés' AND USER_ID = (SELECT ID FROM USER WHERE USERNAME = 'kispista')),
        16);

INSERT INTO PROGRESS(STAT_ID, PROGRESS_VALUE)
VALUES ((SELECT ID FROM STAT WHERE STAT_NAME = 'Felülés' AND USER_ID = (SELECT ID FROM USER WHERE USERNAME = 'kispista')),
        10);

--GOALS
INSERT INTO GOAL(TITLE, GOAL_VALUE, GOAL_LOGIC)
VALUES ('Csinálj 30 felülést',30,'=>');

INSERT INTO GOAL_STAT(GOAL_ID, STAT_ID)
VALUES ((SELECT ID FROM GOAL WHERE TITLE = 'Csinálj 30 felülést'),(SELECT ID FROM STAT WHERE STAT_NAME = 'Felülés' AND USER_ID = (SELECT ID FROM USER WHERE USERNAME = 'kispista')));