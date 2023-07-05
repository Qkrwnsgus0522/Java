package class04;

import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawling {
	public static ArrayList<AirVO> sample() {
		final String url = "https://luciusfox.tistory.com/112";
		Connection conn = Jsoup.connect(url);

		Document doc = null;

		try {
			doc = conn.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Elements elemsAirline = doc.select("tr > td:nth-child(1)");
		Elements elemsLocation = doc.select("tr > td:nth-child(2)");
		Elements elemsStartTime = doc.select("tr > td:nth-child(3)");
		Elements elemsReturnTime = doc.select("tr > td:nth-child(4)");
		Elements elemsPrice = doc.select("tr > td:nth-child(5)");
		
		System.out.println("=======================================================");

		Iterator<Element> itrAirline = elemsAirline.iterator();
		Iterator<Element> itrLocation = elemsLocation.iterator();
		Iterator<Element> itrStartTime = elemsStartTime.iterator();
		Iterator<Element> itrReturnTime = elemsReturnTime.iterator();
		Iterator<Element> itrPrice = elemsPrice.iterator();
		
		ArrayList<AirVO> aList = new ArrayList<AirVO>();
		
		while(itrAirline.hasNext() && itrLocation.hasNext() && itrStartTime.hasNext() && itrReturnTime.hasNext() && itrPrice.hasNext()) {
			String airline = itrAirline.next().text();
			String location = itrLocation.next().text();
			String startTime = itrStartTime.next().text();
			String returnTime = itrReturnTime.next().text();
			int price = Integer.parseInt(itrPrice.next().text());
			AirVO aVO = new AirVO(airline, location, startTime, returnTime, price);
			aList.add(aVO);
//			System.out.print(airline + " ");
//			System.out.print(location + " ");
//			System.out.print(startTime + " ");
//			System.out.print(returnTime + " ");
//			System.out.print(price);
//			System.out.println();
		}
		return aList;
	}
}