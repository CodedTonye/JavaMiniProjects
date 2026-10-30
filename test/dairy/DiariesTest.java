package dairy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    @Test
    public void newDairies_AddDiaries_AddUsernameTest() {
        Diaries diaries = new Diaries();
        assertEquals(0, diaries.count());
        diaries.add("Tyger", "password");
        assertEquals(1, diaries.count());
    }

    @Test
    public void newDiaries_DiaryWithTheSameUsername_ThrowsExceptionTest() {
        Diaries diaries = new Diaries();
        diaries.add("Tyger", "password");
        assertThrows(IllegalArgumentException.class, ()-> diaries.add("Tyger", "password"));

    }

    @Test
    public void newDiaries_FindByUsername_ReturnsNullTest() {
        Diaries diaries = new Diaries();
        assertSame(null, diaries.findByUsername("Tyger"));
    }

    @Test
    public void newDiaries_AddDiary_FindByUsername_ReturnsDiaryTest() {
        Diaries diaries = new Diaries();
        diaries.add("Tyger", "password");

        assertNotNull(diaries.findByUsername("Tyger"));
    }

    @Test
    public void newDiaries_AddDiary_DeleteDiaryTest() {
        Diaries diaries = new Diaries();
        diaries.add("Tyger", "password");
        assertEquals(1,diaries.count());

        diaries.delete("Tyger", "password");
        assertEquals(0, diaries.count());
    }


}
