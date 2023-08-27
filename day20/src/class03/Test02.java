package class03;

import java.util.Iterator;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test02 {

	public static void main(String[] args) {
		
		final String urlIt = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=105";
		final String urlWorld = "https://news.naver.com/main/main.naver?mode=LSD&mid=shm&sid1=104";
		
		Connection connGame = Jsoup.connect(urlIt);
		Connection connWorld = Jsoup.connect(urlWorld);
		
		Document doc1 = null;
		Document doc2 = null;
		
		try {
			doc1 = connGame.get();
			doc2 = connWorld.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Elements elems1Title = doc1.select("a.sh_text_headline");
		Elements elems1Press = doc1.select("div.sh_text_press");
		Elements elems1Text = doc1.select("div.sh_text_lede");
		
		Iterator<Element> itr1Title = elems1Title.iterator();
		Iterator<Element> itr1Press = elems1Press.iterator();
		Iterator<Element> itr1Text = elems1Text.iterator();
		
		System.out.print(doc1.select("a.h_news > span.blind").text() + " > ");
		System.out.println(doc1.select("div#snb > h2.h7 > a").text());
		System.out.println("================================================");
		while(itr1Title.hasNext() && itr1Press.hasNext() && itr1Text.hasNext()) {
			String press = itr1Press.next().text();
			String title = itr1Title.next().text();
			String text = itr1Text.next().text();
			System.out.println("[" + press + "] " + title);
			System.out.println(text);
		}
		
		System.out.println();
		
		Elements elems2Title = doc2.select("a.sh_text_headline");
		Elements elems2Press = doc2.select("div.sh_text_press");
		Elements elems2Text = doc2.select("div.sh_text_lede");
		
		Iterator<Element> itr2Title = elems2Title.iterator();
		Iterator<Element> itr2Press = elems2Press.iterator();
		Iterator<Element> itr2Text = elems2Text.iterator();
		
		System.out.print(doc2.select("a.h_news > span.blind").text() + " > ");
		System.out.println(doc2.select("div#snb > h2.h6 > a").text());
		System.out.println("================================================");
		while(itr2Title.hasNext() && itr2Press.hasNext() && itr2Text.hasNext()) {
			String press = itr2Press.next().text();
			String title = itr2Title.next().text();
			String text = itr2Text.next().text();
			System.out.println("[" + press + "] " + title);
			System.out.println(text);
		}
	}

}
