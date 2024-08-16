import com.rahul.hashmap.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyHashMapTest {

    @Test
    void testWhenPutIsCalledNoExceptionIsThrown(){

        HashMap hashMap= new HashMap();
        Assertions.assertDoesNotThrow(()-> hashMap.put("rahul",10));

    }

    @Test
    void testWhenGetIsCalledNoExceptionIsThrown(){

        HashMap hashMap= new HashMap();
        Assertions.assertDoesNotThrow(()-> hashMap.get("rahul"));
        Integer actual=hashMap.get("rahul");
        Assertions.assertNull(actual);

    }

    @Test
    void testToAssertGet(){
        HashMap hashMap= new HashMap();
        hashMap.put("rahul",20);
        Integer actual=hashMap.get("rahul");
        Assertions.assertEquals(20,actual);
    }

    @Test
    void testToCheckValuesForSameKey(){
        HashMap hashMap= new HashMap();
        hashMap.put("rahul",10);
        hashMap.put("rahul",20);
        Integer actual=hashMap.get("rahul");
        Assertions.assertEquals(20,actual);
    }

}
