import java.util.Map;

public class EnvMap {
    public static void main (String[] args) {
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",
                              envName,
                              env.get(envName));
        }
        System.out.println("key Path exist " + env.containsKey("Path"));
        System.out.println(env.get("Path"));
        System.out.println("value rduvalwa2 exist " + env.containsValue("rduvalwa2"));
        System.out.println(env.hashCode());
        System.out.println(env.get("COMPUTERNAME"));
        try{
        	System.out.println(env.replace("COMPUTERNAME", "C1246895-DELL", "LLED-5986421C"));
        }
        catch(Exception e){
        	System.out.println("cannot change computer name " + e);
        }
        System.out.println(env.get("USERNAME"));
        System.out.println(env.get("Python"));
        try{
        	env.replace("Python", "C:\\Users\\Randall Duval\\AppData\\Local\\Programs\\Python\\Python37-32\\","C:\\Piethon");
        }
        catch(Exception e){
        	System.out.println("cannot change PYTHON variable " + e);
        }
        System.out.println(env.get("Python"));
    }
}
