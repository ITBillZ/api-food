package cn.itbill.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


/**
 * 使用方法：
 * 1. 需要暂存数据时，使用store(餐盘id, 菜品id)，底层使用Map存储
 * 2. 需要更新数据库时，使用update()。更新时，该餐盘id的所有记录会被删除，然后将缓存的数据插入
 * 3.
 */
public class PlateAPI {
	public static String base = "https://api-food.itbill.cn/plate";
//	public static String base = "http://localhost:8080/plate";
	public static void main(String[] args) throws IOException {
		store(1, 1);
		store(1, 2);
		System.out.println(update());

		System.out.println(select(1));
	}


	public static String store(int plate_id, int food_id) throws IOException {
		String url = base + String.format("/in?plate_id=%d&food_id=%d", plate_id, food_id);
		return sendGet(url);
	}

	public static String update() throws IOException {
		String url = base + "/update";
		return sendGet(url);
	}

	public static String select(int plate_id) throws IOException {
		String url = base + String.format("/search?plate_id=%d", plate_id);
		return sendGet(url);
	}

	public static String sendGet(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//GET
		con.setRequestMethod("GET");

		//添加请求头
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		String content = "";
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
		return content;
	}
}
