/**
 * Created by Jibran on 4/25/19.
 */
import CSS143New.*;

public class Driver {
    public static void main(String[] args) {
        QueueInt testQ = new QueueInt();
        System.out.println(testQ.isEmpty());
        testQ.enqueue(5);
        testQ.enqueue(50);
        testQ.enqueue(6);
        testQ.dequeue();
        System.out.println(testQ.isEmpty());

        // testing amount of slots
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);
//        testQ.enqueue(6);


        System.out.println(testQ.dequeue());
        // testQ.report(); testing amount of slots
        System.out.println(testQ.isEmpty());
        testQ.dequeue();
        System.out.println(testQ.isEmpty());

        FTE fte = new FTE();
        System.out.println("Name is " + fte.name);
        System.out.println("SSN is " + fte.ssn);
        System.out.println("Yearly salary is " + fte.yearly_salary);
        Contractor ct = new Contractor();
        System.out.println("Name is " + ct.name);
        System.out.println("SSN is " + ct.ssn);
        System.out.println("Yearly salary is " + ct.yearly_rate);


    }
}
