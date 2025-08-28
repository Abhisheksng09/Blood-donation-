package com.community.blood.controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Simple server-side proxy to fetch a banner text/JSON from AEM publish instance.
 * Configure the AEM_CONTENT_URL environment variable or change the default below.
 */
@WebServlet(name="AemContentProxyServlet", value="/aem/banner")
public class AemContentProxyServlet extends HttpServlet {
    private static final String DEFAULT_AEM_URL = "https://example-aem-publish/content/bloodsite/us/en/banner.txt";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String target = System.getenv().getOrDefault("AEM_CONTENT_URL", DEFAULT_AEM_URL);
        resp.setContentType("text/plain; charset=UTF-8");
        try {
            URL url = new URL(target);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(3000);
            con.setReadTimeout(3000);
            int code = con.getResponseCode();
            if (code == 200) {
                try (Scanner sc = new Scanner(con.getInputStream(), "UTF-8")) {
                    StringBuilder sb = new StringBuilder();
                    while (sc.hasNextLine()) sb.append(sc.nextLine()).append("\n");
                    resp.getWriter().write(sb.toString());
                }
            } else {
                resp.getWriter().write("Welcome to the Community Blood Donation System");
            }
        } catch (Exception e) {
            resp.getWriter().write("Join the next blood camp! Stay healthy, save lives.");
        }
    }
}
