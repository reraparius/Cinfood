-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2021 at 06:29 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinfood`
--

-- --------------------------------------------------------

--
-- Table structure for table `config`
--

CREATE TABLE `config` (
  `id` int(6) UNSIGNED NOT NULL,
  `config` varchar(150) NOT NULL,
  `value` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `config`
--

INSERT INTO `config` (`id`, `config`, `value`) VALUES
(1, 'cfg', '{\"websitetitle\":\"cinfood\",\"maincolor\":\"#F28433\",\"secondcolor\":\"#FFB98A\",\"about\":\"<p>Anda Lapar? Kami Siap Antar.<\\/p>\",\"language\":\"id\",\"thumbnailmode\":\"0\",\"logo\":\"wdi2pznm4c.jpeg\",\"adminwhatsapp\":\"6287880334339\",\"currencysymbol\":\"$\",\"baseurl\":\"http:\\/\\/localhost\\/cinfood\\/\",\"enablerecentpostsliders\":\"1\",\"enablefacebookcomment\":\"1\",\"enablepublishdate\":\"1\",\"disabledecimals\":\"0\"}');

-- --------------------------------------------------------

--
-- Table structure for table `dtl_transaksi_android`
--

CREATE TABLE `dtl_transaksi_android` (
  `id_dtl_transaksi` varchar(6) NOT NULL,
  `id_transaksi` int(11) NOT NULL,
  `id_menu` int(6) NOT NULL,
  `jumlah` int(4) NOT NULL,
  `tot_harga` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dtl_transaksi_android`
--

INSERT INTO `dtl_transaksi_android` (`id_dtl_transaksi`, `id_transaksi`, `id_menu`, `jumlah`, `tot_harga`) VALUES
('1', 2, 1, 2, 20000),
('2', 2, 1, 3, 30000),
('3', 3, 1, 2, 50000),
('4', 3, 2, 3, 60000),
('5', 4, 1, 3, 50000),
('6', 4, 2, 2, 20000),
('7', 123, 1, 2, 20000),
('8', 123, 2, 1, 20000),
('9', 2, 3, 1, 15000);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id` int(6) NOT NULL,
  `category` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id`, `category`) VALUES
(1, 'makanan'),
(2, 'minuman ');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id` int(6) NOT NULL,
  `postid` varchar(70) NOT NULL,
  `catid` int(6) NOT NULL,
  `normalprice` float NOT NULL,
  `discountprice` float NOT NULL,
  `title` varchar(300) NOT NULL,
  `time` varchar(150) NOT NULL,
  `options` varchar(200) NOT NULL,
  `picture` varchar(300) NOT NULL,
  `moreimages` text NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id`, `postid`, `catid`, `normalprice`, `discountprice`, `title`, `time`, `options`, `picture`, `moreimages`, `content`) VALUES
(1, '1', 2, 10000, 0, 'sego goreng ', '1637893541641', '', '', '', '<p>enak</p>'),
(2, '2', 1, 20000, 0, 'Ayam bakar ', '1637941078200', '', '', '', '<p>iuui</p>'),
(3, 'ydoardfqbt', 1, 15000, 0, 'nasi padang', '1637949244015', '', '', '', '<p>enak</p>');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_android`
--

CREATE TABLE `transaksi_android` (
  `id_transaksi` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `tot_harga` int(10) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi_android`
--

INSERT INTO `transaksi_android` (`id_transaksi`, `id_user`, `tot_harga`, `tanggal`) VALUES
(2, 1, 65000, '2021-11-26'),
(3, 1, 110000, '2021-11-14'),
(4, 2, 70000, '2021-11-05'),
(123, 1, 40000, '2021-11-02');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nm_depan` varchar(50) NOT NULL,
  `nm_belakang` varchar(50) NOT NULL,
  `jns_klmn` enum('Perempuan','Laki-Laki','','') NOT NULL,
  `tgl_lahir` date NOT NULL,
  `no_hp` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `email_user` varchar(40) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nm_depan`, `nm_belakang`, `jns_klmn`, `tgl_lahir`, `no_hp`, `alamat`, `email_user`, `password`) VALUES
(1, 'adam', 'hafiz', 'Laki-Laki', '2021-11-17', '123', '', 'adam', 'adam'),
(2, 'rafi', 'karta', 'Perempuan', '2021-11-03', '123', '', 'raf', 'raf');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `config`
--
ALTER TABLE `config`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dtl_transaksi_android`
--
ALTER TABLE `dtl_transaksi_android`
  ADD PRIMARY KEY (`id_dtl_transaksi`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_menu` (`id_menu`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `catid` (`catid`);

--
-- Indexes for table `transaksi_android`
--
ALTER TABLE `transaksi_android`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `config`
--
ALTER TABLE `config`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dtl_transaksi_android`
--
ALTER TABLE `dtl_transaksi_android`
  ADD CONSTRAINT `dtl_transaksi_android_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi_android` (`id_transaksi`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dtl_transaksi_android_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`catid`) REFERENCES `kategori` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi_android`
--
ALTER TABLE `transaksi_android`
  ADD CONSTRAINT `transaksi_android_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
