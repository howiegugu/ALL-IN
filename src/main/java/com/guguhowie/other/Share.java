package com.guguhowie.other;

public class Share {

    public static int i = 1;

    public void add() {
        i++;
    }

    private class ShareInner{
        public boolean doSomething() {
            if (i==1) {
                // do
                return false;
            }
            return true;
        }
    }
}
