package vietnam.com.football_system.dto;


public record SignUpDto( String username, String firstName, String lastName, char[] password, String phoneNumber, String email, Integer age, String skillLevel, Float rating, String position, String profileImage) {
}

