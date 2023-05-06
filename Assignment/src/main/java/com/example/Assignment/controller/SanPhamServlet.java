package com.example.Assignment.controller;

import com.example.Assignment.entity.SanPham;
import com.example.Assignment.service.SanPhamService;
import com.example.Assignment.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/update",
        "/san-pham/add"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private List<SanPham> lists = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("remove")) {
            this.remove(request, response);
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
        SanPham ms = sanPhamService.getOneSP(UUID.fromString(id));
        request.setAttribute("Detail", ms);
        request.getRequestDispatcher("/views/SanPham/update-san-pham.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        SanPham ms = sanPhamService.getOneSP(UUID.fromString(id));
        sanPhamService.remove(ms);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPham ms = sanPhamService.getOneSP(UUID.fromString(id));
        request.setAttribute("Detail", ms);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = sanPhamService.getAll();
        request.setAttribute("listSP", lists);
        request.getRequestDispatcher("/views/SanPham/san-pham.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");

        SanPham cv = SanPham.builder()
                .idSanPham(UUID.fromString(id))
                .maSP(ma)
                .tenSP(ten)
                .build();
        sanPhamService.update(cv);
        response.sendRedirect("/san-pham/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maSP");
        String ten = request.getParameter("tenSP");

        SanPham cv = SanPham.builder()
                .maSP(ma)
                .tenSP(ten)
                .build();
        sanPhamService.add(cv);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
