package com.Movie.Ghibli.Data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.management.RuntimeErrorException;


public class Loadjson {

    private static HttpURLConnection connection;
    String inline;
	
	Loadjson(String link){
	    
        
		try{
			URL url = new URL(link);
			connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.connect();
			int status = connection.getResponseCode();
			// System.out.println(status);

			if (status > 299 ){
				throw new RuntimeErrorException(null, "Http Response: " + status);
			} else {
				this.inline = "";
    			Scanner scanner = new Scanner(url.openStream());
				
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				scanner.close();
			}
			
		} catch (MalformedURLException e){
			e.printStackTrace();
		} catch( IOException e){
			e.printStackTrace();
		} finally{
			connection.disconnect();
		}
        
	}

    String getJson(){
        return inline;
    }
    
}

























// Load Into a JSON File 


// import java.io.FileWriter;

// private static HttpURLConnection connection;
// private static FileWriter file;
// private static String JSONpath = "C:\\Users\\Eric\\Desktop\\Dog\\data.json";



// Loadjson() throws ParseException{
        
//     try{
//         URL url = new URL("https://ghibliapi.herokuapp.com/films/58611129-2dbc-4a81-a72f-77ddfc1b1b49");
//         connection = (HttpURLConnection)url.openConnection();
//         connection.setRequestMethod("GET");
//         connection.setConnectTimeout(5000);
//         connection.connect();
//         int status = connection.getResponseCode();			
//         // System.out.println(status);

//         if (status > 299 ){
//             throw new RuntimeErrorException(null, "Http Response: " + status);
//         } else {

//             String inline = "";
//             Scanner scanner = new Scanner(url.openStream());

//             //Write all the JSON data into a string using a scanner
//             while (scanner.hasNext()) {
//                 inline += scanner.nextLine();
//             }

//             scanner.close();

//             try{
//                 //Using the JSON simple library parse the string into a json object
//                 JSONParser parse = new JSONParser();
//                 JSONObject data_obj = (JSONObject) parse.parse(inline);

//                 //Get the required object from the above created object
//                 // JSONObject obj = (JSONObject) data_obj.get("message");

//                 // System.out.println(data_obj);
//                 try {
//                     file = new FileWriter(JSONpath);
//                     file.write(data_obj.toJSONString());
//                 } catch (IOException e) {
//                     e.printStackTrace();
        
//                 } finally {
//                     try {
//                         file.flush();
//                         file.close();
//                     } catch (IOException e) {
//                         e.printStackTrace();
//                     }
//                 }

//                 } catch (ParseException e){
//                     e.printStackTrace();
//                 }
//         }
                
//     } catch (MalformedURLException e){
//         e.printStackTrace();
//     } catch( IOException e){
//         e.printStackTrace();
//     } finally{
//         connection.disconnect();
//     }

// }
