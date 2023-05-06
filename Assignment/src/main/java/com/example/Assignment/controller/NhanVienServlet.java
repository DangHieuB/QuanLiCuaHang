package com.example.Assignment.controller;

import com.example.Assignment.entity.ChucVu;
import com.example.Assignment.entity.CuaHang;
import com.example.Assignment.entity.NhanVien;
import com.example.Assignment.service.ChucVuService;
import com.example.Assignment.service.CuaHangService;
import com.example.Assignment.service.NhanVienService;
import com.example.Assignment.service.impl.ChucVuServiceImpl;
import com.example.Assignment.service.impl.CuaHangServiceImpl;
import com.example.Assignment.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/remove",
        "/nhan-vien/search",
        "/nhan-vien/view-update",
        "/nhan-vien/update",
        "/nhan-vien/add"
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienService nhanVienService = new NhanVienServiceImpl();
    private CuaHangService cuaHangService = new CuaHangServiceImpl();
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private List<NhanVien> lists = new ArrayList<>();
    private List<CuaHang> listCH = new ArrayList<>();
    private List<ChucVu> listCV = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);

        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);

        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getOneNV(UUID.fromString(id));
        request.setAttribute("Detail", nv);
        String ngaySinh = dateFormat.format(nv.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/views/NhanVien/update-nhan-vien.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSearch");
        List<NhanVien> listSearch = nhanVienService.searchNV(ma);
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);

        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);

        request.setAttribute("listNV", listSearch);
        request.getRequestDispatcher("/views/NhanVien/nhan-vien.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getOneNV(UUID.fromString(id));
        nhanVienService.remove(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        NhanVien nv = nhanVienService.getOneNV(UUID.fromString(id));
        request.setAttribute("Detail", nv);
        String ngaySinh = dateFormat.format(nv.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCH = cuaHangService.getAll();
        request.setAttribute("listCH", listCH);

        listCV = chucVuService.getAll();
        request.setAttribute("listCV", listCV);

        lists = nhanVienService.getAll();
        request.setAttribute("listNV", lists);
        request.getRequestDispatcher("/views/NhanVien/nhan-vien.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String trangThai = request.getParameter("trangThai");
        String gioiTinh = request.getParameter("gioiTinh");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        CuaHang ch = cuaHangService.getOneCH(UUID.fromString(request.getParameter("cuaHang")));
        ChucVu cv = chucVuService.getOneCV(UUID.fromString(request.getParameter("chucVu")));
        NhanVien kh = NhanVien.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .gioiTinh(Boolean.parseBoolean(gioiTinh))
                .trangThai(Boolean.parseBoolean(trangThai))
                .diaChi(diaChi)
                .matKhau(matKhau)
                .cuaHang(ch)
                .chucVu(cv)
                .build();
        nhanVienService.update(kh);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String gioiTinh = request.getParameter("gioiTinh");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sdt = request.getParameter("sdt");
        String trangThai = request.getParameter("trangThai");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        CuaHang ch = cuaHangService.getOneCH(UUID.fromString(request.getParameter("cuaHang")));
        ChucVu cv = chucVuService.getOneCV(UUID.fromString(request.getParameter("chucVu")));
        NhanVien kh = NhanVien.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .gioiTinh(Boolean.parseBoolean(gioiTinh))
                .sdt(sdt)
                .trangThai(Boolean.parseBoolean(trangThai))
                .diaChi(diaChi)
                .matKhau(matKhau)
                .cuaHang(ch)
                .chucVu(cv)
                .build();
        nhanVienService.add(kh);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
