package org.Roclh.third;

import lombok.Getter;

@Getter
public class Ear {
    private String lastHeared;

    private String inTheEar;

    public Ear(){

    }

    public void hear(String text){
        this.lastHeared = text;
    }

    public void putInTheEar(String something){
        this.inTheEar = something;
    }
}
