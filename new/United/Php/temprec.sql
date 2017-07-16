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
-- Table structure for table `temprec`
--

CREATE TABLE `temprec` (
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `reg` varchar(100) NOT NULL,
  `Active` varchar(100) NOT NULL,
  `Status` varchar(100) NOT NULL,
  `pwd` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `temprec`
--

INSERT INTO `temprec` (`name`, `email`, `reg`, `Active`, `Status`, `pwd`) VALUES
('gh', 'r@gmail.com', '23', 'Yes', 'Yes', '222222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `temprec`
--
ALTER TABLE `temprec`
  ADD PRIMARY KEY (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
