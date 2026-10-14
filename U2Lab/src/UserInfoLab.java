import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String creditCard = "";


        // Part 1
        // Create a Scanner for keyboard input
        Scanner scan = new Scanner(System.in);
        
        // Ask the user to enter their first and last name and pass these values to the generateUsername method and save the returned result.
        System.out.println("What is your name?");
        firstName = scan.nextLine();
        System.out.println("What is your last name?");
        lastName = scan.nextLine();

        username = generateUsername(firstName, lastName);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        System.out.println("What password do you want?");
        password = scan.nextLine();

        // The validatePassword method will check if the password meets the criteria:
        if (validatePassword(password)) {
            // Part 3
            // If the user entered a valid password in step 2, then ask the user to enter their credit card number and pass this value to the maskCreditCard method.
            System.out.println("Your password is accepted please input your credit card information");
            creditCard = maskCreditCard(scan.nextLine());
            // Part 4
            // If the user entered a valid password AND valid credit card number, display the output as shown in the demo video
            // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

                System.out.println("Congrats, Here's your info...\nUsername: " + username + "\nCredit card: " + creditCard);
        }
        else{
            System.out.println("Your password did not work please restart the program.");
        }

    }

    public static String generateUsername(String firstName, String lastName) {
        String answer = "";

        if (firstName.length() <= 3){
            answer += firstName;
        }
        else{
            answer += firstName.toLowerCase().substring(0, 3);
        }

        if (lastName.length() <= 3){
            answer += lastName;
        }
        else{
            answer += lastName.toLowerCase().substring(0, 3);
        }
        return answer;
    }

    public static boolean validatePassword(String password) {
        if (password.length() >= 8) {
            if (password.compareTo(password.toLowerCase()) < 0) {
                if (containsDigit(password)){
                    return true;
                }
                else{
                    System.out.println("Your password does not have any number in it");
                }
            }
            else{
                System.out.println("Your password does not have a capital letter");
            }
        }
        else{
            System.out.println("Password length is less than 8");
        }
        return false;
    }

    public static String maskCreditCard(String creditCardNumber) {
        if (allDigits(creditCardNumber) && creditCardNumber.length() == 16){
            return "**** **** **** " + creditCardNumber.substring(12);
        }
        else{
            return "N/A";
        }
    }


    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }


    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}