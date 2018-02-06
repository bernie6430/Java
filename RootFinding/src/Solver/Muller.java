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
public class Muller extends Function{
    
    public Muller(double a,double b,double c){
        super();
        x[0]=a;
        x[1]=b;
        x[2]=c;
    }
    
    @Override
    public double sol(){
        double maxtr=10000;
        double li;
        double di;
        double mu;
        double s;
        double l;
        
        for(int i=0;;i++){
            li=(x[2]-x[1])/(x[1]-x[0]);
            di=(x[2]-x[0])/(x[1]-x[0]);
            mu=f(x[0])*li*li-f(x[1])*di*di+f(x[2])*(di+li);
            s=Math.sqrt(mu*mu-4.0*f(x[2])*di*di*(f(x[0])*li-f(x[1])*di+f(x[2])));
            if(mu<0)
                l=(2.0*f(x[2])*di)/(-mu+s);
            else
                l=(2.0*f(x[2])*di)/(-mu-s);
            x[3]=x[2]+l*(x[2]-x[1]);
            if(Math.abs(x[3]-x[2])<e)
                return x[3];
            else{
                for(int j=0;j<3;j++)
                    x[j]=x[j+1];
            }
            if(i==maxtr)
                return 0;
        }
    }
        
}
