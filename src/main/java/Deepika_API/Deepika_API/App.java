package Deepika_API.Deepika_API;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.text.ParseException;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 

{
	


	JSONObject data;
	
	public JSONObject Request() throws IOException, ParseException, org.json.simple.parser.ParseException {


        File file = new File("..\\Deepika_API\\datafiles\\addpet.json");
            JSONParser parser = new JSONParser();
            //Use JSONObject for simple JSON and JSONArray for array of JSON.
             data = (JSONObject) parser.parse(
                    new FileReader(file.getAbsolutePath()));//path to the JSON file.
           // System.out.println(data.toJSONString());
            int min = 1;
        	int max = 10;
        	Random random=new Random();
        	int value = random.nextInt(max + min) + min;
            data.put("id", value);

            String paramValue = "param\\with\\backslash";
            String yourURLStr = "http://host.com?param=" + java.net.URLEncoder.encode(paramValue, "UTF-8");

            URL url2 = new URL("https://petstore.swagger.io/v2/pet");
            HttpsURLConnection conn = (HttpsURLConnection) url2.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            conn.setDoOutput(true);
            OutputStream outStream = conn.getOutputStream();
            OutputStreamWriter outStreamWriter = new OutputStreamWriter(outStream, "UTF-8");
            outStreamWriter.write(data.toJSONString());
            outStreamWriter.flush();
            outStreamWriter.close();
            outStream.close();
            String response = null;

          //  System.out.println(conn.getResponseCode());
         //   System.out.println(conn.getResponseMessage());
            response=conn.getResponseMessage();

            DataInputStream input = null;
            input = new DataInputStream (conn.getInputStream());
           
        
        return data;
        }
	

	
	
}