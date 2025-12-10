-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 05, 2025 at 12:47 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `testingsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `AccountID` tinyint(3) UNSIGNED NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `FullName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DepartmentID` tinyint(3) UNSIGNED NOT NULL,
  `PositionID` tinyint(3) UNSIGNED NOT NULL,
  `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`AccountID`, `Email`, `Username`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES
(2, 'Email2@gmail.com', 'Username2', 'Fullname2', 1, 2, '2020-03-05 00:00:00'),
(3, 'Email3@gmail.com', 'Username3', 'Fullname3', 2, 2, '2020-03-07 00:00:00'),
(4, 'Email4@gmail.com', 'Username4', 'Fullname4', 3, 4, '2020-03-08 00:00:00'),
(5, 'Email5@gmail.com', 'Username5', 'Fullname5', 4, 4, '2020-03-10 00:00:00'),
(6, 'Email6@gmail.com', 'Username6', 'Fullname6', 6, 3, '2020-04-05 00:00:00'),
(7, 'Email7@gmail.com', 'Username7', 'Fullname7', 2, 2, NULL),
(8, 'Email8@gmail.com', 'Username8', 'Fullname8', 8, 1, '2020-04-07 00:00:00'),
(9, 'Email9@gmail.com', 'Username9', 'Fullname9', 2, 2, '2020-04-07 00:00:00'),
(10, 'Email10@gmail.com', 'Username10', 'Fullname10', 10, 1, '2020-04-09 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `answer`
--

CREATE TABLE `answer` (
  `AnswerID` tinyint(3) UNSIGNED NOT NULL,
  `Content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `QuestionID` tinyint(3) UNSIGNED NOT NULL,
  `isCorrect` bit(1) DEFAULT b'1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `answer`
--

INSERT INTO `answer` (`AnswerID`, `Content`, `QuestionID`, `isCorrect`) VALUES
(1, 'Trả lời 01', 1, b'0'),
(2, 'Trả lời 02', 1, b'1'),
(3, 'Trả lời 03', 1, b'0'),
(4, 'Trả lời 04', 1, b'1'),
(5, 'Trả lời 05', 2, b'1'),
(6, 'Trả lời 06', 3, b'1'),
(7, 'Trả lời 07', 4, b'0'),
(8, 'Trả lời 08', 8, b'0'),
(9, 'Trả lời 09', 9, b'1'),
(10, 'Trả lời 10', 10, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `categoryquestion`
--

CREATE TABLE `categoryquestion` (
  `CategoryID` tinyint(3) UNSIGNED NOT NULL,
  `CategoryName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `categoryquestion`
--

INSERT INTO `categoryquestion` (`CategoryID`, `CategoryName`) VALUES
(3, 'ADO.NET'),
(2, 'ASP.NET'),
(9, 'C Sharp'),
(8, 'C++'),
(1, 'Java'),
(10, 'PHP'),
(5, 'Postman'),
(7, 'Python'),
(6, 'Ruby'),
(4, 'SQL');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `DepartmentID` tinyint(3) UNSIGNED NOT NULL,
  `DepartmentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`DepartmentID`, `DepartmentName`) VALUES
(1, 'Marketing'),
(2, 'Sale'),
(3, 'Bảo vệ'),
(4, 'Nhân sự'),
(6, 'Tài chính'),
(7, 'Phó giám đốc'),
(8, 'Giám đốc'),
(9, 'Thư kí'),
(10, 'Bán hàng');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `ExamID` tinyint(3) UNSIGNED NOT NULL,
  `Code` char(10) NOT NULL,
  `Title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CategoryID` tinyint(3) UNSIGNED NOT NULL,
  `Duration` tinyint(3) UNSIGNED NOT NULL,
  `CreatorID` tinyint(3) UNSIGNED NOT NULL,
  `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`ExamID`, `Code`, `Title`, `CategoryID`, `Duration`, `CreatorID`, `CreateDate`) VALUES
(1, 'VTIQ001', 'Đề thi C#', 1, 60, 5, '2019-04-05 00:00:00'),
(2, 'VTIQ002', 'Đề thi PHP', 10, 60, 2, '2019-04-05 00:00:00'),
(3, 'VTIQ003', 'Đề thi C++', 9, 120, 2, '2019-04-07 00:00:00'),
(4, 'VTIQ004', 'Đề thi Java', 6, 60, 3, '2020-04-08 00:00:00'),
(5, 'VTIQ005', 'Đề thi Ruby', 5, 120, 4, '2020-04-10 00:00:00'),
(6, 'VTIQ006', 'Đề thi Postman', 3, 60, 6, '2020-04-05 00:00:00'),
(7, 'VTIQ007', 'Đề thi SQL', 2, 60, 7, '2020-04-05 00:00:00'),
(8, 'VTIQ008', 'Đề thi Python', 8, 60, 8, '2020-04-07 00:00:00'),
(9, 'VTIQ009', 'Đề thi ADO.NET', 4, 90, 9, '2020-04-07 00:00:00'),
(10, 'VTIQ010', 'Đề thi ASP.NET', 7, 90, 10, '2020-04-08 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `examquestion`
--

CREATE TABLE `examquestion` (
  `ExamID` tinyint(3) UNSIGNED NOT NULL,
  `QuestionID` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `examquestion`
--

INSERT INTO `examquestion` (`ExamID`, `QuestionID`) VALUES
(1, 5),
(2, 10),
(3, 4),
(4, 3),
(5, 7),
(6, 10),
(7, 2),
(8, 10),
(9, 9),
(10, 8);

-- --------------------------------------------------------

--
-- Table structure for table `group`
--

CREATE TABLE `group` (
  `GroupID` tinyint(3) UNSIGNED NOT NULL,
  `GroupName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CreatorID` tinyint(3) UNSIGNED DEFAULT NULL,
  `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `group`
--

INSERT INTO `group` (`GroupID`, `GroupName`, `CreatorID`, `CreateDate`) VALUES
(1, 'Testing System', 5, '2019-03-05 00:00:00'),
(3, 'VTI Sale 01', 2, '2020-03-09 00:00:00'),
(4, 'VTI Sale 02', 3, '2020-03-10 00:00:00'),
(5, 'VTI Sale 03', 4, '2020-03-28 00:00:00'),
(6, 'VTI Creator', 6, '2020-04-06 00:00:00'),
(7, 'VTI Marketing 01', 7, '2020-04-07 00:00:00'),
(8, 'Management', 8, '2020-04-08 00:00:00'),
(9, 'Chat with love', 9, '2020-04-09 00:00:00'),
(10, 'Vi Ti Ai', 10, '2020-04-10 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `groupaccount`
--

CREATE TABLE `groupaccount` (
  `GroupID` tinyint(3) UNSIGNED NOT NULL,
  `AccountID` tinyint(3) UNSIGNED NOT NULL,
  `JoinDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `groupaccount`
--

INSERT INTO `groupaccount` (`GroupID`, `AccountID`, `JoinDate`) VALUES
(1, 1, '2019-03-05 00:00:00'),
(1, 2, '2020-03-07 00:00:00'),
(1, 3, '2020-04-06 00:00:00'),
(1, 7, '2020-04-07 00:00:00'),
(1, 9, '2020-04-09 00:00:00'),
(3, 3, '2020-03-09 00:00:00'),
(3, 4, '2020-03-10 00:00:00'),
(4, 5, '2020-03-28 00:00:00'),
(8, 3, '2020-04-08 00:00:00'),
(10, 10, '2020-04-10 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE `position` (
  `PositionID` tinyint(3) UNSIGNED NOT NULL,
  `PositionName` enum('Dev','Test','Scrum Master','PM') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`PositionID`, `PositionName`) VALUES
(1, 'Dev'),
(2, 'Test'),
(3, 'Scrum Master'),
(4, 'PM');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `QuestionID` tinyint(3) UNSIGNED NOT NULL,
  `Content` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CategoryID` tinyint(3) UNSIGNED NOT NULL,
  `TypeID` tinyint(3) UNSIGNED NOT NULL,
  `CreatorID` tinyint(3) UNSIGNED NOT NULL,
  `CreateDate` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`QuestionID`, `Content`, `CategoryID`, `TypeID`, `CreatorID`, `CreateDate`) VALUES
(1, 'Câu hỏi về Java', 1, 1, 2, '2020-04-05 00:00:00'),
(2, 'Câu Hỏi về PHP', 10, 2, 2, '2020-04-05 00:00:00'),
(3, 'Hỏi về C#', 9, 2, 3, '2020-04-06 00:00:00'),
(4, 'Hỏi về Ruby', 6, 1, 4, '2020-04-06 00:00:00'),
(5, 'Hỏi về Postman', 5, 1, 5, '2020-04-06 00:00:00'),
(6, 'Hỏi về ADO.NET', 3, 2, 6, '2020-04-06 00:00:00'),
(7, 'Hỏi về ASP.NET', 2, 1, 7, '2020-04-06 00:00:00'),
(8, 'Hỏi về C++', 8, 1, 8, '2020-04-07 00:00:00'),
(9, 'Hỏi về SQL', 4, 2, 9, '2020-04-07 00:00:00'),
(10, 'Hỏi về Python', 7, 1, 10, '2020-04-07 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `typequestion`
--

CREATE TABLE `typequestion` (
  `TypeID` tinyint(3) UNSIGNED NOT NULL,
  `TypeName` enum('Essay','Multiple-Choice') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `typequestion`
--

INSERT INTO `typequestion` (`TypeID`, `TypeName`) VALUES
(1, 'Essay'),
(2, 'Multiple-Choice');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`AccountID`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD KEY `DepartmentID` (`DepartmentID`),
  ADD KEY `PositionID` (`PositionID`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`AnswerID`),
  ADD KEY `QuestionID` (`QuestionID`);

--
-- Indexes for table `categoryquestion`
--
ALTER TABLE `categoryquestion`
  ADD PRIMARY KEY (`CategoryID`),
  ADD UNIQUE KEY `CategoryName` (`CategoryName`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`DepartmentID`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`ExamID`),
  ADD KEY `CategoryID` (`CategoryID`),
  ADD KEY `CreatorID` (`CreatorID`);

--
-- Indexes for table `examquestion`
--
ALTER TABLE `examquestion`
  ADD PRIMARY KEY (`ExamID`,`QuestionID`),
  ADD KEY `QuestionID` (`QuestionID`);

--
-- Indexes for table `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`GroupID`),
  ADD UNIQUE KEY `GroupName` (`GroupName`),
  ADD KEY `CreatorID` (`CreatorID`);

--
-- Indexes for table `groupaccount`
--
ALTER TABLE `groupaccount`
  ADD PRIMARY KEY (`GroupID`,`AccountID`);

--
-- Indexes for table `position`
--
ALTER TABLE `position`
  ADD PRIMARY KEY (`PositionID`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`QuestionID`),
  ADD KEY `CategoryID` (`CategoryID`),
  ADD KEY `TypeID` (`TypeID`),
  ADD KEY `CreatorID` (`CreatorID`);

--
-- Indexes for table `typequestion`
--
ALTER TABLE `typequestion`
  ADD PRIMARY KEY (`TypeID`),
  ADD UNIQUE KEY `TypeName` (`TypeName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `AccountID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `answer`
--
ALTER TABLE `answer`
  MODIFY `AnswerID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `categoryquestion`
--
ALTER TABLE `categoryquestion`
  MODIFY `CategoryID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `DepartmentID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `ExamID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `group`
--
ALTER TABLE `group`
  MODIFY `GroupID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `position`
--
ALTER TABLE `position`
  MODIFY `PositionID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `QuestionID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `typequestion`
--
ALTER TABLE `typequestion`
  MODIFY `TypeID` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE CASCADE,
  ADD CONSTRAINT `account_ibfk_2` FOREIGN KEY (`PositionID`) REFERENCES `position` (`PositionID`) ON DELETE CASCADE;

--
-- Constraints for table `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `question` (`QuestionID`) ON DELETE CASCADE;

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `categoryquestion` (`CategoryID`) ON DELETE CASCADE,
  ADD CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`CreatorID`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE;

--
-- Constraints for table `examquestion`
--
ALTER TABLE `examquestion`
  ADD CONSTRAINT `examquestion_ibfk_1` FOREIGN KEY (`QuestionID`) REFERENCES `question` (`QuestionID`) ON DELETE CASCADE,
  ADD CONSTRAINT `examquestion_ibfk_2` FOREIGN KEY (`ExamID`) REFERENCES `exam` (`ExamID`) ON DELETE CASCADE;

--
-- Constraints for table `group`
--
ALTER TABLE `group`
  ADD CONSTRAINT `group_ibfk_1` FOREIGN KEY (`CreatorID`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE;

--
-- Constraints for table `groupaccount`
--
ALTER TABLE `groupaccount`
  ADD CONSTRAINT `groupaccount_ibfk_1` FOREIGN KEY (`GroupID`) REFERENCES `group` (`GroupID`) ON DELETE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `categoryquestion` (`CategoryID`) ON DELETE CASCADE,
  ADD CONSTRAINT `question_ibfk_2` FOREIGN KEY (`TypeID`) REFERENCES `typequestion` (`TypeID`) ON DELETE CASCADE,
  ADD CONSTRAINT `question_ibfk_3` FOREIGN KEY (`CreatorID`) REFERENCES `account` (`AccountID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
