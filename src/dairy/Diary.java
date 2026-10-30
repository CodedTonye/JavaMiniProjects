package dairy;

import java.util.ArrayList;

public class Diary {
    private int count;
    private String username;
    private String password;
    private ArrayList<Entry> entries = new ArrayList<>();
    private boolean isLocked = true;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void unlockDiary(String password) {
        if(this.password.equals(password)) isLocked = false;
    }

    public void lockDairy() {
        isLocked = true;
    }

    public void createEntry(String title, String body) {
        if(isLocked) throw new IllegalArgumentException("Unlock Dairy Before Creating Entry!!!");
        if(title == null || body == null) throw new IllegalArgumentException("This cannot be empty");
        int Id = generateId();
        Entry entry = new Entry(Id, title, body);
        entries.add(entry);
    }

    public int generateId() {
        this.count = count + 1;
        return this.count;
    }



    public Entry findDairyById(int Id) {
        if(isLocked)throw new IllegalArgumentException("Unlock diary first!!!");
        for(Entry entry : entries) {
            if(entry.getId() == Id) {
                return entry;
            }
        }
        return null;
    }

    public void deleteEntry(int Id) {
        if(isLocked)throw new IllegalArgumentException("Unlock diary first!!!");
        Entry entry = findDairyById(Id);
        if(entry.getId() == Id) {
            entries.remove(entry);
        }
    }

    public void updateDiary(int Id, String title, String body) {
        if(isLocked) throw new IllegalArgumentException("Unlock Dairy Before Creating Entry!!!");
        if(title == null || body == null) throw new IllegalArgumentException("This cannot be empty");

        for(Entry entry : entries) {
            if(entry.getId() == Id) {
                entry.setBody(body);
                entry.setTitle(title);
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
}
