package ua.beauty.calendar.api;







import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.exception.ResourceNotFoundException;
import ua.beauty.calendar.service.MasterService;

import java.util.List;


//это есть адаптер

@RestController
@AllArgsConstructor
public class MasterController {

    private final MasterService masterService;



@RequestMapping(method = RequestMethod.GET,path = "/master",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    List<Master> findAllMasters(){
    return masterService.findAll();
}

    @GetMapping("/master/{id}")
    public ResponseEntity<Master> getMasterById(@PathVariable(value = "id") Long masterId)
            throws ResourceNotFoundException {
        Master master = masterService.findById(masterId)
                .orElseThrow(() -> new ResourceNotFoundException("Мастер не найден"));
        return ResponseEntity.ok().body(master);
    }






}
