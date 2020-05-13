package master;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StartAppliation {

  public static void main(String[] args){
    System.out.println("Привет мир!");
    System.out.println(new Utils().getPropertyByName("PROP_ONE"));
    System.out.println(new Utils().getPropertyByName("PROP_TWO"));
  }
}

class Utils{
  public String getPropertyByName(String _prop_name){
    String result = "";
    Properties p = new Properties();
    ClassLoader cl = getClass().getClassLoader();


    try(InputStream is = cl.getResourceAsStream("application.properties")){
      p.load(is);
      result = p.getProperty(_prop_name);
    }catch(IOException ex){
      ex.printStackTrace();
    }
    return result;
  }
}