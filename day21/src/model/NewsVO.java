package model;

import java.util.Random;

public class NewsVO implements Comparable<NewsVO> {
   // 필드
   static Random rand = new Random();
   private int PK;
   private String title;// 기사 제목
   private String genre;// 기사 분야
   private int cnt;// 기사 조회수
   // 생성자=====================================================================

   public NewsVO(int PK, String title, String genre) {
      this.PK = PK;
      this.title = title;
      this.genre = genre;
      this.cnt = rand.nextInt(5);
   }

   // getter & setter ==========================================================

   public int getPK() {
      return PK;
   }

   public void setPK(int pK) {
      PK = pK;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public int getCnt() {
      return cnt;
   }

   public void setCnt(int cnt) {
      this.cnt = cnt;
   }

   // Override==================================================================
   @Override
   public String toString() {
      // TODO Auto-generated method stub
      return this.PK + ". [" + this.genre + "] " + this.title + "조회수 [" + this.cnt + "]\n";
   }

   @Override
   public boolean equals(Object obj) { // PK번호가 같다면 같은 상품
      NewsVO nVO = (NewsVO) obj;
      if (this.PK == nVO.PK) {
         return true;
      }
      return false;
   }

   @Override
   public int compareTo(NewsVO o) {
      return o.getCnt() - this.getCnt();
   }
}