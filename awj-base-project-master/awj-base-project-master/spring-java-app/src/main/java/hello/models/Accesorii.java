package hello;

import java.util.List;
import java.util.ArrayList;

public class Accesorii {
  private String produs;
  private int id;
  private int pret;

  public Accesorii() {}

  public Accesorii(int id, String produs,int pret) {
      this.produs = produs;
      this.id = id;
      this.pret=pret;

  }

  public String getProdus() {
      return this.produs;
  }

  public int getId() {
    return this.id;
  }
  public int getPret() {
    return this.pret;
  }
}