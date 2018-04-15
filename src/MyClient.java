import java.io.Serializable;
public class MyClient {
    public static void main(String[] args) {
        double wynik;
        CalcObject zobiekt;
        CalcObject2 zobiekt2;
        ResultType wynik2;
        InputType inputObject;
        if (args.length==0)
        {
            System.out.println("You ahve to enter RMI object adress in the form : //host_address/service_name");
            return;
        }
        String adres = args[0];

        try
        {
            zobiekt = (CalcObject) java.rmi.Naming.lookup(adres);
            zobiekt2 = (CalcObject2) java.rmi.Naming.lookup(args[1]);
        }
        catch (Exception e)
        {
            System.out.println("Nie mozna pobrac referencji do "+adres);
            e.printStackTrace();;
            return;
        }
        System.out.println("Referencja do "+adres+" jest pobrana");

        try
        {
            wynik = zobiekt.calculate(1.1,2.2);
            inputObject = new InputType();
            inputObject.x1=1.1;
            inputObject.x2 = 2.2;
            inputObject.operation = "sub";
            wynik2=zobiekt2.calculate(inputObject);



        }
        catch(Exception e)
        {
            System.out.println("Blad zdalnego wywolania.");
            e.printStackTrace();
            return;
        }
        System.out.println("wynik = "+wynik);
        System.out.println("wynik2 = "+wynik2.result);
;
        return;
    }
}
