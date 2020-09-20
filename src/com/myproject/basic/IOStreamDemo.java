package com.myproject.basic;

//import com.myproject.basic.oop.EntOption;
import com.myproject.basic.oop.SerialisedEntity;
import com.sun.corba.se.impl.orbutil.ObjectWriter;

import static com.myproject.basic.Main.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IOStreamDemo implements Demo {
    @Override
    public void test() {
        // Read console
//        testConsoleInput();

        // Read network
//        print(" - Load http data - ");
//        List<String> pageContent = loadUrlContent("http://date.jsontest.com/");
//        pageContent.forEach(s -> print(s));

        // Read-write file

        try {
            String tmpDirStr = "C:\\Users\\slisn\\tmp";
            Path dirPath = Paths.get(tmpDirStr);
            if(! Files.isDirectory(dirPath)) {
                Files.createDirectory(dirPath);
            }

            testFileWriteRead();

            // Serialization
            print(" - Serialization - ");
            SerialisedEntity entity = new SerialisedEntity("My-Entity");
            entity.addOption(new SerialisedEntity.EntOption<>("color", "red"));
            entity.addOption(new SerialisedEntity.EntOption<>("size", 12.25));

            File tmpFile = File.createTempFile(tmpDirStr, ".dat");
            tmpFile.deleteOnExit();

            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tmpFile))){
                oos.writeObject(entity);
            }

            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tmpFile))){
                SerialisedEntity entityRestored = (SerialisedEntity) ois.readObject();
                print("Restored entity:");
                print(entityRestored);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Gson

    }

    public void testConsoleInput(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int num = scanner.nextInt();
        print(str, ",", num);
    }

    public List<String> loadUrlContent(String urlPath){
        List<String> content = new ArrayList<>();
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("accept", "application/json");
            // InputStream conn.getInputStream() - read bytes
            // InputStreamReader - read chars
            // BufferedReader   - read lines or make stream
            try(BufferedReader respReader = new BufferedReader(new InputStreamReader(conn.getInputStream()))){
                String line;
                while((line = respReader.readLine()) != null){
                    content.add(line);
                }
            }
        } catch (IOException exc){
            print("Error log:", exc.getMessage());
        }
        return content;
    }

    public void testFileWriteRead(){
        try {
            Path filePath = Paths.get("C:\\Users\\slisn\\tmp\\char-lines.txt");
            if(Files.exists(filePath)){
                Files.delete(filePath);
            }
            File file = filePath.toFile();
            // Write to file
            try (final FileWriter fw = new FileWriter(file)) {
                for (String s : Arrays.asList("a", "b", "c", "d", "e")) {
                    fw.write(repeat(s, 10) + "\n");
                }
            }
            // Read from file
            print(" - Reading file - ");
            try (BufferedReader fr = new BufferedReader(new FileReader(file))) {
                String line;
                while((line = fr.readLine()) != null){
                    print(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
