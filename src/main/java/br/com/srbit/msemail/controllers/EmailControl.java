package br.com.srbit.msemail.controllers;

import br.com.srbit.msemail.models.EmailModel;
import br.com.srbit.msemail.models.dto.EmailDTO;
import br.com.srbit.msemail.service.EmailService;
import com.netflix.discovery.converters.Auto;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/emails")
public class EmailControl {
    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<Page<EmailDTO>> findAll(@PageableDefault(page = 0, size = 5, sort = "emailId", direction = Sort.Direction.DESC) Pageable pageable){
        return ResponseEntity.ok(emailService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmailDTO> findById(@PathVariable("id") ObjectId id){
        return ResponseEntity.ok(emailService.findById(id));
    }

}
