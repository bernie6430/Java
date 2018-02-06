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
public class Secant extends Function{

    public Secant(double a,double b){
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
        
        for(int i=0;;i++){
            x[2]=x[1]-f(x[1])*((x[1]-x[0])/(f(x[1])-f(x[0])));
            if(Math.abs(f(x[2]))<e){
                return x[2];
            }
            else{
                for(int j=0;j<2;j++)
                    x[j]=x[j+1];
            }
        }
    }
}
