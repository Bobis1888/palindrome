package Data;

import java.io.*;
import java.util.Properties;

public class Prop {
    private String url;
    private String name;
    private String pass;
    private String jdbc;
    private Properties properties;
    Prop(){
        File file = new File("/home/bobis1888/Git/palindrome/src/main/resources/connect.properties");
        try {
            properties = new Properties();
            properties.load(new InputStreamReader(new FileInputStream(file)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //init private fields
        init();
    }
    private void init(){
        assert properties != null;
        setName(properties.getProperty("login"));
        setPass(properties.getProperty("pass"));
        setUrl(properties.getProperty("url"));
        setJdbc(properties.getProperty("jdbc"));
    }
    public String toString(){
        return "Name : " + name + "\n" +
               "Pass : " + pass + "\n" +
                "Url : " + url + "\n";
    }
    public String getUrl() {
        return url;
    }

    private void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    private void setPass(String pass) {
        this.pass = pass;
    }

    public String getJdbc() {
        return jdbc;
    }

    private void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }
}
