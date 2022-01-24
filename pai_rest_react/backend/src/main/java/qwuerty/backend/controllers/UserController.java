package qwuerty.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qwuerty.backend.models.Fridge;
import qwuerty.backend.models.User;
import qwuerty.backend.models.jwt.JwtRequest;
import qwuerty.backend.models.jwt.JwtResponse;
import qwuerty.backend.repos.FridgeRepository;
import qwuerty.backend.repos.UserRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FridgeRepository fridgeRepository;
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username){
        User user = userRepository.findUserByUsername(username);
        return user;
    }
    @Valid
    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@Valid @RequestBody Fridge fridge){
        Fridge newFridge = new Fridge(fridge.getUser(), fridge.getProduct(), fridge.getQuantity());
        fridgeRepository.save(newFridge);
        return "dodawanie produktu";
    }

    @RequestMapping(value = "/getProducts/{username}", method = RequestMethod.GET)
    public List<Fridge> getUserProducts(@PathVariable String username){
        User user = userRepository.findUserByUsername(username);
        List<Fridge> listProduct = fridgeRepository.getAllByUser(user);
        return listProduct;
    }
    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable Long id){
        Fridge fridge = fridgeRepository.findFridgeById(id);
        if(fridge != null){
            fridgeRepository.deleteById(id);
            return "Usunięto produkt";
        }
        return "Nie usunięto produktu";
    }
    @RequestMapping(value = "/updateProduct/{id}", method = RequestMethod.PUT)
    public String updateProduct(@PathVariable Long id, @RequestBody Fridge fridge){
        Fridge currentFridge = fridgeRepository.findFridgeById(id);
        if(currentFridge != null){
            currentFridge.setProduct(fridge.getProduct());
            currentFridge.setQuantity(fridge.getQuantity());
            currentFridge.setUser(fridge.getUser());
            fridgeRepository.save(currentFridge);
            return "Edytowano produkt";
        }
        return "Nie edytowano produktu";
    }
}
