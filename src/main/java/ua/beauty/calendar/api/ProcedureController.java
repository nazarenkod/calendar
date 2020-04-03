package ua.beauty.calendar.api;


import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.beauty.calendar.domain.Procedure;
import ua.beauty.calendar.domain.ProcedureRequest;
import ua.beauty.calendar.exception.ResourceNotFoundException;
import ua.beauty.calendar.model.ProcedureResponse;
import ua.beauty.calendar.service.ProcedureService;

import javax.validation.Valid;


//это есть адаптер

@RestController
@AllArgsConstructor
public class ProcedureController {

    private final ProcedureService procedureService;


    @RequestMapping(method = RequestMethod.GET, path = "/getProcedures", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ProcedureResponse getProcedures() {
        return new ProcedureResponse("success", procedureService.findAll());
    }

    @GetMapping("/procedure/{id}")
    public ResponseEntity<Procedure> getProcedureById(@PathVariable(value = "id") Long procedureId)
            throws ResourceNotFoundException {
        Procedure procedure = procedureService.findById(procedureId)
                .orElseThrow(() -> new ResourceNotFoundException("Мастер не найден"));
        return ResponseEntity.ok().body(procedure);
    }

    @PostMapping(path = "/addProcedure", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    Procedure addProcedure(@RequestBody @Valid ProcedureRequest request) {
        Procedure procedure = new Procedure();
        procedure.setName(request.getName());
        return procedureService.save(procedure);

    }


}
