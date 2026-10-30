package dairy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DairyTest {
    private Diary myDiary;

    @BeforeEach
    public void setUp() {
        myDiary = new Diary("@tyger", "password");
    }

    @Test
    public void newDairy_isLockedTest() {
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void newDairy_unlock_isLocked_returnsTrue_lock_returns_falseTest() {

        myDiary.unlockDiary("password");
        assertFalse(myDiary.isLocked());

        myDiary.lockDairy();
        assertTrue(myDiary.isLocked());
    }

    @Test
    public void newDairy_createNewEntry_DairyIsLocked_throwsExceptionTest() {

        assertThrows(IllegalArgumentException.class, ()-> myDiary.createEntry("Life", "In God we Trust..."));
    }


    @Test
    public void newDairy_FindEntryById__createEntry_findEntryById_returnsEntryTest() {
        int Id = 1;
        assertThrows(IllegalArgumentException.class, ()-> myDiary.findDairyById(Id));

        myDiary.unlockDiary("password");
        myDiary.createEntry("Life", "God is the Greatest...");
        Entry foundEntry = myDiary.findDairyById(Id);
        assertEquals("Life", foundEntry.getTitle());
        assertEquals("God is the Greatest...", foundEntry.getBody());
    }

    @Test
    public void newDiary_createEntry_deleteEntry_FindEntry_throwsExceptionTest() {
        int Id = 1;
        myDiary.unlockDiary("password");

        myDiary.createEntry("Life", "God is Good...");

        assertNotNull(myDiary.findDairyById(Id));

        myDiary.deleteEntry(Id);
        assertNull(myDiary.findDairyById(Id));
    }

    @Test
    public void newDairy_createEntry_updateEntry_TitleAndBodyIsUpdatedTest() {
        int Id = 1;
        myDiary.unlockDiary("password");
        myDiary.createEntry("Life", "Life is Good");
        Entry entry = myDiary.findDairyById(Id);

        myDiary.updateDiary(Id, "Life Journey", "God is Good...");
        assertEquals("Life Journey", entry.getTitle());
        assertEquals("God is Good...", entry.getBody());
    }

}