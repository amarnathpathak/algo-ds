package com.hp.sap.ecom;

import java.util.ArrayList;
import java.util.List;

public class ShipmentState {
    public enum State {
        PACK {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        }, SHIP {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        }, INTRANSIT {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        }, DELIVER {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        }, RETURN {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        }, RTO {
            @Override
            void doSomething(String work) {
                // TODO Auto-generated method stub
                
            }
        };
        public static void addNextState(State s){
        }
        abstract void doSomething(String work);
    }

}
