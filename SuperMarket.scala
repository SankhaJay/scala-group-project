import util.control.Breaks._

object SuperMarket{
    var inum:Int =0;
    var cid:Int =0;
    val N:Int = 10;
    var noitem: Int = 0;
    var total: Int = 0;
    class Item(var icode:Int, var iprice:Int,var iqty:Int, var iname:String){
        var code:Int=icode;
        var price:Int =iprice;
        var qty:Int=iqty;
        var name:String=iname;

        def updateItem(quantity:Int){
            this.qty=this.qty-quantity;
        }
    }
    var elements = scala.collection.mutable.Map[Int,Int]();
    val items: Array[Item] = new Array[Item](N);

    def main(args: Array[String]){
        initShop();
    }

    def initShop(){
        println(" Welcome!!! ");
        var op:Int = 0;
        do{
            println("Enter choice");
            println("01.Add a new item");
            println("02.Proceed to the shop");
            println("03.Exit");
            op = scala.io.StdIn.readInt();
            op match{
            case 1 => addNewItem();
            case 2 => enterShop();
            case 3 => System.exit(1);
            case _ => println("Enter a valid choice");
            }
        }while(true);
    }
    def addNewItem(){
        if(inum == N){
            println("Cannot add more items. Please proceed or exit\n");
            return;
        }
        println("Enter item name");
        var iname = scala.io.StdIn.readLine();
        println("Enter unit price");
        var iprice = scala.io.StdIn.readInt();
        println("Enter remaining item quantity");
        var iqty = scala.io.StdIn.readInt();
        inum = inum + 1;
        val temp = new Item(inum,iprice,iqty,iname);
        items(inum-1) = temp;
        println("An item added succesfully\n");
    }
    def closeShop(){
        println("Shop is closed by the owner!!");
        System.exit(1);
    }
    def itemList(){
        var i:Int = 0;
        println("\n----------Item list----------")
        for( i <- 0 to inum-1){
			println("Item code\tItem name\tQuantity");
            println(items(i).code+"\t\t"+items(i).name+"\t\t"+items(i).qty);
        }
    }
    def isEmpty(){
        var flag:Int = 0;
        for( i <- 0 to inum-1){
            if(items(i).qty != 0){
            flag = 1;
            } 
        }
        if(flag == 0){
            println("Shop is closed..nothing to buy");
            closeShop();
        }
    }

    def isAvailable(icode: Int, iqty: Int){
        if(items(icode-1).qty<iqty){
            println("********Sorry there is not enough goods in the shop********\n");
            buyItem();
        }
        if(iqty<=0){
            println("Invalid!! ");
            buyItem();
        }
    }
	
    def buyItem(){
        itemList();
        println("Enter item code to buy");
        var icode = scala.io.StdIn.readInt();
        if(icode<0 || icode>inum){
            println("*****Enter valid item number******\n");
            buyItem();
        }
        println("Enter quantity to buy");
        var iqty = scala.io.StdIn.readInt();
        isAvailable(icode,iqty);
        items(icode-1).updateItem(iqty);
        noitem = noitem + 1;
        total = total + items(icode-1).price * iqty;
        elements += (icode-1 -> iqty);
        println("Item bought succesfully");
    }
    def issueBill(){
        if(noitem == 0){
            println("*****Buy some products*****\n");
			cid = cid - 1;
            newCustomer();
        }
        println("----Bill----\n");
        println("Bill no : "+cid);
        println("Item_No\tQuantity price");
        elements.keys.foreach{ i =>  
        println(i+1+"\t" + elements(i)+"\t "+elements(i) * items(i).iprice);
        }
        println("Total : "+total+"\n");
        elements.clear;
        noitem = 0;
        total = 0;
        enterShop();
   }
    def newCustomer(){
        cid = cid + 1;
        isEmpty();
        do{
            println("Enter choice");
            println("01.Buy items");
            println("02.Issue Bill");
            var op = scala.io.StdIn.readInt();
            op match{
                case 1 => buyItem();
                case 2 => issueBill();
                case _ => println("Enter a valid choice");
            }
        }while(true);
    }
    def enterShop(){
        println("\n###Super Market###");
        println("Enter choice");
        println("01.New Customer");
        println("02.Close the shop");
        var op = scala.io.StdIn.readInt();
        op match{
            case 1 => newCustomer();
            case 2 => closeShop();
            case _ => println("Enter a valid choice");
        }
    }
}