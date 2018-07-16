import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class GmailOAuth {

    private static final String ClientId = "????";
    private static final String Secret = "???";
    private static final String Redirect_URI = "http://127.0.0.1:59917/Gmail/oauth/";
    private static final String Google_User_Info_API = "https://www.googleapis.com/oauth2/v2/userinfo";

    public static void main(String[] args) {
        try {
//            startServer();
            String refreshToken = fetchRefreshToken("???");
            System.out.println(refreshToken);
            String accessToken = fetchAccessToken(refreshToken);
            System.out.println(accessToken);
            String email = fetchEmailAddress(accessToken);
            System.out.println(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fetchToken(Map<String, Object> params, String tokenName, String tokenURL) throws Exception {
        StringBuilder postData = new StringBuilder();
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(param.getKey());
            postData.append('=');
            postData.append(param.getValue());
        }
        byte[] postDataBytes = postData.toString().getBytes("UTF-8");
        URL url = new URL(tokenURL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setUseCaches(false);
        con.setRequestMethod("POST");
        con.getOutputStream().write(postDataBytes);
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            buffer.append(line);
        }
        JSONObject json = new JSONObject(buffer.toString());
        return json.getString(tokenName);
    }

    private static String fetchRefreshToken(String authorizationCode) throws Exception {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("code", authorizationCode);
        params.put("client_id", ClientId);
        params.put("client_secret", Secret);
        params.put("redirect_uri", Redirect_URI);
        params.put("grant_type", "authorization_code");
        return fetchToken(params, "refresh_token", "https://www.googleapis.com/oauth2/v4/token");
    }

    private static String fetchAccessToken(String refreshToken) throws Exception {
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("grant_type", "refresh_token");
        params.put("client_id", ClientId);
        params.put("client_secret", Secret);
        params.put("refresh_token", refreshToken);
        return fetchToken(params, "access_token", "https://www.googleapis.com/oauth2/v4/token");
    }

    private static String fetchEmailAddress(String accessToken) throws Exception {
        URL url = new URL(Google_User_Info_API);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setUseCaches(false);
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);
        con.setDoOutput(true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuffer buffer = new StringBuffer();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            buffer.append(line);
        }
        JSONObject json = new JSONObject(buffer.toString());
        return json.getString("email");
    }

    private static void startServer() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(0), 0);
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange httpExchange) throws IOException {
                Path path = FileSystems.getDefault().getPath("src/test/java/", "EmailTemplate.html");
                String response = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
                httpExchange.sendResponseHeaders(200, response.length());
                OutputStream os = httpExchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });
        server.start();
        System.out.println("http://127.0.0.1:" + server.getAddress().getPort());
    }
}
