package hw10;
import java.util.List;

public interface FamilyDao {
    List<Family>getAllFamilies();
    void saveFamily(Family family);
    void deleteFamily(Family family);
    void loadData(List<Family> families);
}
