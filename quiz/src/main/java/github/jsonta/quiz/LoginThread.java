package github.jsonta.quiz;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class LoginThread extends NotifyingThread {
    private volatile String email,paswd,status,token;
    private volatile boolean loggedIn;
    public LoginThread(String e, String p) {
        this.email = e;
        this.paswd = p;
    }
    
    @Override
    public void doRun() {
        HttpURLConnection conn = null;
        try {
            URL apiUrl = new URL("https://learnandtest.herokuapp.com/quiz/users/login");
            conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            StringBuilder rqstBodySB = new StringBuilder("{\"user_email\": \"");
            rqstBodySB.append(email);
            rqstBodySB.append("\", \"user_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\"}");
            byte[] rqstBody = rqstBodySB.toString().getBytes("utf-8");
            OutputStream os = conn.getOutputStream();
            os.write(rqstBody, 0, rqstBody.length);
        } catch (MalformedURLException ex) {
            status = ex.toString();
            loggedIn = false;
        } catch (IOException ex) {
            status = ex.toString();
            loggedIn = false;
        }
        
        JSONObject jsonRsp;
        if (conn != null) {
            try {
                conn.connect();
                if (conn.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine());
                    token = jsonRsp.getString("Token");
                    loggedIn = true;
                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine());
                    status = jsonRsp.getString("Error");
                    loggedIn = false;
                }
            } catch (IOException ex) {
                status = ex.toString();
                loggedIn = false;
            }
        }
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
    
    public String getLoggedInUser() {
        return email;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getToken() {
        return token;
    }
}
