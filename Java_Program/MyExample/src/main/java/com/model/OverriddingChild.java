package com.model;


/**
 * Created by nikhil on 7/4/18.
 */
public class OverriddingChild extends OverriddingParent {


    @Override
    protected Integer setInt(Integer a )   {
        return 23;
    }
    protected Integer setInt(Integer a ,Integer b ) throws Exception{
        return 23;
    }

    public static void main(String[] arg) throws  Exception{

        OverriddingChild overriddingChild = new  OverriddingChild();




    }


}
