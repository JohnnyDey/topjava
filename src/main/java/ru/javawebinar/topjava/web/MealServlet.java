package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealWithExceed;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet{

    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to users");
        List<MealWithExceed> list = new ArrayList<>();
        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 12, 12, 30), "Мяско", 100, false));
        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 12, 8, 0), "Супчик", 120, false));
        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 12, 20, 0), "Булка", 200, false));

        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 13, 12, 30), "Стейк", 300, true));
        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 13, 8, 0), "Пицца", 520, true));
        list.add(new MealWithExceed(LocalDateTime.of(2017, 9, 13, 20, 0), "Бургер", 460, true));

        request.setAttribute("meals", list);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
//        response.sendRedirect("meals.jsp");
    }
}
