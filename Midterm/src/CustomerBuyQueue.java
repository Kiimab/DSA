public class CustomerBuyQueue {
        String name;
        FruitItem apples;
        FruitItem pears;
        FruitItem peaches;

        public CustomerBuyQueue(String name, FruitItem apples, FruitItem pears, FruitItem peaches){
                this.name = name;
                this.apples = apples;
                this.pears = pears;
                this.peaches = peaches;


        }

        public String getName(){
                return name;
        }

        public FruitItem getApples(){
                return apples;
        }

        public FruitItem getPears(){
                return pears;
        }

        public FruitItem getPeaches(){
                return peaches;
        }



}
