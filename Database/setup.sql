
USE jailbook;

DROP TABLE IF EXISTS Friends;
DROP TABLE IF EXISTS Message;
DROP TABLE IF EXISTS Comment_Post;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Heist_Item;
DROP TABLE IF EXISTS Review;
DROP TABLE IF EXISTS Heist_Position;
DROP TABLE IF EXISTS Heist;
DROP TABLE IF EXISTS Criminal_Position;
DROP TABLE IF EXISTS Position;
DROP TABLE IF EXISTS Criminal;

CREATE TABLE Criminal (
    Criminal_ID INT NOT NULL AUTO_INCREMENT,
    Alias VARCHAR(255) UNIQUE NOT NULL,
    Pass_Word VARCHAR(255) UNIQUE NOT NULL,
    Prison_Release_Date DATE,
    Num_Years_Served INT,
    Rating FLOAT NOT NULL,
    PRIMARY KEY (Criminal_ID)
);

CREATE TABLE Position (
    Position_ID INT NOT NULL AUTO_INCREMENT,
    Position_Name VARCHAR(255) UNIQUE NOT NULL,
    Position_Description VARCHAR(255),
    PRIMARY KEY (Position_ID)
);

CREATE TABLE Criminal_Position (
    Criminal_ID INT NOT NULL,
    Position_ID INT NOT NULL,
    Skill_Level INT NOT NULL,
    PRIMARY KEY (Criminal_ID, Position_ID),
    FOREIGN KEY (Criminal_ID) REFERENCES Criminal (Criminal_ID),
    FOREIGN KEY (Position_ID) REFERENCES Position (Position_ID)
);

CREATE TABLE Heist (
    Heist_ID INT NOT NULL AUTO_INCREMENT,
    Mastermind INT NOT NULL,
    Title VARCHAR(255) NOT NULL,
    Heist_Description VARCHAR(255),
    Location VARCHAR(255) NOT NULL,
    Start_Timestamp TIMESTAMP NOT NULL,
    Close_Timestamp TIMESTAMP,
    Target VARCHAR(255),
    Score VARCHAR(255),
    PRIMARY KEY (Heist_ID),
    FOREIGN KEY (Mastermind) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Heist_Position (
    Heist_ID INT NOT NULL,
    Criminal_ID INT NOT NULL,
    Position_ID INT NOT NULL,
    Minimum_Skill_Level INT,
    Maximum_Skill_Level INT,
    Minimum_Rating FLOAT,
    Maximum_Rating FLOAT,
    PRIMARY KEY (Heist_ID, Criminal_ID, Position_ID),
    FOREIGN KEY (Heist_ID) REFERENCES Heist (Heist_ID),
    FOREIGN KEY (Criminal_ID) REFERENCES Criminal (Criminal_ID),
    FOREIGN KEY (Position_ID) REFERENCES Position (Position_ID)
);

CREATE TABLE Review (
    Heist_ID INT NOT NULL,
    Reviewer INT NOT NULL,
    Reviewee INT NOT NULL,
    Review_Rating FLOAT NOT NULL,
    Review_Text VARCHAR(255),
    PRIMARY KEY (Heist_ID, Reviewer, Reviewee),
    FOREIGN KEY (Heist_ID) REFERENCES Heist (Heist_ID),
    FOREIGN KEY (Reviewer) REFERENCES Criminal (Criminal_ID),
    FOREIGN KEY (Reviewee) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Heist_Item (
    Heist_Item_ID INT NOT NULL AUTO_INCREMENT,
    Heist_ID INT NOT NULL,
    Bringer INT NOT NULL,
    Item_Name VARCHAR(255) NOT NULL,
    Item_Description VARCHAR(255),
    Quantity INT NOT NULL,
    PRIMARY KEY (Heist_Item_ID),
    FOREIGN KEY (Heist_ID) REFERENCES Heist (Heist_ID),
    FOREIGN KEY (Bringer) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Post (
    Post_ID INT NOT NULL AUTO_INCREMENT,
    Criminal_ID INT NOT NULL,
    Upvote_Count INT NOT NULL,
    Post_Text VARCHAR(255) NOT NULL,
    Category VARCHAR(255) NOT NULL,
    Post_Timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY (Post_ID),
    FOREIGN KEY (Criminal_ID) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Comment_Post (
    Comment_Post_ID INT NOT NULL AUTO_INCREMENT,
    Post_ID INT NOT NULL,
    Criminal_ID INT NOT NULL,
    Comment_Text VARCHAR(255) NOT NULL,
    Upvote_Count INT NOT NULL,
    Comment_Timestamp TIMESTAMP NOT NULL,
    PRIMARY KEY (Comment_Post_ID),
    FOREIGN KEY (Post_ID) REFERENCES Post (Post_ID),
    FOREIGN KEY (Criminal_ID) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Message (
    Message_ID INT NOT NULL AUTO_INCREMENT,
    Sender INT NOT NULL,
    Recipient INT NOT NULL,
    Body_Text VARCHAR(255) NOT NULL,
    Message_Timestamp TIMESTAMP NOT NULL,
    Is_Read BOOLEAN NOT NULL,
    PRIMARY KEY (Message_ID),
    FOREIGN KEY (Sender) REFERENCES Criminal (Criminal_ID),
    FOREIGN KEY (Recipient) REFERENCES Criminal (Criminal_ID)
);

CREATE TABLE Friends (
    Friend_One INT NOT NULL,
    Friend_Two INT NOT NULL,
    PRIMARY KEY (Friend_One, Friend_Two),
    FOREIGN KEY (Friend_One) REFERENCES Criminal (Criminal_ID),
    FOREIGN KEY (Friend_Two) REFERENCES Criminal (Criminal_ID)
);

-- Sample Data for Criminal Table
INSERT INTO Criminal (Alias, Pass_Word, Prison_Release_Date, Num_Years_Served, Rating)
	VALUES ('Mr. Pink', 'hashin_assassin', '2016-03-23', 5, 4.75);
INSERT INTO Criminal (Alias, Pass_Word, Prison_Release_Date, Num_Years_Served, Rating)
	VALUES ('Morpheus', 'n2theMatrix', '2010-08-11', 7, 4.38);
INSERT INTO Criminal (Alias, Pass_Word, Prison_Release_Date, Num_Years_Served, Rating)
	VALUES ('Mr. Bigglesworth', 'lolKatz', '2019-10-05', 20, 4.98);
INSERT INTO Criminal (Alias, Pass_Word, Prison_Release_Date, Num_Years_Served, Rating)
	VALUES ('Dr. Evil', '$1M_Dollars', '1999-02-14', 15, 3.28);
INSERT INTO Criminal (Alias, Pass_Word, Prison_Release_Date, Num_Years_Served, Rating)
	VALUES ('The Wet Bandit', 'cloggin_yo_sink', '1991-12-26', 2, 2.56);

-- Sample Data for Position Table
INSERT INTO Position (Position_Name, Position_Description)
	VALUES ('Gunman', 'Supplies guns and ammunitions and shoots to kill');
INSERT INTO Position (Position_Name, Position_Description)
	VALUES ('Driver', 'Drives the getaway vehicle');
INSERT INTO Position (Position_Name, Position_Description)
	VALUES ('Lockpick', 'Picks locks and cracks safes');
INSERT INTO Position (Position_Name, Position_Description)
	VALUES ('Hacker', 'Disables security systems/cameras');
INSERT INTO Position (Position_Name, Position_Description)
	VALUES ('Brains', 'Manages the planning of heists');

-- Sample Data for Criminal_Position Table
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (1, 1, 8);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (1, 2, 2);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (1, 3, 3);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (1, 4, 1);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (1, 5, 2);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (2, 1, 3);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (2, 2, 7);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (2, 3, 4);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (2, 4, 1);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (2, 5, 9);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (3, 1, 1);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (3, 2, 2);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (3, 3, 8);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (3, 4, 5);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (3, 5, 3);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (4, 1, 1);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (4, 2, 2);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (4, 3, 5);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (4, 4, 10);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (4, 5, 8);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (5, 1, 3);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (5, 2, 6);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (5, 3, 3);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (5, 4, 1);
INSERT INTO Criminal_Position (Criminal_ID, Position_ID, Skill_Level)
	VALUES (5, 5, 8);

-- Sample Data for Heist Table
INSERT INTO Heist (Mastermind, Title, Heist_Description, Location, Start_Timestamp, Close_Timestamp, Target, Score)
	VALUES (5, 'The Grinch Stole Christmas', 'Like stealing candy from a baby', '123 Townsville Rd. Hicksville, CA 93619', '2020-12-25 22:45:00', null, 'Secret Santa Community Center', 'Tons of Xmas gifts');
INSERT INTO Heist (Mastermind, Title, Heist_Description, Location, Start_Timestamp, Close_Timestamp, Target, Score)
	VALUES (4, 'Operation Military Pay Day', 'We are going to rob the USAA bank, like Finance robbed me.', '9800 Fredericksburg Rd. San Antonio, TX 78288', '2020-01-15 03:15:00', '2020-01-16 14:38:52', 'USAA Bank', '$7.5 Million');

-- Sample Data for Heist_Position Table
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (1, 5, 5, 4, null, 2.50, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (1, 2, 2, 5, 9, 2.50, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (1, 3, 3, 7, null, 4.00, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (2, 1, 1, 7, null, 4.00, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (2, 2, 5, 8, null, 4.00, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (2, 3, 3, 8, null, 4.50, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (2, 4, 4, 9, null, 3.00, null);
INSERT INTO Heist_Position (Heist_ID, Criminal_ID, Position_ID, Minimum_Skill_Level, Maximum_Skill_Level, Minimum_Rating, Maximum_Rating)
	VALUES (2, 5, 2, 5, null, 2.00, null);

-- Sample Data for Review Table
INSERT INTO Review (Heist_ID, Reviewer, Reviewee, Review_Rating, Review_Text)
	VALUES (2, 2, 5, 1.00, 'Brought a two-seater getaway vehicle to a bank robbery! I was cramped during the entire getaway chase. WHAT A AMATEUR!!!');
INSERT INTO Review (Heist_ID, Reviewer, Reviewee, Review_Rating, Review_Text)
	VALUES (1, 5, 3, 5.00, 'The man knows how to pick locks like no ones business. I would not let him know where you live. JK =)');

-- Sample Data for Heist_Item Table
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (1, 2, 'Getaway vehicle', 'A beautiful, red 2019 Mustang GT. Fast as all hell.', 1);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (1, 3, 'Lockpick Set', 'My own personal collection of lockpicking tools. They were a gift from my father.', 1);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (2, 1, 'Colt AR-15', 'The Colt AR-15 is a lightweight, magazine-fed, gas-operated semi-automatic rifle.', 5);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (2, 1, 'Ammo', '150 rounds for each AR-15', 5);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (2, 3, 'ITL Robotic Safe Cracker', 'The best automatic safe cracker on the black market.', 1);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (2, 4, 'MacBook Pro', 'I can hack the security system from inside my terminal.', 1);
INSERT INTO Heist_Item (Heist_ID, Bringer, Item_Name, Item_Description, Quantity)
	VALUES (2, 5, 'Car', 'My own car. My wife is using the van right now. Sorry.', 1);

-- Sample Data for Post Table
INSERT INTO Post (Criminal_ID, Upvote_Count, Post_Text, Category, Post_Timestamp)
	VALUES (1, 54, 'Apparently CA is prohibiting the arrest of looters with protest signs. I see an opportunity, don\'t you?', 'Police Reform', '2020-12-16 11:32:56');
INSERT INTO Post (Criminal_ID, Upvote_Count, Post_Text, Category, Post_Timestamp)
	VALUES (2, 109, 'Target says they are no longer accepting customer product returns. Who is the real criminal, am I right?', 'Business', '2020-11-08 15:04:16');
INSERT INTO Post (Criminal_ID, Upvote_Count, Post_Text, Category, Post_Timestamp)
	VALUES (5, -438, 'Can someone please sell me a PS5? They\'re all sold out here.', 'Technology', '2020-12-01 10:28:32');

-- Sample Data for Comment_Post Table
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (1, 3, 'I\'m getting my sign ready. I\'ll see you guys at the next protest!', 25, '2020-12-16 12:37:40');
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (1, 4, 'Count me in!', 3, '2020-12-16 12:49:13');
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (2, 1, 'I swear, someone needs to put a stop to these greedy corporations taking everyone\'s money!', 83, '2020-11-08 15:58:27');
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (3, 2, 'Why not just steal one?', 284, '2020-12-01 11:01:48');
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (3, 1, 'No one cares what you want, bud.', 36, '2020-12-01 11:02:03');
INSERT INTO Comment_Post (Post_ID, Criminal_ID, Comment_Text, Upvote_Count, Comment_Timestamp)
	VALUES (3, 3, 'Send me $500 bucks and I\'ll ship you one.', 105, '2020-12-01 11:14:44');

-- Sample Data for Message Table
INSERT INTO Message (Sender, Recipient, Body_Text, Message_Timestamp, Is_Read)
	VALUES (5, 3, 'Hey wanna go see the new Adam Sandler flick this Saturday?', '2020-12-17 19:06:12', true);
INSERT INTO Message (Sender, Recipient, Body_Text, Message_Timestamp, Is_Read)
	VALUES (3, 5, 'No', '2020-12-17 19:07:11', true);
INSERT INTO Message (Sender, Recipient, Body_Text, Message_Timestamp, Is_Read)
	VALUES (5, 1, 'When are you going to return the Xbox that I let you borrow?', '2020-12-18 22:27:02', false);

-- Sample Data for Friends Table
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (1, 4);
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (1, 5);
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (2, 3);
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (2, 4);
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (2, 5);
INSERT INTO Friends (Friend_One, Friend_Two)
	VALUES (3, 5);