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
public class TelefonController {
  private List<Telefon> telefoane = new ArrayList<Telefon>();

  OraseController() {
      Telefon t1 = new Telefon(1,"CSS",5);
      Telefon t2 = new Telefon(2,"Angularjs",8);
      Telefon t3 = new Telefon(3,"Java",7);
      Telefon t4 = new Telefon(4,"github",10);

      telefoane.add(t1);
      telefoane.add(t2);
      telefoane.add(t3);
      telefoane.add(t4);
    
  }

  @RequestMapping(value="/telefoane", method = RequestMethod.GET)
  public List<Telefon> index() {
    return this.telefoane;
  }

  @RequestMapping(value="/telefoane/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Telefon p : this.telefoane) {
      if(p.getId() == id) {
        return new ResponseEntity<Orase>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefoane/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Telefon p : this.telefoane) {
      if(p.getId() == id) {
        this.telefoane.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/telefoane/{id}",method = RequestMethod.PUT)
   public ResponseEntity update(@PathVariable("id") int id) {
	   for(Telefon p : this.telefoane){
		   if(p.getId() == id) {
			   
			   return new ResponseEntity<Orase>(p,new HttpHeaders(), HttpStatus.OK);
		   }
	   }
	   return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

@RequestMapping(value="/Telefon/{id}/{Producator}/{Pret}", method = RequestMethod.POST)
 public List<Telefon> create(@PathVariable(value="id") int id,@PathVariable(value="Producator") String Producator,@PathVariable(value="Pret") int Pret) {
    Telefon t= new Telefon (id,Producator,Pret);
    telefoane.add(t);
  return this.telefoane;
 }

}