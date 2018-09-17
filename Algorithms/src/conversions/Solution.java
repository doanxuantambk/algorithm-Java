/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversions;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tamdx
 */
public class Solution {

    class Movie {

        private String page;
        private Integer per_page;
        private Integer total;
        private Integer total_pages;
        private List<MovieDetail> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getPer_page() {
            return per_page;
        }

        public void setPer_page(Integer per_page) {
            this.per_page = per_page;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotal_pages() {
            return total_pages;
        }

        public void setTotal_pages(Integer total_pages) {
            this.total_pages = total_pages;
        }

        public List<MovieDetail> getData() {
            return data;
        }

        public void setData(List<MovieDetail> data) {
            this.data = data;
        }

    }

    class MovieDetail {

        private String Title;

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

    }

    public static void main(String[] args) {
        String[] ret = null;
        try {
            String str = sendGet("spiderman", null);

            List<MovieDetail> lstData = new ArrayList<>();

            Movie movie = new Gson().fromJson(str, Movie.class);
            lstData.addAll(movie.data);

            if (movie.total_pages > 1) {
                for (int i = 2; i <= movie.total_pages; i++) {

                    str = sendGet("spiderman", i);
                    movie = new Gson().fromJson(str, Movie.class);
                    lstData.addAll(movie.data);
                }
            }

            Collections.sort(lstData, new Comparator<MovieDetail>() {

                @Override
                public int compare(MovieDetail o1, MovieDetail o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
             ret = new String[lstData.size()];
            for (int i = 0; i < lstData.size(); i++) {
                ret[i] = lstData.get(i).getTitle();
            }
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
        }

    }
    private final String USER_AGENT = "Mozilla/5.0";

    private static String sendGet(String keyword, Integer index) throws Exception {

        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + keyword + (index != null ? ("&page=" + index) : "");

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        return response.toString();

    }
}
