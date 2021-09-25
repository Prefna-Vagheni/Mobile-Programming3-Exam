-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2021 at 09:02 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `logindetails`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `date`) VALUES
(1, '', 'gateka', '$2y$10$oG0yNAOUK9A2MGFnoo/n2.E4nfca6TSVrk6okCamIf4', NULL),
(2, 'Gateka Armel', 'gatarm', '1234', NULL),
(3, '', 'hgfc', '$2y$10$Sn76P.4jUGDDOYByQx374OwcDQB4QtkvaaxzgTvFNpy', NULL),
(4, '', 'armeee', '$2y$10$LQ49eMb41lTvqdGI6iZMReOBdfZpo4CriT4mkqKNdc9', NULL),
(9, '', 'rya', '$2y$10$XdKsQLuXRuxR5KtY7TxWRuUnJpNmWCv43CIMx3MvaAX', NULL),
(13, 'gateka_armel', 'gatarme', '1234', NULL),
(14, '', 'rutwe', '$2y$10$TOF/iRfKlcIBiMXbHp9MR.Fzb50hwnOLZfq5RVy/VV8', NULL),
(15, 'Shaffic', 'Shaffic', '1234', '0000-00-00 00:00:00'),
(16, '', 'gtw', '$2y$10$hjqlWTB/lV09bp34JpaRSemE8wijfDv/nNh2IAYff1i', NULL),
(17, '', 'irakora', '$2y$10$bwuYBr1eg7j.u8yV2WPNHOKjS/RakkNZaRFtEUiC0ng', NULL),
(18, '', 'gc', '$2y$10$OSQnieIplKox5AgLVN7uQusOey/3vc5yw5UZ/Li3XQD', NULL),
(19, '', 'amahera', '$2y$10$FAquHxzwyFPdQLyGZszhM.CZ58hg8netI4Atq5CqEs.', NULL),
(20, '', 'yogi', '$2y$10$7NYClbJeNC.YyIixjTqnAuF6bi53P.BjTzGOCwQ8dVl', NULL),
(21, '', 'armel', '$2y$10$D87cfUkyv.1AsJS7nZMuauZvTjTXJS6btp2NFKHUBh0', NULL),
(22, '', 'gateka exam', '$2y$10$SoRMV4OzPA.f0VdrGkrqFOspfDCGh0OXrx/o4nJLsWZ', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
