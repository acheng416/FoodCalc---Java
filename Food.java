package FoodCalc;

public class Food {
private String name;
private int calories;
private double fat;
private double protein;
private double carb;
	Food(){
		this.name="";
		this.calories=0;
		this.fat=0;
		this.protein=0;
		this.carb=0;
	}
	Food(String name, int calories, double fat, double protein, double carb){
		this.name=name;
		this.calories=calories;
		this.fat=fat;
		this.protein=protein;
		this.carb=carb;
	}
	void setCalories(int calories) {
		this.calories=calories;
	}
	int getCalories() {
		return this.calories;
	}
	void setName(String name) {
		this.name= name;
	}
	String getName() {
		return this.name;
	}
	void setFat(double fat) {
		this.fat=fat;
	}
	double getFat() {
		return this.fat;
	}
	void setProtein(double protein) {
		this.protein = protein;
	}
	double getProtein() {
		return this.protein;
	}
	void setCarb(double carb) {
		this.carb = carb;
	}
	double getCarb() {
		return this.carb;
	}
}
