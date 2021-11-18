package idgenertor;

public class IdGenerator {
    static int id;

    public static int generateId(){
        id += 1;
        return id;
    }
}
