-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220627.78b2c1f4eb
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 03, 2023 at 09:19 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hittastic`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `password`) VALUES
(1, 'admin@mail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL,
  `song_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `Date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`order_id`, `song_id`, `user_id`, `quantity`, `Date`) VALUES
(3, 5, 1, 3, '2022-12-28'),
(5, 3, 1, 1, '2022-12-28'),
(6, 5, 2, 1, '2022-12-29'),
(8, 9, 2, 1, '2022-12-29'),
(9, 1, 2, 1, '2022-12-29'),
(12, 1, 2, 1, '2022-12-29'),
(13, 1, 2, 1, '2022-12-29'),
(14, 2, 2, 1, '2022-12-29'),
(15, 1, 4, 1, '2022-12-30'),
(17, 3, 4, 1, '2022-12-30'),
(18, 2, 4, 1, '2022-12-30'),
(19, 1, 4, 1, '2022-12-30'),
(20, 8, 4, 1, '2022-12-30'),
(21, 21, 2, 1, '2022-12-31'),
(22, 1, 2, 1, '2022-12-31'),
(23, 24, 1, 1, '2023-01-01'),
(25, 4, 1, 1, '2023-01-01'),
(29, 1, 4, 3, '2023-01-02');

-- --------------------------------------------------------

--
-- Table structure for table `songs`
--

CREATE TABLE `songs` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `artist` varchar(255) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `songs`
--

INSERT INTO `songs` (`id`, `title`, `artist`, `amount`, `genre`) VALUES
(1, 'Zazuu', 'Portable', '15', 'Afrobeat'),
(2, 'Joha', 'Asake', '25', 'Afropop'),
(3, 'Stand Strong', 'Davido', '41', 'Afrobeat'),
(4, 'Nzaza', 'Asake', '23', 'Afropop'),
(5, 'Doja Cat', 'Central Cee', '45', 'Rap'),
(6, 'Organise', 'Asake', '35', 'Afrobeat'),
(7, 'Soja', 'Black sheriff', '25', 'Rap'),
(8, 'LET GO', 'Central Cee', '35', 'Rap'),
(9, 'Made you look', 'Meghan Trainor', '35', 'Hip Hop'),
(10, 'Cuff it', 'Beyonce', '56', 'Hip Hop'),
(13, 'ades', 'sas', '12.2', 'ade'),
(14, 'FIA', 'Davido', '29.99', 'pop'),
(15, 'calm down', 'rema', '12', 'pop'),
(18, 'dumebi', 'rema', '15.99', 'pop'),
(19, 'dapsy', 'dapo', '19.99', 'rock'),
(20, 'Alors Alors', 'Benzz', '10', 'rap'),
(21, 'Xtra Cool', 'Young John', '10', 'afropop'),
(23, 'Xtra Cool', 'Young John', '10', 'afropop'),
(24, 'FLUTE', 'MONSS', '21', 'Drum & Bass'),
(34, 'Fia', 'Davido', '29.99', 'pop'),
(37, 'Shirt', 'SZA', '21', 'Hip Hop');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`) VALUES
(1, 'freddy', 'fred@gmail.com', '12345'),
(2, 'demi', 'demi@mail.com', '1234'),
(3, 'jummy', 'jummy@mail.com', 'dex'),
(4, 'timmy', 'tim@mail.com', 'tim');

-- --------------------------------------------------------

--
-- Table structure for table `users_role`
--

CREATE TABLE `users_role` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_role`
--

INSERT INTO `users_role` (`id`, `email`, `password`, `role`) VALUES
(1, 'admin@mail.com', 'admin', 'admin'),
(2, 'fred@gmail.com', '12345', 'user'),
(3, 'demi@mail.com', '1234', 'user'),
(4, 'jummy@mail.com', 'dex', 'user'),
(5, 'tim@mail.com', 'tim', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `songs`
--
ALTER TABLE `songs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_role`
--
ALTER TABLE `users_role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `songs`
--
ALTER TABLE `songs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users_role`
--
ALTER TABLE `users_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



