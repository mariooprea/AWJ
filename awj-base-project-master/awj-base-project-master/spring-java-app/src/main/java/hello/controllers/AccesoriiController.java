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
public class AccesoriiController {
  private List<Accesorii> accesorii = new ArrayList<Accesorii>();

  AccesoriiController() {
    Accesorii m1 = new Accesorii(1, "Casti",200);
    Accesorii m2 = new Accesorii(2, "HDD",250);
    Accesorii m3 = new Accesorii(3, "Mouse",150);
    Accesorii m4 = new Accesorii(4, "Tastatura",150);
    Accesorii.add(m1);
    Accesorii.add(m2);
    Accesorii.add(m3);
    Accesorii.add(m4);
  }

  @RequestMapping(value="/accesorii", method = RequestMethod.GET)
  public List<Accesorii> index() {
    return this.accesorii;
  }

  @RequestMapping(value="/accesorii/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Accesorii p : this.accesorii) {
      if(p.getId() == id) {
        return new ResponseEntity<Accesorii>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/accesorii/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Accesorii p : this.accesorii) {
      if(p.getId() == id) {
        this.accesorii.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  @RequestMapping(value="/accesorii/{id}",method = RequestMethod.PUT)
   public ResponseEntity update(@PathVariable("id") int id) {
	   for(Accesorii p : this.accesorii){
		   if(p.getId() == id) {
			  
			   return new ResponseEntity<Accesorii>(p,new HttpHeaders(), HttpStatus.OK);
		   }
	   }
	   return new ResponseEntity<String>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

@RequestMapping(value="/accesorii/{id}/{produs}/{pret}", method = RequestMethod.POST)
 public List<Accesorii> create(@PathVariable(value="id") int id,@PathVariable(value="produs") String produs,@PathVariable(value="pret") int pret) {
  Accesorii m= new Accesorii (id,produs,pret);
  accesorii.add(m);
  return this.accesorii;
 }

}