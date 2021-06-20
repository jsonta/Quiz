package github.jsonta.quiz;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class EmailChangeThread extends NotifyingThread {
    private volatile String emailNew,paswd,token,status;
    private volatile int statusCode;
    public EmailChangeThread(String e, String p, String t) {
        this.emailNew = e;
        this.paswd = p;
        this.token = t;
    }
    
    @Override
    public void doRun() {
        HttpURLConnection conn = null;
        try {
            URL apiUrl = new URL("https://learnandtest.herokuapp.com/quiz/users/email");
            conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", token);
            conn.setDoOutput(true);
            
            StringBuilder rqstBodySB = new StringBuilder("{\"new_user_email\": \"");
            rqstBodySB.append(emailNew);
            rqstBodySB.append("\", \"user_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\"}");
            byte[] rqstBody = rqstBodySB.toString().getBytes("utf-8");
            OutputStream os = conn.getOutputStream();
            os.write(rqstBody, 0, rqstBody.length);
        } catch (MalformedURLException ex) {
            status = ex.toString();
        } catch (IOException ex) {
            status = ex.toString();
        }
        
        if (conn != null) {
            try {
                //JSONObject jsonRsp;
                conn.connect();
                statusCode = conn.getResponseCode();
                if (statusCode == 200) {
                    //BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    //jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    //token = jsonRsp.getString("token");
                    status = "Adres e-mail został pomyślnie zmieniony.";
                } /* else {
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    status = jsonRsp.getString("error");
                    
                } */
            } catch (IOException ex) {
                status = ex.toString();
            }
        }
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getToken() {
        return token;
    }
}
