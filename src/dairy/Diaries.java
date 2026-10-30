package dairy;
import java.util.ArrayList;

public class Diaries {
     private ArrayList<Diary> diaries = new ArrayList<>();
     private int count;


     public void add(String username, String password) {
          if(username == null || password == null) throw new IllegalArgumentException("This cannot be empty");

          for(Diary diary : diaries) {
               if(diary.getUsername().equals(username)) {
                    throw new IllegalArgumentException("Username already available");
               }
          }
          Diary diary = new Diary(username, password);
          diaries.add(diary);
          count += 1;

     }

     public int count() {
          return count;
     }

     public Diary findByUsername(String username) {
          for(Diary diary : diaries) {
               if(diary.getUsername().equals(username)) {
                    return diary;
               }
          }
          return null;
     }

     public void delete(String username, String password) {

          Diary diary = findByUsername(username);
          if(diary.equals(null)) throw new IllegalArgumentException("Username not found!!!");
          if(diary.getPassword().equals(password)) {
               diaries.remove(diary);
               count -= 1;
          }
          else{
               throw new IllegalArgumentException("incorrect password!!!");
          }
     }
}
