package hw04;
import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    public Family(Human mother, Human father){
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        this.children = new Human[0];}
    public Family(Human mother, Human father, Pet pet){
        this.mother = mother;
        this.father = father;
        mother.setFamily(this);
        father.setFamily(this);
        this.pet = pet;
        this.children = new Human[0];}
    public Pet getPet(){return pet;}
    public Human getMother() {return mother;}
    public Human getFather(){return father;}
    public void addChild(Human child){
        Human[] newChildren = new Human[children.length + 1];
        System.arraycopy(children,0,newChildren,0, children.length);
        newChildren [children.length] = child;
        children = newChildren;}
    public Human[] getChildren() {
        return children;}
    public void deleteChild(int index){
        if (index < 0 || index >= children.length) {
            System.out.println("Invalid index");
            return;}
        if (children.length == 0){
            System.out.println("No children found");
            return;}
        Human[] removeChild = new Human[children.length - 1];
        System.arraycopy(children,0,removeChild,0, index);
        System.arraycopy(children, index + 1, removeChild, index, children.length - index - 1);
        children = removeChild;}
    public void deleteChild(Human child){
        boolean found = false;
        for (int i = 0; i < children.length; i++){
            if (children[i].equals(child)){
                deleteChild(i);
                found = true;
                break;}
        }if (!found){
            System.out.println("Child not found");}}
    int countFamily(){
        int count = 2 + (children.length);
        System.out.println("In the family " + count + " persons.");
        return count;}

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }
    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, pet=%s, children=%s}",
                (mother != null) ? mother.toString() : "Mother: Not available",
                (father != null) ? father.toString() : "Father: Not available",
                (pet != null) ? pet.toString() : "Pet: Not available",
                (children != null && children.length > 0) ? Arrays.toString(children) : "Children: Not available");
    }
    @Override
    public boolean equals (Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return Objects.equals(mother, family.mother) && Objects.equals(father,family.father)&& Objects.equals(pet,family.pet);}
    @Override
    public int hashCode (){
        return Objects.hash(mother,father,pet);}
}

