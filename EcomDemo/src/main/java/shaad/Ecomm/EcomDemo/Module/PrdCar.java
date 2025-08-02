package shaad.Ecomm.EcomDemo.Module;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class PrdCar {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String description;
    private String brand;
    private int price;
    private String category;
    private Date releaseDate;
    private long stockQuantity;
    private  boolean productAvailable;
    private String ImageName;
    private  String ImageType;
    @Lob
    private byte [] ImageData;

  public String getImageName() {
    return ImageName;
  }

  public void setImageName(String imageName) {
    ImageName = imageName;
  }

  public String getImageType() {
    return ImageType;
  }

  public void setImageType(String imageType) {
    ImageType = imageType;
  }

  public byte[] getImageData() {
    return ImageData;
  }

  public void setImageData(byte[] imageData) {
    ImageData = imageData;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    name = name;
  }
}

