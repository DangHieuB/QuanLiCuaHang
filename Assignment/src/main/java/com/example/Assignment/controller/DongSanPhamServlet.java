package com.example.Assignment.controller;

import com.example.Assignment.entity.DongSanPham;
import com.example.Assignment.service.DongSanPhamService;
import com.example.Assignment.service.impl.DongSanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSanPhamServlet", value = {
        "/dong-san-pham/hien-thi",
        "/dong-san-pham/detail",
        "/dong-san-pham/remove",
        "/dong-san-pham/view-update",
        "/dong-san-pham/update",
        "/dong-san-pham/add"
})
public class DongSanPhamServlet extends HttpServlet {
    private DongSanPhamService dongSanPhamService = new DongSanPhamServiceImpl();
    private List<DongSanPham> lists = new ArrayList<>();

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
        DongSanPham kh = dongSanPhamService.getOneDSP(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        request.getRequestDispatcher("/views/DongSanPham/update-dong-san-pham.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        DongSanPham kh = dongSanPhamService.getOneDSP(UUID.fromString(id));
        dongSanPhamService.remove(kh);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        DongSanPham kh = dongSanPhamService.getOneDSP(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = dongSanPhamService.getAll();
        request.setAttribute("listDSP", lists);
        request.getRequestDispatcher("/views/DongSanPham/dong-san-pham.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("maDSP");
        String ten = request.getParameter("tenDSP");

        DongSanPham cv = DongSanPham.builder()
                .idDSP(UUID.fromString(id))
                .maDSP(ma)
                .tenDSP(ten)
                .build();
        dongSanPhamService.update(cv);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maDSP");
        String ten = request.getParameter("tenDSP");

        DongSanPham cv = DongSanPham.builder()
                .maDSP(ma)
                .tenDSP(ten)
                .build();
        dongSanPhamService.add(cv);
        response.sendRedirect("/dong-san-pham/hien-thi");
    }
}
