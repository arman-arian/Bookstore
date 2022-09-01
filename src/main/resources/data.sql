INSERT INTO PUBLIC.USERS (Id, USERNAME, PASSWORD, NAME, EMAIL, USER_TYPE, ACTIVE, CREATED_DATE)
VALUES
    (0,'admin', '$2a$10$vEg4sMlDfxIecLLHOGU5h.3kK1wJuZF5a.XGEU2Rd8ZSsbKycfqxO', 'Administrator', 'admin@bookstore.com', 2, true, '2022-08-02 17:30:00'),
    (1,'arman', '$2a$10$vEg4sMlDfxIecLLHOGU5h.3kK1wJuZF5a.XGEU2Rd8ZSsbKycfqxO', 'Arman', 'arman.hassanpoor2000@gmail.com', 2, true, '2022-08-02 17:30:00');

INSERT INTO PUBLIC.CATEGORIES (ID, NAME, CREATED_BY, CREATED_DATE, DELETED, LAST_MODIFIED_DATE, LAST_MODIFIED_BY, VERSION)
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
    ( 13,'HTML5', 2, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 14,'Agile, Scrum', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 15,'Microservices and SOA', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 16,'Reverse Engineering', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 17,'Software Design and Patterns', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 18,'UML (Unified Modeling Language)', 3, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 19,'Bioinformatic Data Analysis', 4, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 20,'Data Analysis and Data Mining', 4, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 21,'Deep Learning', 4, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 22,'Machine Learning', 4, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 23,'R for Data Analysis', 4, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 24,'DB2', 5, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 25,'Oracle', 5, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 26,'MySQL', 5, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 27,'NoSQL Databases', 5, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 28,'Microsoft SQL Server', 5, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),

    ( 29,'BSD and FreeBSD', 6, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 30,'Unix/Linux Programming', 6, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 31,'Unix/Linux Networking', 6, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 32,'Unix/Linux Security', 6, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0),
    ( 33,'Unix/Linux System Administration', 6, 'admin', '2022-08-02 12:30:00', 0, 'admin', '2022-08-02 12:30:00', 0);

INSERT INTO PUBLIC.BOOKS (ID, TITLE, AUTHOR, ISBN, SUB_CATEGORY_ID, BUY_PRICE, RENT_PRICE, PUB_NAME, PUB_YEAR, SUMMARY, CREATED_BY, CREATED_DATE, DELETED, LAST_MODIFIED_BY, LAST_MODIFIED_DATE, VERSION)
VALUES
    ( 0, 'Introduction to Programming Using Java', 'David J. Eck', '978-1441419767', 0, 21.88, 0.10, 'CreateSpace', 2009, 'Designed to support an introductory programming course, this book teaches you concepts of problem-solving and object-orientated programming using a fundamentals-first approach. As beginner programmers, you learn critical problem-solving techniques then move on to grasp the key concepts of object-oriented, GUI programming, advanced GUI and Web programming using JavaFX.', 'admin', '2022-08-02 12:30:00', 0,'admin', '2022-08-02 12:30:00', 0),
    ( 1, 'Think Java: How to Think Like a Computer Scientist, 2nd Edition', 'Allen B. Downey, Chris Mayfield', '978-1492072508', 0, 23.27, 0.10, 'O''Reilly Media', 2019, 'This book is a hands-on introduction to computer science and programming used by many universities and high schools around the world. Its conciseness, emphasis on vocabulary, and informal tone make it particularly appealing for readers with little or no experience. The book starts with the most basic programming concepts and gradually works its way to advanced object-oriented techniques.', 'admin', '2022-08-02 12:30:00', 0,'admin', '2022-08-02 12:30:00', 0);
