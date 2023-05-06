package com.example.Assignment.controller;

import com.example.Assignment.entity.CuaHang;
import com.example.Assignment.service.CuaHangService;
import com.example.Assignment.service.impl.CuaHangServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/detail",
        "/cua-hang/remove",
        "/cua-hang/view-update",
        "/cua-hang/update",
        "/cua-hang/add"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangService cuaHangService = new CuaHangServiceImpl();
    private List<CuaHang> lists = new ArrayList<>();

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
        CuaHang kh = cuaHangService.getOneCH(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        request.getRequestDispatcher("/views/CuaHang/update-cua-hang.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        CuaHang kh = cuaHangService.getOneCH(UUID.fromString(id));
        cuaHangService.remove(kh);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        CuaHang kh = cuaHangService.getOneCH(UUID.fromString(id));
        request.setAttribute("Detail", kh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = cuaHangService.getAll();
        request.setAttribute("listCH", lists);
        request.getRequestDispatcher("/views/CuaHang/cua-hang.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("maCH");
        String ten = request.getParameter("tenCH");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cv = CuaHang.builder()
                .idCH(UUID.fromString(id))
                .maCH(ma)
                .tenCH(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.update(cv);
        response.sendRedirect("/cua-hang/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("maCH");
        String ten = request.getParameter("tenCH");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang cv = CuaHang.builder()
                .maCH(ma)
                .tenCH(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia)
                .build();
        cuaHangService.add(cv);
        response.sendRedirect("/cua-hang/hien-thi");
    }
}
