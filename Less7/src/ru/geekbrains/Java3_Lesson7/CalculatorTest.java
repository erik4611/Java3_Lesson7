package ru.geekbrains.Java3_Lesson7;


public class CalculatorTest {
    private static Calculator calc = null;

    @BeforeSuite
    public void init(){
        calc = new Calculator();
    }

    @Test(priority = 1)
    public boolean additionTest(double a, double b, double result){
        if (calc.addition(a,b) == result) return true;
        else return false;
    }

    @Test(priority = 2)
    public boolean subtractionTest(double a, double b, double result){
        if (calc.subtraction(a,b) == result) return true;
        else return false;
    }

    @Test(priority = 3)
    public boolean multiplicationTest(double a, double b, double result){
        if (calc.multiplication(a,b) == result) return true;
        else return false;
    }

    @Test(priority = 4)
    public boolean divisionTest(double a, double b, double result){
        if (calc.division(a,b) == result) return true;
        else return false;
    }

    @AfterSuite
    public void close(){
        calc = null;
    }
}