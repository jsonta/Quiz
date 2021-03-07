package github.jsonta.quiz;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class LoginThread extends Thread {
    private volatile String email,paswd,status,token;
    private volatile boolean loggedIn;
    public LoginThread(String e, String p) {
        this.email = e;
        this.paswd = p;
    }
    
    @Override
    public void run() {
        JSONObject jsonRsp;
        try {
            URL apiUrl = new URL("https://learnandtest.herokuapp.com/quiz/users/login");
            HttpURLConnection conn = (HttpURLConnection) apiUrl.openConnection();
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
            
            conn.connect();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            jsonRsp = new JSONObject(br.readLine());
            
            if (conn.getResponseCode() == 200) {
                token = jsonRsp.getString("Token");
                loggedIn = true;
            } else {
                status = jsonRsp.getString("Error");
                loggedIn = false;
            }
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
            this.interrupt();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            this.interrupt();
        }
        
        /*
        String testEmail = "johndoe@domain.com";
        String testPaswd = "password";
        
        if (email.equals(testEmail)) {
            if (paswd.equals(testPaswd)) {
                loggedIn = true;
            } else {
                loggedIn = false;
                status = "Podane hasło jest nieprawidłowe";
            }
        } else {
            loggedIn = false;
            status = "Pod podanym adresem e-mail nie ma zarejestrowanego konta użytkownika";
        }
        */
    }
    
    public boolean getLoggedIn() {
        return loggedIn;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getToken() {
        return token;
    }
}
