package class03;

import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test01 {

	public static void main(String[] args) {
		final String urlIt = "https://www.yna.co.kr/industry/technology-science?site=navi_industry_depth02";
		final String urlGame = "https://www.yna.co.kr/industry/game?site=navi_industry_depth02";
		
		Connection connIt = Jsoup.connect(urlIt);
		Connection connGame = Jsoup.connect(urlGame);
		
		Document doc1 = null;
		Document doc2 = null;
		
		try {
			doc1 = connIt.get();
			doc2 = connGame.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Elements elemsTitle1 = doc1.select("div.news-con > a > strong");
		Elements elemsTime1 = doc1.select("div > div.info-box01 > span.txt-time");
		
		Elements elemsTitle2 = doc2.select("div.news-con > a > strong");
		Elements elemsTime2 = doc2.select("div > div.info-box01 > span.txt-time");
		
		Iterator<Element> itr1Title = elemsTitle1.iterator();
		Iterator<Element> itr1Time = elemsTime1.iterator();
		
		Iterator<Element> itr2Title = elemsTitle2.iterator();
		Iterator<Element> itr2Time = elemsTime2.iterator();
		
		System.out.print(doc1.select("strong.ir-txt").text() + " > ");
		System.out.println(doc1.select(".section01 > div > h1 > span").text());
		System.out.println("================================================");
		while(itr1Title.hasNext() && itr1Time.hasNext()) {
			String title = itr1Title.next().text();
			String time = itr1Time.next().text();
			System.out.print(time);
			System.out.println(" " + title);
		}
		
		System.out.println();
		System.out.print(doc2.select("strong.ir-txt").text() + " > ");
		System.out.println(doc2.select(".section01 > div > h1 > span").text());
		System.out.println("================================================");
		while(itr2Title.hasNext() && itr2Time.hasNext()) {
			String title = itr2Title.next().text();
			String time = itr2Time.next().text();
			System.out.print(time);
			System.out.println(" " + title);
		}
		
	}

}
