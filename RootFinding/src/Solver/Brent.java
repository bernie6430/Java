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
public class Brent extends Function{
    
    public Brent(double a,double b){
        super();
            x[0]=a;
            x[1]=b;
    }
    
    private void swap(double y,double z){
        double tmp=z;
        z=y;
        y=tmp;
    }
    
    @Override
    public double sol(){
        double s=0.0;
        if(f(x[0])*f(x[1])>0)
            return 0;
        if(Math.abs(f(x[0]))<Math.abs(f(x[1]))){
            swap(x[0],x[1]);
        }
        x[2]=x[0];
        boolean mflag=true;
        while(f(x[1])>e){
           if(f(x[0])!=f(x[2]) && f(x[1])!=f(x[2])){
               s=(x[0]*f(x[1])*f(x[2]))/((f(x[0])-f(x[1]))*(f(x[0])-f(x[2])))+(x[1]*f(x[0])*f(x[2]))/((f(x[1])-f(x[0]))*(f(x[1])-f(x[2])))+(x[2]*f(x[0])*f(x[1]))/((f(x[2])-f(x[0]))*(f(x[2])-f(x[1])));
               //IQP
           }
           else{
               s=x[1]-f(x[1])*((x[1]-x[0])/(f(x[1])-f(x[0])));
               //Secant
           }
           
           if((s-x[1])*(s-0.25*(3.0*x[0]+x[1]))>0)
               s=0.5*(x[0]+x[1]);
           else if(mflag==true && Math.abs(s-x[1])>0.5*Math.abs(x[1]-x[2]))
               s=0.5*(x[0]+x[1]);
           else if(mflag==false && Math.abs(s-x[1])>0.5*Math.abs(x[2]-x[3]))
               s=0.5*(x[0]+x[1]);
           else if(mflag==true && Math.abs(x[1]-x[2])<e)
               s=0.5*(x[0]+x[1]);
           else if(mflag==false && Math.abs(x[2]-x[3])<e)
               s=0.5*(x[0]+x[1]);
           else
               mflag=false;
           
           x[3]=x[2];
           x[2]=x[1];
           if(f(x[0])*f(s)<0)
               x[1]=s;
           else
               x[0]=s;
           if(Math.abs(f(x[0]))<Math.abs(f(x[1]))){
                swap(x[0],x[1]);
           }
        }
        return s;
    }
}
