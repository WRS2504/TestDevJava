package com.digisystem.TestJavaDeveloper.utilities;

import com.digisystem.TestJavaDeveloper.domain.DataToCompute;
import com.digisystem.TestJavaDeveloper.domain.RspChallenge01;

import java.util.List;

public class Util {
    public static RspChallenge01 compute(DataToCompute data) {
        switch (data.getAcao()) {
            case "soma":
                return addCompute(data.getNumeros());
            case "subtrai":
                return subCompute(data.getNumeros());
            case "media":
                return avrCompute(data.getNumeros());
            case "total":
                return new RspChallenge01(data.getNumeros().size());
        }
        return new RspChallenge01(0);
    }

    private static RspChallenge01 addCompute(List<Integer> number){
        long result = 0;
        for(Integer value : number){
            result += value;
        }
        return new RspChallenge01(result);
    }

    private static RspChallenge01 subCompute(List<Integer> number){
        long result = 0;
        for(Integer value : number){
            if(result == 0){
                result = value;
            }else{
                result -= value;
            }
        }
        return new RspChallenge01(result);
    }

    private static RspChallenge01 avrCompute(List<Integer> number){
        long result = 0;
        for(Integer value : number){
            result += value;
        }
        result = result/number.size();
        return new RspChallenge01(result);
    }
}
