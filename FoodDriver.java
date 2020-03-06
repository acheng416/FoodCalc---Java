package FoodCalc;
import java.util.*;
import java.io.*;
public class FoodDriver {

	public static void main(String[] args)  {
		FoodDriver instance1 = new FoodDriver();
		HashMap<Integer, Food> m1 = new HashMap<Integer, Food>(10000, (float) 0.75);
		InputStream f1 = FoodDriver.class.getResourceAsStream("/Food.txt");
		InputStream f2 = FoodDriver.class.getResourceAsStream("/FoodRaw.txt");
		InputStream f3 = FoodDriver.class.getResourceAsStream("FoodNames.txt");
		InputStream f4 = FoodDriver.class.getResourceAsStream("Calories.txt");
		InputStream f7 = FoodDriver.class.getResourceAsStream("Carbohydrates.txt");
		InputStream f6 = FoodDriver.class.getResourceAsStream("Protein.txt");
		InputStream f5 = FoodDriver.class.getResourceAsStream("Fats.txt");
		InputStream[] files = new InputStream[5];
		files[0] = f3;
		files[1] = f4;
		files[2] = f5;
		files[3] = f6;
		files[4] = f7;
		try {
			FileOutputStream write1 = new FileOutputStream("log.txt");
			System.setOut(new PrintStream(write1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(f2 != null && f1!=null) {
			instance1.parseRawFoodDataUSDA(files, m1);
			//instance1.parseRawFoodData(f2, m1);
			LPP p1 = new LPP();
			HashMap<Integer, String> relations = new HashMap<Integer, String>();
			HashMap<Integer, Double> vecB = new HashMap<Integer, Double>();
			HashMap<Integer, VarPair> artificialVars = new HashMap<Integer, VarPair>();
			instance1.fillLPP(p1, m1, "Min", 4, relations, vecB);
			p1.setArtificialVars(artificialVars);
			p1.setContainsArtificialVars(false);
			relations.put(0, "="); //fat
			relations.put(1, "="); //protein
			relations.put(2, "="); //carb
			relations.put(3, "="); //calories
			vecB.put(0, 100.0);
			vecB.put(1, 160.0);
			vecB.put(2, 150.0);
			vecB.put(3, 2000.0);
			
			
			
			//System.out.println();
			//System.out.println("Before converting to canonical form: ");
			//instance1.printConstraintsEquations(p1);
			//instance1.convertToCanonicalForm(p1);
			//System.out.println();
			//System.out.println("After converting to canonical form: ");
			//instance1.printConstraintsEquations(p1);
			HashMap<Integer, VarPair> initialBasicVars = new HashMap<Integer, VarPair>();
			instance1.addArtificialVariables(p1, initialBasicVars);
			//System.out.println();
			//System.out.println("After adding artificial vars: ");
			//instance1.printConstraintsEquations(p1);
			//System.out.println();
			//instance1.printInitialBasicVars(p1, initialBasicVars);
			//instance1.printArtificialVars(p1);
			//HashMap<Integer, HashMap<Integer, Double>> CTB = instance1.getCTB(initialBasicVars, p1);
			//instance1.printMatrix(CTB, "CTB");
			//instance1.printMatrix(instance1.getMatB(p1, initialBasicVars), "MatB");
			//for(int i =0;i<p1.getNumOfConstraints(); i++) {
			//	System.out.println(instance1.getObjRowValue(p1, initialBasicVars, instance1.getMatB(p1, initialBasicVars), i));
			//}
			
			
			/////Test simplex method (working 2):
//			int testNumberOfConstraints = 3;
//			HashMap<Integer, HashMap<Integer, Double>> testMatA = new HashMap<Integer, HashMap<Integer, Double>>();
//			HashMap<Integer, Double> testNewRow1 = new HashMap<Integer, Double>();
//			testMatA.put(0, testNewRow1);
//			HashMap<Integer, Double> testNewRow2 = new HashMap<Integer, Double>();
//			testMatA.put(1, testNewRow2);
//			HashMap<Integer, Double> testNewRow3 = new HashMap<Integer, Double>();
//			testMatA.put(2, testNewRow3);
//			testMatA.get(0).put(0, 2.0);
//			testMatA.get(0).put(1, 1.0);
//			testMatA.get(0).put(2, 1.0);
//			testMatA.get(0).put(3, 2.0);
//			testMatA.get(1).put(0, 3.0);
//			testMatA.get(1).put(1, 0.0);
//			testMatA.get(1).put(2, 1.0);
//			testMatA.get(1).put(3, 0.0);
//			testMatA.get(2).put(0, 5.0);
//			testMatA.get(2).put(1, 4.0);
//			testMatA.get(2).put(2, 0.0);
//			testMatA.get(2).put(3, 1.0);
//			HashMap<Integer, String> testRelations = new HashMap<Integer, String>();
//			testRelations.put(0, "<=");
//			testRelations.put(1, "<=");
//			testRelations.put(2, "<=");
//			HashMap<Integer, Double> testVecB = new HashMap<Integer, Double>();
//			testVecB.put(testVecB.size(), 6.0);
//			testVecB.put(testVecB.size(), 15.0);
//			testVecB.put(testVecB.size(), 24.0);
//			HashMap<Integer, Double> testVecC = new HashMap<Integer, Double>();
//			testVecC.put(testVecC.size(), 5.0);
//			testVecC.put(testVecC.size(), 2.0);
//			testVecC.put(testVecC.size(), 1.0);
//			testVecC.put(testVecC.size(), 1.0);
//			HashMap<Integer, VarPair> testArtificialVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, VarPair> testInitialBasicVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, HashMap<Integer, Double>> objRow = new HashMap<Integer, HashMap<Integer, Double>>();
//			objRow.put(0, new HashMap<Integer, Double>());
//			double objRowValue = 0.0;
//			LPP test1 = new LPP("Max", testNumberOfConstraints, testMatA, testRelations, testVecB, testVecC, false,testArtificialVars, testInitialBasicVars, objRow, objRowValue);
//			instance1.convertToCanonicalForm(test1);
//			instance1.addArtificialVariables(test1, testInitialBasicVars);
//			for(int i =0;i<test1.getMatA().get(0).size();i++) {
//				objRow.get(0).put(i, -(testVecC.get(i)));
//			}
//			instance1.simplexMethod(test1, testInitialBasicVars);
			
			
			
			
			
			
			
			
			/////Test 2-phase simplex (works):
//			int testNumberOfConstraints = 3;
//			HashMap<Integer, HashMap<Integer, Double>> testMatA = new HashMap<Integer, HashMap<Integer, Double>>();
//			HashMap<Integer, Double> testNewRow1 = new HashMap<Integer, Double>();
//			testMatA.put(0, testNewRow1);
//			HashMap<Integer, Double> testNewRow2 = new HashMap<Integer, Double>();
//			testMatA.put(1, testNewRow2);
//			HashMap<Integer, Double> testNewRow3 = new HashMap<Integer, Double>();
//			testMatA.put(2, testNewRow3);
//			testMatA.get(0).put(0, 2.0);
//			testMatA.get(0).put(1, 1.0);
//			testMatA.get(0).put(2, -1.0);
//			testMatA.get(0).put(3, 0.0);
//			testMatA.get(0).put(4, 0.0);
//			testMatA.get(0).put(5, 1.0);
//			testMatA.get(1).put(0, 3.0);
//			testMatA.get(1).put(1, 0.0);
//			testMatA.get(1).put(2, 2.0);
//			testMatA.get(1).put(3, 1.0);
//			testMatA.get(1).put(4, 2.0);
//			testMatA.get(1).put(5, 0.0);
//			testMatA.get(2).put(0, 0.0);
//			testMatA.get(2).put(1, 1.0);
//			testMatA.get(2).put(2, -3.0);
//			testMatA.get(2).put(3, 0.0);
//			testMatA.get(2).put(4, 1.0);
//			testMatA.get(2).put(5, 0.0);
//			HashMap<Integer, String> testRelations = new HashMap<Integer, String>();
//			testRelations.put(0, "=");
//			testRelations.put(1, "=");
//			testRelations.put(2, "=");
//			HashMap<Integer, Double> testVecB = new HashMap<Integer, Double>();
//			testVecB.put(testVecB.size(), 3.0);
//			testVecB.put(testVecB.size(), 4.0);
//			testVecB.put(testVecB.size(), 2.0);
//			HashMap<Integer, Double> testVecC = new HashMap<Integer, Double>();
//			testVecC.put(testVecC.size(), 3.0);
//			testVecC.put(testVecC.size(), 1.0);
//			testVecC.put(testVecC.size(), -1.0);
//			testVecC.put(testVecC.size(), 2.0);
//			testVecC.put(testVecC.size(), -1.0);
//			testVecC.put(testVecC.size(), 2.0);
//			HashMap<Integer, VarPair> testArtificialVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, VarPair> testInitialBasicVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, HashMap<Integer, Double>> objRow = new HashMap<Integer, HashMap<Integer, Double>>();
//			objRow.put(0, new HashMap<Integer, Double>());
//			double objRowValue = 0.0;
//			LPP test1 = new LPP("Max", testNumberOfConstraints, testMatA, testRelations, testVecB, testVecC, false,testArtificialVars, testInitialBasicVars, objRow, objRowValue);
//			instance1.convertToCanonicalForm(test1);
//			instance1.addArtificialVariables(test1, testInitialBasicVars);
//			instance1.simplexMethod(test1, testInitialBasicVars);
			
			
			
			/////Test dual-simplex/addConstraints (works)
//			int testNumberOfConstraints = 2;
//			HashMap<Integer, HashMap<Integer, Double>> testMatA = new HashMap<Integer, HashMap<Integer, Double>>();
//			HashMap<Integer, Double> testNewRow1 = new HashMap<Integer, Double>();
//			testMatA.put(0, testNewRow1);
//			HashMap<Integer, Double> testNewRow2 = new HashMap<Integer, Double>();
//			testMatA.put(1, testNewRow2);
//			testMatA.get(0).put(0, -0.14);
//			testMatA.get(0).put(1, -0.09);
//			testMatA.get(0).put(2, -0.21);
//			testMatA.get(1).put(0, 0.055);
//			testMatA.get(1).put(1, 0.015);
//			testMatA.get(1).put(2, 0.045);
//			HashMap<Integer, String> testRelations = new HashMap<Integer, String>();
//			testRelations.put(0, "<=");
//			testRelations.put(testRelations.size(), "<=");
//			HashMap<Integer, Double> testVecB = new HashMap<Integer, Double>();
//			testVecB.put(testVecB.size(), -5.0);
//			testVecB.put(testVecB.size(), 1.0);
//			HashMap<Integer, Double> testVecC = new HashMap<Integer, Double>();
//			testVecC.put(testVecC.size(), 4.1);
//			testVecC.put(testVecC.size(), 2.5);
//			testVecC.put(testVecC.size(), 7.3);
//			HashMap<Integer, VarPair> testArtificialVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, VarPair> testInitialBasicVars = new HashMap<Integer, VarPair>();
//			HashMap<Integer, HashMap<Integer, Double>> objRow = new HashMap<Integer, HashMap<Integer, Double>>();
//			objRow.put(0, new HashMap<Integer, Double>());
//			double objRowValue = 0.0;
//			LPP test1 = new LPP("Min", testNumberOfConstraints, testMatA, testRelations, testVecB, testVecC, false,testArtificialVars, testInitialBasicVars, objRow, objRowValue);
//			instance1.printMatrix(testMatA, "testMatA");
//			instance1.convertToCanonicalForm(test1);
//			instance1.printMatrix(testMatA, "testMatA");
//			instance1.printConstraintsEquations(test1);
//			instance1.addArtificialVariables(test1, testInitialBasicVars);
//			for(int i =0;i<testVecC.size();i++) {
//				objRow.get(0).put(i, -(testVecC.get(i)));
//			}
//			HashMap<Integer, VarPair> testSolution = instance1.dualSimplex(m1, test1, testInitialBasicVars, objRow, objRowValue);
//			HashMap<Integer, Double> newConstraintRow = new HashMap<Integer, Double>();
//			newConstraintRow.put(0, 0.08);
//			newConstraintRow.put(1, 0.06);
//			newConstraintRow.put(2, 0.08);
//			newConstraintRow.put(3, 0.0);
//			newConstraintRow.put(4, 0.0);
//			instance1.addConstraint(m1, test1, testInitialBasicVars, 2.5, "<=", newConstraintRow);
			
			
			
			
			
			
			HashMap<Integer, VarPair> solution = instance1.simplexMethod(p1, initialBasicVars);
			
			
//			//Test constraints
			HashMap<Integer, Double> newrow = new HashMap<Integer, Double>();
			for(int i =0;i<p1.getMatA().get(0).size();i++) {
				if(i==2088) {//raw apple
					newrow.put(i, 1.0);
				} else {
					newrow.put(i, 0.0);
				}
			}
			String newRelation = ">=";
			double newBEntry = 0.5;
			solution = instance1.addConstraint(m1, p1, solution, newBEntry, newRelation, newrow);
			
			HashMap<Integer, Double> newrow1 = new HashMap<Integer, Double>();
			for(int i =0;i<p1.getMatA().get(0).size();i++) {
				if(i==896) {//chicken thigh
					newrow1.put(i, 1.0);
				} else {
					newrow1.put(i, 0.0);
				}
			}
			String newRelation1 = ">=";
			double newBEntry1 = .50;
			solution = instance1.addConstraint(m1, p1, solution, newBEntry1, newRelation1, newrow1);
//			
			
			HashMap<Integer, Double> newrow2 = new HashMap<Integer, Double>();
			for(int i =0;i<p1.getMatA().get(0).size();i++) {
				if(i==3107) {
					newrow2.put(i, 1.0);
				} else {
					newrow2.put(i, 0.0);
				}
			}
			String newRelation2 = ">=";
			double newBEntry2 = 0.5;
			solution = instance1.addConstraint(m1, p1, solution, newBEntry2, newRelation2, newrow2);
			
			
			HashMap<Integer, Double> newrow3 = new HashMap<Integer, Double>();
			for(int i =0;i<p1.getMatA().get(0).size();i++) {
				if(i==6382) {
					newrow3.put(i, 1.0);
				} else {
					newrow3.put(i, 0.0);
				}
			}
			String newRelation3 = ">=";
			double newBEntry3 = 1.0;
			solution = instance1.addConstraint(m1, p1, solution, newBEntry3, newRelation3, newrow3);
			
			HashMap<Integer, Double> newrow4 = new HashMap<Integer, Double>();
			for(int i =0;i<p1.getMatA().get(0).size();i++) {
				if(i==4154) {
					newrow4.put(i, 1.0);
				} else {
					newrow4.put(i, 0.0);
				}
			}
			String newRelation4 = "<=";
			double newBEntry4 = 0.0;
			solution = instance1.addConstraint(m1, p1, solution, newBEntry4, newRelation4, newrow4);
			
			
			//print solution in terms of food
			for(int i=0;i<solution.size();i++) {
				if(solution.get(i).colindex < m1.size()) {
					System.out.println("Consume " + Math.round(p1.getVecB().get(i)*10000)/10000.0d*100 + " grams of: " + m1.get(solution.get(i).colindex).getName());
				}
			}
			double totalCalories = 0;
			double totalFat = 0;
			double totalProtein = 0;
			double totalCarb = 0;
			for(int i=0;i<solution.size();i++) {
				if(solution.get(i).colindex < m1.size()) {
					totalCalories += Math.round(p1.getVecB().get(i)*10000)/10000.0d *m1.get(solution.get(i).colindex).getCalories();
					totalFat += Math.round(p1.getVecB().get(i)*10000)/10000.0d *m1.get(solution.get(i).colindex).getFat();
					totalProtein += Math.round(p1.getVecB().get(i)*10000)/10000.0d *m1.get(solution.get(i).colindex).getProtein();
					totalCarb += Math.round(p1.getVecB().get(i)*10000)/10000.0d *m1.get(solution.get(i).colindex).getCarb();
				}
			}
			System.out.println("Total calories: " + totalCalories);
			System.out.println("Total fats: " + totalFat);
			System.out.println("Total protein: " + totalProtein);
			System.out.println("Total carb: " + totalCarb);
//		} else {
//			System.out.println("error files not found");
//		}
	}
	HashMap<Integer, VarPair> simplexMethod(LPP p1, HashMap<Integer, VarPair> initialBasicVars){
		if(p1.getArtificialVars().size() == 0) {//no artificial variables (no need for 2-phase)
			return regularSimplex(p1, initialBasicVars);
		} 
		else {//2-phase method
			
			HashMap<Integer, VarPair> finalSolution = phaseTwo(p1, phaseOne(p1, initialBasicVars));
			return finalSolution;
		}
	}
	
	HashMap<Integer, VarPair> addConstraint(HashMap<Integer, Food> m1, LPP p1, HashMap<Integer, VarPair> BasicVars, double newBEntry, String newRelation, HashMap<Integer, Double> newrow) {
		System.out.println("ObjRowValue is: "+ p1.getObjRowValue());
		if(newRelation.compareToIgnoreCase("<=")==0) {
			p1.getMatA().put(p1.getNumOfConstraints(), newrow);
			p1.setNumOfConstraints(p1.getNumOfConstraints()+1);
			p1.getVecB().put(p1.getVecB().size(), newBEntry);
			p1.getRelations().put(p1.getRelations().size(), newRelation);
			//printConstraintsEquations(p1);
			//printInitialBasicVars(p1, p1.getBasicVars());
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			convertToCanonicalForm(p1);
			//System.out.println("After converting: ");
			//printConstraintsEquations(p1);
			//printInitialBasicVars(p1, p1.getBasicVars());
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			//p1.getObjRow().get(0).put(p1.getObjRow().get(0).size(), 0.0);
			for(int i =0;i<BasicVars.size();i++) {
				pivotAnEntry(p1, p1.getObjRow(), BasicVars.get(i).rowindex, BasicVars.get(i).colindex);
			}
			VarPair newvar = new VarPair();
			newvar.rowindex = p1.getMatA().size()-1;
			newvar.colindex = p1.getMatA().get(0).size()-1;
			BasicVars.put(BasicVars.size(), newvar);
			//printConstraintsEquations(p1);
			//printInitialBasicVars(p1, p1.getBasicVars());
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			//printInitialBasicVars(p1, BasicVars);
			//printArtificialVars(p1);
			//printConstraintsEquations(p1);
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			HashMap<Integer, VarPair> solutionToDualSimplex = dualSimplex(m1, p1, p1.getBasicVars(), p1.getObjRow(), p1.getObjRowValue());
			return solutionToDualSimplex;
		} 
		else if(newRelation.compareToIgnoreCase(">=")==0) {
			System.out.println("Case 2 addConstraint");
			for(int i =0;i<newrow.size();i++) {
				if(newrow.get(i)!=0.0) {
					newrow.replace(i, -(newrow.get(i)));
				}
			}
			newRelation = "<=";
			newBEntry = -(newBEntry);
			p1.getMatA().put(p1.getNumOfConstraints(), newrow);
			p1.setNumOfConstraints(p1.getNumOfConstraints()+1);
			p1.getVecB().put(p1.getVecB().size(), newBEntry);
			p1.getRelations().put(p1.getRelations().size(), newRelation);
			convertToCanonicalForm(p1);
			VarPair newvar = new VarPair();
			newvar.rowindex = p1.getMatA().size()-1;
			newvar.colindex = p1.getMatA().get(0).size()-1;
			BasicVars.put(BasicVars.size(), newvar);
			//p1.getRelations().replace(p1.getRelations().size()-1, "=");
			p1.getObjRow().get(0).put(p1.getObjRow().get(0).size(), 0.0);
			//printConstraintsEquations(p1);
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			//printInitialBasicVars(p1, BasicVars);
			//printArtificialVars(p1);
			for(int i =0;i<BasicVars.size();i++) {
				pivotAnEntry(p1, p1.getObjRow(), BasicVars.get(i).rowindex, BasicVars.get(i).colindex);
			}
			//printConstraintsEquations(p1);
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			HashMap<Integer, VarPair> solutionToDualSimplex = dualSimplex(m1, p1, p1.getBasicVars(), p1.getObjRow(), p1.getObjRowValue());
			return solutionToDualSimplex;
		} else {
			return null;
		}
	}
	
	HashMap<Integer, VarPair> dualSimplex(HashMap<Integer, Food> m1, LPP p1, HashMap<Integer, VarPair> BasicVars, HashMap<Integer, HashMap<Integer, Double>> objRow, double objRowValue){
		boolean vecBHasNegative = false;
		for(int i =0; i<p1.getVecB().size();i++) {
			if(p1.getVecB().get(i)<0.0) {
				vecBHasNegative = true;
				break;
			}
		}
		if(vecBHasNegative) {
			
			while(vecBHasNegative) {
				//System.out.println();
				//System.out.println("The current tableau for DualSimplex is: ");
				//printConstraintsEquations(p1);
				//printObjRow(objRow, objRowValue);
				//printInitialBasicVars(p1,BasicVars);
				int pivotRowIndex = getDepartingVarDual(p1, BasicVars);
				if(pivotRowIndex >= 0) {
					int pivotColIndex = getEnteringVarDual(p1, BasicVars, pivotRowIndex, objRow);
					if(pivotColIndex>=0) {
						VarPair enteringVar = new VarPair();
						enteringVar.rowindex = pivotRowIndex;
						enteringVar.colindex = pivotColIndex;
						BasicVars.replace(pivotRowIndex, enteringVar);
						objRowValue = pivotAnEntry(p1, objRow, pivotRowIndex, pivotColIndex);
					} else {
						System.out.println("No Feasible Solutions!");
						return null;
					}
				}
				vecBHasNegative = false;
				for(int i =0; i<p1.getVecB().size();i++) {
					if(p1.getVecB().get(i)<0.0) {
						vecBHasNegative = true;
						break;
					}
				}
			}
			//System.out.println("The final tableau for DualSimplex is: ");
			//printConstraintsEquations(p1);
			//printObjRow(objRow, objRowValue);
			//printInitialBasicVars(p1,BasicVars);
			//p1.setObjRow(objRow);
			//p1.setObjRowValue(objRowValue);
			return BasicVars;
		}
		else {
			//System.out.println("Feasible solution");
			return p1.getBasicVars();
		}
	}
	
	HashMap<Integer, VarPair> regularSimplex(LPP p1, HashMap<Integer, VarPair> BasicVars){
		System.out.println("Entering regular Simplex");
		printConstraintsEquations(p1);
		printObjRow(p1.getObjRow(), p1.getObjRowValue());
		printInitialBasicVars(p1,BasicVars);
		//int iteration = 0;
		while(containsNegativeObjRow(p1.getObjRow(), p1).get(0).size()!=0) {
			//System.out.println();
			//System.out.println("The current tableau for Regular Simplex is: ");
			//printConstraintsEquations(p1);
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			//printInitialBasicVars(p1,BasicVars);
			int pivotColIndex = getEnteringVar(containsNegativeObjRow(p1.getObjRow(), p1), p1);
			VarPair enteringVar = new VarPair();
			enteringVar.colindex = pivotColIndex;
			System.out.println("The entering var is: " + "X" +(pivotColIndex + 1));
			if(getDepartingVar(p1, pivotColIndex)>=0) {
				int pivotRowIndex = getDepartingVar(p1, pivotColIndex);
				enteringVar.rowindex= pivotRowIndex;
				System.out.println("The departing var is: " + "X" + (BasicVars.get(pivotRowIndex).colindex + 1));
				BasicVars.replace(pivotRowIndex, enteringVar);
				p1.setObjRowValue(pivotAnEntry(p1, p1.getObjRow(), pivotRowIndex, pivotColIndex));
			}
			//iteration++;
		}
		System.out.println("The final tableau for Regular Simplex is: ");
		//printConstraintsEquations(p1);
		//printObjRow(p1.getObjRow(), p1.getObjRowValue());
		//printInitialBasicVars(p1,BasicVars);
		p1.setBasicVars(BasicVars);
		return BasicVars;
	}
	
	LPP phaseOne(LPP p1, HashMap<Integer, VarPair> initialBasicVars) {
		//Setup initial tableau
		LPP p2 = new LPP("Min", p1.getNumOfConstraints(), p1.getMatA(), p1.getRelations(), p1.getVecB(), p1.getVecC(), p1.getContainsArtificialVars(), p1.getArtificialVars(), initialBasicVars, null, 0.0);
//		System.out.println("The initial tableau for Phase I is: ");
//		printConstraintsEquations(p2);
		HashMap<Integer, HashMap<Integer, Double>> objRow = new HashMap<Integer, HashMap<Integer, Double>>();
		objRow.put(0, new HashMap<Integer, Double>());
		double objRowValue = 0.0;
		for(int i=0; i<p2.getArtificialVars().size();i++) {
			int currentRowIndex = p2.getArtificialVars().get(i).rowindex;
			int artificialVarColIndex = p2.getArtificialVars().get(i).colindex;
			for(int j=0;j<p2.getMatA().get(0).size();j++) {
				if(objRow.get(0).get(j)==null) {
					if(j!=artificialVarColIndex) {
						objRow.get(0).put(j, -(p2.getMatA().get(currentRowIndex).get(j)));
					} else {
						objRow.get(0).put(j, 0.0);
					}
				}else {
					if(j!=artificialVarColIndex) {
						double newValue = objRow.get(0).get(j) - p2.getMatA().get(currentRowIndex).get(j);
						objRow.get(0).replace(j, newValue);
					}
				}
			}
			p2.setType("Max");
			objRowValue += -(p2.getVecB().get(currentRowIndex));
			p2.setObjRow(objRow);
			p2.setObjRowValue(objRowValue);
		}
//		printObjRow(objRow, objRowValue);
//		printInitialBasicVars(p2,initialBasicVars);
		int iteration = 0;
		//Run simplex until non-negative obj row and no artificial as basic;
		while(containsNegativeObjRow(p2.getObjRow(), p2).get(0).size()!=0 && iteration<8) {
			//System.out.println();
			//System.out.println("The current tableau for Phase I is: ");
			//printConstraintsEquations(p2);
			//printObjRow(p2.getObjRow(), p2.getObjRowValue());
			//printInitialBasicVars(p2,p2.getBasicVars());
			int pivotColIndex = getEnteringVar(containsNegativeObjRow(p2.getObjRow(), p2), p2);
			VarPair enteringVar = new VarPair();
			enteringVar.colindex = pivotColIndex;
			System.out.println("The entering var is: " + "X" +(pivotColIndex + 1));
			if(getDepartingVar(p2, pivotColIndex)>=0) {
				int pivotRowIndex = getDepartingVar(p2, pivotColIndex);
				//System.out.println("pivotRowIndex is: " + pivotRowIndex);
				enteringVar.rowindex= pivotRowIndex;
				//System.out.println("The size of basicvars is: " + p2.getBasicVars().size());
				//System.out.println("The departing var is: " + "X" + (p2.getBasicVars().get(pivotRowIndex).colindex + 1));
				p2.getBasicVars().replace(pivotRowIndex, enteringVar);
				p2.setObjRowValue(pivotAnEntry(p2, p2.getObjRow(), pivotRowIndex, pivotColIndex));
			}
			iteration++;
		}
		//System.out.println("The final tableau for Phase I is: ");
		//printConstraintsEquations(p2);
		//printObjRow(p2.getObjRow(), p2.getObjRowValue());
		//printInitialBasicVars(p2,p2.getBasicVars());
		p1.setBasicVars(p2.getBasicVars());
		p1.setObjRowValue(p2.getObjRowValue());
		return p2;
	}
	
	HashMap<Integer, VarPair> phaseTwo(LPP p1, LPP p2) {
		//Setup phase-Two
		HashMap<Integer, HashMap<Integer, Double>> objRow = new HashMap<Integer, HashMap<Integer, Double>>();
		objRow.put(0, new HashMap<Integer, Double>());
		for(int j =0;j<p1.getMatA().get(0).size();j++) {
			objRow.get(0).put(j, -(p1.getVecC().get(j)));
		}
		for(int i =0; i<p1.getBasicVars().size();i++) {
			p1.setObjRowValue(pivotAnEntry(p1, objRow, p1.getBasicVars().get(i).rowindex, p1.getBasicVars().get(i).colindex));
		}
		p1.setObjRow(objRow);
		//printConstraintsEquations(p1);
		//printObjRow(p1.getObjRow(), p1.getObjRowValue());
		//printInitialBasicVars(p1,p1.getBasicVars());
		//int iteration = 0;
		while(containsNegativeObjRow(p1.getObjRow(), p1).get(0).size()!=0) {
			//System.out.println();
			//System.out.println("The current tableau for Phase II is: ");
			//printConstraintsEquations(p1);
			//printObjRow(p1.getObjRow(), p1.getObjRowValue());
			//printInitialBasicVars(p1,p1.getBasicVars());
			int pivotColIndex = getEnteringVar(containsNegativeObjRow(p1.getObjRow(), p1), p1);
			VarPair enteringVar = new VarPair();
			enteringVar.colindex = pivotColIndex;
			System.out.println("The entering var is: " + "X" +(pivotColIndex + 1));
			if(getDepartingVar(p1, pivotColIndex)>=0) {
				int pivotRowIndex = getDepartingVar(p1, pivotColIndex);
				enteringVar.rowindex= pivotRowIndex;
				System.out.println("The departing var is: " + "X" + (p1.getBasicVars().get(pivotRowIndex).colindex + 1));
				p1.getBasicVars().replace(pivotRowIndex, enteringVar);
				p1.setObjRowValue(pivotAnEntry(p1, p1.getObjRow(), pivotRowIndex, pivotColIndex));
			}
			//iteration++;
		}
		System.out.println("The final tableau for Phase II is: ");
		printConstraintsEquations(p1);
		printObjRow(p1.getObjRow(), p1.getObjRowValue());
		printInitialBasicVars(p1,p1.getBasicVars());
		return p1.getBasicVars();
	}
	
	
	double pivotAnEntry(LPP p2, HashMap<Integer, HashMap<Integer, Double>> objRow, int pivotRowIndex, int pivotColIndex) {
		for(int i=0;i<p2.getMatA().size();i++) {
			for(int j=0;j<p2.getMatA().get(0).size();j++) {
				if(i!=pivotRowIndex && j!=pivotColIndex) {//not same row and not same col
					double newValue = p2.getMatA().get(i).get(j) + (-(p2.getMatA().get(i).get(pivotColIndex)*p2.getMatA().get(pivotRowIndex).get(j)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex))); //Gauss-Jordan Elimination
					//newValue = Math.round(newValue*1000000)/1000000.0d;
					p2.getMatA().get(i).replace(j, newValue);
				} 
			}
		} 
		p2.setObjRowValue((p2.getObjRowValue() + (-(objRow.get(0).get(pivotColIndex)*p2.getVecB().get(pivotRowIndex)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex)))));
		for(int i=0;i<p2.getVecB().size();i++) {
			if(i!=pivotRowIndex) {
				double newValue = p2.getVecB().get(i) + (-(p2.getVecB().get(pivotRowIndex)*p2.getMatA().get(i).get(pivotColIndex)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex)));
				p2.getVecB().replace(i, newValue);
			}
		}
		p2.getVecB().replace(pivotRowIndex, p2.getVecB().get(pivotRowIndex)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex));
		for(int j=0;j<objRow.get(0).size();j++) {
			if(j!=pivotColIndex) {
				double newValue = (objRow.get(0).get(j) + (-(p2.getMatA().get(pivotRowIndex).get(j)*objRow.get(0).get(pivotColIndex)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex)))); //Gauss-Jordan Elimination
				//newValue = Math.round(newValue*1000000)/1000000.0d;
				objRow.get(0).replace(j, newValue);
			}	
		}
		objRow.get(0).replace(pivotColIndex, 0.0);
		for(int i=0;i<p2.getMatA().size();i++) {
			 if(i!=pivotRowIndex) { //same col
					p2.getMatA().get(i).replace(pivotColIndex, 0.0); //zero out entries in the same col as pivot entry
			 } 
		}
		for(int j=0;j<p2.getMatA().get(0).size();j++) { //same row
			if(j!=pivotColIndex) {
				double newValue = p2.getMatA().get(pivotRowIndex).get(j)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex); //scale entries in same row as pivot entry, including pivot entry
				//newValue = Math.round(newValue*1000000)/1000000.0d;
				p2.getMatA().get(pivotRowIndex).put(j, newValue);
			}
		}
		p2.getMatA().get(pivotRowIndex).put(pivotColIndex, p2.getMatA().get(pivotRowIndex).get(pivotColIndex)/p2.getMatA().get(pivotRowIndex).get(pivotColIndex));
		return p2.getObjRowValue();
	}
	
	int getDepartingVar(LPP p2, int colIndex) {
		HashMap<Integer, HashMap<Integer, Double>> colj = getColOfMatrix(p2.getMatA(), colIndex);
		double minThetaRatio = Double.MAX_VALUE;
		int rowIndexOfDeparting = 0;
		boolean containsValid = false;
		for(int i =0;i<colj.size();i++) {
			if(colj.get(i).get(0) !=null) {
				if(colj.get(i).get(0)>0.0) {
					containsValid = true;
					if((p2.getVecB().get(i)/colj.get(i).get(0)) < minThetaRatio) {
						minThetaRatio = (p2.getVecB().get(i)/colj.get(i).get(0));
						rowIndexOfDeparting = i;
					}
				}
			}
		}
		if(containsValid) {
			return rowIndexOfDeparting;
		} else {
			System.out.println("No Solution");
			return -1;
		}
	}
	
	int getEnteringVar(HashMap<Integer, HashMap<Integer, Double>> negativeObjValues, LPP p2) {
		System.out.println("NegativeObjValues size is: " +negativeObjValues.get(0).size());
		double mostNegativeValue = Double.MAX_VALUE;
		int indexOfMostNegative = -1;
		for(int j=0;j<p2.getMatA().get(0).size();j++) {
			if(negativeObjValues.get(0).get(j)!=null) {
				if(negativeObjValues.get(0).get(j)<mostNegativeValue) {
					mostNegativeValue = negativeObjValues.get(0).get(j);
					indexOfMostNegative = j;
				}
			}
			else {
				//System.out.println("ERROR!!!!!!!!!!!!!");
			}
		}
		return indexOfMostNegative;
	}
	
	int getDepartingVarDual(LPP p1, HashMap<Integer, VarPair> BasicVars) {// get rowIndex of most negative basic var
		System.out.println();
		double mostNegativeBValue = Double.MAX_VALUE;
		int indexOfMostNegativeBValue = -1;
		for(int i =0; i<p1.getVecB().size();i++) {
			if(p1.getVecB().get(i) < 0.0 && p1.getVecB().get(i) < mostNegativeBValue) {
				mostNegativeBValue = p1.getVecB().get(i);
				indexOfMostNegativeBValue = i;
			}
		}
		if(indexOfMostNegativeBValue >=0) {
			System.out.println("Most negative basic var is: X" + (BasicVars.get(indexOfMostNegativeBValue).colindex + 1) + " with value of " + mostNegativeBValue);
			return BasicVars.get(indexOfMostNegativeBValue).rowindex;
		}
		else {
			System.out.println("Error: No negative B value found");
			return -1;
		}
	}
	
	int getEnteringVarDual(LPP p1, HashMap<Integer, VarPair> BasicVars, int pivotRowIndex, HashMap<Integer, HashMap<Integer, Double>> objRow) {
		double minAbsRatio = Double.MAX_VALUE;
		int indexOfMinAbsRatio = -1;
		for(int j =0; j<p1.getMatA().get(pivotRowIndex).size();j++) {
			
			if(p1.getMatA().get(pivotRowIndex).get(j) < 0.0 && p1.getArtificialVars().containsKey(j)!= true) {
//				System.out.println(Math.abs(objRow.get(0).get(j)/p1.getMatA().get(pivotRowIndex).get(j)));
//				System.out.println(minAbsRatio);
				if(Math.abs(objRow.get(0).get(j)/p1.getMatA().get(pivotRowIndex).get(j)) < minAbsRatio) {
					minAbsRatio = Math.abs(objRow.get(0).get(j)/p1.getMatA().get(pivotRowIndex).get(j));
					//System.out.println(minAbsRatio);
					indexOfMinAbsRatio = j;
				}
			}
		}
		if(indexOfMinAbsRatio >=0) {
			System.out.println("Entering Var is: X" + (indexOfMinAbsRatio+1) + " with ratio of " + minAbsRatio);
			return indexOfMinAbsRatio;
		}
		else {
			System.out.println("Error: No viable entering variable found");
			return -1;
		}
	}
	
	HashMap<Integer, HashMap<Integer, Double>> containsNegativeObjRow(HashMap<Integer, HashMap<Integer, Double>> objRow, LPP p1) {
		HashMap<Integer, HashMap<Integer, Double>> negativeObjValues = new HashMap<Integer, HashMap<Integer, Double>>();
		negativeObjValues.put(0, new HashMap<Integer, Double>());
		//System.out.println("AV size: " + p1.getArtificialVars().size());
		printArtificialVars(p1);
		//for(int k=0;k<p1.getArtificialVars().size();k++) {
			for(int j =0; j<objRow.get(0).size();j++) {
				//System.out.print("j is: " + j +" ");
				if(p1.getArtificialVars().size()>0) {
					if(j<p1.getArtificialVars().get(0).colindex) {
						if(objRow.get(0).get(j)<0.0 && p1.getArtificialVars().containsKey(j)==false) {
							//System.out.print("j is: " + j +" ");
							//System.out.print(p1.getArtificialVars().get(0).colindex +" ");
							//System.out.println("Found negative");
							//System.out.println(objRow.get(0).get(j));
							if(negativeObjValues.get(0).get(j)!=null) {
								negativeObjValues.get(0).replace(j, objRow.get(0).get(j));
							} else {
								//System.out.println("J is: " + j);
								negativeObjValues.get(0).put(j, objRow.get(0).get(j));
								//break;
							}
						}
					}
				} else {
					if(objRow.get(0).get(j)<0.0) {
						//System.out.print("j is: " + j +" ");
						//System.out.println("Found negative");
						//System.out.println(objRow.get(0).get(j));
						if(negativeObjValues.get(0).get(j)!=null) {
							negativeObjValues.get(0).replace(j, objRow.get(0).get(j));
						} else {
							negativeObjValues.get(0).put(j, objRow.get(0).get(j));
							break;
						}
					}
				}
			}
		//}
		
		return negativeObjValues;
	}
	
	void printObjRow(HashMap<Integer, HashMap<Integer, Double>> objRow, double objRowValue) {
		System.out.println("The obj row is: ");
		for(int j=0; j<objRow.get(0).size(); j++) {
			if(j == 0 && j+1<objRow.get(0).size()) {//first entry
				System.out.print(objRow.get(0).get(j).toString() + "X" +(j+1) + " ");
			}
			else if(j>0 && j+1<objRow.get(0).size()) {// middle entries
				System.out.print(objRow.get(0).get(j).toString() + "X" + (j+1) + " ");
			}
			else if(j==0 && j+1 == objRow.get(0).size()) {//first and only entry
				System.out.print(objRow.get(0).get(j).toString() + "X" +(j+1));
			}
			else { //last entry
				System.out.print(objRow.get(0).get(j).toString() + "X" +(j+1));
			}
		}
		System.out.println(" = " + objRowValue);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////Matrix Functions//////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	HashMap<Integer, HashMap<Integer, Double>> getColOfMatrix(HashMap<Integer, HashMap<Integer, Double>> matrix, int colIndex){
		HashMap<Integer, HashMap<Integer, Double>> col = new HashMap<Integer, HashMap<Integer, Double>>();
		for(int i =0;i<matrix.size();i++) {
			HashMap<Integer, Double> newrow = new HashMap<Integer, Double>();
			col.put(i, newrow);
			col.get(i).put(0, matrix.get(i).get(colIndex));
		}
		return col;
	}
	
	HashMap<Integer, HashMap<Integer, Double>> multiplyMatricesHashMap(HashMap<Integer, HashMap<Integer, Double>> A, HashMap<Integer, HashMap<Integer, Double>> B){
		int row1 = A.size();
		int col1 = A.get(0).size();
		int row2 = B.size();
		int col2 = B.get(0).size();
		if(col1 == row2) { // valid dimensions
			HashMap<Integer, HashMap<Integer, Double>> result = new HashMap<Integer, HashMap<Integer, Double>>();
			for(int i =0;i<row1;i++) {
				HashMap<Integer, Double> newrow = new HashMap<Integer, Double>();
				result.put(i, newrow);
			}
			for(int i = 0; i<row1; i++) {
				for(int j =0; j<col2; j++) {
					for(int k = 0; k<col1; k++) {
//						result[i][j] += A[i][k] * B[k][j];
						if(result.get(i).get(j) == null) {
							result.get(i).put(j, (A.get(i).get(k) * B.get(k).get(j)));
						} else {
							double newResult = result.get(i).get(j) + (A.get(i).get(k) * B.get(k).get(j));
							result.get(i).replace(j, newResult);
						}
					}
				}
			}
			return result;
		} else { // invalid dimensions
			System.out.println("Returning null");
			return null;
		}
	}
	
	void printMatrix(HashMap<Integer, HashMap<Integer, Double>> matrix, String matrixName) {
		System.out.println();
		System.out.println("The matrix " +matrixName+ " is: ");
		for(int i=0;i<matrix.size();i++) {
			for(int j=0;j<matrix.get(i).size();j++) {
				if(j+1 == matrix.get(i).size()) {
					System.out.print(matrix.get(i).get(j).toString());
				}
				else{
					System.out.print(matrix.get(i).get(j).toString() + " ");
				}
			}
			System.out.println();
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////Loading Food/////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	static void loadFood(HashMap<Integer, Food> m, String foodLine, int varCounter) {
		String[] foodAttributes = foodLine.split("@", 0);
		String FoodName = foodAttributes[0];
		double FoodCalories = Double.parseDouble(foodAttributes[1]);
		double FoodFat = Double.parseDouble(foodAttributes[2]);
		double FoodCarb = Double.parseDouble(foodAttributes[3]);
		double FoodProtein = Double.parseDouble(foodAttributes[4]);
		if(m.containsKey(varCounter)!= true) {
			System.out.println("Loading "+ FoodName + "-" + "X" + (varCounter+1));
			Food newFood = new Food(FoodName, (int) FoodCalories, FoodFat, FoodProtein, FoodCarb);
			m.put(varCounter, newFood);
		}
	}
	
	void printHashMap(HashMap<Integer, Food> m) {
		for(int i = 0; i<m.size();i++) {
			System.out.println(m.get(i).getName());
		}
	}
	
	
	void parseRawFoodData(InputStream f, HashMap<Integer, Food> m){
		Scanner sc2 = new Scanner(f);
		String prev = null;
		String writeStr = "";
		int searchSeq = 0;
		int varCounter = 0;
		while(sc2.hasNextLine()) {
			//System.out.println(writeStr);
			String nextLine = sc2.nextLine();
			//System.out.println(nextLine);
			switch(searchSeq) {
			case 0: //Search for name of the food
				//System.out.println("Searching for name of the food");
				if(containsStringIgnoreCase(nextLine, "Amount")==true) {
						String foodName = prev.trim();
						writeStr += foodName + "@";
						searchSeq++;
				}else {
					prev = nextLine;
				}
				break;
			case 1: //Search for calories in the food
				//System.out.println("Searching for calories");
				if(containsStringIgnoreCase(nextLine, "Calories")==true) {
					String[] caloriesSplit = nextLine.split(" ", 0);
					for(int i =0; i<caloriesSplit.length; i++) {
						if(caloriesSplit[i].compareToIgnoreCase("Calories") == 0) {
							if((i+1) != caloriesSplit.length) {
								String numOfCalories = caloriesSplit[i+1];
								writeStr +=   numOfCalories + "@";
								searchSeq++;
								break;
							}
						}
					}
				}
				prev = nextLine;
				break;
			case 2: //Search for total fats in the food
				//System.out.println("Searching for fats in the food");
				if(containsStringIgnoreCase(nextLine, "Total")==true && containsStringIgnoreCase(nextLine, "Fat") == true) {
					String[] fatsSplit = nextLine.split(" ", 0);
					for(int i =0; i<fatsSplit.length; i++) {
						if(fatsSplit[i].compareToIgnoreCase("Fat") == 0) {
							if((i+1) != fatsSplit.length) {
								String numOfFats = fatsSplit[i+1];
								writeStr += numOfFats + "@";
								searchSeq++;
								break;
							}
						}
					}
				}
				prev = nextLine;
				break;
			case 3: //Search for total carbohydrates in the food
				//System.out.println("Searching for carbs in the food");
				if(containsStringIgnoreCase(nextLine, "Carbohydrate")==true) {
					String[] carbsSplit = nextLine.split(" ", 0);
					for(int i =0; i<carbsSplit.length; i++) {
						if(carbsSplit[i].compareToIgnoreCase("Carbohydrate") == 0) {
							if((i+1) != carbsSplit.length) {
								String numOfCarbs = carbsSplit[i+1];
								writeStr += numOfCarbs + "@";
								searchSeq++;
								break;
							}
						}
					}
				}
				prev = nextLine;
				break;
			case 4: //Search for protein in the food
				//System.out.println("Searching for the protein in the food");
				if(containsStringIgnoreCase(nextLine, "Protein")==true) {
					String[] proteinSplit = nextLine.split(" ", 0);
					for(int i =0; i<proteinSplit.length; i++) {
						if(proteinSplit[i].compareToIgnoreCase("Protein") == 0) {
							//System.out.println("Found protein");
							if((i+1) != proteinSplit.length) {
								String numOfProtein = proteinSplit[i+1];
								writeStr += numOfProtein;
								searchSeq = 0;
								break;
							}
						}
					}
					//System.out.println(writeStr);
					loadFood(m, writeStr, varCounter);
					varCounter++;
					writeStr = "";
				}
				prev = nextLine;
				break;
			default:
				prev = nextLine;
				break;
			}
			
		}
		sc2.close();
	}
	
	void parseRawFoodDataUSDA(InputStream[] files, HashMap<Integer, Food> m){
		Scanner sc2 = new Scanner(files[0]);
		Scanner sc3 = new Scanner(files[1]);
		Scanner sc4 = new Scanner(files[2]);
		Scanner sc5 = new Scanner(files[3]);
		Scanner sc6 = new Scanner(files[4]);
		String writeStr = "";
		int searchSeq = 0;
		int varCounter = 0;
		while(sc2.hasNextLine()&&sc3.hasNextLine()&&sc4.hasNextLine()&&sc5.hasNextLine()&&sc6.hasNextLine()) {
			String foodName = sc2.nextLine().trim();
			String foodCalories = sc3.nextLine().trim();
			String foodFats = sc4.nextLine().trim();
			String foodProtein = sc5.nextLine().trim();
			String foodCarbs = sc6.nextLine().trim();
			if(foodCalories.compareToIgnoreCase("#DIV/0!")!=0 &&foodFats.compareToIgnoreCase("#DIV/0!")!=0&&foodProtein.compareToIgnoreCase("#DIV/0!")!=0&&foodCarbs.compareToIgnoreCase("#DIV/0!")!=0) {
				writeStr += foodName +"@" + foodCalories+"@"+foodFats+"@"+foodProtein+"@"+foodCarbs;
				//System.out.println("["+varCounter+"] "+writeStr);
				loadFood(m, writeStr, varCounter);
				writeStr="";
				varCounter++;
			}
		}
		sc2.close();
		sc3.close();
		sc4.close();
		sc5.close();
		sc6.close();
	}
	
	boolean containsStringIgnoreCase(String line, String target) {
		//System.out.println("!!!!!" + line);
		String[] splitstr = line.split("\\s+", 0);
		for(String s : splitstr) {
			//System.out.println(s);
			if(s.compareToIgnoreCase(target) == 0) {//found target
				//System.out.println("Found");
				return true;
			}
		}
		return false;
	}
	
	
	void fillLPP(LPP p1, HashMap<Integer, Food> foodmap, String type, int numOfConstraints, HashMap<Integer, String> relations, HashMap<Integer, Double> vecB) {
		HashMap<Integer, HashMap<Integer, Double>> matA = new HashMap<Integer, HashMap<Integer, Double>>();
		int loopOrder = 0;
		for(int i =0; i<numOfConstraints; i++) { //Populate Matrix A
			matA.put(i, new HashMap<Integer, Double>());
			switch(loopOrder) {
			case 0:
				for(int j=0; j<foodmap.size(); j++) {
					matA.get(i).put(j, foodmap.get(j).getFat());
				}
				loopOrder++;
				break;
			case 1:
				for(int j=0; j<foodmap.size(); j++) {
					matA.get(i).put(j, foodmap.get(j).getProtein());
				}
				loopOrder++;
				break;
			case 2:
				for(int j=0; j<foodmap.size(); j++) {
					matA.get(i).put(j, foodmap.get(j).getCarb());
				}
				loopOrder++;
				break;
			case 3:
				for(int j=0; j<foodmap.size();j++) {
					matA.get(i).put(j, (double) foodmap.get(j).getCalories());
				}
				loopOrder++;
				break;
			}
		}
		HashMap<Integer, Double> vecC = new HashMap<Integer, Double>();
		for(int i =0; i<foodmap.size(); i++) {
			vecC.put(i, (double) foodmap.get(i).getCalories());
		}
		p1.setMatA(matA);
		p1.setNumOfConstraints(numOfConstraints);
		p1.setRelations(relations);
		p1.setType(type);
		p1.setVecB(vecB);
		p1.setVecC(vecC);
	}

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////Simplex-Prep/////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	void convertToCanonicalForm(LPP p1) {
		HashMap <Integer, String> relations = p1.getRelations();
		for(int i =0; i<p1.getNumOfConstraints();i++) {
			if(relations.get(i).compareToIgnoreCase("<=") == 0) {//"<=" sign for ith constraint, need to add slack variable
				//Add a slack var to ith column, add 0 coefficient to rest of that column 
				int indexToInsertSlack = p1.getMatA().get(i).size();
				p1.getMatA().get(i).put(indexToInsertSlack, 1.0);
				for(int j =0; j<p1.getNumOfConstraints(); j++) {
					if(j != i) {//fill in 0.0 except ith row for slack var column
						p1.getMatA().get(j).put(indexToInsertSlack, 0.0);
					}
				}
				int indexToInsertCoeff = p1.getVecC().size();
				p1.getVecC().put(indexToInsertCoeff, 0.0);
				p1.getRelations().replace(i, p1.getRelations().get(i), "=");
			} 
			else if(relations.get(i).compareToIgnoreCase(">=") == 0) {//">=" sign for the ith constraint, 
				//Subtract a slack var from ith column, add 0 coefficient to the rest of that column
				int indexToInsertSlack = p1.getMatA().get(i).size();
				p1.getMatA().get(i).put(indexToInsertSlack, -1.0);
				for(int j =0; j<p1.getNumOfConstraints(); j++) {
					if(j != i) {//fill in 0.0 except ith row for slack var column
						p1.getMatA().get(j).put(indexToInsertSlack, 0.0);
					}
				}
				int indexToInsertCoeff = p1.getVecC().size();
				p1.getVecC().put(indexToInsertCoeff, 0.0);
				p1.getRelations().replace(i, p1.getRelations().get(i), "=");
			}
		}
		if(p1.getType()=="Min") {
			for(int i = 0;i<p1.getVecC().size(); i++) {
				double cValue = p1.getVecC().get(i);
				p1.getVecC().remove(i);
				p1.getVecC().put(i, -(cValue));
			}
			p1.setType("Max");
		}
	}

	static class VarPair{
		int rowindex;
		int colindex;
		boolean isAV;
	}
	
void addArtificialVariables(LPP p1, HashMap<Integer, VarPair> initialBasicVars) { //find rows that need an artificial variable;
		//System.out.println(p1.getNumOfConstraints());
		for(int i =0; i<p1.getNumOfConstraints();i++) {//For each row
			//System.out.println(initialBasicVars.size());
			boolean rowContainsPotentialCoeffOne = false;
			for(int j=0; j<p1.getMatA().get(i).size();j++) {//For each col in ith row
				//System.out.println("Variable: X" + (j+1));
				//System.out.println("J is: " + (j));
				if(p1.getMatA().get(i).get(j).compareTo(1.0)== 0 && checkUniqueVar(p1, i, j) == true) { //Finds col with var value of 1
						System.out.println("Adding basic var: ");
						rowContainsPotentialCoeffOne = true;
						VarPair newvar = new VarPair();
						newvar.rowindex = i;
						newvar.colindex = j;
						newvar.isAV = false;
						initialBasicVars.put(initialBasicVars.size(), newvar);
						break;
				} 
				else if((p1.getMatA().get(i).get(j).compareTo(1.0)!=0 | checkUniqueVar(p1, i, j) == false) && j+1 == p1.getMatA().get(i).size()) {
					//System.out.println("Entering else if:");
					if(rowContainsPotentialCoeffOne == false) {//needs AV in ith row;\
						//System.out.println("Adding artificial var");
						int indexToInsertAV = p1.getMatA().get(i).size();
						p1.getMatA().get(i).put(indexToInsertAV, 1.0);
						for(int k =0; k<p1.getNumOfConstraints(); k++) {//For each row
							if(k != i) {//fill in 0.0 except ith row for AV var column
								p1.getMatA().get(k).put(indexToInsertAV, 0.0);
							}
						}
						VarPair newvar = new VarPair();
						newvar.rowindex = i;
						newvar.colindex = indexToInsertAV;
						newvar.isAV = true;
						initialBasicVars.put(initialBasicVars.size(), newvar);
						p1.setContainsArtificialVars(true);
						p1.getArtificialVars().put(p1.getArtificialVars().size(), newvar);
						int indexToInsertCoeff = p1.getVecC().size();
						p1.getVecC().put(indexToInsertCoeff, 0.0);
						break;
					}
				}
			}
		}
	}

	boolean checkUniqueVar(LPP p1, int rowIndex, int colIndex) {// checks if var is unique var in the column
		boolean isUnique = true;
		for(int i =0; i<p1.getNumOfConstraints(); i++) {// For each row
			if(i!=rowIndex && p1.getMatA().get(i).get(colIndex).compareTo(0.0)!=0) {//row not in the same row as currentVar
				//System.out.println("Variable: X" + (colIndex+1));
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}
	
	void printConstraintsEquations(LPP p1) {
		for(int i=0;i<p1.getNumOfConstraints();i++) {
			for(int j=0; j<p1.getMatA().get(i).size(); j++) {
				if(j == 0 && j+1<p1.getMatA().get(i).size()) {//first entry
					System.out.print("("+i+")" + " " + p1.getMatA().get(i).get(j).toString() + "X" +(j+1) + " ");
				}
				else if(j>0 && j+1<p1.getMatA().get(i).size()) {// middle entries
					System.out.print("+ " + p1.getMatA().get(i).get(j).toString() + "X" + (j+1) + " ");
				}
				else if(j==0 && j+1 == p1.getMatA().get(i).size()) {//first and only entry
					System.out.print("("+i+")" + " " + p1.getMatA().get(i).get(j).toString() + "X" +(j+1));
				}
				else { //last entry
					System.out.print("+ " + p1.getMatA().get(i).get(j).toString() + "X" +(j+1));
				}
			}
			System.out.print(" "+ p1.getRelations().get(i) + " " + p1.getVecB().get(i).toString());
			System.out.println();
		}
	}
	
	void printInitialBasicVars(LPP p1, HashMap<Integer, VarPair> initialBasicVars) {
		System.out.println("The basic vars are: ");
		for(int i = 0; i<initialBasicVars.size();i++) {
			if(initialBasicVars.get(i)!=null) {// current basic var is NOT artificial
				if(i == 0 && i+1<initialBasicVars.size()) {
					System.out.print("[" +"X" +(initialBasicVars.get(i).colindex+1) +" ");
				}
				else if(i>0 && i+1<initialBasicVars.size()) {
					System.out.print("X" +(initialBasicVars.get(i).colindex+1) +" ");
				}
				else if(i==0 && i+1==initialBasicVars.size()) {
					System.out.println("[" +"X" +(initialBasicVars.get(i).colindex+1) +"]");
				}
				else {
					System.out.println("X" +(initialBasicVars.get(i).colindex+1) +"]");
				}
			} 
				else if(initialBasicVars.get(i).isAV == true && initialBasicVars.get(i)!=null) {//current basic var is artificial
//				if(i == 0 && i+1<initialBasicVars.size()) {
//					System.out.print("[" +"Y" +(artificialVarCounter + 1) +" ");
//				}
//				else if(i>0 && i+1<initialBasicVars.size()) {
//					System.out.print("Y" + (artificialVarCounter + 1) +" ");
//				}
//				else if(i==0 && i+1==initialBasicVars.size()) {
//					System.out.print("[" +"Y" + (artificialVarCounter+1) +"]");
//				}
//				else {
//					System.out.print("Y" +(artificialVarCounter+1) +"]");
//				}
//				artificialVarCounter++;
			}
		}
	}
	void printArtificialVars(LPP p1) {
		System.out.println();
		System.out.println(" The artificial vars are: ");
		for(int i = 0;i<p1.getArtificialVars().size();i++) {
			System.out.print("X" + (p1.getArtificialVars().get(i).colindex+1) + " ");
		}
	}
	
}
