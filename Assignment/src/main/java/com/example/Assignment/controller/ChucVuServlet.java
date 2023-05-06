package com.example.Assignment.controller;

import com.example.Assignment.entity.ChucVu;
import com.example.Assignment.service.ChucVuService;
import com.example.Assignment.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/detail",
        "/chuc-vu/remove",
        "/chuc-vu/view-update",
        "/chuc-vu/update",
        "/chuc-vu/add"
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuService chucVuService = new ChucVuServiceImpl();
    private List<ChucVu> lists = new ArrayList<>();

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
        ChucVu kh = chucVuService.getOneCV(UUID.fromString(id));
        request.setAttribute("cvDetail", kh);
        request.getRequestDispatcher("/views/ChucVu/update-chuc-vu.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        ChucVu kh = chucVuService.getOneCV(UUID.fromString(id));
        chucVuService.remove(kh);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ChucVu kh = chucVuService.getOneCV(UUID.fromString(id));
        request.setAttribute("cvDetail", kh);
        this.hienThi(request, response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lists = chucVuService.getAll();
        request.setAttribute("listCV", lists);
        request.getRequestDispatcher("/views/ChucVu/chuc-vu.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");

        ChucVu cv = ChucVu.builder()
                .id(UUID.fromString(id))
                .maCV(ma)
                .tenCV(ten)
                .build();
        chucVuService.update(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        ChucVu cv = ChucVu.builder()
                .maCV(ma)
                .tenCV(ten)
                .build();
        chucVuService.add(cv);
        response.sendRedirect("/chuc-vu/hien-thi");
    }
}
