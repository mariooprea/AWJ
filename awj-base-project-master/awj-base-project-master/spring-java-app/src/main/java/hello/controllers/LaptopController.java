package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class LaptopController {
  private List<Laptop> laptopuri = new ArrayList<Laptop>();

  LaptopController() {
      Laptop j1 = new Laptop(1,"Asus","k750-JB");
      Laptop j2 = new Laptop(2,"Lenovo","IdeaPad G50");
      Laptop j3 = new Laptop(3,"Dell","Inspiron 700");
      Laptop j4 = new Laptop(4,"Acer","Aspire A5");

      laptopuri.add(j1);
      laptopuri.add(j2);
      laptopuri.add(j3);
      laptopuri.add(j4);
	
  }

  @RequestMapping(value="/laptopuri", method = RequestMethod.GET)
  public List<Laptop> index() {
    return this.laptopuri;
  }

  @RequestMapping(value="/laptopuri/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Laptop p : this.laptopuri) {
      if(p.getId() == id) {
        return new ResponseEntity<Laptop>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/laptopuri/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Laptop p : this.laptopuri) {
      if(p.getId() == id) {
        this.laptopuri.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/laptopuri/{id}",method = RequestMethod.PUT)
   public ResponseEntity update(@PathVariable("id") int id) {
	   for(Laptop p : this.laptopuri){
		   if(p.getId() == id) {
			  
			   return new ResponseEntity<Laptop>(p,new HttpHeaders(), HttpStatus.OK);
		   }
	   }
	   return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

@RequestMapping(value="/Laptop/{id}/{producator}/{model}", method = RequestMethod.POST)
 public List<Laptop> create(@PathVariable(value="id") int id,@PathVariable(value="producator") String producator,@PathVariable(value="model") String model) {
    Laptop ji= new Laptop (id,producator,model);
    laptopuri.add(ji);
  return this.laptopuri;
 }

}