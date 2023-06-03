package class04;

import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {

	public static void main(String[] args) {
		final String url = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=";
		for (int i = 100; i < 106; i++) {
			Connection conn = Jsoup.connect(url + i);
			
			Document doc = null;
			
			try {
				doc = conn.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Elements elemsTitle = doc.select("a.sh_text_headline");
			Elements elemsPress = doc.select("div.sh_text_press");
			Elements elemsText = doc.select("div.sh_text_lede");
			
			String cateName1 = "div#snb > h2.h";
			String cateName2 = " > a";
			
			System.out.print(doc.select("a.h_news > span.blind").text() + " > ");
			System.out.println(doc.select(cateName1 + (i - 98) + cateName2).text());
			System.out.println("=======================================================");
			
			Iterator<Element> itrTitle = elemsTitle.iterator();
			Iterator<Element> itrPress = elemsPress.iterator();
			Iterator<Element> itrText = elemsText.iterator();
			
			while(itrTitle.hasNext() && itrPress.hasNext() && itrText.hasNext()) {
				String press = itrPress.next().text();
				String title = itrTitle.next().text();
				String text = itrText.next().text();
				System.out.println("[" + press + "] " + title);
				System.out.println(text);
			}
			System.out.println();
		}
	}
}
