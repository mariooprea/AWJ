package hello;

import java.util.List;
import java.util.ArrayList;

public class Telefon{
	private String Producator;
	private int id;
	private int Pret;

	public Telefon(){}
	
	public Telefon(int id,String Producator,int Pret){
		this.Producator=Producator;
		this.id=id;
		this.Pret=Pret;
	}
	
	public String getProducator(){
		return this.Producator;
	}
	
	public float getId(){
		return this.id;
	}
	
	public int getPret(){
		return this.Pret;
	}
}