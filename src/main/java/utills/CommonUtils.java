package utills;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CommonUtils {
    static String folderPath = System.getProperty("user.dir") + "/screenshot";
    public static Env env;

    public static Env getEnv() {
        return env;
    }

    public static void setEnv(Env env) {
        CommonUtils.env = env;
    }

    public static void setEnv(String env) {
        Gson gson = new Gson();
        try {
            Env en = gson.fromJson(
                    new FileReader("" + System.getProperty("user.dir") +"/src/"+ envDecider(env) + ""),
                    Env.class);
            CommonUtils.env = en;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String envDecider(String env) {
        String selectedEnv = null;
        if (env.contains("TestData")) {
            selectedEnv = "TestData.json";
        }
        return selectedEnv;
    }

    public static void cleanFolder() {
        File dir = new File(folderPath);

        if (dir.isDirectory() == false) {
            System.out.println("Not a directory. Do nothing");
            return;
        }
        File[] listFiles = dir.listFiles();
        for (File file : listFiles) {
            System.out.println("Deleting " + file.getName());
            file.delete();
        }
        // now directory is empty, so we can delete it
        System.out.println("Deleting Directory. Success = " + dir.delete());

    }
}
