import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class App {
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
        FSDataOutputStream fos = fs.create(path);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write("Bonjour\n");
        bw.write("Je suis Nouhaila Lahsaoui \n");
        bw.write ("fin file \n");
        bw.write ("update \n");
        bw.write ("update 2\n");
        bw.close();
        fs.close();
    }
}
