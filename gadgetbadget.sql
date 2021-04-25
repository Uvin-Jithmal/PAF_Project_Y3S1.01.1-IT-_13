-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 03:42 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Phone_number` varchar(10) NOT NULL,
  `Project_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `Name`, `Email`, `Phone_number`, `Project_name`) VALUES
(1, 'Ishara', 'Isaharadilki@gmail.com', '0766312357', ''),
(4, 'Isuru Dilaka', 'Dilaka@gmail.com', '077964235', 'Hotel Managemnet'),
(6, 'Kavindu', 'Kavindu@gmail.com', '0178945632', 'BikeHome');

-- --------------------------------------------------------

--
-- Table structure for table `payment_t`
--

CREATE TABLE `payment_t` (
  `payment_id` int(100) NOT NULL,
  `cus_name` varchar(200) NOT NULL,
  `mobile_no` varchar(200) NOT NULL,
  `amount` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `card_type` varchar(200) NOT NULL,
  `card_no` varchar(100) NOT NULL,
  `exp_month` varchar(20) NOT NULL,
  `exp_year` varchar(20) NOT NULL,
  `cvn` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment_t`
--

INSERT INTO `payment_t` (`payment_id`, `cus_name`, `mobile_no`, `amount`, `email`, `card_type`, `card_no`, `exp_month`, `exp_year`, `cvn`) VALUES
(1, 'Angelo', '0766312357', '15000', 'angelo@gmeil.com', 'Visa', '78994214237989634', '10', '23', '486');

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `Pro_ID` int(11) NOT NULL,
  `Pro_Name` varchar(50) NOT NULL,
  `Pro_Category` varchar(50) NOT NULL,
  `Pro_Description` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `projects`
--

INSERT INTO `projects` (`Pro_ID`, `Pro_Name`, `Pro_Category`, `Pro_Description`) VALUES
(1, 'FlipApp', 'Mobile Application', 'Social Media App like facebook'),
(3, 'ITPM Project', 'Desktop Application', 'Desktop Application C# MSsql'),
(4, 'Pharmacutical Management System', 'Web Based Application', 'Java/JDBC/MySQL Database/Eclipse Tool'),
(5, 'Online Storage And File Sharing System', 'Web Site', 'MsSQL/ PHP/Website/Provide Storage for Customers'),
(6, 'Vehicle Sparepart Management Sysytem', 'Mobile Application', 'Users Can search Any Spare part/Firebase'),
(9, 'GadgetBadget online Platform', 'Restful Web Service', 'Highly Scalable Restful Web Service/ PHPMyAdmin/ MySQL Database');

-- --------------------------------------------------------

--
-- Table structure for table `researcher`
--

CREATE TABLE `researcher` (
  `ResearcherID` int(11) NOT NULL,
  `ResearcherName` varchar(20) NOT NULL,
  `ResearcherEmail` varchar(20) NOT NULL,
  `AboutResearcher` varchar(200) NOT NULL,
  `ProjectName` varchar(20) NOT NULL,
  `ProjectDescription` varchar(500) NOT NULL,
  `ProjectPrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `researcher`
--

INSERT INTO `researcher` (`ResearcherID`, `ResearcherName`, `ResearcherEmail`, `AboutResearcher`, `ProjectName`, `ProjectDescription`, `ProjectPrice`) VALUES
(1, 'Kalindu Laksahan', 'kali@gmail.com', 'gangster', 'POS ', 'This is a good project', 3000),
(2, 'Uvin Jithmal', 'Uvinj@gmail.com', 'I am a NSBM Student', 'Web Application', 'This my Web Application', 2400),
(9, 'Nipun l', 'NipunL@gmail.com', 'I Am a Sliit Student', 'Quiz Application', 'This App is IOS Application', 5000),
(10, 'Anjelo', 'Anjelo@gmaol.com', 'I am working on my app', 'Mobile App', 'This is an ios app', 7500);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `payment_t`
--
ALTER TABLE `payment_t`
  ADD PRIMARY KEY (`payment_id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`Pro_ID`);

--
-- Indexes for table `researcher`
--
ALTER TABLE `researcher`
  ADD PRIMARY KEY (`ResearcherID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `payment_t`
--
ALTER TABLE `payment_t`
  MODIFY `payment_id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `Pro_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `researcher`
--
ALTER TABLE `researcher`
  MODIFY `ResearcherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
