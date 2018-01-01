-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 01, 2018 lúc 05:25 PM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `socialplace`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `commentlike`
--

CREATE TABLE `commentlike` (
  `ID` int(11) NOT NULL,
  `IDCOMMENT` int(11) DEFAULT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `DATECREATE` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `commentpost`
--

CREATE TABLE `commentpost` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `IDPOST` int(11) DEFAULT NULL,
  `DETAIL` text,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `commentreply`
--

CREATE TABLE `commentreply` (
  `ID` int(11) NOT NULL,
  `IDCOMMENT` int(11) NOT NULL,
  `IDUSER` int(11) NOT NULL,
  `DESCRIPTION` text,
  `IDIMAGE` int(11) DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `felling`
--

CREATE TABLE `felling` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `DESCRIPTION` varchar(100) NOT NULL,
  `LEVEL` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `grouplocation`
--

CREATE TABLE `grouplocation` (
  `ID` int(11) NOT NULL,
  `NAMEGR` varchar(255) DEFAULT NULL,
  `DESCRIPTION` text,
  `KEYWORD` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `grouplocation`
--

INSERT INTO `grouplocation` (`ID`, `NAMEGR`, `DESCRIPTION`, `KEYWORD`) VALUES
(2, 'accounting', 'accounting', 'accounting'),
(3, 'airport', 'airport', 'airport'),
(4, 'amusement_park', 'amusement_park', 'amusement_park'),
(5, 'aquarium', 'aquarium', 'aquarium'),
(6, 'art_gallery', 'art_gallery', 'art_gallery'),
(7, 'atm', 'atm', 'atm'),
(8, 'bakery', 'bakery', 'bakery'),
(9, 'bank', 'bank', 'bank'),
(10, 'bar', 'bar', 'bar'),
(11, 'beauty_salon', 'beauty_salon', 'beauty_salon'),
(12, 'bicycle_store', 'bicycle_store', 'bicycle_store'),
(13, 'book_store', 'book_store', 'book_store'),
(14, 'bowling_alley', 'bowling_alley', 'bowling_alley'),
(15, 'bus_station', 'bus_station', 'bus_station'),
(16, 'cafe', 'cafe', 'cafe'),
(17, 'campground', 'campground', 'campground'),
(18, 'car_dealer', 'car_dealer', 'car_dealer'),
(19, 'car_rental', 'car_rental', 'car_rental'),
(20, 'car_repair', 'car_repair', 'car_repair'),
(21, 'car_wash', 'car_wash', 'car_wash'),
(22, 'casino', 'casino', 'casino'),
(23, 'cemetery', 'cemetery', 'cemetery'),
(24, 'church', 'church', 'church'),
(25, 'city_hall', 'city_hall', 'city_hall'),
(26, 'clothing_store', 'clothing_store', 'clothing_store'),
(27, 'convenience_store', 'convenience_store', 'convenience_store'),
(28, 'courthouse', 'courthouse', 'courthouse'),
(29, 'dentist', 'dentist', 'dentist'),
(30, 'department_store', 'department_store', 'department_store'),
(31, 'doctor', 'doctor', 'doctor'),
(32, 'electrician', 'electrician', 'electrician'),
(33, 'electronics_store', 'electronics_store', 'electronics_store'),
(34, 'embassy', 'embassy', 'embassy'),
(35, 'establishment (deprecated)', 'establishment (deprecated)', 'establishment (deprecated)'),
(36, 'finance (deprecated)', 'finance (deprecated)', 'finance (deprecated)'),
(37, 'fire_station', 'fire_station', 'fire_station'),
(38, 'florist', 'florist', 'florist'),
(39, 'food (deprecated)', 'food (deprecated)', 'food (deprecated)'),
(40, 'funeral_home', 'funeral_home', 'funeral_home'),
(41, 'furniture_store', 'furniture_store', 'furniture_store'),
(42, 'gas_station', 'gas_station', 'gas_station'),
(43, 'general_contractor (deprecated)', 'general_contractor (deprecated)', 'general_contractor (deprecated)'),
(44, 'grocery_or_supermarket(deprecated)', 'grocery_or_supermarket(deprecated)', 'grocery_or_supermarket(deprecated)'),
(45, 'gym', 'gym', 'gym'),
(46, 'hair_care', 'hair_care', 'hair_care'),
(47, 'hardware_store', 'hardware_store', 'hardware_store'),
(48, 'health (deprecated)', 'health (deprecated)', 'health (deprecated)'),
(49, 'hindu_temple', 'hindu_temple', 'hindu_temple'),
(50, 'home_goods_store', 'home_goods_store', 'home_goods_store'),
(51, 'hospital', 'hospital', 'hospital'),
(52, 'insurance_agency', 'insurance_agency', 'insurance_agency'),
(53, 'jewelry_store', 'jewelry_store', 'jewelry_store'),
(54, 'laundry', 'laundry', 'laundry'),
(55, 'lawyer', 'lawyer', 'lawyer'),
(56, 'library', 'library', 'library'),
(57, 'liquor_store', 'liquor_store', 'liquor_store'),
(58, 'local_government_office', 'local_government_office', 'local_government_office'),
(59, 'locksmith', 'locksmith', 'locksmith'),
(60, 'lodging', 'lodging', 'lodging'),
(61, 'meal_delivery', 'meal_delivery', 'meal_delivery'),
(62, 'meal_takeaway', 'meal_takeaway', 'meal_takeaway'),
(63, 'mosque', 'mosque', 'mosque'),
(64, 'movie_rental', 'movie_rental', 'movie_rental'),
(65, 'movie_theater', 'movie_theater', 'movie_theater'),
(66, 'moving_company', 'moving_company', 'moving_company'),
(67, 'museum', 'museum', 'museum'),
(68, 'night_club', 'night_club', 'night_club'),
(69, 'painter', 'painter', 'painter'),
(70, 'park', 'park', 'park'),
(71, 'parking', 'parking', 'parking'),
(72, 'pet_store', 'pet_store', 'pet_store'),
(73, 'pharmacy', 'pharmacy', 'pharmacy'),
(74, 'physiotherapist', 'physiotherapist', 'physiotherapist'),
(75, 'place_of_worship (deprecated)', 'place_of_worship (deprecated)', 'place_of_worship (deprecated)'),
(76, 'plumber', 'plumber', 'plumber'),
(77, 'police', 'police', 'police'),
(78, 'post_office', 'post_office', 'post_office'),
(79, 'real_estate_agency', 'real_estate_agency', 'real_estate_agency'),
(80, 'restaurant', 'restaurant', 'restaurant'),
(81, 'roofing_contractor', 'roofing_contractor', 'roofing_contractor'),
(82, 'rv_park', 'rv_park', 'rv_park'),
(83, 'school', 'school', 'school'),
(84, 'shoe_store', 'shoe_store', 'shoe_store'),
(85, 'shopping_mall', 'shopping_mall', 'shopping_mall'),
(86, 'spa', 'spa', 'spa'),
(87, 'stadium', 'stadium', 'stadium'),
(88, 'storage', 'storage', 'storage'),
(89, 'store', 'store', 'store'),
(90, 'subway_station', 'subway_station', 'subway_station'),
(91, 'synagogue', 'synagogue', 'synagogue'),
(92, 'taxi_stand', 'taxi_stand', 'taxi_stand'),
(93, 'train_station', 'train_station', 'train_station'),
(94, 'transit_station', 'transit_station', 'transit_station'),
(95, 'travel_agency', 'travel_agency', 'travel_agency'),
(96, 'university', 'university', 'university'),
(97, 'veterinary_care', 'veterinary_care', 'veterinary_care'),
(98, 'zoo', 'zoo', 'zoo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `groupplace`
--

CREATE TABLE `groupplace` (
  `ID` int(11) NOT NULL,
  `NAMEGR` text,
  `DESCRIPTION` text,
  `KEYWORD` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `groupplace`
--

INSERT INTO `groupplace` (`ID`, `NAMEGR`, `DESCRIPTION`, `KEYWORD`) VALUES
(3, 'Ăn Uống', 'Ăn Uống', 'Ăn Uống'),
(4, 'Du Lịch', 'Du Lịch', 'Du Lịch'),
(5, 'Cưới Hỏi', 'Cưới Hỏi', 'Cưới Hỏi'),
(6, 'Tâm Linh', 'Tâm Linh', 'Tâm Linh'),
(7, 'Đẹp Khỏe', 'Đẹp Khỏe', 'Đẹp Khỏe'),
(8, 'Giải Trí', 'Giải Trí', 'Giải Trí'),
(9, 'Mua Sắm', 'Mua Sắm', 'Mua Sắm'),
(10, 'Giáo Dục', 'Giáo Dục', 'Giáo Dục'),
(11, 'Dịch Vụ', 'Dịch Vụ', 'Dịch Vụ'),
(12, 'Công Cộng', 'Công Cộng', 'Công Cộng'),
(13, 'Cơ Quan Nhà Nước', 'Cơ Quan Nhà Nước', 'Cơ Quan Nhà Nước');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `imagepic`
--

CREATE TABLE `imagepic` (
  `ID` int(11) NOT NULL,
  `DATA` longblob NOT NULL,
  `CAPTION` varchar(255) DEFAULT NULL,
  `DATECREATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `location`
--

CREATE TABLE `location` (
  `ID` int(11) NOT NULL,
  `LOCATIONX` float NOT NULL,
  `LOCATIONY` float NOT NULL,
  `NOTE` varchar(100) CHARACTER SET latin1 DEFAULT NULL,
  `IDGROUP` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notification`
--

CREATE TABLE `notification` (
  `ID` int(11) NOT NULL,
  `IDNOTITYPE` int(11) NOT NULL,
  `CAPTION` text,
  `VALUE` text,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notificationtype`
--

CREATE TABLE `notificationtype` (
  `ID` int(11) NOT NULL,
  `CAPTION` varchar(255) DEFAULT NULL,
  `DESCRIPTION` text,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `place`
--

CREATE TABLE `place` (
  `ID` int(11) NOT NULL,
  `NAME` text,
  `DECRIPSION` text,
  `IDLOCATION` int(11) DEFAULT NULL,
  `IDGROUPPLACE` int(11) DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL,
  `PHONENUMBER` varchar(20) NOT NULL,
  `EMAIL` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placecomment`
--

CREATE TABLE `placecomment` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `VALUE` text,
  `DATECREATE` datetime DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL,
  `IDPLACE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placecomment_image`
--

CREATE TABLE `placecomment_image` (
  `IDPLACECOMMENT` int(11) NOT NULL,
  `IDIMAGE` int(11) NOT NULL,
  `STATE` char(1) DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placecomment_like`
--

CREATE TABLE `placecomment_like` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `IDPLACECOMMENT` int(11) DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placecomment_place`
--

CREATE TABLE `placecomment_place` (
  `IDPLACECOMMENT` int(11) NOT NULL,
  `IDPLACE` int(11) NOT NULL,
  `NOTE` text,
  `DATECREATE` datetime DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placereview`
--

CREATE TABLE `placereview` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) NOT NULL,
  `CAPTION` text,
  `DESCRIPTION` text,
  `IDFELLING` int(11) DEFAULT NULL,
  `IDPLACE` int(11) NOT NULL,
  `DATECREATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placereview_image`
--

CREATE TABLE `placereview_image` (
  `IDPLACEREVIEW` int(11) NOT NULL,
  `IDIMAGE` int(11) NOT NULL,
  `STATE` char(1) DEFAULT NULL,
  `DATECREATE` datetime DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `placereview_like`
--

CREATE TABLE `placereview_like` (
  `ID` int(11) NOT NULL,
  `IDPLACEREVIEW` int(11) DEFAULT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `place_image`
--

CREATE TABLE `place_image` (
  `IDPLACE` int(11) NOT NULL,
  `IDIMAGE` int(11) NOT NULL,
  `DATECREATE` date DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `place_like`
--

CREATE TABLE `place_like` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `IDPLACE` int(11) DEFAULT NULL,
  `DATECREATE` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `postdetail`
--

CREATE TABLE `postdetail` (
  `ID` int(11) NOT NULL,
  `DETAIL` text,
  `STATE` char(1) DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL,
  `IDPLACE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `postdetail_image`
--

CREATE TABLE `postdetail_image` (
  `IDPOSTDETAIL` int(11) NOT NULL,
  `IDIMAGE` int(11) NOT NULL,
  `DATECREATE` date DEFAULT NULL,
  `STATE` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `postlike`
--

CREATE TABLE `postlike` (
  `IDUSER` int(11) NOT NULL,
  `IDPOST` int(11) NOT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rating`
--

CREATE TABLE `rating` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `IDPLACE` int(11) DEFAULT NULL,
  `VALUE` float DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `souserinfo`
--

CREATE TABLE `souserinfo` (
  `ID` int(11) NOT NULL,
  `SUBID` char(6) CHARACTER SET latin1 DEFAULT NULL,
  `FIRSTNAME` varchar(30) DEFAULT NULL,
  `LASTNAME` varchar(50) DEFAULT NULL,
  `PROVINCE` varchar(50) DEFAULT NULL,
  `NATIONAL` varchar(50) DEFAULT NULL,
  `IDAVATAR` int(11) DEFAULT '0',
  `IDUSER` int(11) NOT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `CREATEDATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `LOCATIONX` float DEFAULT NULL,
  `LOCATIONY` float DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `PHONENUMBER` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `souserinfo`
--

INSERT INTO `souserinfo` (`ID`, `SUBID`, `FIRSTNAME`, `LASTNAME`, `PROVINCE`, `NATIONAL`, `IDAVATAR`, `IDUSER`, `STATUS`, `CREATEDATE`, `LOCATIONX`, `LOCATIONY`, `EMAIL`, `PHONENUMBER`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, 1, 1, 'A', '2017-12-22 21:43:31', 1, 1, '1@GMAIL.COM', '123'),
(2, NULL, 'Su', 'Pham', NULL, NULL, 0, -1, 'A', '2017-12-25 19:56:40', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(3, NULL, 'Su', 'Pham', NULL, NULL, 0, 1, 'A', '2017-12-25 20:02:01', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(4, NULL, 'Su', 'Pham', NULL, NULL, 0, 2, 'A', '2017-12-25 20:04:36', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(5, NULL, 'Su', 'Pham', NULL, NULL, 0, 3, 'A', '2017-12-25 20:48:09', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(6, NULL, 'Su', 'Pham', NULL, NULL, 0, 4, 'A', '2017-12-25 20:52:38', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(7, NULL, 'Su', 'Pham', NULL, NULL, 0, 5, 'A', '2017-12-25 21:20:25', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(8, NULL, 'Su', 'Pham', NULL, NULL, 0, 6, 'A', '2017-12-25 21:22:57', NULL, NULL, 'thanhsu604@gmail.com', '12353463'),
(9, NULL, 'su pahm 13123', '23213', NULL, NULL, 0, 7, 'A', '2018-01-01 14:38:25', NULL, NULL, '!@asdasdas', 'asdasdas'),
(10, NULL, 'su pahm 13123', '23213', NULL, NULL, 0, 8, 'A', '2018-01-01 14:40:23', NULL, NULL, '!@asdasdas', 'asdasdas');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `souserrigister`
--

CREATE TABLE `souserrigister` (
  `ID` int(11) NOT NULL,
  `USERNAME` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `PASSWORD` varchar(50) CHARACTER SET latin1 DEFAULT NULL,
  `TOKEN` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `STATE` char(1) CHARACTER SET latin1 DEFAULT NULL,
  `DATECREAT` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `souserrigister`
--

INSERT INTO `souserrigister` (`ID`, `USERNAME`, `PASSWORD`, `TOKEN`, `STATE`, `DATECREAT`) VALUES
(1, 'thanhsu', '123456', NULL, NULL, NULL),
(2, 'thanhsu', '123456', NULL, NULL, NULL),
(3, 'thanhsu', '123456', NULL, NULL, NULL),
(4, 'thanhsu', '123456', NULL, NULL, NULL),
(5, 'thanhsu2', '123456', NULL, NULL, NULL),
(6, 'thanhsu2', '123456', NULL, NULL, NULL),
(7, '123123', '1123123', NULL, NULL, NULL),
(8, '123123', '1123123', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status`
--

CREATE TABLE `status` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `DETAIL` text,
  `DATECREATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `IDFELL` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status_image`
--

CREATE TABLE `status_image` (
  `ID` int(11) NOT NULL,
  `IDSTATUS` int(11) DEFAULT NULL,
  `IDIMAGE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `status_like`
--

CREATE TABLE `status_like` (
  `ID` int(11) NOT NULL,
  `IDSTATUS` int(11) DEFAULT NULL,
  `IDUSER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `usercomment`
--

CREATE TABLE `usercomment` (
  `ID` int(11) NOT NULL,
  `IDUSER` int(11) DEFAULT NULL,
  `VALUE` text,
  `STATE` char(1) DEFAULT NULL,
  `DATECREATE` datetime DEFAULT NULL,
  `IDREVIEW` int(11) NOT NULL,
  `IDIMAGE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `userfollow`
--

CREATE TABLE `userfollow` (
  `ID` int(11) NOT NULL,
  `DATECREATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `IDUSER` int(11) DEFAULT NULL,
  `BEIDUSER` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `usersession`
--

CREATE TABLE `usersession` (
  `ID` int(11) NOT NULL,
  `UUID` varchar(255) NOT NULL,
  `IDUSER` int(11) NOT NULL,
  `STATE` char(1) DEFAULT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_followplace`
--

CREATE TABLE `user_followplace` (
  `IDUSER` int(11) NOT NULL,
  `IDPLACE` int(11) NOT NULL,
  `DATECREATE` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `commentlike`
--
ALTER TABLE `commentlike`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `commentpost`
--
ALTER TABLE `commentpost`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `commentreply`
--
ALTER TABLE `commentreply`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `felling`
--
ALTER TABLE `felling`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `grouplocation`
--
ALTER TABLE `grouplocation`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `groupplace`
--
ALTER TABLE `groupplace`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `imagepic`
--
ALTER TABLE `imagepic`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `notificationtype`
--
ALTER TABLE `notificationtype`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `placecomment`
--
ALTER TABLE `placecomment`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `placecomment_image`
--
ALTER TABLE `placecomment_image`
  ADD PRIMARY KEY (`IDPLACECOMMENT`,`IDIMAGE`);

--
-- Chỉ mục cho bảng `placecomment_like`
--
ALTER TABLE `placecomment_like`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `placecomment_place`
--
ALTER TABLE `placecomment_place`
  ADD PRIMARY KEY (`IDPLACECOMMENT`,`IDPLACE`);

--
-- Chỉ mục cho bảng `placereview`
--
ALTER TABLE `placereview`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `placereview_image`
--
ALTER TABLE `placereview_image`
  ADD PRIMARY KEY (`IDPLACEREVIEW`,`IDIMAGE`);

--
-- Chỉ mục cho bảng `placereview_like`
--
ALTER TABLE `placereview_like`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `place_image`
--
ALTER TABLE `place_image`
  ADD PRIMARY KEY (`IDPLACE`,`IDIMAGE`);

--
-- Chỉ mục cho bảng `place_like`
--
ALTER TABLE `place_like`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `postdetail`
--
ALTER TABLE `postdetail`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `postdetail_image`
--
ALTER TABLE `postdetail_image`
  ADD PRIMARY KEY (`IDPOSTDETAIL`,`IDIMAGE`);

--
-- Chỉ mục cho bảng `postlike`
--
ALTER TABLE `postlike`
  ADD PRIMARY KEY (`IDUSER`,`IDPOST`);

--
-- Chỉ mục cho bảng `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `souserinfo`
--
ALTER TABLE `souserinfo`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `souserrigister`
--
ALTER TABLE `souserrigister`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `status_image`
--
ALTER TABLE `status_image`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `status_like`
--
ALTER TABLE `status_like`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `usercomment`
--
ALTER TABLE `usercomment`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `userfollow`
--
ALTER TABLE `userfollow`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `usersession`
--
ALTER TABLE `usersession`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `user_followplace`
--
ALTER TABLE `user_followplace`
  ADD PRIMARY KEY (`IDUSER`,`IDPLACE`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `commentlike`
--
ALTER TABLE `commentlike`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `commentpost`
--
ALTER TABLE `commentpost`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `commentreply`
--
ALTER TABLE `commentreply`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `felling`
--
ALTER TABLE `felling`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `grouplocation`
--
ALTER TABLE `grouplocation`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT cho bảng `groupplace`
--
ALTER TABLE `groupplace`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT cho bảng `imagepic`
--
ALTER TABLE `imagepic`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `location`
--
ALTER TABLE `location`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `notification`
--
ALTER TABLE `notification`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `notificationtype`
--
ALTER TABLE `notificationtype`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `place`
--
ALTER TABLE `place`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `placecomment`
--
ALTER TABLE `placecomment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `placecomment_like`
--
ALTER TABLE `placecomment_like`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `placereview`
--
ALTER TABLE `placereview`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `placereview_like`
--
ALTER TABLE `placereview_like`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `place_like`
--
ALTER TABLE `place_like`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `postdetail`
--
ALTER TABLE `postdetail`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `rating`
--
ALTER TABLE `rating`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `souserinfo`
--
ALTER TABLE `souserinfo`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `souserrigister`
--
ALTER TABLE `souserrigister`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `status`
--
ALTER TABLE `status`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `status_image`
--
ALTER TABLE `status_image`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `status_like`
--
ALTER TABLE `status_like`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `usercomment`
--
ALTER TABLE `usercomment`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `userfollow`
--
ALTER TABLE `userfollow`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `usersession`
--
ALTER TABLE `usersession`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
