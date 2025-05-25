package hw11;
import hw11.Human.Human;
import java.util.List;
    public class FamilyController {
        private final FamilyService familyService;

        public FamilyController() {
            this.familyService = new FamilyService();}

        public void loadFamiliesFromFile(String path) {
            familyService.loadFamiliesFromFile(path);}

        public void saveFamiliesToFile(String path) {
            familyService.saveFamiliesToFile(path);}

        public void displayAllFamilies() {
            familyService.displayAllFamilies();}

        public List<Family> getFamiliesBiggerThan(int number) {
            return familyService.getFamiliesBiggerThan(number);}

        public List<Family> getFamiliesLessThan(int number) {
            return familyService.getFamiliesLessThan(number);}

        public long countFamiliesWithMemberNumber(int number) {
            return familyService.countFamiliesWithMemberNumber(number);}

        public void createFamily() {
            familyService.createFamily();}

        public void deleteFamilyByIndex(int index) {
            familyService.deleteFamilyByIndex(index);}

        public void bornChild(int familyIndex, String boyName, String girlName) {
            familyService.bornChild(familyIndex, boyName, girlName);}

        public void adoptChild(int familyIndex, Human child) {
            familyService.adoptChild(familyIndex, child);}

        public void deleteAllChildrenOlderThan(int age) {
            familyService.deleteAllChildrenOlderThan(age);}

        public void fillWithTestData() {
            familyService.fillWithTestData();}
    }

