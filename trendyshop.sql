USE [master]
GO
/****** Object:  Database [trendyshop]    Script Date: 11/10/2023 8:24:12 AM ******/
CREATE DATABASE [trendyshop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'trendyshop', FILENAME = N'D:\PTUD\trendyshop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'trendyshop_log', FILENAME = N'D:\PTUD\trendyshop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [trendyshop] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [trendyshop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [trendyshop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [trendyshop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [trendyshop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [trendyshop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [trendyshop] SET ARITHABORT OFF 
GO
ALTER DATABASE [trendyshop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [trendyshop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [trendyshop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [trendyshop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [trendyshop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [trendyshop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [trendyshop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [trendyshop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [trendyshop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [trendyshop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [trendyshop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [trendyshop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [trendyshop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [trendyshop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [trendyshop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [trendyshop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [trendyshop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [trendyshop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [trendyshop] SET  MULTI_USER 
GO
ALTER DATABASE [trendyshop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [trendyshop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [trendyshop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [trendyshop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [trendyshop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [trendyshop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [trendyshop] SET QUERY_STORE = OFF
GO
USE [trendyshop]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHangHoa] [char](100) NOT NULL,
	[maHoaDon] [char](100) NOT NULL,
	[soLuong] [int] NULL,
	[giaBan] [float] NOT NULL,
	[thanhTien] [float] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHangHoa] ASC,
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HangHoa]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoa](
	[maHangHoa] [char](100) NOT NULL,
	[tenHangHoa] [varchar](150) NULL,
	[phanLoai] [varchar](150) NULL,
	[thuongHieu] [varchar](150) NULL,
	[xuatXu] [varchar](150) NULL,
	[chatLieu] [varchar](150) NULL,
	[chiTietMoTa] [varchar](500) NULL,
	[hinhAnh] [char](100) NULL,
	[maNhaCungCap] [char](100) NULL,
	[kichCo] [varchar](50) NULL,
	[mauSac] [varchar](50) NULL,
	[soLuongTon] [int] NULL,
	[soLuongDaBan] [int] NULL,
	[donGiaNhap] [float] NULL,
	[trangThai] [bit] NULL,
 CONSTRAINT [PK_hang_hoa] PRIMARY KEY CLUSTERED 
(
	[maHangHoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [char](100) NOT NULL,
	[thoiGianTao] [datetime] NULL,
	[tongThanhTien] [float] NULL,
	[maVoucher] [char](100) NULL,
	[maKhachHang] [char](100) NULL,
	[maNhanVien] [char](100) NULL,
	[trangThaiThanhToan] [bit] NULL,
 CONSTRAINT [PK_hoa_don] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [char](100) NOT NULL,
	[soDienThoai] [char](15) NOT NULL,
	[tenKhachHang] [varchar](150) NULL,
	[email] [char](100) NULL,
	[diaChi] [varchar](150) NULL,
	[trangThai] [bit] NULL,
	[diemTichLuy] [float] NULL,
 CONSTRAINT [PK_khach_hang_1] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [char](100) NOT NULL,
	[tenNhaCungCap] [varchar](150) NULL,
	[soDienThoai] [char](15) NULL,
	[email] [char](50) NULL,
	[diaChi] [varchar](150) NULL,
 CONSTRAINT [PK_nha_cung_cap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [char](100) NOT NULL,
	[hoTen] [varchar](150) NULL,
	[ngaySinh] [date] NULL,
	[soCCCD] [char](15) NULL,
	[soDienThoai] [char](15) NULL,
	[email] [char](50) NULL,
	[diaChi] [varchar](250) NULL,
	[chucVu] [varchar](50) NULL,
	[trangThai] [bit] NULL,
	[matKhau] [char](200) NULL,
	[phanQuyen] [bit] NULL,
	[hinhAnh] [char](100) NULL,
 CONSTRAINT [PK_nhan_vien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhienDangNhap]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhienDangNhap](
	[maPhienDangNhap] [char](100) NOT NULL,
	[thoiGianDangNhap] [datetime] NULL,
	[thoiGianDangXuat] [datetime] NULL,
	[maNhanVien] [char](100) NULL,
 CONSTRAINT [PK_phien_dang_nhap] PRIMARY KEY CLUSTERED 
(
	[maPhienDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VoucherGiamGia]    Script Date: 11/10/2023 8:24:12 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VoucherGiamGia](
	[maVoucher] [char](100) NOT NULL,
	[tenVoucher] [varchar](150) NULL,
	[moTaChuongTrinh] [varchar](250) NULL,
	[phanTramGiamTheoHoaDon] [float] NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
	[trangThai] [bit] NULL,
	[soLuotDung] [int] NULL,
 CONSTRAINT [PK_voucher_giam_gia] PRIMARY KEY CLUSTERED 
(
	[maVoucher] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0001                                                                                              ', N'Hoodie', N'Áo', N'JUNO ', N'Vi?t Nam', N'V?i kate', NULL, NULL, N'NCC001                                                                                              ', N'S', N'xanh', 112, 221, 400, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0002                                                                                              ', N'Sweater', N'Áo', N'OWEN', N'Vi?t Nam', N'V?i Kaki', NULL, NULL, N'NCC002                                                                                              ', N'S', N'd?', 113, 321, 390, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0003                                                                                              ', N'Kính mát', N'Ph? ki?n', N'NOVELTY', N'Trung Qu?c', N'Nh?a', N'', N'Hình ?nh                                                                                            ', N'NCC011                                                                                              ', N'M', N'tím', 345, 32, 95, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0004                                                                                              ', N'Váy ch? A', N'Váy', N'NEM', N'Nh?t B?n', N'V?i Poplin', N'', N'Hình ?nh                                                                                            ', N'NCC005                                                                                              ', N'XXL', N'vàng', 234, 43, 484, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0005                                                                                              ', N'Váy peplum', N'Váy', N'Moda', N'Hàn Qu?c', N'V?i voan', NULL, NULL, N'NCC005                                                                                              ', N'L', N'l?c', 232, 54, 200, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0006                                                                                              ', N'Áo vest', N'Áo', N'PT2000', N'Hàn Qu?c', N'V?i thô', N'', N'Hình ?nh                                                                                            ', N'NCC006                                                                                              ', N'S', N'xanh', 432, 11, 345, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0007                                                                                              ', N'Qu?n Baggy', N'Qu?n', N'Genviet ', N'Vi?t Nam', N'V?i Cotton', NULL, NULL, N'NCC007                                                                                              ', N'S', N'chàm', 125, 233, 790, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0009                                                                                              ', N'Qu?n Joggers', N'Qu?n', N'Coolmate ', N'Vi?t Nam', N'V?i Polyester', NULL, NULL, N'NCC008                                                                                              ', N'L', N'tím', 111, 254, 653, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0010                                                                                              ', N'Qu?n Kaki', N'Qu?n', N'Ninomaxx ', N'Trung Qu?c', N'V?i kate', NULL, NULL, N'NCC009                                                                                              ', N'M', N'tr?ng', 32, 345, 560, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0011                                                                                              ', N'Mu lu?i trai', N'Ph? ki?n', N'Prada', N'Nh?t B?n', N'V?i Cotton', NULL, NULL, NULL, N'M', N'tr?ng', 110, 321, 45, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0012                                                                                              ', N'Mu nón k?t ', N'Ph? ki?n', N'Prada', N'Trung Qu?c', N'V?i Cotton', NULL, NULL, NULL, N'XXL', N'xanh', 200, 100, 55, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0013                                                                                              ', N'Th?t lung da', N'Ph? ki?n', N'Fendi', N'Vi?t Nam', N'Da bò', NULL, NULL, NULL, N'S', N'h?ng', 342, 13, 230, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0014                                                                                              ', N'Ð?m bodycon', N'Ð?m', N'Moda', N'Hàn Qu?c', N'V?i voan', NULL, NULL, NULL, N'S', N'tím', 321, 32, 670, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0015                                                                                              ', N'Áo khoác len', N'Áo khoác', N'JUNO ', N'Trung Qu?c', N'Len', NULL, NULL, NULL, N'M', N'cam', 154, 231, 850, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0016                                                                                              ', N'Áo ng? dài', N'Ð? ng?', N'NEM', N'Hàn Qu?c', N'V?i kate', NULL, NULL, NULL, N'L', N'den', 231, 111, 650, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0017                                                                                              ', N'Maillot', N'Ð? boi', N'Coolmate ', N'Vi?t Nam', N'V?i s?i nano', NULL, NULL, NULL, N'M', N'd?', 123, 361, 420, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0018                                                                                              ', N'Monokin', N'Ð? boi', N'OWEN', N'Nh?t B?n', N'V?i s?i nano', NULL, NULL, NULL, N'S', N'nâu', 432, 5, 580, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0019                                                                                              ', N'Ð?m hai dây', N'Ð?m', N'Moda', N'Trung Qu?c', N'V?i Poplin', NULL, NULL, NULL, N'XXL', N'vàng', 117, 10, 340, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0020                                                                                              ', N'Gang tay', N'Ph? ki?n', N'NEM', N'Vi?t Nam', N'V?i Poplin', NULL, NULL, NULL, N'S', N'cam', 231, 21, 120, 1)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0001                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 1110000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0002                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 490000, NULL, NULL, N'NV0003                                                                                              ', 0)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0003                                                                                              ', CAST(N'2021-10-03T00:00:00.000' AS DateTime), 320000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0004                                                                                              ', CAST(N'2020-10-03T00:00:00.000' AS DateTime), 2302000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0005                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 450000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0006                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 690000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0007                                                                                              ', CAST(N'2020-10-03T00:00:00.000' AS DateTime), 320000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0008                                                                                              ', CAST(N'2021-10-03T00:00:00.000' AS DateTime), 250000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0009                                                                                              ', CAST(N'2021-10-03T00:00:00.000' AS DateTime), 340000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0010                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 3450000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0011                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 430000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0012                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 200000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0013                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 320000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0014                                                                                              ', CAST(N'2021-10-03T00:00:00.000' AS DateTime), 320000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0015                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 780000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0016                                                                                              ', CAST(N'2021-10-03T00:00:00.000' AS DateTime), 320000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0017                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 549000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0018                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 430000, NULL, NULL, N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0019                                                                                              ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 430000, NULL, NULL, N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD0020                                                                                              ', CAST(N'2022-10-03T00:00:00.000' AS DateTime), 590000, NULL, NULL, N'NV0002                                                                                              ', 1)
GO
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC001                                                                                              ', N'May Mc Thành Đạt', N'0923452836     ', N'thanhdat@gmail.com                                ', N'Vung Tàu')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC002                                                                                              ', N'P&T Vina', N'0923452288     ', N'quyentran@gmail.com                               ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC003                                                                                              ', N'Fahad International', N'0923527287     ', N'dhkajs@gmail.com                                  ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC004                                                                                              ', N'Vi?t Hùng', N'0963572829     ', N'viethun@gmail.com                                 ', N'An Giang')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC005                                                                                              ', N'T.M.G', N'0672891097     ', N'tmg@gmail.com                                     ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC006                                                                                              ', N'Meo Map Shop', N'0189787902     ', N'meomapshop@gmail.com                              ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC007                                                                                              ', N'Yaly', N'0797097107     ', N'yaly@gmail.com                                    ', N'Long An')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC008                                                                                              ', N'Thi?n Vân', N'0871987090     ', N'thienvan@gmail.com                                ', N'C?n Tho')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC009                                                                                              ', N'GymStore AZ', N'0889070796     ', N'gymstore@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC010                                                                                              ', N'Shop Hi?n Th?o', N'0990970978     ', N'hienthao@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC011                                                                                              ', N'Shop H?ng Vân', N'0927127089     ', N'hongvan@gmail.com                                 ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC012                                                                                              ', N'Vi?t Hùng', N'0927127432     ', N'viethun@gmail.com                                 ', N'An Giang')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC013                                                                                              ', N'P&T Vina', N'0927127324     ', N'quyentran@gmail.com                               ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC014                                                                                              ', N'Shop Hi?n Th?o', N'0927342678     ', N'hienthao@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC015                                                                                              ', N'T.M.G', N'0945737324     ', N'tmg@gmail.com                                     ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC016                                                                                              ', N'Thi?n Vân', N'0954277324     ', N'thienvan@gmail.com                                ', N'C?n Tho')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC017                                                                                              ', N'Meo Map Shop', N'0927154267     ', N'meomapshop@gmail.com                              ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC018                                                                                              ', N'Yaly', N'0342567324     ', N'yaly@gmail.com                                    ', N'Long An')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC019                                                                                              ', N'May M?c Thành Ð?t', N'0426737324     ', N'thanhdat@gmail.com                                ', N'Vung Tàu')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC020                                                                                              ', N'Yaly', N'0927127324     ', N'yaly@gmail.com                                    ', N'Long An')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0001                                                                                              ', N'Phạm Nhật Linh', CAST(N'2002-05-28' AS Date), NULL, NULL, NULL, NULL, NULL, 1, N'123                                                                                                                                                                                                     ', 1, NULL)
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0002                                                                                              ', N'Tr?n Th? Bình', CAST(N'2003-02-13' AS Date), NULL, NULL, NULL, NULL, NULL, 1, N'456                                                                                                                                                                                                     ', 0, NULL)
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0003                                                                                              ', N'Ph?m Th? Duyên', CAST(N'2002-12-16' AS Date), NULL, NULL, NULL, NULL, NULL, 1, N'789                                                                                                                                                                                                     ', 0, NULL)
GO
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0001                                                                                              ', N'Phi?u gi?m giá', NULL, 0.05, CAST(N'2023-01-11' AS Date), NULL, 1, 90)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0002                                                                                              ', N'Phi?u gi?m giá l?n d?u', NULL, 0.2, CAST(N'2023-01-01' AS Date), NULL, 1, 78)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0003                                                                                              ', N'Phi?u quà t?ng mua s?m', NULL, 0.02, CAST(N'2023-09-07' AS Date), NULL, 1, 43)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0004                                                                                              ', N'Phi?u quà t?ng tham gia chuong trình thành viên', NULL, 0.15, CAST(N'2023-01-01' AS Date), NULL, 1, 65)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0005                                                                                              ', N'Phi?u gi?m giá hàng lo?t', NULL, 0.05, CAST(N'2023-06-09' AS Date), NULL, 1, 87)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0006                                                                                              ', N'Phi?u quà t?ng sinh nh?t', NULL, 0.2, CAST(N'2023-01-01' AS Date), NULL, 1, 98)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0007                                                                                              ', N'Phi?u quà t?ng s? ki?n d?c bi?t', NULL, 0.3, CAST(N'2023-01-11' AS Date), NULL, 1, 21)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0008                                                                                              ', N'Th? quà t?ng', NULL, 0.03, CAST(N'2023-09-10' AS Date), NULL, 1, 33)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0009                                                                                              ', N'Voucher mùa sale', NULL, 0.1, CAST(N'2023-01-11' AS Date), NULL, 0, 13)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0010                                                                                              ', N'Voucher dành cho chuong trình khuy?n mãi hàng ngày', NULL, 0.05, CAST(N'2023-11-11' AS Date), NULL, 1, 65)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0011                                                                                              ', N'Phi?u quà t?ng cho sinh viên', NULL, 0.1, CAST(N'2023-11-05' AS Date), NULL, 1, 24)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0012                                                                                              ', N'Phi?u quà t?ng gi?i thi?u b?n bè', NULL, 0.2, CAST(N'2023-01-01' AS Date), NULL, 1, 96)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0013                                                                                              ', N'Phi?u quà t?ng cho khách hàng thân thi?t ', NULL, 0.3, CAST(N'2023-01-01' AS Date), NULL, 1, 43)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0014                                                                                              ', N'Phi?u quà t?ng mùa l? h?i', NULL, 0.15, CAST(N'2023-10-27' AS Date), NULL, 0, 13)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0015                                                                                              ', N'Phi?u quà t?ng mua s?m mùa m?i', NULL, 0.2, CAST(N'2023-01-11' AS Date), NULL, 1, 87)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0016                                                                                              ', N'Phi?u quà t?ng cho khách hàng VIP', NULL, 0.3, CAST(N'2023-01-11' AS Date), NULL, 1, 34)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0017                                                                                              ', N'Phi?u quà t?ng gi? vàng', NULL, 0.1, CAST(N'2023-12-11' AS Date), NULL, 1, 27)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0018                                                                                              ', N'Phi?u quà t?ng mùa hè ', NULL, 0.1, CAST(N'2023-01-05' AS Date), NULL, 0, 85)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0019                                                                                              ', N'Voucher uu dãi', NULL, 0.05, CAST(N'2023-10-23' AS Date), NULL, 1, 83)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0020                                                                                              ', N'Voucher gi?i h?n s?n ph?m', NULL, 0.2, CAST(N'2023-09-14' AS Date), NULL, 1, 22)
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_chi_tiet_hoa_don_hang_hoa] FOREIGN KEY([maHangHoa])
REFERENCES [dbo].[HangHoa] ([maHangHoa])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_chi_tiet_hoa_don_hang_hoa]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_chi_tiet_hoa_don_hoa_don] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_chi_tiet_hoa_don_hoa_don]
GO
ALTER TABLE [dbo].[HangHoa]  WITH CHECK ADD  CONSTRAINT [FK_hang_hoa_nha_cung_cap] FOREIGN KEY([maNhaCungCap])
REFERENCES [dbo].[NhaCungCap] ([maNhaCungCap])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HangHoa] CHECK CONSTRAINT [FK_hang_hoa_nha_cung_cap]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoa_don_khach_hang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_hoa_don_khach_hang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoa_don_nhan_vien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_hoa_don_nhan_vien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_hoa_don_voucher_giam_gia] FOREIGN KEY([maVoucher])
REFERENCES [dbo].[VoucherGiamGia] ([maVoucher])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_hoa_don_voucher_giam_gia]
GO
ALTER TABLE [dbo].[PhienDangNhap]  WITH CHECK ADD  CONSTRAINT [FK_phien_dang_nhap_nhan_vien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PhienDangNhap] CHECK CONSTRAINT [FK_phien_dang_nhap_nhan_vien]
GO
USE [master]
GO
ALTER DATABASE [trendyshop] SET  READ_WRITE 
GO
