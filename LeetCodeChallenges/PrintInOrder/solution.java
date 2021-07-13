// from https://leetcode.com/problems/print-in-order/
class Foo {
    private boolean firstDone = false;
    private boolean secondDone = false;
    
    public Foo() {
        
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone = true;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(!firstDone) {
            this.wait(100);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone = true;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(!secondDone) {
            this.wait(100);
        }
        printThird.run();
    }
}