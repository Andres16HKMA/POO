package com.ingenieria_de_software.helpers;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.nio.file.*;
import java.time.*;
import org.json.*;

import com.ingenieria_de_software.model.IFormatCSV;

public class Utils implements IFormatCSV {
    private Utils() {
    }

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String PATH = "./data/";

    public static boolean fileExists(String fileName) {
        Path dirPath = Paths.get(fileName);
        return Files.exists(dirPath) && !Files.isDirectory(dirPath);
    }

    public static boolean pathExists(String path) {
        Path folder = Paths.get(path);
        return Files.exists(folder) && Files.isDirectory(folder);
    }

    public static void createFolderIfNotExist(String folder) throws IOException {
        // si no existe o si existe y no es una carpeta, crear la carpeta
        if (!pathExists(folder)) {
            Path dirPath = Paths.get(folder);
            Files.createDirectories(dirPath);
        }
    }

    public static String getRandomKey(int stringLength) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 90; // letter 'Z'
        Random random = new Random();
        // si genera un error cambiar en POM.XML la versión 1.7 por 11
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static String getPath(String path) {
        Path parentPath = Paths.get(path).getParent();
        return parentPath == null ? null : parentPath.toString();
    }

    public static Path initPath(String filePath) throws IOException {
        String path = getPath(filePath);
        createFolderIfNotExist(path);
        return Paths.get(filePath);
    }

    public static void writeText(List<?> list, String fileName) throws Exception {
        initPath(fileName);
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(new File(fileName)), StandardCharsets.UTF_8))) {
            for (int i = 0; i < list.size(); i++) {
                writer.append(list.get(i).toString());
                writer.newLine();
            }
        }
    }

    public static String readText(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }

    @Override
    public String toCSV() {

        throw new UnsupportedOperationException("Unimplemented method 'toCSV'");
    }

    public static void writeCSV(List<?> list, String fileName) throws IOException {
        Path path = initPath(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Object obj : list) {
                IFormatCSV aux = (IFormatCSV) obj; // <-- conversión de tipo
                writer.append(aux.toCSV());
            }
        }
    }

    public static void writeText(String content, String fileName) throws IOException {
        Path path = initPath(fileName);
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
    }

    public static void writeJSON(List<?> list, String fileName) throws IOException {
        JSONArray jsonArray = new JSONArray(list);
        writeText(jsonArray.toString(2), fileName);
    }

    public static void writeData(List<?> list, String fileName) throws IOException {
        writeCSV(list, fileName + ".csv");
        writeJSON(list, fileName + ".json");
    }

    public static String strDateTime(LocalDateTime dateTime) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formato);
    }

    public static String strDuration(Duration duracion) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Duration docTimeString = duracion;
        Duration docTimeDur = docTimeString;
        LocalTime docTimeOfDay = LocalTime.MIDNIGHT.plus(docTimeDur);
        String horaFinal = docTimeOfDay.format(formatter);
        return horaFinal;
    }

    public static String MD5(String s) throws Exception {
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.update(s.getBytes(), 0, s.length());
        return new BigInteger(1, m.digest()).toString(16);
    }

    public static JSONObject paramsToJson(String s) throws Exception {
        s = s.replace("&", "\n");
        StringReader reader = new StringReader(s);
        Properties properties = new Properties();
        properties.load(reader);
        return Property.toJSONObject(properties);
    }

    /**
     * 
     * @param fileName 
     * @param key    
     * @param search 
     * @return
     * @throws Exception
     */
    public static boolean exists(String fileName, String key, Object search)
            throws Exception {
        String data = readText(fileName + ".json");
        JSONArray jsonArrayData = new JSONArray(data);
        Constructor<?> constructor = search.getClass().getConstructor(JSONObject.class);

        for (int i = 0; i < jsonArrayData.length(); i++) {
            JSONObject jsonObj = jsonArrayData.getJSONObject(i);

            if (jsonObj.has(key)) {
                jsonObj = jsonObj.getJSONObject(key);
                Object current = constructor.newInstance(jsonObj);

                if (current.equals(search)) {
                    return true;
                }
            }
        }

        return false;
    }

}
