package shaad.Ecomm.EcomDemo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;
import shaad.Ecomm.EcomDemo.Module.PrdCar;
import shaad.Ecomm.EcomDemo.Repository.Repo;

import java.io.IOException;
import java.util.List;

@Service
public class logic {

    @Autowired
     Repo rp;
    public List<PrdCar> getPrd() {
        return rp.findAll();
    }


    public PrdCar getbyId(int id){
        return rp.findById(id).orElse(null);

    };

    public PrdCar AddPrd(PrdCar prd, MultipartFile imageFile) throws IOException {
        prd.setImageName(imageFile.getOriginalFilename());
        prd.setImageType(imageFile.getContentType());
        prd.setImageData(imageFile.getBytes());
        return rp.save(prd);
    }

    public boolean existByName(String name) {
         return  rp.existsByName(name);
    }

    public PrdCar UpdateProduct(int id, PrdCar product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        return rp.save(product);
    }

    public void DeletedPrd(int id) {
        rp.deleteById(id);
    }

    public List<PrdCar> SearchByBrand(String keyword) {
        return rp.SearchBYBrand(keyword);
    }
}
