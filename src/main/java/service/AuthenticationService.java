package service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private static final String FILE_PATH = "users.txt";
    private Map<String, String> userDatabase = new HashMap<>();

    public AuthenticationService() {
        loadUsersFromFile();
    }

    public boolean login(String username, String password) {
        return userDatabase.containsKey(username) &&
                userDatabase.get(username).equals(password);
    }

    public boolean register(String username, String password) {
        if (username.isBlank() || password.isBlank()) {
            return false; // No blank fields
        }
        if (userDatabase.containsKey(username)) {
            return false; // Already exists
        }
        userDatabase.put(username, password);
        saveUserToFile(username, password);
        return true;
    }

    private void loadUsersFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userDatabase.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUserToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(username + ":" + password);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
