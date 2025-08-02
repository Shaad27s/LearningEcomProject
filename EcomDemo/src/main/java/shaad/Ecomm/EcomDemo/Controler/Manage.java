package shaad.Ecomm.EcomDemo.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import shaad.Ecomm.EcomDemo.Module.PrdCar;
import shaad.Ecomm.EcomDemo.Service.logic;

import java.io.IOException;
import java.util.List;



@RestController
@RequestMapping("/api")
public class Manage {

    private logic log;
    @Autowired
    public  Manage(logic log) {
        this.log = log;
    }
    @RequestMapping("/home")
    @ResponseBody
    public  String home(){
        return "Welcome to Site";
    }


    @GetMapping("/list")
    public ResponseEntity<List<PrdCar>>getProd(){
        return new ResponseEntity<>(log.getPrd(), HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<PrdCar> geByID(@PathVariable int id){

        PrdCar prd=log.getbyId(id);

        if(prd!=null)
            return new ResponseEntity<>(log.getbyId(id),HttpStatus.FOUND);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }

    @PostMapping("/list")
    public ResponseEntity<?>addPrd(@RequestPart PrdCar prd, @RequestPart MultipartFile ImageFile){

        try {
            if(log.existByName(prd.getName())){
                return new ResponseEntity<>("Product already exists",HttpStatus.CONFLICT);
            }

            PrdCar prd1= log.AddPrd(prd,ImageFile);
            return  new ResponseEntity<>(prd1,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

   @GetMapping("/list/{prdId}/image")
   public ResponseEntity<byte[]>addPrd(@PathVariable int id) {

       try {


           PrdCar product = log.getbyId(id);

           if (product == null) {
               return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }

           byte[] imageFile = product.getImageData();
           return ResponseEntity.ok()
                   .contentType(MediaType.valueOf(product.getImageType()))
                   .body(imageFile);
       }catch (Exception e){
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

   }
    @PutMapping ("/list/{id}")
    public ResponseEntity<String> UpdatePrd(@PathVariable int id,@RequestPart PrdCar product,@RequestPart MultipartFile ImageFile){
        PrdCar prod = null;
        try {
            prod = log.UpdateProduct(id,product,ImageFile);
        } catch (IOException e) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(prod!=null)

              return new ResponseEntity<>("Updated",HttpStatus.CREATED);
          else
              return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<String> DeleteProduct(@PathVariable int id ){
        PrdCar product= log.getbyId(id);
        if (product != null){
            log.DeletedPrd(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("NOt found", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/list/search")
    public  ResponseEntity<List<PrdCar>>SearchBYBrand(@RequestParam String keyword){
        return  new ResponseEntity<>(log.SearchByBrand(keyword),HttpStatus.OK);
    }
}
