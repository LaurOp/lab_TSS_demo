package Helpers;

public class RandomString {
    public String generate(int length) {
        StringBuilder random = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (Math.random() * 52);
            if (randomChar < 26) {
                random.append((char) ('a' + randomChar));
            } else {
                random.append((char) ('A' + randomChar - 26));
            }
        }

        if (length > 0) {
            random.setCharAt(0, Character.toUpperCase(random.charAt(0)));
        }

        if (length > 1) {
            random.setCharAt(1, Character.toLowerCase(random.charAt(1)));
        }

        return random.toString();
    }

    public String generateUpper(int length) {
        StringBuilder random = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (Math.random() * 26);
            random.append((char) ('A' + randomChar));
        }

        return random.toString();
    }

    public String generateLower(int length) {
        StringBuilder random = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (Math.random() * 26);
            random.append((char) ('a' + randomChar));
        }

        return random.toString();
    }
}