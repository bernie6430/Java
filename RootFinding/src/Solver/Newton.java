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
public class Newton extends Function{
    
    public Newton(double a){
        super();
        x[0]=a;
    };
    
    private double df(double x){
        return 3.0*x*x-2.0*x-1;
    }
        
 
    @Override
    public double sol(){
        
        for(int i=0;;i++){
            x[1]=x[0]-f(x[0])/df(x[0]);
            if(Math.abs(x[1]-x[0])<e){
                return x[1];
            }
            else{
                x[0]=x[1];
            }
        }
        
    }
    
    
    
    
}
