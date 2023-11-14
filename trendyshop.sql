USE [master]
GO
/****** Object:  Database [trendyshop]    Script Date: 11/14/2023 6:21:47 AM ******/
CREATE DATABASE [trendyshop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'trendyshop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.QUYENTRAN\MSSQL\DATA\trendyshop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'trendyshop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.QUYENTRAN\MSSQL\DATA\trendyshop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHangHoa] [nchar](100) NOT NULL,
	[maHoaDon] [nchar](100) NOT NULL,
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
/****** Object:  Table [dbo].[HangHoa]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HangHoa](
	[maHangHoa] [nchar](100) NOT NULL,
	[tenHangHoa] [nvarchar](150) NULL,
	[phanLoai] [nvarchar](150) NULL,
	[thuongHieu] [nvarchar](150) NULL,
	[xuatXu] [nvarchar](150) NULL,
	[chatLieu] [nvarchar](150) NULL,
	[chiTietMoTa] [nvarchar](500) NULL,
	[hinhAnh] [nchar](100) NULL,
	[maNhaCungCap] [nchar](100) NULL,
	[kichCo] [nvarchar](50) NULL,
	[mauSac] [nvarchar](50) NULL,
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](100) NOT NULL,
	[thoiGianTao] [datetime] NULL,
	[tongThanhTien] [float] NULL,
	[maVoucher] [nchar](100) NULL,
	[maKhachHang] [nchar](100) NULL,
	[maNhanVien] [nchar](100) NULL,
	[trangThaiThanhToan] [bit] NULL,
 CONSTRAINT [PK_hoa_don] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nchar](100) NOT NULL,
	[soDienThoai] [nchar](15) NOT NULL,
	[tenKhachHang] [nvarchar](150) NULL,
	[email] [nchar](100) NULL,
	[diaChi] [nvarchar](150) NULL,
	[trangThai] [bit] NULL,
	[diemTichLuy] [float] NULL,
 CONSTRAINT [PK_khach_hang_1] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNhaCungCap] [nchar](100) NOT NULL,
	[tenNhaCungCap] [nvarchar](150) NULL,
	[soDienThoai] [nchar](15) NULL,
	[email] [nchar](50) NULL,
	[diaChi] [nvarchar](150) NULL,
 CONSTRAINT [PK_nha_cung_cap] PRIMARY KEY CLUSTERED 
(
	[maNhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](100) NOT NULL,
	[hoTen] [nvarchar](150) NULL,
	[ngaySinh] [date] NULL,
	[soCCCD] [nchar](15) NULL,
	[soDienThoai] [nchar](15) NULL,
	[email] [nchar](50) NULL,
	[diaChi] [nvarchar](250) NULL,
	[chucVu] [nvarchar](50) NULL,
	[trangThai] [bit] NULL,
	[matKhau] [nchar](200) NULL,
	[phanQuyen] [bit] NULL,
	[hinhAnh] [nchar](100) NULL,
 CONSTRAINT [PK_nhan_vien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhienDangNhap]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhienDangNhap](
	[maPhienDangNhap] [nchar](100) NOT NULL,
	[thoiGianDangNhap] [datetime] NULL,
	[thoiGianDangXuat] [datetime] NULL,
	[maNhanVien] [nchar](100) NULL,
 CONSTRAINT [PK_phien_dang_nhap] PRIMARY KEY CLUSTERED 
(
	[maPhienDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VoucherGiamGia]    Script Date: 11/14/2023 6:21:47 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VoucherGiamGia](
	[maVoucher] [nchar](100) NOT NULL,
	[tenVoucher] [nvarchar](150) NULL,
	[moTaChuongTrinh] [nvarchar](250) NULL,
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
INSERT [dbo].[ChiTietHoaDon] ([maHangHoa], [maHoaDon], [soLuong], [giaBan], [thanhTien]) VALUES (N'HH0001S                                                                                             ', N'HD202310030001                                                                                      ', 1, 460000, 0)
INSERT [dbo].[ChiTietHoaDon] ([maHangHoa], [maHoaDon], [soLuong], [giaBan], [thanhTien]) VALUES (N'HH0002S                                                                                             ', N'HD202310030001                                                                                      ', 1, 449000, 0)
INSERT [dbo].[ChiTietHoaDon] ([maHangHoa], [maHoaDon], [soLuong], [giaBan], [thanhTien]) VALUES (N'HH0007S                                                                                             ', N'HD202309120001                                                                                      ', 1, 909000, 0)
INSERT [dbo].[ChiTietHoaDon] ([maHangHoa], [maHoaDon], [soLuong], [giaBan], [thanhTien]) VALUES (N'HH0011M                                                                                             ', N'HD202310030001                                                                                      ', 1, 52000, 0)
INSERT [dbo].[ChiTietHoaDon] ([maHangHoa], [maHoaDon], [soLuong], [giaBan], [thanhTien]) VALUES (N'HH0013S                                                                                             ', N'HD202310030001                                                                                      ', 1, 265000, 0)
GO
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0001L                                                                                             ', N'Hoodie', N'Áo', N'JUNO ', N'Việt Nam', N'Vải kate', N'Áo hoodie thường được làm từ chất liệu cotton, polyester hoặc sự kết hợp của cả hai để tạo ra sự thoải mái và độ bền cao', N'img\\hoodie.jpg                                                                                     ', N'NCC001                                                                                              ', N'L', N'xanh', 112, 221, 400000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0001M                                                                                             ', N'Hoodie', N'Áo', N'JUNO ', N'Việt Nam', N'Vải kate', N'Áo hoodie thường được làm từ chất liệu cotton, polyester hoặc sự kết hợp của cả hai để tạo ra sự thoải mái và độ bền cao', N'img\\hoodie.jpg                                                                                     ', N'NCC001                                                                                              ', N'M', N'xanh', 112, 221, 400000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0001S                                                                                             ', N'Hoodie', N'Áo', N'JUNO ', N'Việt Nam', N'Vải kate', N'Áo hoodie thường được làm từ chất liệu cotton, polyester hoặc sự kết hợp của cả hai để tạo ra sự thoải mái và độ bền cao', N'img\\hoodie.jpg                                                                                     ', N'NCC001                                                                                              ', N'S', N'xanh', 112, 221, 400000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0001XXL                                                                                           ', N'Hoodie', N'Áo', N'JUNO ', N'Việt Nam', N'Vải kate', N'Áo hoodie thường được làm từ chất liệu cotton, polyester hoặc sự kết hợp của cả hai để tạo ra sự thoải mái và độ bền cao', N'img\\hoodie.jpg                                                                                     ', N'NCC001                                                                                              ', N'XXL', N'xanh', 112, 221, 400000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0002L                                                                                             ', N'Sweater', N'Áo', N'OWEN', N'Việt Nam', N'Vải kaki', N'Áo sweater thường được làm từ các chất liệu như len, cotton, polyester, hoặc sự kết hợp của chúng để đảm bảo sự thoải mái và giữ ấm', N'img\\sweater.jpg                                                                                    ', N'NCC002                                                                                              ', N'L', N'đỏ', 113, 321, 390000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0002M                                                                                             ', N'Sweater', N'Áo', N'OWEN', N'Việt Nam', N'Vải kaki', N'Áo sweater thường được làm từ các chất liệu như len, cotton, polyester, hoặc sự kết hợp của chúng để đảm bảo sự thoải mái và giữ ấm', N'img\\sweater.jpg                                                                                    ', N'NCC002                                                                                              ', N'M', N'đỏ', 113, 321, 390000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0002S                                                                                             ', N'Sweater', N'Áo', N'OWEN', N'Việt Nam', N'Vải kaki', N'Áo sweater thường được làm từ các chất liệu như len, cotton, polyester, hoặc sự kết hợp của chúng để đảm bảo sự thoải mái và giữ ấm', N'img\\sweater.jpg                                                                                    ', N'NCC002                                                                                              ', N'S', N'đỏ', 113, 321, 390000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0002XXL                                                                                           ', N'Sweater', N'Áo', N'OWEN', N'Việt Nam', N'Vải kaki', N'Áo sweater thường được làm từ các chất liệu như len, cotton, polyester, hoặc sự kết hợp của chúng để đảm bảo sự thoải mái và giữ ấm', N'img\\sweater.jpg                                                                                    ', N'NCC002                                                                                              ', N'XXL', N'đỏ', 113, 321, 390000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0003L                                                                                             ', N'Kính mát', N'Phụ kiện', N'NOVELTY', N'Trung Quốc', N'Nhựa', N'Gọng kính thường được làm từ các loại chất liệu như kim loại, nhựa, acetate, hay kết hợp giữa chúng để tạo ra sự nhẹ nhàng và thoải mái', N'img\\kinh.jpg                                                                                       ', N'NCC011                                                                                              ', N'L', N'đen', 345, 32, 95000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0004L                                                                                             ', N'Vãy chữ A', N'Váy', N'NEM', N'Nhật Bản', N'Vải Poplin', N'Váy chữ A thường được làm từ nhiều loại chất liệu khác nhau như cotton, chiffon, satin, hoặc các loại vải dày và thoải mái', N'img\\vaychuA.jpg                                                                                    ', N'NCC005                                                                                              ', N'L', N'vàng', 234, 43, 484000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0004M                                                                                             ', N'Vãy chữ A', N'Váy', N'NEM', N'Nhật Bản', N'Vải Poplin', N'Váy chữ A thường được làm từ nhiều loại chất liệu khác nhau như cotton, chiffon, satin, hoặc các loại vải dày và thoải mái', N'img\\vaychuA.jpg                                                                                    ', N'NCC005                                                                                              ', N'M', N'vàng', 234, 43, 484000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0004S                                                                                             ', N'Vãy chữ A', N'Váy', N'NEM', N'Nhật Bản', N'Vải Poplin', N'Váy chữ A thường được làm từ nhiều loại chất liệu khác nhau như cotton, chiffon, satin, hoặc các loại vải dày và thoải mái', N'img\\vaychuA.jpg                                                                                    ', N'NCC005                                                                                              ', N'S', N'vàng', 234, 43, 484000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0004XXL                                                                                           ', N'Vãy chữ A', N'Váy', N'NEM', N'Nhật Bản', N'Vải Poplin', N'Váy chữ A thường được làm từ nhiều loại chất liệu khác nhau như cotton, chiffon, satin, hoặc các loại vải dày và thoải mái', N'img\\vaychuA.jpg                                                                                    ', N'NCC005                                                                                              ', N'XXL', N'vàng', 234, 43, 484000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0005L                                                                                             ', N'Váy peplum', N'Váy', N'Moda', N'Hàn Quốc', N'Vải voan', N'Được làm từ nhiều chất liệu khác nhau như cotton, satin, chiffon, hoặc các loại vải co giãn để tạo ra sự thoải mái và vẻ đẹp linh hoạt', N'img\\Vaypeplum.jpg                                                                                  ', N'NCC005                                                                                              ', N'L', N'lục', 232, 54, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0005M                                                                                             ', N'Váy peplum', N'Váy', N'Moda', N'Hàn Quốc', N'Vải voan', N'Được làm từ nhiều chất liệu khác nhau như cotton, satin, chiffon, hoặc các loại vải co giãn để tạo ra sự thoải mái và vẻ đẹp linh hoạt', N'img\\Vaypeplum.jpg                                                                                  ', N'NCC005                                                                                              ', N'M', N'lục', 232, 54, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0005S                                                                                             ', N'Váy peplum', N'Váy', N'Moda', N'Hàn Quốc', N'Vải voan', N'Được làm từ nhiều chất liệu khác nhau như cotton, satin, chiffon, hoặc các loại vải co giãn để tạo ra sự thoải mái và vẻ đẹp linh hoạt', N'img\\Vaypeplum.jpg                                                                                  ', N'NCC005                                                                                              ', N'S', N'lục', 0, 54, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0005XXL                                                                                           ', N'Váy peplum', N'Váy', N'Moda', N'Hàn Quốc', N'Vải voan', N'Được làm từ nhiều chất liệu khác nhau như cotton, satin, chiffon, hoặc các loại vải co giãn để tạo ra sự thoải mái và vẻ đẹp linh hoạt', N'img\\Vaypeplum.jpg                                                                                  ', N'NCC005                                                                                              ', N'XXL', N'lục', 232, 54, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0006L                                                                                             ', N'Áo vest', N'Áo', N'PT2000', N'Hàn Quốc', N'Vải thô', N'Thường được làm từ vải dày và sang trọng như len, cashmere, hoặc vải lụa tùy thuộc vào mục đích sử dụng', N'img\\aovest.jpg                                                                                     ', N'NCC006                                                                                              ', N'L', N'xanh', 432, 11, 345000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0006M                                                                                             ', N'Áo vest', N'Áo', N'PT2000', N'Hàn Quốc', N'Vải thô', N'Thường được làm từ vải dày và sang trọng như len, cashmere, hoặc vải lụa tùy thuộc vào mục đích sử dụng', N'img\\aovest.jpg                                                                                     ', N'NCC006                                                                                              ', N'M', N'xanh', 432, 11, 345000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0006S                                                                                             ', N'Áo vest', N'Áo', N'PT2000', N'Hàn Quốc', N'Vải thô', N'Thường được làm từ vải dày và sang trọng như len, cashmere, hoặc vải lụa tùy thuộc vào mục đích sử dụng', N'img\\aovest.jpg                                                                                     ', N'NCC006                                                                                              ', N'S', N'xanh', 432, 11, 345000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0006XXL                                                                                           ', N'Áo vest', N'Áo', N'PT2000', N'Hàn Quốc', N'Vải thô', N'Thường được làm từ vải dày và sang trọng như len, cashmere, hoặc vải lụa tùy thuộc vào mục đích sử dụng', N'img\\aovest.jpg                                                                                     ', N'NCC006                                                                                              ', N'XXL', N'xanh', 432, 11, 345000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0007L                                                                                             ', N'Quần Baggy', N'Quần', N'Genviet', N'Việt Nam', N'Vải Cotton', N'Thường được làm từ vải nhẹ, thoải mái như cotton, linen, denim, hoặc các loại vải co giãn để tạo ra sự thoải mái khi mặc', N'img\\quanBaggy.jpg                                                                                  ', N'NCC004                                                                                              ', N'L', N'chàm', 0, 233, 790000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0007M                                                                                             ', N'Quần Baggy', N'Quần', N'Genviet', N'Việt Nam', N'Vải Cotton', N'Thường được làm từ vải nhẹ, thoải mái như cotton, linen, denim, hoặc các loại vải co giãn để tạo ra sự thoải mái khi mặc', N'img\\quanBaggy.jpg                                                                                  ', N'NCC004                                                                                              ', N'M', N'chàm', 125, 233, 790000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0007S                                                                                             ', N'Quần Baggy', N'Quần', N'Genviet ', N'Việt Nam', N'Vải Cotton', N'Thường được làm từ vải nhẹ, thoải mái như cotton, linen, denim, hoặc các loại vải co giãn để tạo ra sự thoải mái khi mặc', N'img\\quanBaggy.jpg                                                                                  ', N'NCC004                                                                                              ', N'S', N'chàm', 125, 233, 790000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0007XXL                                                                                           ', N'Quần Baggy', N'Quần', N'Genviet ', N'Việt Nam', N'Vải Cotton', N'Thường được làm từ vải nhẹ, thoải mái như cotton, linen, denim, hoặc các loại vải co giãn để tạo ra sự thoải mái khi mặc', N'img\\quanBaggy.jpg                                                                                  ', N'NCC004                                                                                              ', N'XXL', N'chàm', 125, 233, 790000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0009L                                                                                             ', N'Quần Baggy', N'Quần', N'Coolmate ', N'Việt Nam', N'Vải Polyester', N'Thường được làm từ vải co giãn và thoáng khí như cotton, polyester, hoặc các loại vải kỹ thuật để tạo cảm giác thoải mái và linh hoạt khi vận động', N'img\\quanBaggy.jpg                                                                                  ', N'NCC003                                                                                              ', N'L', N'tím', 111, 254, 653000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0010M                                                                                             ', N'Quần Kaki', N'Quần', N'Ninomaxx', N'Trung Quốc', N'Vải kate', N'Thường được làm từ vải kaki, một loại vải bền và dễ chăm sóc, thường là cotton hoặc sự kết hợp với các loại sợi khác như spandex để tạo độ co giãn', N'img\\QuanKaki.jpg                                                                                   ', N'NCC003                                                                                              ', N'M', N'trắng', 32, 345, 560000, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0011M                                                                                             ', N'Mũ lưỡi trai', N'Phụ kiện', N'Prada', N'Nhật Bản', N'Vải Cotton', N'Thường được làm từ nhiều loại vật liệu khác nhau như len, vải, denim, bông, hay da tùy thuộc vào mục đích sử dụng và mùa vụ.', N'img\\muluoitrai.jpg                                                                                 ', N'NCC001                                                                                              ', N'M', N'trắng', 110, 321, 45000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0012XXL                                                                                           ', N'Mũ lưỡi trai', N'Phụ kiện', N'Prada', N'Trung Quốc', N'Vải Cotton', N'Chất liệu chủ yếu là các loại sợi tự nhiên như cotton hoặc raffia, tạo cảm giác nhẹ nhàng và thoáng khí', N'img\\muluoitrai.jpg                                                                                 ', N'NCC002                                                                                              ', N'XXL', N'xanh', 200, 100, 55000, 0)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0013S                                                                                             ', N'Thắt lưng da', N'Phụ kiện', N'Fendi', N'Việt Nảm', N'Da bò', N'Thường được làm từ da thật (da bò, da nai, da cá sấu) hoặc da tổng hợp, tùy thuộc vào sở thích và ngân sách của người mua', N'img\\thatlungda.jpg                                                                                 ', N'NCC004                                                                                              ', N'S', N'hồng', 342, 13, 230000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0014S                                                                                             ', N'Ðầm bodycon', N'Đầm', N'Moda', N'Hàn Quốc', N'Vải voan', N'Thường được làm từ các loại vải co giãn như spandex, lycra, nylon, hay polyester để tạo ra sự ôm sát và thoải mái khi mặc.', N'img\\dambody.jpg                                                                                    ', N'NCC006                                                                                              ', N'M', N'tím', 321, 32, 670000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0015L                                                                                             ', N'Áo Gile', N'Áo', N'Genviet ', N'Hàn Quốc', N'Len', N'Chất liệu chủ yếu là các loại sợi tự nhiên như cotton hoặc raffia, tạo cảm giác nhẹ nhàng và thoáng khí', N'img\\aogile.jpg                                                                                     ', N'NCC003                                                                                              ', N'L', N'trắng', 100, 98, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0015M                                                                                             ', N'Áo Gile', N'Áo', N'Genviet ', N'Hàn Quốc', N'Len', N'Chất liệu chủ yếu là các loại sợi tự nhiên như cotton hoặc raffia, tạo cảm giác nhẹ nhàng và thoáng khí', N'img\\aogile.jpg                                                                                     ', N'NCC003                                                                                              ', N'M', N'trắng', 100, 98, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0015S                                                                                             ', N'Áo Gile', N'Áo', N'Genviet ', N'Hàn Quốc', N'Len', N'Chất liệu chủ yếu là các loại sợi tự nhiên như cotton hoặc raffia, tạo cảm giác nhẹ nhàng và thoáng khí', N'img\\aogile.jpg                                                                                     ', N'NCC003                                                                                              ', N'S', N'trắng', 100, 98, 200000, 1)
INSERT [dbo].[HangHoa] ([maHangHoa], [tenHangHoa], [phanLoai], [thuongHieu], [xuatXu], [chatLieu], [chiTietMoTa], [hinhAnh], [maNhaCungCap], [kichCo], [mauSac], [soLuongTon], [soLuongDaBan], [donGiaNhap], [trangThai]) VALUES (N'HH0015XXL                                                                                           ', N'Áo Gile', N'Áo', N'Genviet ', N'Hàn Quốc', N'Len', N'Chất liệu chủ yếu là các loại sợi tự nhiên như cotton hoặc raffia, tạo cảm giác nhẹ nhàng và thoáng khí', N'img\\aogile.jpg                                                                                     ', N'NCC003                                                                                              ', N'XXL', N'trắng', 100, 98, 200000, 1)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD202308180001                                                                                      ', CAST(N'2023-08-18T00:00:00.000' AS DateTime), 997640, N'VC0003                                                                                              ', N'KH0003                                                                                              ', N'NV0002                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD202309120001                                                                                      ', CAST(N'2022-11-13T00:00:00.000' AS DateTime), 7872000, N'VC0002                                                                                              ', N'KH0002                                                                                              ', N'NV0003                                                                                              ', 1)
INSERT [dbo].[HoaDon] ([maHoaDon], [thoiGianTao], [tongThanhTien], [maVoucher], [maKhachHang], [maNhanVien], [trangThaiThanhToan]) VALUES (N'HD202310030001                                                                                      ', CAST(N'2023-10-03T00:00:00.000' AS DateTime), 354350, N'VC0001                                                                                              ', N'KH0001                                                                                              ', N'NV0002                                                                                              ', 1)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0000                                                                                              ', N'               ', N'', N'                                                                                                    ', N'', 0, 0)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0001                                                                                              ', N'0945959741     ', N'Đặng Thị Quyền Trân', N'tran@gmail.com                                                                                      ', N'Long An', 1, 70000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0002                                                                                              ', N'0326045365     ', N'Lê Thanh Toàn', N'toan@gmail.com                                                                                      ', N'Phú Yên', 1, 10000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0003                                                                                              ', N'0332678365     ', N'Nguyễn Thị Kim Ngọc', N'ngoc@gmail.com                                                                                      ', N'Tiền Giang', 1, 5000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0004                                                                                              ', N'0327539402     ', N'Lê Thị Kim Ngân', N'ngan@gmail.com                                                                                      ', N'Long An', 1, 40000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0005                                                                                              ', N'0326362892     ', N'Trần Thị Phương Vy', N'phuongvy@gmail.com                                                                                  ', N'Long An', 1, 1000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0006                                                                                              ', N'0322575395     ', N'Đặng Thị Quyền Cơ', N'quyenco@gmail.com                                                                                   ', N'Long An', 1, 30000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0007                                                                                              ', N'0386392025     ', N'Phạm Nhật Linh', N'linhnhat@gmail.com                                                                                  ', N'Quảng Bình', 1, 10000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0008                                                                                              ', N'0366802736     ', N'Nguyễn Hoài Phúc', N'hoaiphuc@gmail.com                                                                                  ', N'TP.HCM', 1, 20000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'Kh0009                                                                                              ', N'0836492649     ', N'Trần Văn Lo', N'tranvanlo@gmail.com                                                                                 ', N'TP.HCM', 1, 4000)
INSERT [dbo].[KhachHang] ([maKhachHang], [soDienThoai], [tenKhachHang], [email], [diaChi], [trangThai], [diemTichLuy]) VALUES (N'KH0010                                                                                              ', N'0248437238     ', N'Hoàng Thị Mén', N'hoangthimen@gmail.com                                                                               ', N'TP.HCM', 1, 15000)
GO
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC001                                                                                              ', N'May Mặc Thành Đạt', N'0923452836     ', N'thanhdat@gmail.com                                ', N'Vung Tàu')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC002                                                                                              ', N'P&T Vina', N'0923452288     ', N'quyentran@gmail.com                               ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC003                                                                                              ', N'Fahad International', N'0923527287     ', N'dhkajs@gmail.com                                  ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC004                                                                                              ', N'Việt Hùng', N'0963572829     ', N'viethun@gmail.com                                 ', N'An Giang')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC005                                                                                              ', N'T.M.G', N'0672891097     ', N'tmg@gmail.com                                     ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC006                                                                                              ', N'Meo Map Shop', N'0189787902     ', N'meomapshop@gmail.com                              ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC007                                                                                              ', N'Yaly', N'0797097107     ', N'yaly@gmail.com                                    ', N'Long An')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC008                                                                                              ', N'Thi?n Vân', N'0871987090     ', N'thienvan@gmail.com                                ', N'C?n Tho')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC009                                                                                              ', N'GymStore AZ', N'0889070796     ', N'gymstore@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC010                                                                                              ', N'Shop Hiền Thảo', N'0990970978     ', N'hienthao@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC011                                                                                              ', N'Shop Hoàng Vân', N'0927127089     ', N'hongvan@gmail.com                                 ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC012                                                                                              ', N'Việt Hùng', N'0927127432     ', N'viethun@gmail.com                                 ', N'An Giang')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC013                                                                                              ', N'P&T Vina', N'0927127324     ', N'quyentran@gmail.com                               ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC014                                                                                              ', N'Shop Hiền Thảo', N'0927342678     ', N'hienthao@gmail.com                                ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC015                                                                                              ', N'T.M.G', N'0945737324     ', N'tmg@gmail.com                                     ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC016                                                                                              ', N'Thi?n Vân', N'0954277324     ', N'thienvan@gmail.com                                ', N'C?n Tho')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC017                                                                                              ', N'Meo Map Shop', N'0927154267     ', N'meomapshop@gmail.com                              ', N'TP.HCM')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC018                                                                                              ', N'Yaly', N'0342567324     ', N'yaly@gmail.com                                    ', N'Long An')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC019                                                                                              ', N'May Mặc Thành Đạt', N'0426737324     ', N'thanhdat@gmail.com                                ', N'Vung Tàu')
INSERT [dbo].[NhaCungCap] ([maNhaCungCap], [tenNhaCungCap], [soDienThoai], [email], [diaChi]) VALUES (N'NCC020                                                                                              ', N'Yaly', N'0927127324     ', N'yaly@gmail.com                                    ', N'Long An')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0001                                                                                              ', N'Đặng Thị Quyền Trân', CAST(N'2002-01-31' AS Date), N'301772725      ', N'0945959741     ', N'quyentran@gmail.com                               ', N'Long An', N'QL', 1, N'1234                                                                                                                                                                                                    ', 1, N'images\\avt-nv1.jpg                                                                                 ')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0002                                                                                              ', N'Đặng Thị Quyền Cơ', CAST(N'2002-01-31' AS Date), N'301772724      ', N'0326045365     ', N'quyenco@gmail.com                                 ', N'Long An', N'NV', 1, N'1111                                                                                                                                                                                                    ', 0, N'images\\avt-nv1.jpg                                                                                 ')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0003                                                                                              ', N'Phạm Nhật Linh', CAST(N'2002-01-20' AS Date), N'302482883      ', N'0936482934     ', N'linhnhat@gmail.com                                ', N'Quảng Bình', N'NV', 1, N'1111                                                                                                                                                                                                    ', 0, N'images\\avt-nv1.jpg                                                                                 ')
INSERT [dbo].[NhanVien] ([maNhanVien], [hoTen], [ngaySinh], [soCCCD], [soDienThoai], [email], [diaChi], [chucVu], [trangThai], [matKhau], [phanQuyen], [hinhAnh]) VALUES (N'NV0004                                                                                              ', N'Nguyễn Hoài Phúc', CAST(N'2002-08-10' AS Date), N'303749272      ', N'0836492752     ', N'hoaiphuc@gmail.com                                ', N'TP.HCM', N'NV', 1, N'1111                                                                                                                                                                                                    ', 0, N'images\\avt-nv1.jpg                                                                                 ')
GO
INSERT [dbo].[PhienDangNhap] ([maPhienDangNhap], [thoiGianDangNhap], [thoiGianDangXuat], [maNhanVien]) VALUES (N'PN0001                                                                                              ', CAST(N'2023-11-10T10:00:00.000' AS DateTime), CAST(N'2023-11-10T16:00:00.000' AS DateTime), N'NV0001                                                                                              ')
INSERT [dbo].[PhienDangNhap] ([maPhienDangNhap], [thoiGianDangNhap], [thoiGianDangXuat], [maNhanVien]) VALUES (N'PN0002                                                                                              ', CAST(N'2023-11-07T16:00:00.000' AS DateTime), CAST(N'2023-11-07T21:00:00.000' AS DateTime), N'NV0002                                                                                              ')
INSERT [dbo].[PhienDangNhap] ([maPhienDangNhap], [thoiGianDangNhap], [thoiGianDangXuat], [maNhanVien]) VALUES (N'PN0003                                                                                              ', CAST(N'2023-11-11T10:00:00.000' AS DateTime), CAST(N'2023-11-11T16:00:00.000' AS DateTime), N'NV0003                                                                                              ')
INSERT [dbo].[PhienDangNhap] ([maPhienDangNhap], [thoiGianDangNhap], [thoiGianDangXuat], [maNhanVien]) VALUES (N'PN0004                                                                                              ', CAST(N'2023-10-29T16:00:00.000' AS DateTime), CAST(N'2023-10-29T21:00:00.000' AS DateTime), N'NV0004                                                                                              ')
GO
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0000                                                                                              ', N'', N'', 0, CAST(N'1759-01-01' AS Date), CAST(N'1999-12-31' AS Date), 0, 0)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0001                                                                                              ', N'Phiếu giảm giá', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.05, CAST(N'2023-01-10' AS Date), CAST(N'2023-10-30' AS Date), 1, 90)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0002                                                                                              ', N'Phiếu giảm giá lần đầu', N'Voucher thường đi kèm với một giảm giá cụ thể, được tính theo tỷ lệ phần trăm (%) hoặc số tiền cụ thể (VND). Đôi khi, nó có thể áp dụng cho một sản phẩm hoặc một danh mục sản phẩm cụ thể.', 0.2, CAST(N'2022-10-01' AS Date), CAST(N'2022-11-29' AS Date), 0, 10)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0003                                                                                              ', N'Phiếu giảm giá mua sắm', N'Voucher giảm giá tham gia lần đầu tiên là một cơ hội tuyệt vời để khám phá và trải nghiệm một dịch vụ, sản phẩm hoặc sự kiện mà bạn có thể chưa từng thử trước đó', 0.02, CAST(N'2021-01-01' AS Date), CAST(N'2023-12-31' AS Date), 0, 43)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0004                                                                                              ', N'Phiếu quà tặng tham gia chuong trình thành viên', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.15, CAST(N'2023-01-10' AS Date), CAST(N'2023-10-30' AS Date), 1, 65)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0005                                                                                              ', N'Phiếu giảm giá hàng loat', N'Voucher thường đi kèm với một giảm giá cụ thể, được tính theo tỷ lệ phần trăm (%) hoặc số tiền cụ thể (VND). Đôi khi, nó có thể áp dụng cho một sản phẩm hoặc một danh mục sản phẩm cụ thể.', 0.05, CAST(N'2023-06-09' AS Date), CAST(N'2023-11-30' AS Date), 1, 87)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0006                                                                                              ', N'Phiếu quà tặng sinh nhật', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.2, CAST(N'2020-01-01' AS Date), CAST(N'2020-12-31' AS Date), 0, 98)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0007                                                                                              ', N'Phiếu quà tặng sự kiện dặc biệt', N'Voucher này đi kèm với một mã giảm giá đặc biệt, thường là một chuỗi ký tự độc đáo hoặc số. Điều này là chìa khóa mở cửa cho ưu đãi đặc biệt khi bạn tham gia lần đầu tiên.', 0.3, CAST(N'2023-01-11' AS Date), CAST(N'2023-03-15' AS Date), 0, 21)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0008                                                                                              ', N'Thẻ quà tặng', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.03, CAST(N'2023-09-10' AS Date), CAST(N'2023-11-25' AS Date), 1, 33)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0009                                                                                              ', N'Voucher mùa sale', N'Voucher thường đi kèm với một giảm giá cụ thể, được tính theo tỷ lệ phần trăm (%) hoặc số tiền cụ thể (VND). Đôi khi, nó có thể áp dụng cho một sản phẩm hoặc một danh mục sản phẩm cụ thể.', 0.1, CAST(N'2023-01-11' AS Date), CAST(N'2023-09-11' AS Date), 0, 13)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0010                                                                                              ', N'Voucher dành cho chuong trình khuyến mãi hàng ngày', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.05, CAST(N'2023-11-11' AS Date), CAST(N'2023-12-31' AS Date), 1, 65)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0011                                                                                              ', N'Phiếu quà tặng cho sinh viên', N'Voucher giảm giá tham gia lần đầu tiên là một cơ hội tuyệt vời để khám phá và trải nghiệm một dịch vụ, sản phẩm hoặc sự kiện mà bạn có thể chưa từng thử trước đó', 0.1, CAST(N'2023-05-01' AS Date), CAST(N'2023-05-31' AS Date), 0, 24)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0012                                                                                              ', N'Phiệu quà tặng cho giới thiệu bạn bè', N'Voucher này đi kèm với một mã giảm giá đặc biệt, thường là một chuỗi ký tự độc đáo hoặc số. Điều này là chìa khóa mở cửa cho ưu đãi đặc biệt khi bạn tham gia lần đầu tiên.', 0.2, CAST(N'2023-10-01' AS Date), CAST(N'2023-10-31' AS Date), 1, 96)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0013                                                                                              ', N'Phiếu quà tặng cho khách hàng thân thiết ', N'Voucher thường đi kèm với một giảm giá cụ thể, được tính theo tỷ lệ phần trăm (%) hoặc số tiền cụ thể (VND). Đôi khi, nó có thể áp dụng cho một sản phẩm hoặc một danh mục sản phẩm cụ thể.', 0.3, CAST(N'2023-10-01' AS Date), CAST(N'2023-10-25' AS Date), 1, 43)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0014                                                                                              ', N'Phiếu quà tặng mùa lễ hội', N'Mã số hoặc chuỗi ký tự đặc biệt được gọi là "mã giảm giá" là yếu tố quan trọng nhất của voucher. Đây là thông tin quyết định để kích hoạt ưu đãi khi thanh toán.', 0.15, CAST(N'2023-07-30' AS Date), CAST(N'2023-08-30' AS Date), 0, 13)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0015                                                                                              ', N'Phiếu quà tăng mua sắm mùa mới', N'Voucher này đi kèm với một mã giảm giá đặc biệt, thường là một chuỗi ký tự độc đáo hoặc số. Điều này là chìa khóa mở cửa cho ưu đãi đặc biệt khi bạn tham gia lần đầu tiên.', 0.2, CAST(N'2023-01-11' AS Date), CAST(N'2023-12-31' AS Date), 1, 87)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0016                                                                                              ', N'Phiếu quà tặng cho khách hàng VIP', N'Voucher giảm giá tham gia lần đầu tiên là một cơ hội tuyệt vời để khám phá và trải nghiệm một dịch vụ, sản phẩm hoặc sự kiện mà bạn có thể chưa từng thử trước đó', 0.3, CAST(N'2023-01-11' AS Date), CAST(N'2023-12-25' AS Date), 1, 34)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0017                                                                                              ', N'Phiếu quà tặng giờ vàng', N'Voucher thường đi kèm với một giảm giá cụ thể, được tính theo tỷ lệ phần trăm (%) hoặc số tiền cụ thể (VND). Đôi khi, nó có thể áp dụng cho một sản phẩm hoặc một danh mục sản phẩm cụ thể.', 0.1, CAST(N'2023-10-10' AS Date), CAST(N'2023-12-12' AS Date), 1, 27)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0018                                                                                              ', N'Phiếu quà tặng mùa hè ', N'Voucher này đi kèm với một mã giảm giá đặc biệt, thường là một chuỗi ký tự độc đáo hoặc số. Điều này là chìa khóa mở cửa cho ưu đãi đặc biệt khi bạn tham gia lần đầu tiên.', 0.1, CAST(N'2023-01-05' AS Date), CAST(N'2023-07-31' AS Date), 0, 85)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0019                                                                                              ', N'Voucher uu dãi', N'Voucher giảm giá tham gia lần đầu tiên là một cơ hội tuyệt vời để khám phá và trải nghiệm một dịch vụ, sản phẩm hoặc sự kiện mà bạn có thể chưa từng thử trước đó', 0.05, CAST(N'2023-10-23' AS Date), CAST(N'2023-12-31' AS Date), 1, 83)
INSERT [dbo].[VoucherGiamGia] ([maVoucher], [tenVoucher], [moTaChuongTrinh], [phanTramGiamTheoHoaDon], [ngayBatDau], [ngayKetThuc], [trangThai], [soLuotDung]) VALUES (N'VC0020                                                                                              ', N'Voucher giải hn sản phẩm', N'Voucher giảm giá tham gia lần đầu tiên là một cơ hội tuyệt vời để khám phá và trải nghiệm một dịch vụ, sản phẩm hoặc sự kiện mà bạn có thể chưa từng thử trước đó', 0.2, CAST(N'2023-09-14' AS Date), CAST(N'2023-12-31' AS Date), 1, 22)
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
