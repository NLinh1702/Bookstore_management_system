CREATE DATABASE QuanLyNhaSach;
USE QuanLyNhaSach;

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- START TRANSACTION;
-- SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

-- Cơ sở dữ liệu: `quanlydausach`

DELIMITER $$

-- Thủ tục
CREATE DEFINER=`root`@`localhost` PROCEDURE `thongkesach` (IN `masach` NVARCHAR(10))  begin
	select dms.MaSach, TenSach, sum(cthd.SoLuong) as TongSL
	from DanhMucSach dms join ChiTietHoaDon cthd on cthd.MaSach=dms.MaSach
	where dms.MaSach=masach
	group by dms.MaSach, TenSach;
end$$

DELIMITER ;


-- ----------------------------------------------------
use quanlynhasach;
DELIMITER $$
CREATE PROCEDURE `themkhachhang`(
	`MaKH` varchar(10),
  `TenKH` varchar(30),
  `TenCT` varchar(30),
  `DiaChi` varchar(100),
  `Email` varchar(30),
  `SDT` varchar(10),
  `Fax` varchar(10)  )
 
BEGIN
INSERT INTO khachhang VALUES (MaKH,TenKH,TenCT,DiaChi,Email,SDT,Fax);
END$$
delimiter ;


 -- call themkhachhang('KH010','Nguyen Van A','CCC','DD','A@gmail.com','092342049','642346238');
-- Them nhan vien---

DELIMITER $$
CREATE PROCEDURE `themnhanvien`(
	`MaNV` varchar(10) ,
  `HoLot` varchar(20) ,
  `TenNV` varchar(10) ,
  `Phai` int(11) ,
  `NgaySinh` date ,
  `NgayLamViec` datetime(0),
  `DiaChi` varchar(100),
  `Email` varchar(30),
  `ChucVu` varchar(15),
  `SoDT` varchar(10),
  `LuongCB` int(11),
  `PhuCap` int(11)) 
BEGIN
INSERT INTO nhanvien VALUES (MaNV,HoLot,TenNV,Phai,NgaySinh,NgayLamViec,DiaChi,Email,ChucVu,SoDT,LuongCB,PhuCap);
END$$
delimiter ;
-- call themnhanvien('NV009', 'Trần Ngọc', 'Như', 1, '1994-10-20', '2022-02-10 00:00:00', '17, 30/4 Cần Thơ', 'Nhu@gmail.com', 'Nhân viên', '0834001929', 51, 0 );


SET SQL_SAFE_UPDATES = 0;

DELIMITER $$
CREATE PROCEDURE `xoakhachhang`(
	MKH varchar(10)
) 
BEGIN
DELETE From khachhang Where MaKH = MKH;
END$$
delimiter ;


-- XOA NHAN VIEN
DELIMITER $$
 CREATE PROCEDURE `xoanhanvien`(
 	MNV varchar(10)
 ) 
 BEGIN
 DELETE From nhanvien Where MaNV = MNV;
 END$$
 delimiter ; 
 
 
-- XOA DANH MUC SACH
DELIMITER $$
 CREATE PROCEDURE `xoadanhmucsach`(
 	MDMS varchar(10)
 ) 
 BEGIN
 DELETE From danhmucsach Where MaSach = MDMS;
 END$$
 delimiter ; 


-- Xoa nha cung cap
DELIMITER $$
CREATE PROCEDURE `xoanhacungcap`(
 	MNCC varchar(10)
 ) 
 BEGIN
 DELETE From nhanvien Where MaNCC = MNCC;
 END$$
 delimiter ;
 
 
-- Them nha cung cap 
DELIMITER $$
CREATE PROCEDURE `themnhacungcap`(
  `MaNCC` varchar(10) ,
  `TenNCC` varchar(20) ,
  `DiaChi` varchar(10) ,
  `DienThoai` int(11) ,
  `Email` varchar(30),
  `Fax` varchar(10))
 
BEGIN
INSERT INTO nhacungcap VALUES (MaNCC,TenNCC,DiaChi,DienThoai,Email,Fax);
END$$
delimiter ;


-- Them danh muc sach
DELIMITER $$
 CREATE PROCEDURE `themdanhmucsach`(
  `MaSach` varchar(10) ,
  `TenSach` varchar(20) ,
  `TacGia` varchar(10) ,
  `MaNhom`  varchar(10) ,
  `MaNCC` varchar(30),
  `DonGia` varchar(10),
  `SLTon` int(11))
 
BEGIN
INSERT INTO danhmucsach VALUES (MaSach,TenSach,TacGia,MaNhom,MaNCC,DonGia,SLTon);
END$$
delimiter ;
-- ---------------------------------- 

-- Cấu trúc bảng cho bảng `chitiethoadon`

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MaSach` varchar(10) CHARACTER SET utf8 NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaBan` int(11) NOT NULL,
  `GiamGia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--  Dữ liệu cho bảng `chitiethoadon`

INSERT INTO `chitiethoadon` (`MaHD`, `MaSach`, `SoLuong`, `GiaBan`, `GiamGia`) VALUES
('HD001', 'S0001', 20, 150000, 10000),
('HD002', 'S0002', 10, 150000, 10000),
('HD002', 'S0003', 9, 160000, 10000),
('HD002', 'S0004', 8, 160000, 10000),
('HD002', 'S0005', 10, 170000, 10000),
('HD003', 'S0001', 21, 180000, 10000),
('HD003', 'S0003', 13, 200000, 2000);

-- ---------------------------------------------------------------------------------------

-- Cấu trúc bảng cho bảng `danhmucsach`

CREATE TABLE `danhmucsach` (
  `MaSach` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TenSach` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TacGia` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MaNhom` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MaNCC` varchar(10) CHARACTER SET utf8 NOT NULL,
  `DonGia` varchar(10) CHARACTER SET utf8 NOT NULL,
  `SLTon` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dữ liệu cho bảng `danhmucsach`
--

INSERT INTO `danhmucsach` (`MaSach`, `TenSach`, `TacGia`, `MaNhom`, `MaNCC`, `DonGia`, `SLTon`) VALUES
('S0001', 'QTDL', 'T.C.An', 'N0001', 'NCC03', '40000', 100),
('S0002', 'MHUD', 'N.M.Thu', 'N0001', 'NCC03', '60000', 80),
('S0003', 'LTCB', 'N.B.Tuyen', 'N0003', 'NCC01', '86000', 50),
('S0004', 'CTDL', 'T.C.De', 'N0002', 'NCC03', '24000', 16),
('S0005', 'CNW', 'T.M.Thai', 'N0002', 'NCC02', '34000', 150),
('S0006', 'LTDT', 'L.P.Dung', 'N0004', 'NCC01', '28000', 210),
('S0007', 'QTHT', 'T.M.Tuan', 'N0002', 'NCC01', '26000', 45),
('S0008', 'MySQL', 'D.X.Thanh', 'N0006', 'NCC01', '145000', 54),
('S0009', 'SQL', 'T.Q.Dinh', 'N0006', 'NCC01', '100000', 82);

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MaNV` varchar(10) CHARACTER SET utf8 NOT NULL,
  `MaKH` varchar(10) CHARACTER SET utf8 NOT NULL,
  `NgayDH` date NOT NULL,
  `NgayGH` date NOT NULL,
  `NoiGiao` varchar(10) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dữ liệu cho bảng `hoadon`

INSERT INTO `hoadon` (`MaHD`, `MaNV`, `MaKH`, `NgayDH`, `NgayGH`, `NoiGiao`) VALUES
('HD001', 'NV001', 'KH001', '2005-01-15', '2005-02-17', 'Sóc Trăng'),
('HD002', 'NV001', 'KH003', '2005-02-01', '2005-02-17', 'Cằn Thơ'),
('HD003', 'NV001', 'KH004', '2005-01-20', '2006-01-20', 'Vĩnh Long'),
('HD004', 'NV002', 'KH005', '2005-01-10', '2005-01-17', 'Vĩnh Long'),
('HD005', 'NV001', 'KH006', '2004-01-04', '2005-01-07', 'Vĩnh Long'),
('HD006', 'NV003', 'KH001', '2005-10-15', '2005-10-20', 'Vĩnh Long'),
('HD007', 'NV003', 'KH004', '2005-01-25', '2005-01-27', 'Cà Mau'),
('HD008', 'NV002', 'KH005', '2005-02-15', '2005-02-17', 'Cà Mau'),
('HD009', 'NV001', 'KH002', '2005-01-14', '2005-01-17', 'TPHCM');

-- ---------------------------------------------------------------------------------------

-- Cấu trúc bảng cho bảng `khachhang`

CREATE TABLE `khachhang` (
  `MaKH` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TenKH` varchar(30) CHARACTER SET utf8 NOT NULL,
  `TenCT` varchar(30) CHARACTER SET utf8 NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
`SDT` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `Fax` varchar(10) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dữ liệu cho bảng `khachhang`

INSERT INTO `khachhang` (`MaKH`, `TenKH`, `TenCT`, `DiaChi`, `Email`, `SDT`, `Fax`) VALUES
('KH001', 'Phan Minh Hiền', 'Đại Học Cần Thơ', 'Cần Thơ', 'hien@gmail.com', '0123456789', '0123456789'),
('KH002', 'Nguyễn Võ Việt Nga', 'Đại Học Nam Cần Thơ', 'Cần Thơ', 'ngag@gmail.com', '0234567891', '0987654321'),
('KH003', 'Lê Nhựt Linh', 'Một Nhà', 'Bạc Liêu', 'linh@gmail.com', '0987654321', '0987615243'),
('KH004', 'Mai Nhựt Long', 'Phát Đạt', 'Cà Mau', 'long@gmail.com', '0897654123', '0897165243'),
('KH005', 'Lê Thị Thúy Hằng', 'Đại Học Cần Thơ', 'Cần Thơ', 'hang@gmail.com', '0789654123', '0981726354'),
('KH006', 'Nguyễn Thị Trang Đài', 'Ước Mơ', 'Cần Thơ', 'dai@gmail.com', '0909775529', '0980765432');
-- ---------------------------------------------------------------------------------------

-- Cấu trúc bảng cho bảng `nhacungcap`

CREATE TABLE `nhacungcap` (
  `MaNCC` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TenNCC` varchar(20) CHARACTER SET utf8 NOT NULL,
  `DiaChi` varchar(10) CHARACTER SET utf8 NOT NULL,
  `DienThoai` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Fax` varchar(10) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--  Dữ liệu cho bảng `nhacungcap`

INSERT INTO `nhacungcap` (`MaNCC`, `TenNCC`, `DiaChi`, `DienThoai`, `Email`, `Fax`) VALUES
('NCC01', 'Hát Mãi', 'TPHCM', '0123456789', 'hatmai@gmail.com', '0123456789'),
('NCC02', 'Cộng Đồng', 'HN', '0345567891', 'congdong@gmail.com', '0345565534'),
('NCC03', 'CTU', 'CT', '0122345987', 'ctu@gmail.com', '0239492941'),
('NCC04', 'CTU', 'CT', '0987121345', 'ctu@gmail.com', '0228748234'),
('NCC05', 'Nam CanTho', 'CT', '0123789456', 'ctho@gmail.com', '0232318555');
-- ---------------------------------------------------------------------------------------

-- Cấu trúc bảng cho bảng `nhanvien`

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) CHARACTER SET utf8 NOT NULL,
  `HoLot` varchar(20) CHARACTER SET utf8 NOT NULL,
  `TenNV` varchar(10) CHARACTER SET utf8 NOT NULL,
  `Phai` int(11) NOT NULL,
  `NgaySinh` date NOT NULL,
  `NgayLamViec` datetime NOT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 NOT NULL,
  `Email` varchar(30) CHARACTER SET utf8 NOT NULL,
  `ChucVu` varchar(15) CHARACTER SET utf8 NOT NULL,
  `SoDT` varchar(10) CHARACTER SET utf8 NOT NULL,
  `LuongCB` int(11) NOT NULL,
  `PhuCap` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dữ liệu cho bảng `nhanvien`

INSERT INTO `nhanvien` (`MaNV`, `HoLot`, `TenNV`, `Phai`, `NgaySinh`, `NgayLamViec`, `DiaChi`, `Email`, `ChucVu`, `SoDT`, `LuongCB`, `PhuCap`) VALUES
('NV001', 'Nguyễn Thị', 'Cúc', 0, '1980-03-17', '2022-05-10 00:00:00', 'Đường 3/2, Ninh Kiều', 'Cuc@yahoo.com', 'Nhân viên', '0859770429', 102, 1),
('NV002', 'Phạm Tấn', 'Phát', 1, '1982-01-29', '2022-04-14 00:00:00', 'Đường 30/40, Hưng Lợi', 'Phat@yahoo.com', 'Nhân Viên', '0345867544', 90, 1),
('NV003', 'Trần Thị', 'Liên', 0, '1992-05-25', '2022-04-13 00:00:00', 'Trần Hoàng Na', 'Lien@gmail.com', 'Trưởng phòng', '0344712128', 110, 1),
('NV004', 'Phạm Văn', 'Bách', 1, '1989-01-17', '2022-03-05 00:00:00', 'Trần Văn Khéo', 'Bach@yahoo.com', 'Nhân viên', '0587070942', 97, 1),
('NV005', 'Trương Thị', 'Chi', 0, '2000-01-15', '2022-05-05 00:00:00', 'Cách Mạng Tháng 8', 'Chi@gmail.com', 'KT trưởng', '0913778837', 110, 0),
('NV006', 'Ngô Quang', 'Tèo', 1, '1971-11-01', '2022-05-05 00:00:00', '15, 3/2 Cần Thơ', 'Teo@gmail.com', 'Nhân viên', '0385555470', 51, 0),
('NV007', 'Trần Ngọc', 'Như', 1, '1994-10-20', '2022-02-10 00:00:00', '17, 30/4 Cần Thơ', 'Nhu@gmail.com', 'Nhân viên', '0834001929', 51, 0);

-- ---------------------------------------------------------------------------------------

-- Cấu trúc bảng cho bảng `nhomsach`

CREATE TABLE `nhomsach` (
  `MaNhom` varchar(10) CHARACTER SET utf8 NOT NULL,
  `TenNhom` varchar(10) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dữ liệu cho bảng `nhomsach`

INSERT INTO `nhomsach` (`MaNhom`, `TenNhom`) VALUES
('N0001', 'Khoa học'),
('N0002', 'Toán học'),
('N0003', 'Anh văn'),
('N0004', 'Chính trị'),
('N0005', 'Y học'),
('N0006', 'Văn học');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaSach`);

--
-- Chỉ mục cho bảng `danhmucsach`
--
ALTER TABLE `danhmucsach`
  ADD PRIMARY KEY (`MaSach`),
  ADD KEY `fk_MaNCC1` (`MaNCC`),
  ADD KEY `fk_MaNhom1` (`MaNhom`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `fk_MaNV1` (`MaNV`),
  ADD KEY `fk_MaKH1` (`MaKH`);

--
-- Chỉ mục cho bảng `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhomsach`
--
ALTER TABLE `nhomsach`
  ADD PRIMARY KEY (`MaNhom`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `danhmucsach`
--
ALTER TABLE `danhmucsach`
  ADD CONSTRAINT `fk_MaNCC1` FOREIGN KEY (`MaNCC`) REFERENCES `nhacungcap` (`MaNCC`),
  ADD CONSTRAINT `fk_MaNhom1` FOREIGN KEY (`MaNhom`) REFERENCES `nhomsach` (`MaNhom`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `fk_MaKH1` FOREIGN KEY (`MaKH`) REFERENCES `khachhang` (`MaKH`),
ADD CONSTRAINT `fk_MaNV1` FOREIGN KEY (`MaNV`) REFERENCES `nhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;