# Community Blood Donation System (JSP/Servlet + J2EE + AEM proxy)

A minimal end-to-end project that demonstrates HTML/CSS/JS frontend, JSP views, Servlets, JDBC DAO layer, session handling, and a simple AEM integration via a proxy servlet.

## Tech Stack
- HTML, CSS, JavaScript (vanilla)
- JSP & Servlets (Jakarta EE 10 APIs via Maven)
- J2EE concepts: MVC, Sessions, JDBC DAO, WAR packaging
- AEM Developer: Consume content authored in AEM Publish via `/aem/banner` proxy

## Run Locally (Tomcat)
1. Ensure MySQL is running; update DB credentials in `DBUtil.java` if needed.
2. Execute SQL: `schema.sql` to create DB and seed admin.
3. Build:
   ```bash
   mvn clean package
   ```
4. Deploy the generated `target/blood-donation-system.war` to Apache Tomcat `webapps/`.
5. Visit: `http://localhost:8080/blood-donation-system/`

## AEM Banner Integration
- Set an environment variable `AEM_CONTENT_URL` on your server/Tomcat to point to your AEM publish content (e.g., a content fragment or text asset).
- Example:
  ```bash
  export AEM_CONTENT_URL="https://your-aem-publish/content/bloodsite/us/en/banner.txt"
  ```
- The home page fetches announcements from `/aem/banner` (server-side proxy), displayed in the pink banner at the top.

## Features
- Register/Login (session-based auth)
- Become Donor (blood group, city, phone)
- Post Blood Request (patient, group, city, hospital, contact)
- View Open Requests
- Automatic matching of donors by group and city upon posting a request

## Notes
- Passwords are stored in plain text for demo simplicity; **hash them** in production (e.g., BCrypt).
- Validate inputs and add CSRF protection for production use.
- You can add role-based admin functions easily (approve/close requests, manage donors).

## Useful Paths
- `/register` (POST): handle registration
- `/login` (POST): authenticate
- `/logout` (GET): logout
- `/become-donor` (POST): save donor profile
- `/post-request` (POST): submit blood request + show matches
- `/requests` (GET): list open requests
- `/aem/banner` (GET): proxy banner text from AEM

## Folder Structure
```
blood-donation-system
├─ src
│  ├─ main
│  │  ├─ java/com/community/blood
│  │  │  ├─ controller (Servlets)
│  │  │  ├─ dao
│  │  │  ├─ model
│  │  │  └─ util
│  │  ├─ resources
│  │  └─ webapp
│  │     ├─ WEB-INF/web.xml
│  │     ├─ static/css, static/js
│  │     ├─ index.jsp, login.jsp, register.jsp, dashboard.jsp, donor_form.jsp, request_form.jsp, requests.jsp
├─ pom.xml
├─ schema.sql
└─ README.md
```
