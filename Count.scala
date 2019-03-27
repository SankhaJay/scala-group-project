object Count{
    var num:Int = 0;
    var count:Int = 0;
    var rnum:Int = 0;

    def main(args: Array[String]){
        getNum();
        checkDigits();
        checkNum(count);
        reverseNum()
    }
    def getNum(){
        println("Enter positive integer to print");
        num = scala.io.StdIn.readInt();
        if(num<0){
            println("Enter a valid number");
            getNum();
        }
    }
    def checkDigits(){
        var temp = num;
        while(temp!=0){
            temp = temp/10;
            count = count + 1;
        }
    }
    def checkNum(count:Int){
        if(count==1){
            print20(num);
        }
        else if(count==2 && num<=20){
            print20(num);
        }
        else if(count==2){
            reverseNum();
        }
    }
    def print20(num:Int){
        var op:Int = 0;
        op = num;
        op match{
            case 1 => println("One");
            case 2 => println("Two");
            case 3 => println("Three");
            case 4 => println("Four");
            case 5 => println("Five");
            case 6 => println("Six");
            case 7 => println("Seven");
            case 8 => println("Eight");
            case 9 => println("Nine");
            case 10 => println("Ten");
            case 11 => println("Eleven");
            case 12 => println("Twelve");
            case 13 => println("Thirteen");
            case 14 => println("Fourteen");
            case 15 => println("Fifteen");
            case 16 => println("Sixteen");
            case 17 => println("Seventeen");
            case 18 => println("Eighteen");
            case 19 => println("Nineteen");
            case 20 => println("Twenty");
        }
    }
}