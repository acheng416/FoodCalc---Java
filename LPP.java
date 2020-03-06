package FoodCalc;
import java.util.*;
public class LPP {
	private String type; //Max/Min
	private int numOfConstraints; //# of equations
	private HashMap<Integer, HashMap<Integer, Double>> matA; //A
	private HashMap<Integer, String> relations; //"<=", "=", ">=" 
	private HashMap<Integer, Double> vecB; // b-vector
	private HashMap<Integer, Double> vecC; //c-vector
	private boolean containsArtificialVars;
	private HashMap<Integer, FoodDriver.VarPair> artificialVars;
	private HashMap<Integer, FoodDriver.VarPair> basicVars;
	private HashMap<Integer, HashMap<Integer, Double>> objRow;
	private double objRowValue;
	LPP(){
		this.type = "";
		this.numOfConstraints = 0;
		this.matA = null;
		this.relations = null;
		this.vecB = null;
		this.vecC = null;
		this.containsArtificialVars=false;
		this.artificialVars=null;
		this.basicVars=null;
		this.objRow=null;
		this.objRowValue=0.0;
	}
	LPP(String type, int numOfConstraints, HashMap<Integer, HashMap<Integer, Double>> matA, HashMap<Integer, String> relations, HashMap<Integer, Double> vecB, HashMap<Integer, Double> vecC, boolean containsArtificialVars
			,HashMap<Integer, FoodDriver.VarPair> artificialVars, HashMap<Integer, FoodDriver.VarPair> basicVars, HashMap<Integer, HashMap<Integer, Double>> objRow, double objRowValue){
		this.type = type;
		this.numOfConstraints = numOfConstraints;
		this.matA = matA;
		this.relations = relations;
		this.vecB = vecB;
		this.vecC = vecC;
		this.containsArtificialVars=containsArtificialVars;
		this.artificialVars=artificialVars;
		this.basicVars=basicVars;
		this.objRow=objRow;
		this.objRowValue=objRowValue;
	}
	void setType(String type) {
		this.type= type;
	}
	String getType(){
		return this.type;
	}
	void setNumOfConstraints(int numOfConstraints) {
		this.numOfConstraints=numOfConstraints;
	}
	int getNumOfConstraints() {
		return this.numOfConstraints;
	}
	void setMatA(HashMap<Integer, HashMap<Integer, Double>> matA) {
		this.matA=matA;
	}
	HashMap<Integer, HashMap<Integer, Double>> getMatA(){
		return this.matA;
	}
	void setRelations(HashMap<Integer, String> relations) {
		this.relations = relations;
	}
	HashMap<Integer, String> getRelations(){
		return this.relations;
	}
	void setVecB(HashMap<Integer, Double> vecB) {
		this.vecB = vecB;
	}
	HashMap<Integer, Double> getVecB(){
		return this.vecB;
	}
	void setVecC(HashMap<Integer, Double> vecC) {
		this.vecC = vecC;
	}
	HashMap<Integer, Double> getVecC(){
		return this.vecC;
	}
	void setContainsArtificialVars(boolean containsArtificialVars) {
		this.containsArtificialVars = containsArtificialVars;
	}
	boolean getContainsArtificialVars() {
		return this.containsArtificialVars;
	}
	void setArtificialVars(HashMap<Integer, FoodDriver.VarPair> artificialVars) {
		this.artificialVars = artificialVars;
	}
	HashMap<Integer, FoodDriver.VarPair> getArtificialVars(){
		return this.artificialVars;
	}
	void setBasicVars(HashMap<Integer, FoodDriver.VarPair> BasicVars) {
		this.basicVars=BasicVars;
	}
	HashMap<Integer, FoodDriver.VarPair> getBasicVars(){
		return this.basicVars;
	}
	void setObjRow(HashMap<Integer, HashMap<Integer, Double>> objRow) {
		this.objRow=objRow;
	}
	HashMap<Integer, HashMap<Integer, Double>> getObjRow(){
		return this.objRow;
	}
	void setObjRowValue(double objRowValue) {
		this.objRowValue = objRowValue;
	}
	double getObjRowValue() {
		return this.objRowValue;
	}
}
