public class Person implements ATMAction {
    String[] ident = new String[6];
    String[] name = new String[6];
    String[] sex = new String[6];

    public void Checkable(int i) {
    }


    public void Withdrawable(int i){

    }

    public void Depositeable(int i) {

    }

    public void Transferable(int i) {

    }
    public String[] getName (){
        return name;
    }
    public String[] setName(String[] n){
        return this.name = n;
    }
}



