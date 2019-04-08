package com.per.sundg.jdk;

import org.junit.jupiter.api.Test;

public class Assert {

    public static void main(String[] args) {

    }

    @Test
    public void test(){
        java.lang.String s = null;
        assert s!=null?true:false;
        assert false;
        System.out.println("end");
    }
}
