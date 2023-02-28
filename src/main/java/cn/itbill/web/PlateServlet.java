package cn.itbill.web;

import cn.itbill.service.PlateService;
import cn.itbill.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/plate/*")
public class PlateServlet extends HttpServlet {
	private static final ArrayList<ArrayList<Integer>> foodListList = new ArrayList<>();
	private static final ArrayList<Integer> foodList = new ArrayList<>();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] split = req.getRequestURI().split("/", 3);
		PlateService plateService = new PlateService();
		String jsonString = "";

		if ("in".equals(split[2])) {
			Integer foodId = Integer.valueOf(req.getParameter("food_id"));
			foodList.add(foodId);

			jsonString = Result.getSuccessMsg();
		} else if ("groupfood".equals(split[2])) {
			foodListList.add(new ArrayList<>(foodList));
			foodList.clear();
			jsonString = Result.getSuccessMsg();
		} else if ("update".equals(split[2])) {
			plateService.updateByPlateId(Integer.valueOf(req.getParameter("plate_id")), foodListList.remove(0));
			jsonString = Result.getSuccessMsg();
		} else if ("search".equals(split[2])) {
			jsonString = plateService.selectById(Integer.parseInt(req.getParameter("plate_id")));
		}
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().write(jsonString);
	}
}
