package github.jsonta.quiz;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class DeleteUserThread extends NotifyingThread {
    private volatile String paswd,status,token;
    private volatile boolean userDeleted;
    public DeleteUserThread(String p, String t) {
        this.paswd = p;
        this.token = t;
    }

    @Override
    public void doRun() {
        HttpURLConnection conn = null;
        try {
            URL apiUrl = new URL("https://learnandtest.herokuapp.com/quiz/users/delete");
            conn = (HttpURLConnection) apiUrl.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Authorization", token);
            conn.setDoOutput(true);
            
            StringBuilder rqstBodySB = new StringBuilder("{\"user_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\", \"confirm_password\": \"");
            rqstBodySB.append(paswd);
            rqstBodySB.append("\"}");
            byte[] rqstBody = rqstBodySB.toString().getBytes("utf-8");
            OutputStream os = conn.getOutputStream();
            os.write(rqstBody, 0, rqstBody.length);
        } catch (MalformedURLException ex) {
            status = ex.toString();
            userDeleted = false;
        } catch (IOException ex) {
            status = ex.toString();
            userDeleted = false;
        }
        
        JSONObject jsonRsp;
        if (conn != null) {
            try {
                conn.connect();
                if (conn.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    status = jsonRsp.getString("message");
                    userDeleted = true;
                } else {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
                    jsonRsp = new JSONObject(br.readLine()).getJSONObject("messages");
                    status = jsonRsp.getString("error");
                    userDeleted = false;
                }
            } catch (IOException ex) {
                status = ex.toString();
                userDeleted = false;
            }
        }
    }
    
    public boolean isUserDeleted() {
        return userDeleted;
    }
    
    public String getStatus() {
        return status;
    }
}
