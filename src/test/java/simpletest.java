import com.ramcharans.central.model.libraries.LocalLibrary;
import com.ramcharans.central.model.locations.LocalLocation;
import com.ramcharans.central.model.locations.Location;

public class simpletest {
    public static void main(String[] args) {
//        Document doc = new Document("abcd123", "hello.md", "hello world", new LocalLocation("/hello.txt"));
//        LocalLibrary lib = null;
//
//        try {
//            lib = new LocalLibrary("/Users/ramcharan/java-central/central/local_library/");
//            lib.storeDocument(doc);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            lib.moveDocument(new LocalLocation("/hello.txt"), new LocalLocation("/root/hello.txt"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        LocalLibrary lib = null;
//
//        try {
//            lib = new LocalLibrary("/Users/ramcharan/java-central/central/local_library/");
//            System.out.println(lib.getFilesInCategory(new LocalLocation("/root")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            LocalLibrary lib = new LocalLibrary("/Users/ramcharan/java-central/central/local_library/");
            lib.deleteCategory(new LocalLocation("/root/hello"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
