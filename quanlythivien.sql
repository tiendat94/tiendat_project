-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: quanlythuvien
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `docgia`
--

DROP TABLE IF EXISTS `docgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docgia` (
  `MaDG` char(20) NOT NULL,
  `TenDG` varchar(45) DEFAULT NULL,
  `matkhau` varchar(45) DEFAULT NULL,
  `MaKhoa` char(20) NOT NULL,
  `KhoaHoc` char(10) DEFAULT NULL,
  `GioiTinh` varchar(10) DEFAULT NULL,
  `NgaySinh` char(10) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `DienThoai` varchar(45) DEFAULT NULL,
  `NgayCap` date DEFAULT NULL,
  `NgayHethan` date DEFAULT NULL,
  PRIMARY KEY (`MaDG`),
  KEY `fk_DocGia_Khoa1_idx` (`MaKhoa`),
  CONSTRAINT `fk_DocGia_Khoa1` FOREIGN KEY (`MaKhoa`) REFERENCES `khoa` (`MaKhoa`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docgia`
--

LOCK TABLES `docgia` WRITE;
/*!40000 ALTER TABLE `docgia` DISABLE KEYS */;
INSERT INTO `docgia` VALUES ('DG001','nguyễn ngọc cường',NULL,'MK001','57','Nam','1994-08-20','CNTT2.02','01693514432','2012-09-30','2017-05-12'),('DG002','nguyễn thiện bảo',NULL,'MK001','57','Nam','1994-09-10','CNTT2.04','0169676887','2012-09-30','2017-05-12'),('DG003','Hà Thị Hoàn',NULL,'MK001','57','Nữ','1994-05-06','CNTT2.04','01693514432','2012-09-30','2017-05-12'),('DG004','Trịnh Thị Huyền',NULL,'MK002','57','Nữ','1994-05-11','TDH2.01','0967856732','2012-09-30','2017-05-12'),('DG005','Phạm Bình Minh',NULL,'MK003','56','Nam','1993-09-20','VLDT2.02','0948359534','2011-09-30','2016-05-12'),('DG006','Nguyễn Thành Công',NULL,'MK002','55','Nam','1992-09-06','TDH2.03','0965434878','2010-09-30','2015-05-12'),('DG007','Trịnh thị Hằng',NULL,'MK004','55','Nữ','1992-07-08','Cơ Khí 1.01','016892359898','2010-09-30','2015-05-12'),('DG008','Hà Thị Hải Trang',NULL,'MK004','56','Nữ','1993-08-20','Cơ Khí 2.01','0987324877','2011-09-30','2016-05-12');
/*!40000 ALTER TABLE `docgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa`
--

DROP TABLE IF EXISTS `khoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khoa` (
  `MaKhoa` char(20) NOT NULL,
  `TenKhoa` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaKhoa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa`
--

LOCK TABLES `khoa` WRITE;
/*!40000 ALTER TABLE `khoa` DISABLE KEYS */;
INSERT INTO `khoa` VALUES ('MK001','Công Nghệ Thông Tin '),('MK002','Tự Động Hóa'),('MK003','Vật Lý Điện Tử'),('MK004','Cơ Khí');
/*!40000 ALTER TABLE `khoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `linhvuc`
--

DROP TABLE IF EXISTS `linhvuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `linhvuc` (
  `MaLV` char(10) NOT NULL,
  `TenLinhVuc` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaLV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `linhvuc`
--

LOCK TABLES `linhvuc` WRITE;
/*!40000 ALTER TABLE `linhvuc` DISABLE KEYS */;
INSERT INTO `linhvuc` VALUES ('LV001','Công Nghệ Thông Tin'),('LV002','Sách Văn Hóa Nghệ Thuật'),('LV003','Chuyên Ngành Cơ-Điện-Tử'),('LV004','Sách Văn Hóa Và Đời Sống'),('LV005','Khoa Học Tự Nhiên'),('LV006','Các Môn Đại Cương'),('LV007','Ngoại Ngữ');
/*!40000 ALTER TABLE `linhvuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ngonngu`
--

DROP TABLE IF EXISTS `ngonngu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ngonngu` (
  `MaNgonNgu` char(10) NOT NULL,
  `TenNgonNgu` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaNgonNgu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ngonngu`
--

LOCK TABLES `ngonngu` WRITE;
/*!40000 ALTER TABLE `ngonngu` DISABLE KEYS */;
INSERT INTO `ngonngu` VALUES ('LG001','France 1'),('LG002','Tiếng Anh');
/*!40000 ALTER TABLE `ngonngu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `MaNV` char(20) NOT NULL,
  `TenNV` varchar(45) DEFAULT NULL,
  `matkhau` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(50) DEFAULT NULL,
  `DienThoai` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaNV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES ('NV001','Ngô Đức Vĩnh','admin','66 Cầu Giấy, Hà Nội',967349884),('NV002','Nguyễn Thị Huyền',NULL,'16 Đống Đa Hà Nội',987343345),('NV003','Vũ Thị Dương',NULL,'56 Mai Dịch Hà Nội',969435756),('NV004','Vương Quốc Dũng',NULL,'12 Thanh Xuân, Hà Nội ',968353453),('NV005','Nguyễn Thế Sơn',NULL,'22 Hoàn Kiếm Hà Nội',986565323),('NV006','Phạm Hùng Cường',NULL,'34 Giải Phóng, Hà nội',965632336),('NV007','Nguyễn Văn tuấn',NULL,'12 Hồ Tùng Mậu',987878676),('NV008','Trần Văn Khánh',NULL,'34 Ngọc Khánh Hà Nội',965455343),('NV009','Nguyễn Thị Hồng',NULL,'32 Phạm Hùng Hà Nội',987211333),('NV010','Dương Thị Khánh',NULL,'52 Phùng Hưng hà Nội',987211222);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhaxuatban`
--

DROP TABLE IF EXISTS `nhaxuatban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhaxuatban` (
  `MaNXB` char(10) NOT NULL,
  `TenNXB` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  `DienThoai` int(11) DEFAULT NULL,
  PRIMARY KEY (`MaNXB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhaxuatban`
--

LOCK TABLES `nhaxuatban` WRITE;
/*!40000 ALTER TABLE `nhaxuatban` DISABLE KEYS */;
INSERT INTO `nhaxuatban` VALUES ('NXB001','NXB Giáo Dục','25 Thanh Xuân Hà Nội',423164478),('NXB002','NXB Chính Trị Quốc gia','12 Hoàn Kiếm Hà Nội',436565699),('NXB003','NXB Đại Học Quốc Gia Hà Nội','Cầu Giấy Hà Nội',431645634),('NXB004','NXB Thành Phố Hồ Chí Minh','Thành Phố Hồ Chí Minh',836464654),('NXB005','NXB Hà N?i','Cầu Giấy Hà Nội',434343554),('NXB007','NXB Bách Khoa Hà Nội','Hai Bà Trưng Hà Nội',NULL),('NXB008','NXB Khoa Học Và Kỹ Thuật','Hà Nội',NULL),('NXB009','NXB Thống Kê','Hà Nội',NULL);
/*!40000 ALTER TABLE `nhaxuatban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieumuon`
--

DROP TABLE IF EXISTS `phieumuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phieumuon` (
  `MaPhieu` char(20) NOT NULL,
  `TienDatCoc` char(20) DEFAULT NULL,
  `NgayLap` date DEFAULT NULL,
  `NgayHenTra` date DEFAULT NULL,
  `MaNV` char(20) NOT NULL,
  `MaDG` char(20) NOT NULL,
  PRIMARY KEY (`MaPhieu`),
  KEY `fk_PhieuMuon_NhanVien1_idx` (`MaNV`),
  KEY `fk_PhieuMuon_DocGia1_idx` (`MaDG`),
  CONSTRAINT `fk_PhieuMuon_DocGia1` FOREIGN KEY (`MaDG`) REFERENCES `docgia` (`MaDG`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_PhieuMuon_NhanVien1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieumuon`
--

LOCK TABLES `phieumuon` WRITE;
/*!40000 ALTER TABLE `phieumuon` DISABLE KEYS */;
INSERT INTO `phieumuon` VALUES ('PM001','40000','2013-10-15','2014-04-20','NV001','DG002'),('PM002','30000','2014-05-10','2014-09-20','NV001','DG004'),('PM003','80000','2013-09-15','2014-04-20','NV002','DG003'),('PM004','50000','2013-11-15','2014-04-20','NV002','DG005'),('PM005','100000','2013-11-21','2014-04-20','NV003','DG006'),('PM006','70000','2013-11-30','2014-01-12','NV004','DG007'),('PM007','90000','2012-01-12','2013-04-20','NV004','DG008'),('PM008','40000','2012-01-12','2013-04-20','NV005','DG003'),('PM009','40000','2013-08-24','2014-04-20','NV004','DG003'),('PM010','50000','2014-10-19','2015-04-20','NV005','DG008');
/*!40000 ALTER TABLE `phieumuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sach` (
  `MaSach` int(11) NOT NULL AUTO_INCREMENT,
  `MaTuaSach` char(10) NOT NULL,
  PRIMARY KEY (`MaSach`),
  KEY `fk_sach_tuasach1_idx` (`MaTuaSach`),
  CONSTRAINT `fk_sach_tuasach1` FOREIGN KEY (`MaTuaSach`) REFERENCES `tuasach` (`MaTuaSach`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sach`
--

LOCK TABLES `sach` WRITE;
/*!40000 ALTER TABLE `sach` DISABLE KEYS */;
INSERT INTO `sach` VALUES (2,'AC'),(5,'AC'),(68,'AW'),(69,'AW'),(74,'AW'),(101,'BD'),(102,'BD'),(104,'BD'),(105,'BD'),(96,'BF'),(97,'BF'),(100,'BF'),(106,'BF');
/*!40000 ALTER TABLE `sach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sachmuon`
--

DROP TABLE IF EXISTS `sachmuon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sachmuon` (
  `MaSach` int(11) NOT NULL,
  `MaPhieuMuon` char(20) NOT NULL,
  `trangthaitra` bit(1) DEFAULT NULL,
  `ngaytrasach` date DEFAULT NULL,
  `MaNVnhansachtra` char(20) DEFAULT NULL,
  KEY `fk_phieumuon_has_sach_sach1_idx` (`MaSach`),
  KEY `fk_phieumuon_has_sach_phieumuon1_idx` (`MaPhieuMuon`),
  KEY `fk_sachmuon_nhanvien1_idx` (`MaNVnhansachtra`),
  CONSTRAINT `fk_phieumuon_has_sach_phieumuon1` FOREIGN KEY (`MaPhieuMuon`) REFERENCES `phieumuon` (`MaPhieu`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_phieumuon_has_sach_sach1` FOREIGN KEY (`MaSach`) REFERENCES `sach` (`MaSach`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sachmuon_nhanvien1` FOREIGN KEY (`MaNVnhansachtra`) REFERENCES `nhanvien` (`MaNV`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sachmuon`
--

LOCK TABLES `sachmuon` WRITE;
/*!40000 ALTER TABLE `sachmuon` DISABLE KEYS */;
INSERT INTO `sachmuon` VALUES (5,'PM003','\0',NULL,NULL);
/*!40000 ALTER TABLE `sachmuon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tacgia`
--

DROP TABLE IF EXISTS `tacgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tacgia` (
  `MaTG` char(10) NOT NULL,
  `TenTacGia` varchar(45) DEFAULT NULL,
  `DiaChi` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MaTG`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tacgia`
--

LOCK TABLES `tacgia` WRITE;
/*!40000 ALTER TABLE `tacgia` DISABLE KEYS */;
INSERT INTO `tacgia` VALUES ('TG002','Daniel C.Matis','England'),('TG004','Vincent J.Nestler  ','America'),('TG005','Joanne M.atlee','America'),('TG006','Richard F.Raposa ','Russia'),('TG008','Lê Văn Khoa','Viet Nam'),('TG009','La Tổ Đức','Viet Nam'),('TG010','Nguyễn Văn Dương','Viet Nam'),('TG011','Lương Thị Phương Thảo','Viet Nam'),('TG012','Phạm thánh Nghị','Viet Nam'),('TG013','Nguyễn Văn Siêu','Viet Nam'),('TG014','Trần Đình Tường','Viet Nam'),('TG015','Nguyễn Hoàng Phương','Viet Nam'),('TG016','Đỗ Xuân Lôi','Viet Nam'),('TG017','Nguyễn Gia Định','Viet Nam'),('TG018','Lê Tuấn Hùng','Viet Nam'),('TG019','Lê Hữu Bình','Viet Nam');
/*!40000 ALTER TABLE `tacgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuasach`
--

DROP TABLE IF EXISTS `tuasach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tuasach` (
  `MaTuaSach` char(10) NOT NULL,
  `TenSach` varchar(155) DEFAULT NULL,
  `ChoMuon` bit(1) DEFAULT NULL,
  `GiaSach` char(10) DEFAULT NULL,
  `SoTrang` int(11) DEFAULT NULL,
  `MaNgonNgu` char(10) NOT NULL,
  `MaTG` char(10) NOT NULL,
  `MaNXB` char(10) NOT NULL,
  `MaLV` char(10) NOT NULL,
  PRIMARY KEY (`MaTuaSach`),
  KEY `fk_TuaSach_ngonngu1_idx` (`MaNgonNgu`),
  KEY `fk_TuaSach_TacGia1_idx` (`MaTG`),
  KEY `fk_TuaSach_NhaXuatBan1_idx` (`MaNXB`),
  KEY `fk_TuaSach_LinhVuc1_idx` (`MaLV`),
  CONSTRAINT `fk_TuaSach_LinhVuc1` FOREIGN KEY (`MaLV`) REFERENCES `linhvuc` (`MaLV`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TuaSach_NhaXuatBan1` FOREIGN KEY (`MaNXB`) REFERENCES `nhaxuatban` (`MaNXB`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TuaSach_TacGia1` FOREIGN KEY (`MaTG`) REFERENCES `tacgia` (`MaTG`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_TuaSach_ngonngu1` FOREIGN KEY (`MaNgonNgu`) REFERENCES `ngonngu` (`MaNgonNgu`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuasach`
--

LOCK TABLES `tuasach` WRITE;
/*!40000 ALTER TABLE `tuasach` DISABLE KEYS */;
INSERT INTO `tuasach` VALUES ('AC','Test Your Enlish Vocabulary In Use','\0','200',50000,'LG002','TG019','NXB004','LV007'),('AW','Computer Security','\0',NULL,150,'LG002','TG004','NXB001','LV001'),('BD','Software Engineering','\0',NULL,40,'LG002','TG005','NXB008','LV001'),('BF','Understanding C++ for MFC','',NULL,200,'LG002','TG006','NXB008','LV001');
/*!40000 ALTER TABLE `tuasach` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-04-22 16:42:45
