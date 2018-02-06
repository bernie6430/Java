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
public class Bisection extends Function {
    
    public Bisection(double a,double b){
        super();
        if(a<b){
            x[0]=a;
            x[1]=b;
        }
        else{
            x[1]=a;
            x[0]=b;
        }
    }
    
    @Override
    public double sol(){
        if(f(x[0])*f(x[1])>0)
            return 0;
        
        for(int i=0;;i++){
            x[2]=(x[0]+x[1])/2.0;
            if(Math.abs(f(x[2]))<e){
                return x[2];
            }
            else if(f(x[2])<0){
                if(f(x[0])>0){
                    x[1]=x[2];
                }
                else{
                    x[0]=x[2];
                }
            }
            else{
                if(f(x[0])>0){
                    x[0]=x[2];
                }
                else{
                    x[1]=x[2];
                }
            }
        }
    
    }
}
