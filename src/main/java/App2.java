import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.*;

public class App2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Version de Java : " + System.getProperty("java.version"));
        // Configuration Hadoop
        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", "hdfs://namenode:8020"); // Port correct pour Hadoop

        // Obtenir le système de fichiers HDFS
        FileSystem fs = FileSystem.get(conf);

        // Chemin du fichier HDFS
        Path path = new Path("/file1.txt");

        // Création du fichier et écriture de données
        FSDataInputStream fsis = fs.open(path);
        BufferedReader bw = new BufferedReader(new InputStreamReader(fsis));

        String line=null;
        while ((line=fsis.readLine())!=null){
            System.out.println(line);
        }
        bw.readLine();
        bw.close();
        fs.close();
    }

}
