package com.springbootexample.api;

import com.springbootexample.entity.Kisi;
import com.springbootexample.repositories.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/kisi")
public class KisiController {

    private final KisiRepository kisiRepository;

    /*
    @PostConstruct
    public void init(){
        Kisi kisi = new Kisi();
        kisi.setAd("Özgür");
        kisi.setSoyad("Akburu");
        kisi.setAdres("adres adres adres");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisi.setId("K0001");
        kisiRepository.save(kisi);
    }
     */

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getAllByName(@PathVariable String search){
        List<Kisi> kisiler = kisiRepository.findByAdLikeOrSoyadLike(search, search);
        return ResponseEntity.ok(kisiler);
    }

    @PostMapping("/add")
    public ResponseEntity<Kisi> add(@RequestBody Kisi kisi){
        return ResponseEntity.ok(kisiRepository.save(kisi));
    }

}
