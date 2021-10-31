 /**
* Java 1. Lesson 7
*@author Sergey Sergeev
*@version 31.10.2021
*/

public class Lesson7   {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Shveps", 10);
        cats[1] = new Cat("Vasya", 15);
        cats[2] = new Cat("Tom", 30);
        Plate plate = new Plate(100, 40);
        System.out.println(plate);
       
	    for (Cat cat : cats) {
			cat.eat(plate);
			System.out.println(cat);
	    }

        System.out.println(plate);
		plate.add(35);
		System.out.println(plate);
		
		for (Cat cat : cats) {
			cat.setFullness(false);
			cat.eat(plate);
			System.out.println(cat);
		}
		System.out.println(plate);
		}
}

class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
	}

    void setFullness(boolean status) {
        fullness = status;
	}

    void eat(Plate plate) {
        if (!fullness) {
            fullness = plate.decreaseFood(appetite);
		}
	}
    
    @Override
    public String toString()  {
	    return "(name=" + name + ", appetite=" + appetite + ", fullness=" + fullness + ")";	
	}
}	

class Plate  {
    private int volume;
	private int food;
	
	Plate(int volume, int food)  {
		this.volume = volume;
		this.volume = food;
	}
	
	boolean decreaseFood(int portion) {
		if (food < portion) {
			return false;
		}
		food -= portion;
		return true;
	}
	
	void add(int food) {
		if (this.food + food <= volume) {
			this.food += food;
		}
	}
	
	@Override 
	public String toString() {
		return "plate " + food;
	}
}