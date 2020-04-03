package ua.beauty.calendar.api;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.Master;
import ua.beauty.calendar.domain.MasterRequest;
import ua.beauty.calendar.exception.ResourceNotFoundException;
import ua.beauty.calendar.model.MasterResponse;
import ua.beauty.calendar.service.MasterService;

import javax.validation.Valid;


//это есть адаптер

@RestController
@AllArgsConstructor
public class MasterController {

    private final MasterService masterService;



@RequestMapping(method = RequestMethod.GET,path = "/master",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
MasterResponse findAllMasters() {
    return new MasterResponse("success", masterService.findAll());
}

    @GetMapping("/master/{id}")
    public ResponseEntity<Master> getMasterById(@PathVariable(value = "id") Long masterId)
            throws ResourceNotFoundException {
        Master master = masterService.findById(masterId)
                .orElseThrow(() -> new ResourceNotFoundException("Мастер не найден"));
        return ResponseEntity.ok().body(master);
    }

    @PostMapping(path = "/addMaster", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    Master addMaster(@RequestBody @Valid MasterRequest request) {
        Master master = new Master();
        master.setName(request.getName());
        return masterService.save(master);

    }






}
