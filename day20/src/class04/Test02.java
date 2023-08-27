package class04;

import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {

	public static void main(String[] args) {
		final String url = "https://kr.hotels.com/Hotel-Search?adults=2&children=&d1=2023-06-22&d2=2023-06-23&destination=%ED%95%9C%EA%B5%AD&endDate=2023-06-23&latLong=35.907757%2C127.766922&mapBounds=&regionId=94&rooms=1&semdtl=&sort=RECOMMENDED&startDate=2023-06-22&theme=&useRewards=false&userIntent=";
		Connection conn = Jsoup.connect(url);

		Document doc = null;

		try {
			doc = conn.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Elements elemsTitle = doc.select("div.uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme");
		System.out.println(elemsTitle);

		System.out.println("=======================================================");

		Iterator<Element> itrTitle = elemsTitle.iterator();

		while(itrTitle.hasNext()) {
			String title = itrTitle.next().text();
			System.out.println(title);
		}
		System.out.println();
	}
}
