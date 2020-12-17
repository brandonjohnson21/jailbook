CREATE DATABASE jailbook;
CREATE DATABASE jailbook_test;

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
