package cn.itbill.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


/**
 * 使用方法：
 * 1. 需要暂存菜品时，storeFoodList(菜品id列表)
 * 2. 需要更新数据库时，使用update(餐盘id)。
 * 3. 需要查询时，使用search(餐盘id)
 */
public class PlateAPI {
	public static String base = "https://api-food.itbill.cn/plate";
//	public static String base = "http://localhost:8080/plate";

	public static void main(String[] args) {
		ArrayList<Integer> foodList = new ArrayList<>();
		foodList.add(1);
		foodList.add(2);

		System.out.println(storeFoodList(foodList));

		// 1号盘子会对应队列头部的arrayList，将plate_id + foodList存入数据库。
		System.out.println(update(1));

	}





	public static String storeFoodList(ArrayList<Integer> foodList) {
		for (Integer food_id : foodList) {
			storeSingleFood(food_id);
		}
		// 成组，在后端组成单个List
		String url = base + "/groupfood";
		return sendGet(url);
	}

	public static String storeSingleFood(Integer food_id){
		String url = base + String.format("/in?food_id=%d", food_id);
		return sendGet(url);
	}

	public static String update(Integer plate_id){
		String url = base + "/update?plate_id=" + plate_id;
		return sendGet(url);
	}

	public static String search(int plate_id) {
		String url = base + String.format("/search?plate_id=%d", plate_id);
		return sendGet(url);
	}

	public static String sendGet(String url) {
		String content;
		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//GET
			con.setRequestMethod("GET");

			//添加请求头
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader
						(con.getInputStream(), StandardCharsets.UTF_8));
				StringBuilder bs = new StringBuilder();
				String l;
				while ((l = bufferedReader.readLine()) != null) {
					bs.append(l).append("\n");
				}
				content = bs.toString();
			} else {
				content = "Fail";
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return content;
	}
}
