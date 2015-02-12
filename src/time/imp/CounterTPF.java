package time.imp;

import time.ICounterTPF;

public class CounterTPF implements ICounterTPF{

    public static final CounterTPF INSTANCE = new CounterTPF();
    
    private CounterTPF() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void count() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getTPF() {
        // TODO Auto-generated method stub
        return 0;
    }

}
