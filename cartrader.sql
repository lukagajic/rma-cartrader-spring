-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.17-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for cartrader
DROP DATABASE IF EXISTS `cartrader`;
CREATE DATABASE IF NOT EXISTS `cartrader` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `cartrader`;

-- Dumping structure for table cartrader.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `parent__category_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_category_parent__category_id` (`parent__category_id`),
  CONSTRAINT `fk_category_parent__category_id` FOREIGN KEY (`parent__category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.category: ~9 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`id`, `name`, `parent__category_id`) VALUES
	(10, 'Limuzina', 19),
	(11, 'Hečbek', 19),
	(12, 'Karavan', 19),
	(14, 'Kupe', 19),
	(15, 'Kabriolet / Roadster', 19),
	(16, 'Monovolumen (MiniVan)', 19),
	(17, 'Džip / SUV', 19),
	(18, 'Pick up', 19),
	(19, 'Putničko vozilo', NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table cartrader.city
DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_city_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.city: ~14 rows (approximately)
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`id`, `name`) VALUES
	(14, 'Bečej'),
	(1, 'Beograd'),
	(9, 'Kragujevac'),
	(10, 'Kraljevo'),
	(5, 'Leskovac'),
	(4, 'Niš'),
	(2, 'Novi Sad'),
	(13, 'Sremska Mitrovica'),
	(3, 'Subotica'),
	(11, 'Topola'),
	(12, 'Valjevo'),
	(7, 'Vranje'),
	(8, 'Vršac'),
	(6, 'Zrenjanin');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;

-- Dumping structure for table cartrader.color_type
DROP TABLE IF EXISTS `color_type`;
CREATE TABLE IF NOT EXISTS `color_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_color_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.color_type: ~13 rows (approximately)
/*!40000 ALTER TABLE `color_type` DISABLE KEYS */;
INSERT INTO `color_type` (`id`, `name`) VALUES
	(2, 'Bela'),
	(4, 'Bež'),
	(3, 'Bordo'),
	(8, 'Braon'),
	(1, 'Crna'),
	(6, 'Crvena'),
	(10, 'Kameleon'),
	(12, 'Ljubičasta'),
	(7, 'Narandžasta'),
	(5, 'Plava'),
	(11, 'Roze'),
	(13, 'Siva'),
	(9, 'Zelena');
/*!40000 ALTER TABLE `color_type` ENABLE KEYS */;

-- Dumping structure for table cartrader.door_count_type
DROP TABLE IF EXISTS `door_count_type`;
CREATE TABLE IF NOT EXISTS `door_count_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_door_count_type_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.door_count_type: ~2 rows (approximately)
/*!40000 ALTER TABLE `door_count_type` DISABLE KEYS */;
INSERT INTO `door_count_type` (`id`, `name`) VALUES
	(1, '2 / 3 vrata'),
	(2, '4 / 5 vrata');
/*!40000 ALTER TABLE `door_count_type` ENABLE KEYS */;

-- Dumping structure for table cartrader.equipment_feature
DROP TABLE IF EXISTS `equipment_feature`;
CREATE TABLE IF NOT EXISTS `equipment_feature` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(10) unsigned NOT NULL DEFAULT 19,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_equipment_feature_name` (`name`),
  KEY `fk_equipment_feature_category_id` (`category_id`),
  CONSTRAINT `fk_equipment_feature_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.equipment_feature: ~13 rows (approximately)
/*!40000 ALTER TABLE `equipment_feature` DISABLE KEYS */;
INSERT INTO `equipment_feature` (`id`, `name`, `category_id`) VALUES
	(2, 'Metalik boja', 19),
	(3, 'Branici u boji auta', 19),
	(4, 'Servo volan', 19),
	(5, 'Multifunkcionalni volan', 19),
	(6, 'Tempomat', 19),
	(7, 'Daljinsko zaključavanje', 19),
	(8, 'Putni računar', 19),
	(9, 'Šiber', 19),
	(10, 'Panorama krov', 19),
	(11, 'Tonirana stakla', 19),
	(12, 'Električni podizači', 19),
	(13, 'Električni retrovizori', 19),
	(14, 'Grejači retrovizora', 19);
/*!40000 ALTER TABLE `equipment_feature` ENABLE KEYS */;

-- Dumping structure for table cartrader.favorite
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE IF NOT EXISTS `favorite` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `vehicle_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_favorite_user_id_vehicle_id` (`user_id`,`vehicle_id`),
  KEY `fk_favorite_vehicle_id` (`vehicle_id`),
  CONSTRAINT `fk_favorite_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_favorite_vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.favorite: ~2 rows (approximately)
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` (`id`, `user_id`, `vehicle_id`) VALUES
	(105, 1, 14);
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;

-- Dumping structure for table cartrader.fuel_type
DROP TABLE IF EXISTS `fuel_type`;
CREATE TABLE IF NOT EXISTS `fuel_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_fuel_type_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.fuel_type: ~6 rows (approximately)
/*!40000 ALTER TABLE `fuel_type` DISABLE KEYS */;
INSERT INTO `fuel_type` (`id`, `name`) VALUES
	(1, 'Benzin'),
	(3, 'Benzin + Gas (TNG)'),
	(2, 'Dizel'),
	(6, 'Električni pogon'),
	(5, 'Hibridni pogon'),
	(4, 'Metan CNG');
/*!40000 ALTER TABLE `fuel_type` ENABLE KEYS */;

-- Dumping structure for table cartrader.gearbox_type
DROP TABLE IF EXISTS `gearbox_type`;
CREATE TABLE IF NOT EXISTS `gearbox_type` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_gearbox_type_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.gearbox_type: ~5 rows (approximately)
/*!40000 ALTER TABLE `gearbox_type` DISABLE KEYS */;
INSERT INTO `gearbox_type` (`id`, `name`) VALUES
	(4, 'Automatski'),
	(5, 'Manuelni 4 brzine'),
	(1, 'Manuelni 5 brzina'),
	(2, 'Manuelni 6 brzina'),
	(3, 'Poluautomatski');
/*!40000 ALTER TABLE `gearbox_type` ENABLE KEYS */;

-- Dumping structure for table cartrader.manufacturer
DROP TABLE IF EXISTS `manufacturer`;
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_manufacturer_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.manufacturer: ~81 rows (approximately)
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
INSERT INTO `manufacturer` (`id`, `name`) VALUES
	(7, 'AC'),
	(8, 'Alfa Romeo'),
	(9, 'Aro'),
	(5, 'Audi'),
	(10, 'Austin'),
	(11, 'Bentley'),
	(6, 'BMW'),
	(12, 'Buick'),
	(13, 'Cadillac'),
	(14, 'Chery'),
	(15, 'Chevrolet'),
	(16, 'Chrysler'),
	(3, 'Citroen'),
	(17, 'Dacia'),
	(18, 'Daewoo'),
	(19, 'Daihatsu'),
	(20, 'Dodge'),
	(21, 'Ferrari'),
	(1, 'Fiat'),
	(22, 'Ford'),
	(23, 'GAZ'),
	(25, 'GMC'),
	(24, 'Great Wall'),
	(26, 'Honda'),
	(27, 'Hummer'),
	(28, 'Hyundai'),
	(29, 'Infiniti'),
	(30, 'Innocenti'),
	(31, 'Isuzu'),
	(32, 'Jaguar'),
	(33, 'Jeep'),
	(34, 'Katay Gonow'),
	(35, 'Kia'),
	(36, 'Lada'),
	(37, 'Lamborghini'),
	(38, 'Lancia'),
	(39, 'Land Rover'),
	(40, 'Lexus'),
	(41, 'Lincoln'),
	(42, 'Lotus'),
	(43, 'Mahindra'),
	(44, 'Maserati'),
	(45, 'Mazda'),
	(46, 'Mercedes Benz'),
	(48, 'MG'),
	(47, 'Mini'),
	(49, 'Mitsubishi'),
	(50, 'Moskvitch'),
	(51, 'Nissan'),
	(52, 'NSU'),
	(53, 'Oldsmobile'),
	(2, 'Opel'),
	(81, 'Ostalo'),
	(54, 'Peugeot'),
	(55, 'Piaggio'),
	(56, 'Polski Fiat'),
	(57, 'Pontiac'),
	(58, 'Porsche'),
	(59, 'Renault'),
	(60, 'Rolls Royce'),
	(61, 'Rover'),
	(62, 'Saab'),
	(63, 'Seat'),
	(64, 'Shuanghuan'),
	(69, 'Škoda'),
	(65, 'Smart'),
	(66, 'SsangYong'),
	(67, 'Subaru'),
	(68, 'Suzuki'),
	(70, 'Tata'),
	(71, 'Tavria'),
	(72, 'Toyota'),
	(73, 'Trabant'),
	(74, 'Triumph'),
	(75, 'UAZ'),
	(76, 'Vauxhall'),
	(4, 'Volkswagen'),
	(77, 'Volvo'),
	(78, 'Wartburg'),
	(79, 'Zastava'),
	(80, 'ZhiDou');
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;

-- Dumping structure for table cartrader.model
DROP TABLE IF EXISTS `model`;
CREATE TABLE IF NOT EXISTS `model` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `manufacturer_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_model_manufacturer_id` (`manufacturer_id`),
  CONSTRAINT `fk_model_manufacturer_id` FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.model: ~12 rows (approximately)
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` (`id`, `name`, `manufacturer_id`) VALUES
	(2, 'Grande Punto', 1),
	(3, 'Astra H', 2),
	(4, 'Serija 3', 6),
	(5, 'Serija 5', 6),
	(6, 'C4', 3),
	(7, 'A4', 5),
	(8, 'A3', 5),
	(9, 'A6', 5),
	(10, 'C3', 3),
	(11, 'Touran', 4),
	(12, 'Passat B6', 4),
	(13, 'Golf 7', 4);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;

-- Dumping structure for table cartrader.photo
DROP TABLE IF EXISTS `photo`;
CREATE TABLE IF NOT EXISTS `photo` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(10) unsigned NOT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_photo_vehicle_id` (`vehicle_id`),
  CONSTRAINT `fk_photo_vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.photo: ~12 rows (approximately)
/*!40000 ALTER TABLE `photo` DISABLE KEYS */;
INSERT INTO `photo` (`id`, `vehicle_id`, `path`) VALUES
	(8, 14, 'https://s1.cdn.autoevolution.com/images/models/AUDI_A3-2005_main.jpg'),
	(16, 16, 'https://935992fb69eb96c9a842-a2f14db1c49fce9a84b6ffdd384166ba.ssl.cf3.rackcdn.com/large/5b77b269cc41ba02ca69b9399a15d429.jpg'),
	(19, 28, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(20, 29, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(22, 31, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(29, 38, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(30, 39, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(33, 14, 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/2009_Audi_A3_%288PA%29_1.9_TDIe_5-door_Sportback_01.jpg/280px-2009_Audi_A3_%288PA%29_1.9_TDIe_5-door_Sportback_01.jpg'),
	(34, 14, 'https://s9.pik.ba/galerija/2020-09/23/12/slika-1246414-5f6b1e61affe3-default.jpg'),
	(35, 16, 'https://www.cars-data.com/pictures/citroen/citroen-c3_439_2.jpg'),
	(36, 49, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg'),
	(41, 54, 'https://i.pinimg.com/originals/97/80/a6/9780a624cf428ecbad4672878c06b8eb.jpg');
/*!40000 ALTER TABLE `photo` ENABLE KEYS */;

-- Dumping structure for table cartrader.security_feature
DROP TABLE IF EXISTS `security_feature`;
CREATE TABLE IF NOT EXISTS `security_feature` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `category_id` int(10) unsigned NOT NULL DEFAULT 19,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_security_feature_name` (`name`),
  KEY `fk_security_feature_category_id` (`category_id`),
  CONSTRAINT `fk_security_feature_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.security_feature: ~16 rows (approximately)
/*!40000 ALTER TABLE `security_feature` DISABLE KEYS */;
INSERT INTO `security_feature` (`id`, `name`, `category_id`) VALUES
	(1, 'ABS', 19),
	(2, 'ESP', 19),
	(3, 'ESR', 19),
	(4, 'Airbag za vozača', 19),
	(5, 'Airbag za suvozača', 19),
	(6, 'Bočni airbag', 19),
	(7, 'Child lock', 19),
	(8, 'Alarm', 19),
	(9, 'Kodiran ključ', 19),
	(10, 'Blokada motora', 19),
	(11, 'Centralno zaključavanje', 19),
	(12, 'Mehanička zaštita', 19),
	(13, 'Ulazak bez ključa', 19),
	(14, 'Asistencija praćenja trake', 19),
	(15, 'Senzor mrtvog ugla', 19),
	(16, 'OBD zaštita', 19);
/*!40000 ALTER TABLE `security_feature` ENABLE KEYS */;

-- Dumping structure for table cartrader.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password_hash` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `phone_number` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `postal_code` int(5) unsigned NOT NULL,
  `address` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_user_email` (`email`),
  KEY `fk_user_city_id` (`city_id`),
  CONSTRAINT `fk_user_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.user: ~8 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `password_hash`, `phone_number`, `postal_code`, `address`, `city_id`) VALUES
	(1, 'Luka', 'Gajic', 'lgajic@mail.local', '$2a$10$sGJw.ppDPh8Ywijs59TVLO2gZKrzQD59X/HXNiQw6MbvTLAxX5XZW', '+381111234567', 11000, 'Adresa neka bb', 1),
	(2, 'Pera', 'Peric', 'pperic@mail.local', '$2a$10$qaTx0Ge43ikFmVQxc89V7uI5RgYlsTUZqaYyClnTe.DbTb6sN/Z2O', '+381641231231', 11000, 'Neznanog junaka BB', 1),
	(4, 'Zika', 'Zikic', 'zikic@mail.local', '$2a$10$Nnx51WOdmUZPmGFGyABC.Onat7umaYxBXhP1bRRFzN.qwBxy0VTGi', '+381111234569', 11000, 'Micka Mickovica 35', 1),
	(5, 'Jasmina', 'Gajic', 'jaca@mail.local', '$2a$10$zElkehrDJ7oGCgPl.pWxWe1MTB/pe2DzV6UXg2Aooa6BGYYEFH1u6', '+38164111222', 11000, 'Neka ulica 21', 1),
	(6, 'Marko', 'Markovic', 'mare@mail.local', '$2a$10$STrUVh70Ezata9gyB3vL.O8U7MPpFDW3quZQ94b3FISjx8q2d9PjO', '+381111231231', 11000, 'Adresa 11', 1),
	(7, 'Lazar', 'Lazovic', 'lazovic@mail.local', '$2a$10$.pZuFswtqZebf2rYqbGryuEXvYRpDI1rFmcMS6trNeXiOhfWb.ZZy', '+38161111222', 11000, 'Adresa Neka 211', 1),
	(8, 'Steva', 'Stevanovic', 'steva@mail.local', '$2a$10$ylko3tSUVlKZrPM1KQaiTOrrJ6hjnKqU6RE.F23qfrSpM/Cu8Q7FC', '+38162111222', 11000, 'Adresa 15', 1),
	(9, 'Luka', 'Gajic', 'lukag98@gmail.com', '$2a$10$4HeLe0oeo1JEQLYUnNsYBeXKBMNt/3BFtfJ/nxHY0PI7IR5b2.J6q', '+381112555555', 11000, 'Adresa 15', 1),
	(11, 'Luka', 'Gajic', 'lukag998@gmail.com', '$2a$10$q/5ediospO9dowfTEuwudOHoNE7iH3VfLJ97uEa7T4vyxtWSbvBVi', '+381112555555', 11000, 'Adresa 15', 1),
	(12, 'Luka', 'Gajic', 'lukag9998@gmail.com', '$2a$10$baNAqY5Ojg9hMU6GM8Kzs.0pZ96YcLSgA3WYDgWUHPK/ZR7HI2i62', '+381112555555', 11000, 'Adresa 15', 1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table cartrader.vehicle
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `model_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `gearbox_type_id` int(10) unsigned DEFAULT NULL,
  `category_id` int(10) unsigned DEFAULT NULL,
  `fuel_type_id` int(10) unsigned DEFAULT NULL,
  `color_type_id` int(10) unsigned DEFAULT NULL,
  `door_count_type_id` int(10) unsigned DEFAULT NULL,
  `excerpt` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `engine_capacity` smallint(5) unsigned NOT NULL,
  `engine_power` smallint(5) unsigned NOT NULL,
  `mileage` int(7) unsigned NOT NULL,
  `year` smallint(4) unsigned NOT NULL,
  `price` int(8) unsigned NOT NULL,
  `is_from_owner` tinyint(1) unsigned NOT NULL DEFAULT 1,
  `registration_expires_at` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`) USING BTREE,
  KEY `fk_vehicle_model_id` (`model_id`),
  KEY `fk_vehicle_user_id` (`user_id`),
  KEY `fk_vehicle_gearbox_type_id` (`gearbox_type_id`),
  KEY `fk_vehicle_category_id` (`category_id`),
  KEY `fk_vehicle_fuel_type_id` (`fuel_type_id`),
  KEY `fk_vehicle_color_type_id` (`color_type_id`),
  KEY `fk_vehicle_door_count_type_id` (`door_count_type_id`),
  CONSTRAINT `fk_vehicle_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_color_type_id` FOREIGN KEY (`color_type_id`) REFERENCES `color_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_door_count_type_id` FOREIGN KEY (`door_count_type_id`) REFERENCES `door_count_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_fuel_type_id` FOREIGN KEY (`fuel_type_id`) REFERENCES `fuel_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_gearbox_type_id` FOREIGN KEY (`gearbox_type_id`) REFERENCES `gearbox_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_model_id` FOREIGN KEY (`model_id`) REFERENCES `model` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.vehicle: ~10 rows (approximately)
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` (`id`, `model_id`, `user_id`, `gearbox_type_id`, `category_id`, `fuel_type_id`, `color_type_id`, `door_count_type_id`, `excerpt`, `description`, `engine_capacity`, `engine_power`, `mileage`, `year`, `price`, `is_from_owner`, `registration_expires_at`, `created_at`) VALUES
	(14, 8, 1, 2, 11, 2, 1, 2, '2.0 TDI hitno!', 'U dobrom stanju', 2000, 110, 155000, 2005, 5500, 1, '2020-12-30', '2020-12-30 01:24:49'),
	(16, 10, 2, 1, 11, 1, 13, 2, '1.4 benzin', 'U odlicnom stanju', 1400, 55, 178000, 2006, 2200, 1, '2020-12-30', '2020-12-30 01:25:37'),
	(28, 9, 1, 4, 10, 1, 2, 1, 'SUPER', 'Detalji o vozilu', 2000, 110, 220000, 2005, 5000, 0, '2020-12-31', '2021-07-07 22:19:28'),
	(29, 9, 1, 4, 10, 1, 2, 1, 'opis...', 'Detalji...', 2500, 200, 110000, 2008, 9000, 0, '2020-12-31', '2021-07-07 22:19:29'),
	(31, 2, 1, 4, 10, 1, 2, 1, 'opis', 'detalji', 1248, 55, 110000, 2007, 2200, 0, '2020-12-31', '2021-07-07 22:19:29'),
	(38, 10, 1, 2, 10, 2, 1, 2, 'neki opis', 'neki detalji', 2000, 110, 22000, 2007, 1500, 0, '2020-12-30', '2021-07-07 22:19:30'),
	(39, 9, 1, 4, 10, 1, 2, 1, 'opis', 'detalji', 2000, 110, 100000, 2005, 11000, 0, '2020-12-31', '2021-07-07 22:19:30'),
	(49, 3, 1, 2, 10, 2, 13, 2, '1.9 CDTI', 'Vozilo uvezeno iz Austrije!', 1910, 88, 240000, 2007, 3500, 0, '2021-01-01', '2021-07-07 22:19:30'),
	(54, 6, 8, 1, 11, 2, 1, 2, '1.6 NOV', 'Ovo je odlicno vozilo', 1600, 80, 180000, 2005, 2700, 1, '2021-08-08', '2021-07-07 22:19:35');
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

-- Dumping structure for table cartrader.vehicle_equipment_feature
DROP TABLE IF EXISTS `vehicle_equipment_feature`;
CREATE TABLE IF NOT EXISTS `vehicle_equipment_feature` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(10) unsigned NOT NULL,
  `equipment_feature_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_vehicle_equipment_feature_vehicle_id_equipment_feature_id` (`vehicle_id`,`equipment_feature_id`),
  KEY `fk_vehicle_equipment_feature_equipment_feature_id` (`equipment_feature_id`),
  CONSTRAINT `fk_vehicle_equipment_feature_equipment_feature_id` FOREIGN KEY (`equipment_feature_id`) REFERENCES `equipment_feature` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_equipment_feature_vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.vehicle_equipment_feature: ~20 rows (approximately)
/*!40000 ALTER TABLE `vehicle_equipment_feature` DISABLE KEYS */;
INSERT INTO `vehicle_equipment_feature` (`id`, `vehicle_id`, `equipment_feature_id`) VALUES
	(40, 14, 3),
	(42, 14, 4),
	(44, 14, 6),
	(41, 14, 14),
	(29, 38, 3),
	(26, 38, 7),
	(25, 38, 9),
	(28, 38, 12),
	(27, 38, 13),
	(31, 39, 4),
	(30, 39, 7),
	(32, 39, 10),
	(33, 39, 12),
	(34, 39, 14),
	(71, 49, 4),
	(69, 49, 5),
	(70, 49, 13),
	(86, 54, 4),
	(85, 54, 6),
	(84, 54, 10);
/*!40000 ALTER TABLE `vehicle_equipment_feature` ENABLE KEYS */;

-- Dumping structure for table cartrader.vehicle_security_feature
DROP TABLE IF EXISTS `vehicle_security_feature`;
CREATE TABLE IF NOT EXISTS `vehicle_security_feature` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_id` int(10) unsigned NOT NULL,
  `security_feature_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uq_vehicle_id_security_feature_id` (`vehicle_id`,`security_feature_id`),
  KEY `fk_vehicle_security_feature_security_feature_id` (`security_feature_id`),
  CONSTRAINT `fk_vehicle_security_feature_security_feature_id` FOREIGN KEY (`security_feature_id`) REFERENCES `security_feature` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vehicle_security_feature_vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table cartrader.vehicle_security_feature: ~20 rows (approximately)
/*!40000 ALTER TABLE `vehicle_security_feature` DISABLE KEYS */;
INSERT INTO `vehicle_security_feature` (`id`, `vehicle_id`, `security_feature_id`) VALUES
	(61, 14, 1),
	(62, 14, 2),
	(63, 14, 3),
	(64, 14, 4),
	(65, 14, 5),
	(67, 14, 6),
	(49, 38, 8),
	(51, 38, 12),
	(50, 38, 13),
	(52, 38, 14),
	(48, 38, 15),
	(55, 39, 4),
	(54, 39, 15),
	(53, 39, 16),
	(93, 49, 5),
	(94, 49, 14),
	(92, 49, 16),
	(108, 54, 1),
	(110, 54, 2),
	(109, 54, 3);
/*!40000 ALTER TABLE `vehicle_security_feature` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
