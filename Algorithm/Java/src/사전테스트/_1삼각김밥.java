package 사전테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1삼각김밥 {
   public static class Point{
      int r;
      int c;
      public Point(int r, int c) {
         this.r = r;
         this.c = c;
      }
   }
   
   public static int findNum(int n) {
      int cr = 0;
      if (n == 1) return 0;
      else {
         while(true) {
            cr ++;
            int r = (int)(Math.pow(cr, 2) - cr)/2 + 1;
            int r_n = (int)(Math.pow(cr + 1, 2) - cr)/2 + 1;
            if (n >= r && n < r_n) {
               int cc = 0;
               for (int i=r; i<r_n; i++) {
                  memo[i] = new Point(cr, cc);
                  cc++;                  
               }
               return cr;
            }
         }
      }
   }
   
   static int[] dr = {-1, -1, 0, 1, 1, 0};
   static int[] dc = {-1, 0, 1, 1, 0, -1};
   static int s, e;
   static Point[] memo = new Point[10001];
   
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());
      for (int tc = 1; tc < t+1; tc++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         s = Integer.parseInt(st.nextToken());
         e = Integer.parseInt(st.nextToken());
         if (memo[s] == null) findNum(s);
         if (memo[e] == null) findNum(e);
         int tmp_r = Math.abs(memo[s].r - memo[e].r);
         int tmp_c = Math.abs(memo[s].c - memo[e].c);
         int ans;
         if (tmp_c > tmp_r) {
            int tmp = tmp_c - tmp_r;
            ans = tmp_r + tmp;
         }
         else {
            ans = tmp_r;
         }
         System.out.println("#"+tc+" "+ans);
      }
   }
}