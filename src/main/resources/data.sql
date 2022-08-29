INSERT INTO PUBLIC.USERS (Id, USERNAME, PASSWORD, NAME, EMAIL, USER_TYPE, ACTIVE, CREATED_DATE)
VALUES
    (0,'admin', '$2a$10$vEg4sMlDfxIecLLHOGU5h.3kK1wJuZF5a.XGEU2Rd8ZSsbKycfqxO', 'Administrator', 'admin@bookstore.com', 2, true, '2022-08-02 17:30:00'),
    (1,'arman', '$2a$10$vEg4sMlDfxIecLLHOGU5h.3kK1wJuZF5a.XGEU2Rd8ZSsbKycfqxO', 'Arman', 'arman.hassanpoor2000@gmail.com', 2, true, '2022-08-02 17:30:00');

INSERT INTO PUBLIC.CATEGORIES (ID, NAME, CREATED_BY, CREATED_DATE, DELETED, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, VERSION)
VALUES
    (0,'Programming', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (1,'Mobile Programming', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (2,'Web Programming', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (3,'Software Engineering', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (4,'Data Science', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (5,'Databases', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0),
    (6,'Linux and Unix', 'admin', '2022-08-02 12:30:00', 0, '2022-08-02 17:30:00', 'admin', 0);

INSERT INTO PUBLIC.SUB_CATEGORIES (ID, NAME, CATEGORY_ID, CREATED_BY, CREATED_DATE, DELETED, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, VERSION)
VALUES
    ( 0, 'Java Programming', 0, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 1, 'CSharp Programming', 0, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 2, 'Python Programming', 0, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 3, 'Javascript Programming', 0, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 4, 'iOS Programming', 1, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 5, 'Objective-C Programming', 1, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 6, 'React Native Programming', 1, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 7, 'Kotlin Programming', 1, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 8, 'Angular.js', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 9, 'Node.js', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 10,'React.js', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 11,'Web Style, Design and Accessibility', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 12,'JavaScript Programming', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 13,'HTML5, HTML, XHTML, and DHTML', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 14,'Agile, Scrum', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 15,'Microservices and SOA', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 16,'Reverse Engineering', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 17,'Software Design and Patterns', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 18,'UML (Unified Modeling Language)', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0);