package Step1;

public class Pet {

    // Variables
    String name;
    Pet pet;

    // Constructor
    public Pet(String name, Pet pet) {
        //Stage one Pet objects only hold the pet name
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        System.out.println(this.name + " " + this.pet);

        return "";
    }

}
