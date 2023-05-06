package com.example.Assignment.controller;

import com.example.Assignment.entity.KhachHang;
import com.example.Assignment.service.KhachHangService;
import com.example.Assignment.service.impl.KhachHangServiceImpl;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/detail",
        "/khach-hang/remove",
        "/khach-hang/search",
        "/khach-hang/view-update",
        "/khach-hang/update",
        "/khach-hang/add"
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangService khachHangService = new KhachHangServiceImpl();
    private List<KhachHang> lists = new ArrayList<>();
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
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOneKH(UUID.fromString(id));
        request.setAttribute("khDetail", kh);
        String ngaySinh = dateFormat.format(kh.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        request.getRequestDispatcher("/views/KhachHang/update-khach-hang.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ma = request.getParameter("maSearch");
        lists = khachHangService.searchKH(ma);
        request.setAttribute("listKH", lists);
        request.getRequestDispatcher("/views/KhachHang/khach-hang.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOneKH(UUID.fromString(id));
        khachHangService.remove(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        KhachHang kh = khachHangService.getOneKH(UUID.fromString(id));
        request.setAttribute("khDetail", kh);
        String ngaySinh = dateFormat.format(kh.getNgaySinh());
        request.setAttribute("ngaySinh", ngaySinh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = khachHangService.getAll();
        request.setAttribute("listKH", lists);
        request.getRequestDispatcher("/views/KhachHang/khach-hang.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        KhachHang kh = KhachHang.builder()
                .id(UUID.fromString(id))
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.update(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");

        KhachHang kh = KhachHang.builder()
                .ma(ma)
                .ten(ten)
                .tenDem(tenDem)
                .ho(ho)
                .ngaySinh(ngaySinh)
                .sdt(sdt)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .matKhau(matKhau)
                .build();
        khachHangService.add(kh);
        response.sendRedirect("/khach-hang/hien-thi");
    }
}
