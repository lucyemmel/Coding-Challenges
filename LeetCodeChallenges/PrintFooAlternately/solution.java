// from https://leetcode.com/problems/print-foobar-alternately/
class FooBar {
    private int n;
    private boolean fooPrinted = false;
    
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(fooPrinted) {
                this.wait(200);
            }
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            this.fooPrinted = true;
            this.notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!fooPrinted) {
                this.wait(200);
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            this.fooPrinted = false;
            this.notify();
        }
    }
}