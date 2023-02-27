package cn.itbill.web;

import cn.itbill.service.FoodService;
import cn.itbill.service.PlateService;
import cn.itbill.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/plate/*")
public class PlateServlet extends HttpServlet {
	private static final Map<Integer, ArrayList<Integer>> plateMap = new HashMap<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] split = req.getRequestURI().split("/", 3);
		PlateService plateService = new PlateService();
		String jsonString = "";

		if ("in".equals(split[2])) {
			Integer plate_id = Integer.valueOf(req.getParameter("plate_id"));
			ArrayList<Integer> foodList = plateMap.getOrDefault(plate_id, new ArrayList<>());
			foodList.add(Integer.valueOf(req.getParameter("food_id")));
			plateMap.put(plate_id, foodList);
			jsonString = Result.getSuccessMsg();
		} else if ("update".equals(split[2])) {
			plateService.updateByMap(plateMap);
			jsonString = Result.getSuccessMsg();
		} else if ("search".equals(split[2])) {
			jsonString = plateService.selectById(Integer.parseInt(req.getParameter("plate_id")));
		}
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().write(jsonString);
	}
}
