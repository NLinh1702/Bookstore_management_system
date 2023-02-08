
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author dell
 */


public class Project_QTDL {
    
    /*-----THEM THONG TIN KHACH NHAN VIEN-----*/
    public static void themnhanvien(Connection conn){
         try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;
                
                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String a, b, c, d, e, f, g, h, i, k, l, m;
                    System.out.println("------------------------------");
                    System.out.println("Them nhan vien!");
                    System.out.print("Nhap vao ma nhan vien muon them khac voi(NV001 -> NV007): ");
                    a = sc.nextLine();
                    System.out.print("Nhap vao ho lot nhan vien muon them: ");
                    b = sc.nextLine();
                    System.out.print("Nhap vao ten nhan vien muon them: ");
                    c = sc.nextLine();
                    System.out.print("Nhap vao phai nhan vien muon them(0 la Nu, 1 la Nam): ");
                    d= sc.nextLine();
                    System.out.print("Nhap vao ngay sinh nhan vien muon them:(VD:2001-02-17): ");
                    e = sc.nextLine();
                    System.out.print("Nhap vao ngay lam viec nhan vien muon them:(VD: 2022-05-13 00:00:00): ");
                    f = sc.nextLine();
                    System.out.print("Nhap vao dia chi nhan vien muon them: ");
                    g = sc.nextLine();
                    System.out.print("Nhap vao email nhan vien muon them: ");
                    h = sc.nextLine();
                    System.out.print("Nhap vao chuc vu nhan vien muon them: ");
                    i= sc.nextLine();
                    System.out.print("Nhap vao SDT nhan vien muon them: ");
                    k = sc.nextLine();
                    System.out.print("Nhap vao luong co ban nhan vien muon them: ");
                    l = sc.nextLine();
                    System.out.print("Nhap vao luong phu cap nhan vien muon them:(0 hoac 1) ");
                    m = sc.nextLine();
                    pStmt = conn.prepareStatement("insert into nhanvien values (?,?,?,?,?,?,?,?,?,?,?,?)");
                    pStmt.setString(1, a);
                    pStmt.setString(2, b);
                    pStmt.setString(3, c);
                    pStmt.setString(4, d);
                    pStmt.setString(5, e);
                    pStmt.setString(6, f);
                    pStmt.setString(7, g);
                    pStmt.setString(8, h);
                    pStmt.setString(9, i);
                    pStmt.setString(10, k);
                    pStmt.setString(11, l);
                    pStmt.setString(12, m);
                    pStmt.executeUpdate();
                    System.out.println("\nThem Nhan Vien thanh cong!\n");
                    System.out.println("------------------------------");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
}
    
                /*-----THEM KHACH HANG-----*/
    public static void themkhachhang(Connection conn){
        try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n, m,a,b,c,d,e;
                    System.out.println("------------------------------");
                    System.out.println("Them khach hang!");
                    System.out.print("Nhap vao ma khach hang muon them khac voi(KH001 -> KH006): ");
                    n = sc.nextLine();
                    System.out.print("Nhap vao ten khach hang muon them: ");
		    m = sc.nextLine();
		    System.out.print("Nhap vao ten CT muon them: ");
		    a = sc.nextLine();
	            System.out.print("Nhap vao dia chi muon them: ");
		    b = sc.nextLine();
		    System.out.print("Nhap email muon them: ");
		    c = sc.nextLine();
		    System.out.print("Nhap SDT muon them: ");
		    d = sc.nextLine();
		    System.out.print("Nhap Fax muon them: ");
		    e = sc.nextLine();
                    pStmt = conn.prepareStatement("insert into khachhang values (?,?,?,?,?,?,?)");
                    pStmt.setString(1, n);
                    pStmt.setString(2, m);
		    pStmt.setString(3, a);
                    pStmt.setString(4, b);
	            pStmt.setString(5, c);
                    pStmt.setString(6, d);
		    pStmt.setString(7, e);
                    pStmt.executeUpdate();
                    System.out.println("\nThem Khach Hang thanh cong!\n");
                    System.out.println("------------------------------");
                    System.out.print("Ban co muon tiep tuc neu co an phim 1:  ");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
    }
    
    
            /*-----XOA KHACH HANG-----*/
    public static void xoakhachhang(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs;
                rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.println("------------------------");
                    System.out.println("Xoa Khach Hang!");
                    System.out.print("Nhap vao ma khach hang muon xoa (KH001 -> KH006): ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("delete from khachhang where MaKH=?");
                    pStmt.setString(1, n);
                    pStmt.executeUpdate();
                    System.out.println("\nXoa Nhom Sach " + n + " thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }  
        
    }
    
    /*-----XOA DANH MUC SACH-----*/
    
    public static void xoadanhmucsach(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs;
                rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.println("------------------------");
                    System.out.println("Xoa Danh Muc Sach!");
                    System.out.print("Nhap vao ma sach muon xoa (S0001 -> S0009): ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("delete from danhmucsach where MaSach=?");
                    pStmt.setString(1, n);
                    pStmt.executeUpdate();
                    System.out.println("\nXoa Danh Muc Sach " + n + " thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }  
        
    }
    
                /*-----XOA NHAN VIEN-----*/
    public static void xoanhanvien(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs;
                rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.println("------------------------");
                    System.out.println("Xoa Nhan Vien!");
                    System.out.print("Nhap vao ma nhan vien muon xoa (NV001 -> NV007): ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("delete from nhanvien where MaNV=?");
                    pStmt.setString(1, n);
                    pStmt.executeUpdate();
                    System.out.println("\nXoa Nhom Sach " + n + " thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }  
        
    }
    
             /*-----THEM NHA CUNG CAP-----*/ 
   
    public static void themnhacungcap(Connection conn){
        try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n, m,a,b,c,d;
                    System.out.println("------------------------------");
                    System.out.println("Them nha cung cap!");
                    System.out.print("Nhap vao ma nha cung cap muon them khac voi(NCC01 -> NCC06): ");
                    n = sc.nextLine();
                    System.out.print("Nhap vao ten nha cung cap muon them: ");
		    m = sc.nextLine();
		    System.out.print("Nhap vao dia chi muon them: ");
		    a = sc.nextLine();
		    System.out.print("Nhap so dien thoai muon them: ");
		    b = sc.nextLine();
		    System.out.print("Nhap email them: ");
		    c = sc.nextLine();
		    System.out.print("Nhap Fax muon them: ");
		    d = sc.nextLine();
                    pStmt = conn.prepareStatement("insert into nhacungcap values (?,?,?,?,?,?)");
                    pStmt.setString(1, n);
                    pStmt.setString(2, m);
		    pStmt.setString(3, a);
                    pStmt.setString(4, b);
	            pStmt.setString(5, c);
                    pStmt.setString(6, d);
                    pStmt.executeUpdate();
                    System.out.println("\nThem Khach Hang thanh cong!\n");
                    System.out.println("------------------------------");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
            System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
    }
    
    
                /*-----XOA NHA CUNG CAP-----*/ 
    public static void xoanhacungcap(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs;
                rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.println("------------------------");
                    System.out.println("Xoa Nha Cung Cap!");
                    System.out.print("Nhap vao ma nha cung cap muon xoa (NCC01 -> NCC06): ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("delete from nhacungcap where MaNCC=?");
                    pStmt.setString(1, n);
                    pStmt.executeUpdate();
                    System.out.println("\nXoa Nha cung cap " + n + " thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }  
        
    }
    
                /*-----THEM DANH MUC SACH-----*/   
    public static void themdanhmucsach(Connection conn){
         try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n, m,a,b,c,d,e;
                    System.out.println("------------------------------");
                    System.out.println("Them danh muc sach!");
                    System.out.print("Nhap vao ma sach muon them khac voi(S0001 -> S0009): ");
                    n = sc.nextLine();
                    System.out.print("Nhap vao ten sach muon them: ");
                    m = sc.nextLine();
			System.out.print("Nhap vao ten tac gia muon them: ");
                    a = sc.nextLine();
			System.out.print("Nhap vao ma nhom them(VD: N0001): ");
                    b = sc.nextLine();
			System.out.print("Nhap vao ma nha cung cap muon them(VD:NCC01): ");
                    c = sc.nextLine();
			System.out.print("Nhap vao don gia muon them: ");
                    d = sc.nextLine();
			System.out.print("Nhap vao so luong ton kho: ");
                    e = sc.nextLine();
                    pStmt = conn.prepareStatement("insert into danhmucsach values (?,?,?,?,?,?,?)");
                    pStmt.setString(1, n);
                    pStmt.setString(2, m);
		    pStmt.setString(3, a);
                    pStmt.setString(4, b);
	            pStmt.setString(5, c);
                    pStmt.setString(6, d);
		    pStmt.setString(7, e);
                    pStmt.executeUpdate();
                    System.out.println("\nThem Danh muc sach thanh cong!\n");
                    System.out.println("------------------------------");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
}

                 
    
    public static void timthongtinkh(Connection conn){
        try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;

                System.out.println("\nTIM THONG TIN KHACH HANG!");

                int dem;
                do {
                    System.out.println("\nNhap vao ma khach hang muon tim kiem (KH001 -> KH006) ");
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.print("Nhap vao ma Khach Hang: ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("select * from khachhang where MaKH = ?");
                    pStmt.setString(1, n);
                    rs = pStmt.executeQuery();

                    while (rs.next()) {
                        System.out.println("------------------------------");
                        System.out.println("*** THONG TIN KHACH HANG *** " + n);
                        System.out.println("MaKH: " + rs.getString("MaKH"));
                        System.out.println("Ten khach hang: " + rs.getString("TenKH"));
                        System.out.println("So dien thoai: " + rs.getString("SDT"));
                        System.out.println("Ten cong ty: " + rs.getString("TenCT"));
                        System.out.println("Dia chi: " + rs.getString("DiaChi"));
                        System.out.println("Fax: " + rs.getString("Fax"));
                        System.out.println("Email: " + rs.getString("Email"));
                        System.out.println("------------------------------");
                    }
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nhan phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }

}
    
    
    
             /*------ TIM THONG TIN NHAN VIEN------*/
    public static void timthongtinnv(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs = null;

                System.out.println("Tim Thong tin Nhan Vien!");
                int dem;

                do {
                    System.out.println("\nNhap vao ma Nhan Vien muon tim kiem (NV001 -> NV007) ");
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.print("Nhap vao ma Nhan Vien: ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("select * from nhanvien where MaNV = ?");
                    pStmt.setString(1, n);
                    rs = pStmt.executeQuery();

                    while (rs.next()) {
                        System.out.println("------------------------------");
                        System.out.println("Thong tin Nhan Vien " + n);
                        System.out.println("MaNV: " + rs.getString("MaNV"));
                        System.out.println("Ten Nhan Vien: " + rs.getString("TenNV"));
                        System.out.println("So dien thoai: " + rs.getString("SoDT"));
                        System.out.println("Chuc vu: " + rs.getString("ChucVu"));
                        System.out.println("Dia chi: " + rs.getString("DiaChi"));
                        System.out.println("Luong co ban: " + rs.getString("LuongCB"));
                        System.out.println("Ngay sinh: " + rs.getString("NgaySinh"));
                        System.out.print("Phai: " + rs.getString("Phai"));
                        System.out.println("  0 la nu, 1 la nam");
                        System.out.println("------------------------------");
                    }
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    System.out.print("Dem"+dem);
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
    }
    
                 /*------- TIM THONG TIN SACH------*/
    public static void timkiemsach(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    System.out.println("Tim Thong tin sach!");
                    System.out.println("Nhap vao ma sach muon tim kiem (S0001 -> S0009) ");
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.print("Nhap vao ma sach: ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("select * from danhmucsach where MaSach = ?");
                    pStmt.setString(1, n);
                    rs = pStmt.executeQuery();                  
                    while (rs.next()) {
                        System.out.println("------------------------------");
                        System.out.println("Ma sach: " + rs.getString("MaSach"));
                        System.out.println("Ten sach: " + rs.getString("TenSach"));
                        System.out.println("Tac gia: " + rs.getString("TacGia"));
                        System.out.println("Ma nhom: " + rs.getString("MaNhom"));
                        System.out.println("Ma nha cung cap: " + rs.getString("MaNCC"));
                        System.out.println("Don gia: " + rs.getString("DonGia"));
                        System.out.println("So luong ton: " + rs.getString("SLTon"));
                        System.out.println("------------------------------");
                    }
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }
    }
            /*-------INSERT THONG TIN NHOM SACH------*/
    public static void themnhomsach(Connection conn){
         try {

                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n, m;
                    System.out.println("------------------------------");
                    System.out.println("Them nhom sach!");
                    System.out.print("Nhap vao ma nhom sach muon them khac voi(N0001 -> N0006): ");
                    n = sc.nextLine();
                    System.out.print("Nhap vao ten nhom sach muon them: ");
                    m = sc.nextLine();

                    pStmt = conn.prepareStatement("insert into nhomsach values (?,?)");
                    pStmt.setString(1, n);
                    pStmt.setString(2, m);
                    pStmt.executeUpdate();
                    System.out.println("\nThem Nhom Sach thanh cong!\n");
                    System.out.println("------------------------------");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
}
    
    
    
            /*------THONG KE SO LUONG SACH BAN RA CUA MOI LOAI SACH*-------*/
            
     public static void thongkesach(Connection conn){
         try {
                CallableStatement cStmt = null;

                int dem;
                do {
                    System.out.println("Nhap vao ma sach muon thong ke (S0001 -> S0009)");
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.print("Nhap vao ma sach: ");
                    n = sc.nextLine();

                    cStmt = conn.prepareCall("call thongkesach(?)");
                    cStmt.setString(1, n);
                    ResultSet rs = cStmt.executeQuery();
                    while (rs.next()) {
                        System.out.println("Ma sach: " + rs.getString("MaSach"));
                        System.out.println("Ten sach: " + rs.getString("TenSach"));
                        System.out.println("Tong so luong ban: " + rs.getString("TongSL"));
                        System.out.println("------------------------");
                    }
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException e) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + e.getMessage());
            }
    
     }
     
     
     
      /*-------UPDATE THONG TIN NHOM SACH------*/
    public static void capnhatnhomsach(Connection conn){
            try {
                PreparedStatement pStmt = null;
                ResultSet rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n, m;
                    System.out.println("------------------------");
                    System.out.println("Cap nhat thong tin nhom sach!");
                    System.out.print("Nhap vao ma nhom sach muon cap nhat (N0001 -> N0006): ");
                    n = sc.nextLine();
                    System.out.print("Nhap vao noi dung ten nhom cap nhat: ");
                    m = sc.nextLine();
                    pStmt = conn.prepareStatement("update nhomsach SET TenNhom =? where MaNhom =?");
                    pStmt.setString(1, m);
                    pStmt.setString(2, n);
                    pStmt.executeUpdate();
                    System.out.println("\nCap nhat thong tin Nhom Sach thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }
        }
    
    /*------DELETE THONG TIN NHOM SACH------*/
    public static void xoanhomsach(Connection conn){
        try {
                PreparedStatement pStmt = null;
                ResultSet rs;
                rs = null;

                int dem;
                do {
                    Scanner sc = new Scanner(System.in);
                    String n;
                    System.out.println("------------------------");
                    System.out.println("Xoa nhom sach!");
                    System.out.print("Nhap vao ma nhom sach muon xoa (N0001 -> N0006): ");
                    n = sc.nextLine();

                    pStmt = conn.prepareStatement("delete from nhomsach where MaNhom=?");
                    pStmt.setString(1, n);
                    pStmt.executeUpdate();
                    System.out.println("\nXoa Nhom Sach " + n + " thanh cong!\n");
                    System.out.print("- Ban co muon tim nua khong? \n+ Neu co nhan phim 1 (Quay lai nham phim khac 1):");
                    dem = sc.nextInt();
                    
                } while (dem == 1);
                System.out.println("Thuc thi cau lenh SQL thanh cong");
                System.out.println("******************************************************************");
                System.out.println("******************************************************************");
            } catch (SQLException ex) {
                System.out.println("Thuc thi cau lenh SQL khong thanh cong");
                System.out.println("Error: " + ex.getMessage());
            }  
        
    }
      /*------HAM MAIN------*/
    public static void main(String[] arge) {
        
        try {
            //.1 Tạo connection
           String connStr = "jdbc:mysql://localhost/quanlynhasach?" + "user=root";
            Connection conn = DriverManager.getConnection(connStr);
            System.out.println("Noi ket thanh cong!");
            System.out.println("*************************************");
            OUTER:
            while (true) {
                System.out.println("  - YEU CAU CUA BAN LA GI? -");
                System.out.println("------------------------------- ");          
                System.out.println("| 1. TIM THONG TIN KHACH HANG  |");
                System.out.println("| 2. THEM KHACH HANG           |");
                System.out.println("| 3. XOA KHACH HANG            |");               
                System.out.println("| 4. TIM THONG TIN NHAN VIEN   |");
                System.out.println("| 5. THEM NHAN VIEN            |");
                System.out.println("| 6. XOA NHAN VIEN             |");                
                System.out.println("| 7. TIM KIEM DANH MUC SACH    |");
                System.out.println("| 8. THEM DANH MUC SACH        |");
                System.out.println("| 9. XOA DANH MUC SACH         |");               
                System.out.println("| 10. THEM NHA CUNG CAP        |");
                System.out.println("| 11. XOA NHA CUNG CAP         |");               
                System.out.println("| 12. THONG KE SACH            |");  
                System.out.println("| 13. THEM NHOM SACH           |");
                System.out.println("| 14. XOA NHOM SACH            |");
                System.out.println("| 15. CAP NHAT NHOM SACH          |");
                System.out.println("--------------------------------");
                System.out.println("Moi ban chon chuc nang(1 den 15)|| Nhan(0) ket thuc!");
                Scanner st = new Scanner(System.in);
                int x = st.nextInt();
                switch (x) {
                    case 1:
                        Project_QTDL.timthongtinkh(conn);
                        break;
                    case 2:
                        Project_QTDL.themkhachhang(conn);
                        break;                       
                     case 3:
                        Project_QTDL.xoakhachhang(conn);
                        break;                         
                    case 4:
                        Project_QTDL.timthongtinnv(conn);
                        break;
                     case 5:
                        Project_QTDL.themnhanvien(conn);
                        break; 
                    case 6:
                        Project_QTDL.xoanhanvien(conn);
                        break;       
                    case 7:
                        Project_QTDL.timkiemsach(conn);  
                        break;
                    case 8:
                        Project_QTDL.themdanhmucsach(conn);
                        break;    
                    case 9:
                        Project_QTDL.xoadanhmucsach(conn);
                        break;    
                    case 10:
                        Project_QTDL.themnhacungcap(conn);
                        break;   
                    case 11:
                        Project_QTDL.xoanhacungcap(conn);
                        break;   
                    case 12:
                        Project_QTDL.thongkesach(conn);
                        break;                        
                    case 13:
                        Project_QTDL.themnhomsach(conn);
                        break;
                    case 14:
                        Project_QTDL.xoanhomsach(conn);
                        break;
                    case 15:
                        Project_QTDL.capnhatnhomsach(conn);
                        break;
                    case 0:
                        break OUTER;
                    default:
                        break;
                }
            }
  
        } catch (Exception e) {
            System.out.println("Noi ket khong thanh cong!!!");
            System.out.println("Error: " + e.getMessage());
        } 
    }
}
