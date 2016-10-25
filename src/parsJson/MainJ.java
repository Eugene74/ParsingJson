package parsJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MainJ {

    public static void main(String[] args)throws IOException {
        String request ="C:\\json.txt";
        String result = performRequest(request);
        System.out.println(result);
        Gson gson = new GsonBuilder().create();
        RootElement json = (RootElement) gson.fromJson(result, RootElement.class);

        System.out.println("JSON: \n\t" + gson.toJson(json));
    }
    private static String performRequest(String request) throws IOException {

        byte[] buf;

        RandomAccessFile f = new RandomAccessFile(request, "r");
        try {
            buf = new byte[(int)f.length()];
            f.read(buf, 0, buf.length);
        } finally {
            f.close();
        }



// или так...
  /*    StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(request);
          try{
            byte[] buf = new byte[1024];

            int r = 0;
            do {
                if ((r = fis.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
             }finally {
            fis.close();
          }
        return sb.toString();*/

        return new String(buf);
    }
}
