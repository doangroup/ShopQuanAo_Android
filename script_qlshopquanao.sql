USE [master]
GO
/****** Object:  Database [QLSHOPQUANAO]    Script Date: 6/30/2021 11:57:31 PM ******/
CREATE DATABASE [QLSHOPQUANAO]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QLSHOPQUANAO', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QLSHOPQUANAO.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QLSHOPQUANAO_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QLSHOPQUANAO_log.ldf' , SIZE = 784KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QLSHOPQUANAO] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QLSHOPQUANAO].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QLSHOPQUANAO] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET ARITHABORT OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QLSHOPQUANAO] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QLSHOPQUANAO] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QLSHOPQUANAO] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QLSHOPQUANAO] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QLSHOPQUANAO] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QLSHOPQUANAO] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QLSHOPQUANAO] SET  MULTI_USER 
GO
ALTER DATABASE [QLSHOPQUANAO] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QLSHOPQUANAO] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QLSHOPQUANAO] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QLSHOPQUANAO] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QLSHOPQUANAO]
GO
/****** Object:  StoredProcedure [dbo].[DangKyThanhVien]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create proc [dbo].[DangKyThanhVien](@makhach int,@tenKH nvarchar(50),@diachi nvarchar(100),@sdt nvarchar(20),@mk nvarchar(50))
as 
insert into KhachHang(MaKH,TenKH,DiaChi,SDT,MatKhau)
values (@makhach,@tenKH,@diachi,@sdt,@mk)
------------
GO
/****** Object:  StoredProcedure [dbo].[lay_DanhMuc]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[lay_DanhMuc]
as
(
select * from DanhMuc
)
---------------------
GO
/****** Object:  StoredProcedure [dbo].[lay_DS_SanPham_Theo_Danh_Muc]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[lay_DS_SanPham_Theo_Danh_Muc](@ma int)
as
Select *
from SanPham as s
where  s.MaDM=@ma
GO
/****** Object:  StoredProcedure [dbo].[lay_KhachHang]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[lay_KhachHang](@sdt nvarchar(50))
as
Select *
from KhachHang
where KhachHang.SDT=@sdt
GO
/****** Object:  StoredProcedure [dbo].[lay_SanPham]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create proc [dbo].[lay_SanPham]
as
(
select * from SanPham
)
GO
/****** Object:  Table [dbo].[ChiTietHD]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHD](
	[MaCTHD] [int] IDENTITY(1,1) NOT NULL,
	[MaHD] [int] NULL,
	[MaSP] [int] NULL,
	[SoLuong] [int] NULL,
	[ThanhTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDM] [int] NOT NULL,
	[TenDM] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [int] NOT NULL,
	[MaKH] [int] NULL,
	[MaNV] [int] NULL,
	[Tinhtrang] [int] NULL,
	[NgayBan] [datetime] NOT NULL,
	[NgayGiao] [datetime] NULL,
	[TongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [int] IDENTITY(1,1) NOT NULL,
	[TenKH] [nvarchar](100) NOT NULL,
	[DiaChi] [nvarchar](100) NULL,
	[SDT] [nvarchar](20) NULL,
	[MatKhau] [nvarchar](50) NULL DEFAULT (NULL),
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MaKM] [int] NOT NULL,
	[TenKM] [nvarchar](50) NULL,
	[LinkKM] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [int] IDENTITY(1,1) NOT NULL,
	[TenNV] [nvarchar](100) NOT NULL,
	[GioiTinh] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[SDT] [nvarchar](100) NOT NULL,
	[NgaySinh] [datetime] NOT NULL,
	[TenDN] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[LoaiTK] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 6/30/2021 11:57:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [int] NOT NULL,
	[MaDM] [int] NULL,
	[TenSP] [nvarchar](100) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[DonGia] [money] NOT NULL,
	[HinhAnh] [nvarchar](50) NULL,
	[GhiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (1, N'Áo Sơ Mi')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (2, N'Áo Thun')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (3, N'Quần Jean')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (4, N'Quần Tây')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (5, N'Áo Khoác Nam')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (6, N'Quần Jogger')
INSERT [dbo].[DanhMuc] ([MaDM], [TenDM]) VALUES (7, N'Áo Cặp')
SET IDENTITY_INSERT [dbo].[KhachHang] ON 

INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [MatKhau]) VALUES (1, N'Tạ Quang Trung', N'Thôn 5', N'0123456', N'1')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [MatKhau]) VALUES (2, N'Nguyễn Văn Tèo', N'Thôn 2', N'0123456', N'1')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [MatKhau]) VALUES (3, N'Nguyễn Thị Bưởi', N'Thôn 8', N'0123456', N'1')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [MatKhau]) VALUES (4, N'Nguyễn Thị Đào', N'Thôn 1', N'0123456', N'1')
INSERT [dbo].[KhachHang] ([MaKH], [TenKH], [DiaChi], [SDT], [MatKhau]) VALUES (5, N'Nguyễn Thanh Huy', N'Tp.HCM', N'0902669401', N'admin')
SET IDENTITY_INSERT [dbo].[KhachHang] OFF
SET IDENTITY_INSERT [dbo].[NhanVien] ON 

INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [SDT], [NgaySinh], [TenDN], [MatKhau], [LoaiTK]) VALUES (1, N'Trung', N'Nam', N'Tân Phú', N'045648932', CAST(N'1900-03-28 00:00:00.000' AS DateTime), N'admin', N'c4ca4238a0b923820dcc509a6f75849b', 1)
INSERT [dbo].[NhanVien] ([MaNV], [TenNV], [GioiTinh], [DiaChi], [SDT], [NgaySinh], [TenDN], [MatKhau], [LoaiTK]) VALUES (2, N'Nhân Viên 2', N'Nữ', N'Thủ Đức', N'045648932', CAST(N'1900-01-15 00:00:00.000' AS DateTime), N'admin2', N'c4ca4238a0b923820dcc509a6f75849b', 0)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (1, 7, N'Áo thun đính đá hình báo', 20, 200000.0000, N'cap3.jpg', N'Giặt ra màu')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (2, 7, N'Áo thun đính đá', 10, 100000.0000, N'cap6.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (3, 7, N'Áo thun đính đá đầu hổ', 50, 20000.0000, N'cap10.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (4, 7, N'Áo thun burlong thêu', 10, 50000.0000, N'cap5.jpg', N'Giặt ra màu')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (5, 7, N'Áo thun cánh chim', 40, 100000.0000, N'cap13.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (6, 7, N'Áo thun cánh chim ngũ sắc', 15, 200000.0000, N'cap13.jpg', N'Giặt không ra màu')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (7, 7, N'Áo sơ mi nam họa tiết sọc in', 20, 250000.0000, N'cap17.jpg', N'Vải dày')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (8, 7, N'Áo thun cánh chim thiên thần có cổ đính ', 50, 20000.0000, N'cap14.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (9, 7, N'Áo thun nam đính đá versace ', 20, 100000.0000, N'cap2.jpg', N'Giặt ra màu')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (10, 7, N'Áo thun cánh chim thiên thần', 20, 100000.0000, N'cap1.jpg', N'Giặt ra màu')
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (11, 7, N'Áo sơ mi nam họa tiết jean sọc ', 20, 100000.0000, N'cap16.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (12, 7, N'Áo thun tay dài thêu versace', 20, 100000.0000, N'cap4.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (13, 7, N'Áo thun dài tay đính đá', 20, 100000.0000, N'cap7.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (14, 7, N'Áo thun dài tay đính cườm versace', 20, 100000.0000, N'cap12.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (15, 7, N'áo thun đầu hổ 8997 Nam-Nữ', 20, 100000.0000, N'cap9.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (16, 7, N'áo sơ mi sọc 1890', 20, 100000.0000, N'cap18.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (17, 7, N'áo sơ mi mặt trời 290 (Nam -nữ)', 20, 100000.0000, N'cap15.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (18, 1, N'Áo sơ mi họa tiết versace', 20, 100000.0000, N'somi14.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (19, 1, N'Áo sơ mi họa tiết versace', 20, 100000.0000, N'somi15.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (20, 1, N'Áo sơ mi nam họa tiết D&G', 20, 100000.0000, N'somi16.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (21, 1, N'Áo sơ mi nam trắng NYC', 20, 100000.0000, N'somi11.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (22, 1, N'Áo sơ mi nam trắng trơn', 20, 100000.0000, N'somi20.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (23, 1, N'Áo sơ mi nam họa tiết versace', 20, 100000.0000, N'somi13.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (24, 1, N'Áo sơ mi nam họa tiết versace', 20, 100000.0000, N'somi25.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (25, 1, N'Áo sơ mi nam burberry ', 20, 100000.0000, N'somi10.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (26, 1, N'Áo sơ mi nam họa tiết hoa văn', 20, 100000.0000, N'somi12.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (27, 1, N'Áo sơ mi NYC', 20, 100000.0000, N'somi9.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (28, 1, N'Áo sơ mi nam sọc caro', 20, 100000.0000, N'somi23.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (29, 1, N'áo sơ mi nam trắng trơn', 20, 100000.0000, N'somi24.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (30, 1, N'Áo sơ mi nam họa tiết', 20, 100000.0000, N'somi3.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (31, 1, N'Áo sơ mi nam sọc họa', 20, 100000.0000, N'somi2.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (32, 2, N'Áo thun nam hoạ tiết burberi', 20, 100000.0000, N'thun1.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (33, 2, N'Áo thun nam hoạ tiết hình sư tử', 20, 100000.0000, N'thun2.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (34, 2, N'Áo thun nam hoạ tiết đặc biệt', 20, 100000.0000, N'thun3.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (35, 2, N'Áo thun nam hoạ tiết chuột Mickey đính', 20, 100000.0000, N'thun4.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (36, 2, N'Áo thun nam hoạ tiết đặc biệt ', 20, 100000.0000, N'thun5.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (37, 2, N'Áo thun nam đính cườm', 20, 100000.0000, N'thun6.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (38, 2, N'Áo thun nam hoạ tiết in nhũ vàng', 20, 100000.0000, N'thun7.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (39, 2, N'Áo thun đính cườm', 20, 100000.0000, N'thun8.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (40, 2, N'áo thun nam họa tiết thêu 3D đính cườm', 20, 100000.0000, N'thun9.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (41, 2, N'Áo thun có cổ LOGO', 20, 100000.0000, N'thun10.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (42, 2, N'Áo thun nam có cổ', 20, 100000.0000, N'thun11.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (43, 3, N'Quần jean đen nam rách gối', 20, 100000.0000, N'jean1.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (44, 3, N'quần jean rách nam', 20, 100000.0000, N'jean2', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (45, 3, N'quần jean rách', 20, 100000.0000, N'jean3', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (46, 3, N'quần jean rách', 20, 100000.0000, N'jean4', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (47, 3, N'Quần jean rách', 20, 100000.0000, N'jean5', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (48, 3, N'quần jean', 20, 100000.0000, N'jean6', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (49, 3, N'quần jean rách', 20, 100000.0000, N'jean7', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (50, 3, N'quần jean rách gối', 20, 100000.0000, N'jean8', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (51, 3, N'quần jean rách', 20, 100000.0000, N'jean9', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (52, 3, N'quần jean rách', 20, 100000.0000, N'jean10.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (53, 3, N'quần jean rách', 20, 100000.0000, N'jean11.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (54, 4, N'quần tây âu (big size)', 20, 100000.0000, N'tay1.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (55, 4, N'quần tây Nam size lớn ống côn', 20, 100000.0000, N'tay2.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (56, 4, N'quần tây size lớn xám chì ống ôm', 20, 100000.0000, N'tay3.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (57, 4, N'Quần Tây nam ống côn', 20, 100000.0000, N'tay4.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (58, 4, N'quần tây nam ống côn', 20, 100000.0000, N'tay5.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (59, 4, N'quần tây âu 3', 20, 100000.0000, N'tay6.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (60, 4, N'quần tây âu 5', 20, 100000.0000, N'tay7.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (61, 4, N'quần tây âu 1', 20, 100000.0000, N'tay8.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (62, 4, N'Tây slim hàn quốc', 20, 100000.0000, N'tay9.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (63, 5, N'áo khoác số c7', 20, 100000.0000, N'khoac1.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (64, 5, N'áo khoác bombor', 20, 100000.0000, N'khoac2.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (65, 6, N'quần jogger thun', 20, 100000.0000, N'jogger2.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (66, 6, N'quần jogger thun 2007', 20, 100000.0000, N'jogger3.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (67, 6, N'quần jogger thun 2009', 20, 100000.0000, N'jogger4.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (68, 6, N'quần jogger thun 2019', 20, 100000.0000, N'jogger5.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (69, 6, N'quần jogger thun 2020', 20, 100000.0000, N'jogger6.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (70, 6, N'quần jogger', 20, 100000.0000, N'jogger7.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (71, 6, N'quần jogger 1815', 20, 100000.0000, N'jogger8.jpg', NULL)
INSERT [dbo].[SanPham] ([MaSP], [MaDM], [TenSP], [SoLuong], [DonGia], [HinhAnh], [GhiChu]) VALUES (72, 6, N'quần jogger 925', 20, 100000.0000, N'jogger9.jpg', NULL)
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [Tinhtrang]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [fk_CTHD_HD] FOREIGN KEY([MaHD])
REFERENCES [dbo].[HoaDon] ([MaHD])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [fk_CTHD_HD]
GO
ALTER TABLE [dbo].[ChiTietHD]  WITH CHECK ADD  CONSTRAINT [fk_HD_H] FOREIGN KEY([MaSP])
REFERENCES [dbo].[SanPham] ([MaSP])
GO
ALTER TABLE [dbo].[ChiTietHD] CHECK CONSTRAINT [fk_HD_H]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [fk_HD_KH] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [fk_HD_KH]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [fk_HD_NV] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [fk_HD_NV]
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD  CONSTRAINT [fk_SP_DM] FOREIGN KEY([MaDM])
REFERENCES [dbo].[DanhMuc] ([MaDM])
GO
ALTER TABLE [dbo].[SanPham] CHECK CONSTRAINT [fk_SP_DM]
GO
USE [master]
GO
ALTER DATABASE [QLSHOPQUANAO] SET  READ_WRITE 
GO
