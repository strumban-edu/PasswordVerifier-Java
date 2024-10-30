import java.util.Scanner;

public class password_checker {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------------");
        System.out.println("--                                    --");
        System.out.println("--        PASSWORED  VALIDATOR        --");
        System.out.println("--    tough to crack? only I know!    --");
        System.out.println("--                                    --");
        System.out.println("----------------------------------------");
        System.out.println();
        System.out.println("Salutations! You are speaking to the greatest computer program ever written, for I can conduct feats far beyond the capabilities of man!");
        System.out.println("Yes, it is true! I, the magnificent PASSWORD VALIDATOR shall no doubt shock and awe you!");
        System.out.println();
        System.out.println("Simply provide me with any input and I shall tell you if it is a valid password!");

        Scanner scan = new Scanner(System.in);
        main_loop:
        while (true) {
            System.out.println();
            System.out.print("Enter anything to continue...");
            scan.nextLine();

            System.out.println();
            System.out.println("Enter a password and I, the great PASSWORD VALIDATOR, shall check its validity.");
            System.out.println("Once you have checked passwords to your heart's content, you may enter '-1' to quit.");
            System.out.println();
            System.out.println("Password Requirements:");
            System.out.println("1. The password's length is between 8 and 16 (inclusive)");
            System.out.println("2. The password must be a combination of at least three out of the following four categories:");
            System.out.println("    (1) lower case letters, i.e., a-z");
            System.out.println("    (2) upper case letters, i.e., A-Z");
            System.out.println("    (3) numbers, i.e., 0-9");
            System.out.println("    (4) the following special symbols: ~!@#$%^&*()-=+_");
            System.out.println();
            System.out.print("The password I wish to check is: ");
            String password = scan.nextLine();
            System.out.println();

            if (password.equals("-1")) {
                scan.close();
                break;
            }

            /*1. The password's length is between 8 and 16 (inclusive)
            2. The password must be a combination of at least three out of the following four categories:
            (1) lower case letters, i.e., a-z
            (2) upper case letters, i.e., A-Z
            (3) numbers, i.e., 0-9
            (4) the following special symbols: ~!@#$%^&*()-=+_*/
            if (password.length() >= 8 && password.length() <= 16) {
                int[] passReqs = new int[]{0, 0, 0, 0};
                int reqSum = 0;
                for (int i = 0; i < password.length(); i++) {
                    char letter = password.charAt(i);
                    if (letter >= 'a' && letter <= 'z') {
                        passReqs[0] = 1;
                    } else if (letter >= 'A' && letter <= 'Z') {
                        passReqs[1] = 1;
                    } else if (letter >= '0' && letter <= '9') {
                        passReqs[2] = 1;
                    } else if ("~!@#$%^&*()-=+_".contains(Character.toString(letter))) {
                        passReqs[3] = 1;
                    }

                    reqSum = 0;
                    for (int j : passReqs) {
                        reqSum += j;
                    }
                    if (reqSum >= 3) {
                        System.out.println("Password '" + password + "' is a valid password.");
                        continue main_loop;
                    }
                }
                System.out.println("Password '" + password + "' is invalid! Password must contain at least three of the following: lowercase, upercase, numbers, special symbols.");
                System.out.println("The given password only contains " + reqSum + " of the requirements.");
                continue main_loop;
            }

            System.out.println("Password '" + password + "' is invalid! Password must be at least 8 and at most 16 characters.");
            System.out.println("The given password was " + password.length() + " characters long.");
        }

        System.out.println("Thank you for using the password verifier!");
    }
}
