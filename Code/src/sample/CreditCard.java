package sample;

public class CreditCard{

    private int card_Number;
    private int PIN;
    private int C_ID;

    public CreditCard(){
        card_Number = 0;
        PIN = 0;
        C_ID = 0;
    }

    public CreditCard(int cnum, int pin, int cid){
        card_Number = cnum;
        PIN = pin;
        C_ID = cid;
    }

    public void setCardNumber(int cnum){

        String number = String.valueOf(cnum);
        if (number.length() < 1 && number.length() > 10){
            System.out.println("The card number is invalid\n");
        }
        else{
            card_Number = cnum;
        }
    }

    public void setPIN(int pin){

        String number = String.valueOf(pin);
        if (number.length() < 1 && number.length() > 4){
            System.out.println("The PIN is invalid\n");
        }
        else{
            PIN = pin;
        }
    }

    public void setCard_Number(int card_number){
        card_Number = card_number;
    }

    public int getPIN(){
        return PIN;
    }

    public int getCard_Number(){
        return card_Number;
    }

    public void showCreditCard(){
        System.out.println("Card Number: " + card_Number + " \n" + "PIN: " + PIN + "\n" + "C_ID: " + C_ID + "\n");
    }
}
