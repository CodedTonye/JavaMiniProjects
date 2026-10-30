package dairy;
import java.util.Scanner;


public class DiaryMainApplication {
    public static Diaries diaries = new Diaries();

    public static void main(String[] args) {
        goToMainmenu();
    }

    private static  void goToMainmenu() {
        String menu = """
                \n=========================
                WELCOME TO CODED DIARY
                1. CREATE DIARY
                2. UNLOCK DIARY
                3. DELETE
                4. EXIT
                ============================
                """;

        print(menu);
        try{
            int choice = inputInt("Enter an option >> ");
            scanner.nextLine();
            if( choice == 4) {
                print("Goodbye!");
            }
            switch(choice) {
                case 1 -> createDiary();
                case 2 -> unlockDiary();
                case 3 -> deleteDiary();
                default -> print("Enter a valid option");
            }

        }catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }

    }

    private static void deleteDiary() {

        try{
            String username = input("Enter username >> ");
            String password = input("Enter password >> ");
            diaries.delete(username, password);
            print("Diary has been deleted");

        }catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }
        goToMainmenu();
    }

    private static void unlockDiary() {
        try{
            String username = input("Enter user name >> ");
            String password = input("Enter password >> ");
            Diary user = diaries.findByUsername(username);
            user.unlockDiary(password);
            print("Diary unlocked!!!");

        }catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }
        goToDiaryMenu();
    }

    private static void createDiary() {
        try{

            String username = input("Enter username >> ");
            String password = input("Enter password >> ");
            diaries.add(username, password);
            print("You have successfully created a diary!!!!\n");
            Diary diary =diaries.findByUsername(username);
            print("Your id >> " + diary.generateId());
        }catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }

        goToMainmenu();
    }

    private static void goToDiaryMenu() {
        String menu = """
                \n==============
                1. Create Entry
                2. View Entries
                3. Update Entry
                4. Delete Entry
                5. Lock
                ================
                """;
        print(menu);
        try {
            int choice = inputInt("Enter an option >> ");
            switch(choice) {
                case 1-> createEntry();
                case 2-> viewEntry();
                case 3-> updateEntry();
                case 4-> deleteEntry();
                case 5-> goToMainmenu();
                default -> print("Enter a valid option");
            }

        }catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }

    }

    private static void deleteEntry() {
        try{

            String username = input("Enter username >> ");
            Diary user = diaries.findByUsername(username);
            int id = inputInt("Enter your id >> ");
            user.deleteEntry(id);
            print("Entry deleted successfully!!!");
            goToDiaryMenu();
        }
        catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }
    }

    private static void updateEntry() {
        try{
            String username = input("Enter username >> ");
            Diary user = diaries.findByUsername(username);
            int id = inputInt("Enter your id >> ");
            String newTitle = input("Enter new title >> ");
            String newBody = input("Enter new body >> ");
            user.updateDiary(id , newTitle, newBody);
            print("Entry updated successfully!!!");
        } catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }

        goToDiaryMenu();

    }

    private static void viewEntry() {
        try{
            String username = input("Enter username >> ");
            Diary user = diaries.findByUsername(username);
            for(Entry entry : user.getEntries()) {
                print(entry.getTitle());
                print(entry.getBody());
            }
        } catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }
        goToDiaryMenu();

    }

    private static void createEntry() {

        try {
            String username = input("Enter username >> ");
            Diary user = diaries.findByUsername(username);
            String title = input("Enter title >> ");
            String body = input("Enter body >> ");
            user.createEntry(title, body);

            print("Entry created successfully!!!");

        }
        catch(IllegalArgumentException e){
            print("Error " + e.getMessage() );
        }
        goToDiaryMenu();

    }

    private static final Scanner scanner = new Scanner(System.in);

    private static String input(String message) {
        print(message);
        return scanner.nextLine();
    }

    private static int inputInt(String message) {
        print(message);
        return scanner.nextInt();

    }

    private static void print(String message) {
        System.out.println(message);
    }
}
