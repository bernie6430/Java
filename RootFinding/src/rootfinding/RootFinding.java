/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rootfinding;

import Solver.Bisection;
import Solver.Brent;
import Solver.Function;
import Solver.Muller;
import Solver.Newton;
import Solver.Secant;

/**
 *
 * @author user
 */
public class RootFinding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Function test1=new Newton(0.0);
        Function test2=new Bisection(1.0,4.0);
        Function test3=new Secant(1.0,3.0);
        Function test4=new Muller(1.0,1.5,2.0);
        Function test5=new Brent(1.0,2.0);
        
        System.out.println(test1.sol());
        System.out.println(test2.sol());
        System.out.println(test3.sol());
        System.out.println(test4.sol());
        System.out.println(test5.sol());
    }
    
}
