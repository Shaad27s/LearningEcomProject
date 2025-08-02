package shaad.Ecomm.EcomDemo.Module;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String name;
    private  String password;

   @Enumerated(EnumType.STRING)
   private  Role role;



    public  User(String name, String password,Role role){
        this.name = name;
        this.password=password;
        this.role = role;
    }
    public  void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
