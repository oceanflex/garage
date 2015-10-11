/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package garage;



/**
 *
 * @author Zachary
 */
public class Startup {
    public static void main(String[] args) {
//        FileDate now = new FileDate();
//        System.out.println(now.todayIs());
//        System.out.println(now.timeIs());
        
//        OwnerOutStrategy own = new OwnerTotalFile();
//        own.update(2, 3.5);
//        own.update(1, 2.5);
        
//        CustOutStrategy cust = new CustConsoleReceipt();
//        cust.output(101, 2, 4.5);
        
        FeeCalcStrategy fee = new MinNoMaxFeeCalc();
        System.out.println(fee.getFee(3.1));
    }
}
