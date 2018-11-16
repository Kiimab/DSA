public class FruitItem {

        String name;
        int amount;


        public FruitItem(String name, int amount){
                this.name = name;
                this.amount= amount;
        }


        public String getName(){
                return name;
        }

        public int getAmount(){
                return amount;
        }

        public void setAmount(int amount){
                this.amount = this.amount + amount;
        }
}