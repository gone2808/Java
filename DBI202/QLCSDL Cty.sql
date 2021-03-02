create database Congty

on primary
(
name=CongTy,
filename='D:\Congty.mdf',
size=10mb, maxsize=50mb,filegrowth=2mb
)
log on
(
name=CongTy_log,
filename='D:\Congty.ldf',
size=10mb, maxsize=50mb,filegrowth=2mb
)

use Congty
create table NhanVien
(
HoNV nvarchar(10),
TenLot nvarchar(10),
TenNV nvarchar(10),
MaNV char(10) NOT NULL,
Ngaysinh date,
DiaChi nvarchar(30),
GioiTinh char(5) check (GioiTinh in ('Nam','Nu')),
Luong float,
MaNguoiQL char(10),
MaPhong char(4)
)

create table PhongBan
(
TenPhong char(6),
MaPhong char(4) NOT NULL,
TruongPhong char(10),
NgayNhamChuc date
)

create table DiaDiem
(
DiaDiem char(10),
MaPhong char(4) NOT NULL
)

create table DuAn
(
TenDuAn nvarchar(20),
MaDuAn	char(10) NOT NULL,
DiaDiemDA char(10),
Phong char(4) NOT NULL,
)

create table CongViec
(
MaDuAn char(10) NOT NULL,
STT int NOT NULL,
TenCongViec nvarchar(20),
)

create table PhanCong
(
MaNV char(10) NOT NULL,	
MaDuAn char(10) NOT NULL,
STT int NOT NULL,
ThoiGian date,
)

create table ThanNhan
(
MaNhanVien char(10) NOT NULL,
TenThanNhan nvarchar(20) NOT NULL,
GioiTinh char(5) check (GioiTinh in ('Nam','Nu')),
Ngaysinh date,
QuanHe char (10),
)

alter table ThanNhan add constraint PK_ThanNhan_MaNhanVien_TenThanNhan primary key (MaNhanVien,TenThanNhan);
alter table ThanNhan add constraint FK_ThanNhan_MaNhanVien foreign key (MaNhanVien) references NhanVien(MaNV);

alter table NhanVien add constraint PK_NhanVien_MaNV primary key (MaNV);
alter table NhanVien add constraint FK_NhanVien_MaNguoiQL foreign key (MaNguoiQL) references NhanVien(MaNV);

alter table PhongBan add constraint FK_PhongBan_MaNguoiQL primary key (MaPhong);
alter table PhongBan add constraint FK_PhongBan_TruongPhong foreign key (TruongPhong) references NhanVien(MaNV);

alter table DiaDiem add constraint PK_DiaDiem_MaPhong primary key (MaPhong);
alter table DiaDiem add constraint FK_DiaDiem_MaPhong foreign key (MaPhong) references PhongBan(MaPhong);

alter table DuAn add constraint PK_DuAn_MaDuAn primary key (MaDuAn);
alter table DuAn add constraint FK_DuAn_Phong foreign key (Phong) references PhongBan(MaPhong);

alter table CongViec add constraint PK_CongViec_MaDuAn_STT primary key (MaDuAn,STT);
alter table CongViec add constraint FK_CongViec_MaDuAn foreign key (MaDuAn) references DuAn(MaDuAn);

alter table PhanCong add constraint PK_PhanCong_MaNV_MaDuAn_STT primary key (MaNV,MaDuAn,STT);
alter table PhanCong add constraint FL_PhanCong_MaDuAn_STT foreign key (MaDuAn,STT) references CongViec(MaDuAn,STT);
alter table PhanCong add constraint FK_PhanCong_MaNV foreign key (MaNV) references NhanVien(MaNV);

select * from NhanVien
select * from PhongBan

drop database Congty