package _hackerrank.java.oop;

/**
 * Created by Михаил on 26.02.2016.
 * <b>task description: https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword</b>
 */
public class JavaMethodOverriding2SuperKeyword {
    MotorCycle M = new MotorCycle();
}

class BiCycle {
    String define_me() {
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle {
    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());
        String temp = super.define_me();
        System.out.println("My ancestor is a cycle who is " + temp);
    }

}