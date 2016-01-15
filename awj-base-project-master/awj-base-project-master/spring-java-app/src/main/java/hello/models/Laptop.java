package hello;

import java.util.List;
import java.util.ArrayList;

public class Laptop{
		private String producator;
		private String model;
		private int id;

		public Laptop(){}
		
		public Laptop(int id,String producator,String model){
			this.producator=producator;
			this.id=id;
			this.model=model;
		}
		
		public String getProducator(){
			return this.producator;
		}
		
		public int getId(){
			return this.id;
		}
		
		public int getModel(){
			return this.model;
		}
		}