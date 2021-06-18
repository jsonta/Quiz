package github.jsonta.quiz;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class RegisterThread extends NotifyingThread {
    private volatile String email, paswd, gender, status;
    private volatile boolean verification;
    
    public RegisterThread(String e, String p, String s, boolean v) {
        this.email = e;
        this.paswd = p;
        this.gender = s;
        this.verification = v;
    }
    
    @Override
    public void doRun() {
        HttpURLConnection conn = null;
        try {
            URL apiUrl = new URL("https://learnandtest.herokuapp.com/quiz/users/register");
            conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            
            StringBuilder rqstBodySB = new StringBuilder("{\"user_email\": \"");
            rqstBodySB.append(email);
            rqstBodySB.append("\", \"user_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\", \"confirm_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\", \"user_gender\": \"");
            rqstBodySB.append(gender);
            rqstBodySB.append("\", \"user_verification\": \"");
            rqstBodySB.append(verification);
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
                JSONObject jsonRsp;
                conn.connect();
                if (conn.getResponseCode() == 201) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    status = jsonRsp.getString("message");
                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    status = jsonRsp.getString("error");
                }
            } catch (IOException ex) {
                status = ex.toString();
            }
        }
    }
       
    public String getStatus() {
        return status;
    }
}
