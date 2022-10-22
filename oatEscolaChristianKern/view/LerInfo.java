package view;

import java.util.*;

public class LerInfo {
    public Scanner sc;

  public LerInfo(){
    sc = new Scanner(System.in);
  }

  public String lerString(String msg) {
    System.out.print(msg);
    return sc.nextLine();
  }

  public String lerEmail(String msg){
    System.out.print(msg);
    return sc.next();
  }

  public String lerMatricula(String msg){
    System.out.print(msg);
    return sc.next();
  }

  public int lerInt(String msg) {
    System.out.print(msg);
    return sc.nextInt();
  }
  
  public double lerDouble (String msg) {
    System.out.print(msg);
    return sc.nextDouble();
  }

  public Calendar lerData(String msg) {
    System.out.print(msg + " (DD/MM/AAAA): ");
    String data = sc.next();
    int dia = Integer.parseInt(data.split("/")[0]);
    int mes = Integer.parseInt(data.split("/")[1]);
    int ano = Integer.parseInt(data.split("/")[2]);
    Calendar c1 = Calendar.getInstance();
    c1.set(ano, mes, dia);
    return c1;
  }

  public boolean letBoolean(String msg) {
    System.out.print(msg + " Digite < 1 > para verdadeiro ou < 2 > para falso: ");
    int verdadeiro = sc.nextInt();
    return verdadeiro == 1 ? true : false;
  }
}
