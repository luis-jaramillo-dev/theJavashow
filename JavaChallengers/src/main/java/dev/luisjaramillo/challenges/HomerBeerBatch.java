package dev.luisjaramillo.challenges;



public class HomerBeerBatch {

    public static void main(String[] args){
        int batchOfBeer1 = 5;
        int batchOfBeer2 = 5;
        if(++batchOfBeer2 > batchOfBeer1 || batchOfBeer1++ == batchOfBeer2++){
            batchOfBeer1++;
        }
        batchOfBeer1 = (batchOfBeer1++ > batchOfBeer2 && ++batchOfBeer2< batchOfBeer1 ? ++batchOfBeer1: ++batchOfBeer2);

        System.out.println("Homer will have "+ batchOfBeer1 +" and "+ batchOfBeer2);
    }
}
