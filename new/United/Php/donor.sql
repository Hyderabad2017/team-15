-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 16, 2017 at 03:51 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `united`
--

-- --------------------------------------------------------

--
-- Table structure for table `donor`
--

CREATE TABLE `donor` (
  `doid` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Mobile` varchar(13) NOT NULL,
  `City` varchar(20) NOT NULL,
  `Area` varchar(20) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Bgroup` varchar(100) NOT NULL,
  `Weight` int(4) NOT NULL,
  `Age` int(4) NOT NULL,
  `state` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `donor`
--

INSERT INTO `donor` (`doid`, `Name`, `Email`, `Password`, `Mobile`, `City`, `Area`, `Gender`, `Bgroup`, `Weight`, `Age`, `state`) VALUES
(15, 'ranjith', 'g@gmail.com', 'f4044efc0ab23485f5c10d1302116c57', '', 'Hyderabad', 'jntu', 'Male', 'A plus', 32, 21, 'yes'),
(16, 'gshz', 'b@gmail.com', '074fd28eff0f5adea071694061739e55', '', 'Hyderabad', 'jntu', 'Male', 'A plus', 32, 21, 'yes'),
(17, 'gshs', 'b@gmail.cpm', '79d886010186eb60e3611cd4a5d0bcae', '', 'Hyderabad', 'h@gmail.com', 'Male', 'A minus', 32, 54, 'yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donor`
--
ALTER TABLE `donor`
  ADD PRIMARY KEY (`doid`,`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donor`
--
ALTER TABLE `donor`
  MODIFY `doid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
