/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solver;

/**
 *
 * @author user
 */
public abstract class Function {
    protected double[] x=new double[4];
    protected static double e=0.0000001;    
    
    public Function(){};
    
    public double f(double x){
        return x*x*x-x*x-x-1.0;
    }
    
    public abstract double sol();
    
}
