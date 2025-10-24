-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 22, 2025 at 02:02 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET time_zone = "+00:00";

CREATE TABLE `account` (
    `AccountID` int(11) NOT NULL,
    `Email` varchar(255) DEFAULT NULL,
    `Username` varchar(50) DEFAULT NULL,
    `FullName` varchar(100) DEFAULT NULL,
    `DepartmentID` int(11) DEFAULT NULL,
    `PositionID` int(11) DEFAULT NULL,
    `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `account` (
        `AccountID`,
        `Email`,
        `Username`,
        `FullName`,
        `DepartmentID`,
        `PositionID`,
        `CreateDate`
    )
VALUES (
        1,
        'alice@example.com',
        'alice',
        'Alice Nguyen',
        4,
        1,
        '2025-10-22 19:01:29'
    ),
    (
        2,
        'bob@example.com',
        'bob',
        'Bob Tran',
        4,
        2,
        '2025-10-22 19:01:29'
    ),
    (
        3,
        'carol@example.com',
        'carol',
        'Carol Pham',
        2,
        4,
        '2025-10-22 19:01:29'
    ),
    (
        4,
        'david@example.com',
        'david',
        'David Le',
        1,
        5,
        '2025-10-22 19:01:29'
    ),
    (
        5,
        'erin@example.com',
        'erin',
        'Erin Ho',
        3,
        3,
        '2025-10-22 19:01:29'
    );

CREATE TABLE `answer` (
    `AnswerID` int(11) NOT NULL,
    `Content` text DEFAULT NULL,
    `QuestionID` int(11) DEFAULT NULL,
    `isCorrect` tinyint(1) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `answer` (
        `AnswerID`,
        `Content`,
        `QuestionID`,
        `isCorrect`
    )
VALUES (
        1,
        'HashMap không đồng bộ, Hashtable có.',
        1,
        1
    ),
    (2, 'Giống nhau.', 1, 0),
    (
        3,
        'CLR là runtime, CTS là kiểu dữ liệu.',
        2,
        1
    ),
    (
        4,
        'SELECT TOP 5 theo doanh số.',
        3,
        1
    ),
    (
        5,
        'Pre-request chạy sau request.',
        4,
        0
    );

CREATE TABLE `categoryquestion` (
    `CategoryID` int(11) NOT NULL,
    `CategoryName` varchar(50) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `categoryquestion` (`CategoryID`, `CategoryName`)
VALUES (1, 'Java'),
    (2, '.NET'),
    (3, 'SQL'),
    (4, 'Postman'),
    (5, 'Ruby');

CREATE TABLE `department` (
    `DepartmentID` int(11) NOT NULL,
    `DepartmentName` varchar(100) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `department` (
        `DepartmentID`,
        `DepartmentName`
    )
VALUES (1, 'Sales'),
    (2, 'Marketing'),
    (3, 'HR'),
    (4, 'IT'),
    (5, 'Finance');

CREATE TABLE `exam` (
    `ExamID` int(11) NOT NULL,
    `Code` varchar(20) DEFAULT NULL,
    `Title` varchar(200) DEFAULT NULL,
    `CategoryID` int(11) DEFAULT NULL,
    `Duration` smallint(6) DEFAULT NULL,
    `CreatorID` int(11) DEFAULT NULL,
    `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `exam` (
        `ExamID`,
        `Code`,
        `Title`,
        `CategoryID`,
        `Duration`,
        `CreatorID`,
        `CreateDate`
    )
VALUES (
        1,
        'EX-JA-01',
        'Java Core Basics',
        1,
        60,
        1,
        '2025-10-22 19:01:29'
    ),
    (
        2,
        'EX-DN-01',
        '.NET Fundamentals',
        2,
        60,
        3,
        '2025-10-22 19:01:29'
    ),
    (
        3,
        'EX-SQL-01',
        'SQL Practice',
        3,
        45,
        2,
        '2025-10-22 19:01:29'
    ),
    (
        4,
        'EX-PS-01',
        'Postman Basics',
        4,
        30,
        5,
        '2025-10-22 19:01:29'
    ),
    (
        5,
        'EX-RB-01',
        'Ruby Essentials',
        5,
        45,
        4,
        '2025-10-22 19:01:29'
    );

CREATE TABLE `examquestion` (
    `ExamID` int(11) DEFAULT NULL,
    `QuestionID` int(11) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `examquestion` (`ExamID`, `QuestionID`)
VALUES (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

CREATE TABLE `group` (
    `GroupID` int(11) NOT NULL,
    `GroupName` varchar(100) DEFAULT NULL,
    `CreatorID` int(11) DEFAULT NULL,
    `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `group` (
        `GroupID`,
        `GroupName`,
        `CreatorID`,
        `CreateDate`
    )
VALUES (
        1,
        'G-Alpha',
        1,
        '2025-10-22 19:01:29'
    ),
    (
        2,
        'G-Beta',
        2,
        '2025-10-22 19:01:29'
    ),
    (
        3,
        'G-Gamma',
        3,
        '2025-10-22 19:01:29'
    ),
    (
        4,
        'G-Delta',
        4,
        '2025-10-22 19:01:29'
    ),
    (
        5,
        'G-Epsilon',
        5,
        '2025-10-22 19:01:29'
    );

CREATE TABLE `groupaccount` (
    `GroupID` int(11) DEFAULT NULL,
    `AccountID` int(11) DEFAULT NULL,
    `JoinDate` datetime DEFAULT current_timestamp()
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `groupaccount` (
        `GroupID`,
        `AccountID`,
        `JoinDate`
    )
VALUES (1, 1, '2025-10-22 19:01:29'),
    (1, 2, '2025-10-22 19:01:29'),
    (2, 3, '2025-10-22 19:01:29'),
    (3, 4, '2025-10-22 19:01:29'),
    (4, 5, '2025-10-22 19:01:29');

CREATE TABLE `position` (
    `PositionID` int(11) NOT NULL,
    `PositionName` varchar(50) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `position` (`PositionID`, `PositionName`)
VALUES (1, 'Dev'),
    (2, 'Test'),
    (3, 'Scrum Master'),
    (4, 'PM'),
    (5, 'BA');

CREATE TABLE `question` (
    `QuestionID` int(11) NOT NULL,
    `Content` text DEFAULT NULL,
    `CategoryID` int(11) DEFAULT NULL,
    `TypeID` int(11) DEFAULT NULL,
    `CreatorID` int(11) DEFAULT NULL,
    `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `question` (
        `QuestionID`,
        `Content`,
        `CategoryID`,
        `TypeID`,
        `CreatorID`,
        `CreateDate`
    )
VALUES (
        1,
        'Java: Khác nhau giữa HashMap và Hashtable?',
        1,
        1,
        1,
        '2025-10-22 19:01:29'
    ),
    (
        2,
        '.NET: Giải thích CLR và CTS.',
        2,
        4,
        3,
        '2025-10-22 19:01:29'
    ),
    (
        3,
        'SQL: Viết truy vấn lấy top 5 doanh số.',
        3,
        2,
        2,
        '2025-10-22 19:01:29'
    ),
    (
        4,
        'Postman: Cách dùng pre-request script.',
        4,
        2,
        5,
        '2025-10-22 19:01:29'
    ),
    (
        5,
        'Ruby: Khối (block) và Proc khác gì?',
        5,
        1,
        4,
        '2025-10-22 19:01:29'
    );

CREATE TABLE `typequestion` (
    `TypeID` int(11) NOT NULL,
    `TypeName` varchar(30) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO
    `typequestion` (`TypeID`, `TypeName`)
VALUES (1, 'Essay'),
    (2, 'Multiple-Choice'),
    (3, 'True/False'),
    (4, 'Short Answer'),
    (5, 'Fill Blank');

ALTER TABLE `account` ADD PRIMARY KEY (`AccountID`);

ALTER TABLE `answer` ADD PRIMARY KEY (`AnswerID`);

ALTER TABLE `categoryquestion` ADD PRIMARY KEY (`CategoryID`);

ALTER TABLE `department` ADD PRIMARY KEY (`DepartmentID`);

ALTER TABLE `exam` ADD PRIMARY KEY (`ExamID`);

ALTER TABLE `group` ADD PRIMARY KEY (`GroupID`);

ALTER TABLE `position` ADD PRIMARY KEY (`PositionID`);

ALTER TABLE `question` ADD PRIMARY KEY (`QuestionID`);

ALTER TABLE `typequestion` ADD PRIMARY KEY (`TypeID`);

ALTER TABLE `account`
MODIFY `AccountID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
MODIFY `AnswerID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `categoryquestion`
--
ALTER TABLE `categoryquestion`
MODIFY `CategoryID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
MODIFY `DepartmentID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
MODIFY `ExamID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `group`
--
ALTER TABLE `group`
MODIFY `GroupID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `position`
--
ALTER TABLE `position`
MODIFY `PositionID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

--
-- AUTO_INCREMENT for table `typequestion`
--
ALTER TABLE `typequestion`
MODIFY `TypeID` int(11) NOT NULL AUTO_INCREMENT,
AUTO_INCREMENT = 6;

COMMIT;

SELECT * FROM Account
WHERE AccountID BETWEEN 10 AND 20
ORDER BY AccountID ASC;
