import java.util.Random;

public class TempMailGenerator {
    private static final String[] DISPOSABLE_DOMAINS = {
            "sharklasers.com", "mailslurp.com", "fexbox.org"
    };

    // Generates a random temporary email address
    public static String generateValidTempEmail() {
        Random random = new Random();
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder emailPrefix = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            emailPrefix.append(characters.charAt(random.nextInt(characters.length())));
        }

        String domain = DISPOSABLE_DOMAINS[random.nextInt(DISPOSABLE_DOMAINS.length)];
        return emailPrefix.toString() + "@" + domain;
    }

    // Main method for testing the function
    public static void main(String[] args) {
        String tempEmail = generateValidTempEmail();
        System.out.println("Generated Temporary Email: " + tempEmail);
    }
}
