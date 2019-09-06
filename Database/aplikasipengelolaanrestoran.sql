-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2018 at 08:40 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasipengelolaanrestoran`
--

-- --------------------------------------------------------

--
-- Table structure for table `item_menu_delivery`
--

CREATE TABLE `item_menu_delivery` (
  `node` char(10) DEFAULT NULL,
  `kd_menu` char(5) DEFAULT NULL,
  `alamat` varchar(15) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_menu_delivery`
--

INSERT INTO `item_menu_delivery` (`node`, `kd_menu`, `alamat`, `harga`, `jumlah`) VALUES
('D0001', 'M0001', 'terban', 20000, 2),
('D0001', 'M0009', 'terban', 3000, 2),
('D0002', 'M0003', 'wew', 18000, 2),
('D0002', 'M0010', 'wew', 4000, 1),
('D0003', 'M0001', 'Terban GG', 20000, 2),
('D0004', 'M0003', 'YEKA', 18000, 2),
('D0004', 'M0009', 'YEKA', 3000, 2);

-- --------------------------------------------------------

--
-- Table structure for table `item_menu_ditempat`
--

CREATE TABLE `item_menu_ditempat` (
  `nota` char(10) DEFAULT NULL,
  `kd_menu` char(5) DEFAULT NULL,
  `no_meja` char(2) NOT NULL,
  `harga` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_menu_ditempat`
--

INSERT INTO `item_menu_ditempat` (`nota`, `kd_menu`, `no_meja`, `harga`, `jumlah`) VALUES
('N0001', 'M0001', 'M1', 20000, 2),
('N0001', 'M0003', 'M1', 18000, 1),
('N0001', 'M0009', 'M1', 3000, 1),
('N0002', 'M0001', 'M2', 20000, 2),
('N0002', 'M0009', 'M2', 3000, 2),
('N0003', 'M0004', 'M3', 15000, 2),
('N0004', 'M0003', 'M1', 18000, 2),
('N0004', 'M0008', 'M1', 20000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` char(5) NOT NULL,
  `nama_karyawan` varchar(100) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `username`, `password`) VALUES
('K0001', 'Annas Al Amin', 'A3ISAGOD', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `kd_menu` char(5) NOT NULL,
  `nama_menu` varchar(100) NOT NULL,
  `harga_menu` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`kd_menu`, `nama_menu`, `harga_menu`) VALUES
('M0001', 'Rendang Sapi', '20000'),
('M0002', 'Pempek Kapal Selam', '15000'),
('M0003', 'Sate Ayam', '18000'),
('M0004', 'Gado-Gado', '15000'),
('M0005', 'Nasi Goreng Ayam', '16000'),
('M0006', 'Sop Buntut', '20000'),
('M0007', 'Soto Ayam', '17000'),
('M0008', 'Gudeg', '20000'),
('M0009', 'Es Teh', '3000'),
('M0010', 'Es Jeruk', '4000'),
('M0011', 'Milk Shake', '8000'),
('M0012', 'Fruit Tea', '6000');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` char(5) NOT NULL,
  `nama_pelanggan` varchar(100) NOT NULL,
  `no_telp` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `no_telp`) VALUES
('P0001', 'Agung Suroto', '085726186476');

-- --------------------------------------------------------

--
-- Table structure for table `tarif_antar`
--

CREATE TABLE `tarif_antar` (
  `kd_wilayah` char(5) NOT NULL,
  `nama_wilayah` varchar(100) NOT NULL,
  `tarif_kirim` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tarif_antar`
--

INSERT INTO `tarif_antar` (`kd_wilayah`, `nama_wilayah`, `tarif_kirim`) VALUES
('W0001', 'Jogjakarta', 10000),
('W0002', 'Sleman', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_delivery`
--

CREATE TABLE `transaksi_delivery` (
  `node` char(10) NOT NULL,
  `id_pelanggan` char(5) DEFAULT NULL,
  `kd_wilayah` char(5) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi_delivery`
--

INSERT INTO `transaksi_delivery` (`node`, `id_pelanggan`, `kd_wilayah`, `tanggal`) VALUES
('D0001', 'P0001', 'W0001', '2018-05-27'),
('D0002', 'P0001', 'W0001', '2018-05-27'),
('D0003', 'P0001', 'W0001', '2018-05-27'),
('D0004', 'P0001', 'W0002', '2018-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_ditempat`
--

CREATE TABLE `transaksi_ditempat` (
  `nota` char(10) NOT NULL,
  `id_pelanggan` char(5) DEFAULT NULL,
  `tanggal` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi_ditempat`
--

INSERT INTO `transaksi_ditempat` (`nota`, `id_pelanggan`, `tanggal`) VALUES
('N0001', 'P0001', '2018-05-27'),
('N0002', 'P0001', '2018-05-27'),
('N0003', 'P0001', '2018-05-27'),
('N0004', 'P0001', '2018-05-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_menu_delivery`
--
ALTER TABLE `item_menu_delivery`
  ADD KEY `node` (`node`),
  ADD KEY `kd_menu` (`kd_menu`);

--
-- Indexes for table `item_menu_ditempat`
--
ALTER TABLE `item_menu_ditempat`
  ADD KEY `nota` (`nota`),
  ADD KEY `kd_menu` (`kd_menu`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`kd_menu`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `tarif_antar`
--
ALTER TABLE `tarif_antar`
  ADD PRIMARY KEY (`kd_wilayah`);

--
-- Indexes for table `transaksi_delivery`
--
ALTER TABLE `transaksi_delivery`
  ADD PRIMARY KEY (`node`),
  ADD KEY `id_pelanggan` (`id_pelanggan`),
  ADD KEY `kd_wilayah` (`kd_wilayah`);

--
-- Indexes for table `transaksi_ditempat`
--
ALTER TABLE `transaksi_ditempat`
  ADD PRIMARY KEY (`nota`),
  ADD KEY `id_pelanggan` (`id_pelanggan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `item_menu_delivery`
--
ALTER TABLE `item_menu_delivery`
  ADD CONSTRAINT `item_menu_delivery_ibfk_1` FOREIGN KEY (`node`) REFERENCES `transaksi_delivery` (`node`),
  ADD CONSTRAINT `item_menu_delivery_ibfk_2` FOREIGN KEY (`kd_menu`) REFERENCES `menu` (`kd_menu`);

--
-- Constraints for table `item_menu_ditempat`
--
ALTER TABLE `item_menu_ditempat`
  ADD CONSTRAINT `item_menu_ditempat_ibfk_1` FOREIGN KEY (`nota`) REFERENCES `transaksi_ditempat` (`nota`),
  ADD CONSTRAINT `item_menu_ditempat_ibfk_2` FOREIGN KEY (`kd_menu`) REFERENCES `menu` (`kd_menu`);

--
-- Constraints for table `transaksi_delivery`
--
ALTER TABLE `transaksi_delivery`
  ADD CONSTRAINT `transaksi_delivery_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`),
  ADD CONSTRAINT `transaksi_delivery_ibfk_2` FOREIGN KEY (`kd_wilayah`) REFERENCES `tarif_antar` (`kd_wilayah`);

--
-- Constraints for table `transaksi_ditempat`
--
ALTER TABLE `transaksi_ditempat`
  ADD CONSTRAINT `transaksi_ditempat_ibfk_1` FOREIGN KEY (`id_pelanggan`) REFERENCES `pelanggan` (`id_pelanggan`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
